package ru.atoskaitm.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.atoskaitm.bookstore.dao.IBookDao;
import ru.atoskaitm.bookstore.model.Book;
import ru.atoskaitm.bookstore.model.Cart;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SessionAttributes("cart")
@MultipartConfig
public class BookController {

	private IBookDao bookDao;
	private Integer pageSize;

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@RequestMapping(value = {"books"}, method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("books", this.bookDao.listBooks(0, pageSize));
		model.addAttribute("pagesCount",this.bookDao.getPageCount(pageSize));
		return "books/list";
	}

	@RequestMapping(value = {"books/{pageNumber}"}, method = RequestMethod.GET)
	public String listBooks(Model model, @PathVariable("pageNumber") Integer pageNumber) {
		model.addAttribute("books", this.bookDao.listBooks(pageNumber, pageSize));
		model.addAttribute("pagesCount",this.bookDao.getPageCount(pageSize));
		return "books/list";
	}


	@RequestMapping(value = "/books/save", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, MultipartFile file, HttpSession session) {
		try {
			Book lastBook = (Book) session.getAttribute("lastBook");
			book.setImage(receiveImage(lastBook, file));
			if (book.getId() == 0) {
				this.bookDao.addBook(book);
			} else if (book.getId() != lastBook.getId()) {
				throw new IllegalArgumentException();
			} else {
				this.bookDao.updateBook(book);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "redirect:/books";
	}

	private byte[] receiveImage(Book lastBook, MultipartFile file) throws IOException {
		if (file != null && !file.isEmpty()) {
			return file.getBytes();
		} else if (lastBook != null) {
			return lastBook.getImage();
		} else {
			return null;
		}
	}

	@RequestMapping("books/remove/{id}")
	public String removeBook(@PathVariable("id") int id) {
		this.bookDao.removeBook(id);
		return "redirect:/books";
	}

	@RequestMapping(value = {"books/edit/{id}"})
	public String editBook(@PathVariable("id") int id, Model model, HttpSession session) {
		Book book = this.bookDao.getBookById(id);
		model.addAttribute("book", book);
		session.setAttribute("lastBook", book);
		return "books/edit";
	}

	@RequestMapping(value = "books/create")
	public String createBook(Model model, HttpSession session) {
		model.addAttribute("book", new Book());
		session.setAttribute("lastBookId", null);
		return "books/edit";
	}

	@RequestMapping("books/data/{id}")
	public String bookData(@PathVariable("id") int id, Model model, HttpSession httpSession) {
		Book book = this.bookDao.getBookById(id);
		model.addAttribute("book", book);
		return "books/info";
	}


	@ResponseBody
	@RequestMapping("books/images/{id}")
	public byte[] bookImage(@PathVariable("id") int id) {
		return this.bookDao.getBookById(id).getImage();
	}

	@ModelAttribute("cart")
	public Cart getCart() {
		return new Cart();
	}
}
