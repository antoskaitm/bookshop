package  ru.atoskaitm.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import  ru.atoskaitm.bookstore.dao.IBookDao;
import  ru.atoskaitm.bookstore.model.Cart;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

	private IBookDao bookDa;

	public void setBookDao(IBookDao bookDao) {
		this.bookDa = bookDao;
	}

	@RequestMapping("cart")
	public String cart(Model model, HttpSession httpSession) {
		model.addAttribute("cart", (Cart) httpSession.getAttribute("cart"));
		return "cart";
	}

	@RequestMapping(value = "cart/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable("id") int id, HttpSession httpSession) {
		Cart cart = (Cart) httpSession.getAttribute("cart");
		cart.addOneBook(bookDa.getBookById(id));
		return "redirect:/books";
	}

	@RequestMapping(value = "cart/delete/{id}", method = RequestMethod.GET)
	public String drop(@PathVariable("id") int id, HttpSession httpSession) {
		Cart cart = (Cart) httpSession.getAttribute("cart");
		cart.removeLine(id);
		return "redirect:/cart";
	}
}
