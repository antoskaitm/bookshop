package ru.atoskaitm.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.atoskaitm.bookstore.dao.IBookDao;
import ru.atoskaitm.bookstore.model.Book;
import ru.atoskaitm.bookstore.model.Cart;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SessionAttributes("cart")
public class BookController {

	private IBookDao bookDao;

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@RequestMapping(value = "books", method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("books", this.bookDao.listBooks());
		return "books/list";
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, MultipartFile file, HttpSession session) {
		try {
			if (file != null) {
				book.setImage(file.getBytes());
			}
			if (book.getId() == 0) {
				this.bookDao.addBook(book);
			} else if (book.getId() != (Integer) session.getAttribute("lastBookId")) {
				throw new IllegalStateException();
			} else {
				this.bookDao.updateBook(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/books";
	}

	@RequestMapping("books/remove/{id}")
	public String removeBook(@PathVariable("id") int id) {
		this.bookDao.removeBook(id);
		return "redirect:/books";
	}

	@RequestMapping("books/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model, HttpSession session) {
		model.addAttribute("book", this.bookDao.getBookById(id));
		session.setAttribute("lastBookId", id);
		return "books/edit";
	}

	@RequestMapping("data/{id}")
	public String bookData(@PathVariable("id") int id, Model model, HttpSession httpSession) {
		Book book = this.bookDao.getBookById(id);
		model.addAttribute("book", book);
		return "data";
	}

	@ModelAttribute("cart")
	public Cart getCart() {
		return new Cart();
	}
}
