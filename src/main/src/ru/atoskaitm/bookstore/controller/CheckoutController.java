package ru.atoskaitm.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.atoskaitm.bookstore.dao.IOrderDao;
import ru.atoskaitm.bookstore.model.Cart;
import ru.atoskaitm.bookstore.model.Order;

import javax.servlet.http.HttpSession;

@Controller
public class CheckoutController {
	private IOrderDao orderDao;

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@RequestMapping(value = "checkout")
	public String checkout(Model model) {
		model.addAttribute("order", new Order());
		return "cart/checkout";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		order.setFrom(cart);
		order.setGiftWrap(order.getGiftWrap() != null && order.getGiftWrap());
		orderDao.addOrder(order);
		cart.clear();
		return "redirect:/books";
	}
}
