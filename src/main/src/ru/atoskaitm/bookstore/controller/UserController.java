package ru.atoskaitm.bookstore.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.atoskaitm.bookstore.model.security.User;
import ru.atoskaitm.bookstore.security.ISecurityService;
import ru.atoskaitm.bookstore.security.IUserService;

@Controller
public class UserController {

	private IUserService userService;

	private ISecurityService securityService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setSecurityService(ISecurityService securityService) {
		this.securityService = securityService;
	}

	@RequestMapping(value = "/security/signup", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "security/signup";
	}

	@RequestMapping(value = "/security/signup", method = RequestMethod.POST)
	public String registration(User user, Model model) {
		if (!user.isConfirmedPassword()) {
			model.addAttribute("error", "Password isn't confirmed");
			return "security/signup";
		}
		userService.save(user);
		securityService.autoLogin(user.getUsername(), user.getPassword());
		return "redirect:/books";
	}

	@RequestMapping(value = "/security/login", method = RequestMethod.GET)
	public String login(Model model, String error) {
		if (error != null) {
			model.addAttribute("error", "Username or password is incorrect");
		}
		return "security/login";
	}
}
