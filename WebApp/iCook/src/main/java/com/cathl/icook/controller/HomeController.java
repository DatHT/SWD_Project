package com.cathl.icook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cathl.icook.entity.TblFood;
import com.cathl.icook.entity.TblUser;
import com.cathl.icook.service.FoodService;
import com.cathl.icook.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private FoodService foodService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView userPage() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/Admin", method = RequestMethod.GET)
	public ModelAndView login(Model model, HttpSession session) {
		if (session.getAttribute("username") != null) {

			if ((Integer) session.getAttribute("role") == 0) {
				model.addAttribute("pageheader", "Admin");//set header  at view
				model.addAttribute("activeTab", "Dashboard");//set active tab at view
				return new ModelAndView("dashboard");
			}
			if ((Integer) session.getAttribute("role") == 1) {
				model.addAttribute("pageheader", "Dashboard");
				model.addAttribute("activeTab", "Dashboard");
				return new ModelAndView("dashboard_user");
			}
		} else {
			return new ModelAndView("login", "user", new TblUser());
		}
		return null;
	}

	@RequestMapping(value = "/Admin", method = RequestMethod.POST)
	public String home(@ModelAttribute("user") TblUser user, Locale locale, Model model, HttpSession session) {
		TblUser checkUser = userService.checkLogin(user);
		if (checkUser != null && checkUser.getRole() == 0) {
			session.setAttribute("role", checkUser.getRole());
			session.setAttribute("username", checkUser.getUserName());
			model.addAttribute("pageheader", "Admin");//set header  at view
			model.addAttribute("activeTab", "Dashboard");//set active tab at view
			return "dashboard";
		}
		if (checkUser != null && checkUser.getRole() == 1) {
			session.setAttribute("username", checkUser.getUserName());
			session.setAttribute("role", checkUser.getRole());
			model.addAttribute("pageheader", "Dashboard");//set header  at view
			model.addAttribute("activeTab", "Dashboard");//set active tab at view
			return "dashboard_user";
		}
		model.addAttribute("error", "wrong");
		return "login";
	}

	@RequestMapping(value = "/CreatePost", method = RequestMethod.GET)
	public String createPost(Model model, HttpSession session) {
		if (session.getAttribute("username") != null && (Integer) session.getAttribute("role") == 0) {
			model.addAttribute("pageheader", "Create New Post");//set header  at view
			model.addAttribute("activeTab", "CreatePost");//set active tab at view
			return "createpost";
		}
		return "redirect:/Admin";
	}

	@RequestMapping(value = "/ManagePost", method = RequestMethod.GET)
	public String managePost(Model model, HttpSession session) {
		if (session.getAttribute("username") != null && (Integer) session.getAttribute("role") == 0) {
			List<TblFood> result = new ArrayList<TblFood>();
			result = foodService.getFood();
			model.addAttribute("foodPost", result);
			model.addAttribute("pageheader", "Quản lý bài đăng");//set header  at view
			model.addAttribute("activeTab", "ManagePost");//set active tab at view
			return "managepost";
		}
		/* model.addAttribute("user", null); */
		return "redirect:/Admin";
	}

	@RequestMapping(value = "/getUserPost", method = RequestMethod.GET)
	public String managePostUser(Model model, HttpSession session) {
		if (session.getAttribute("username") != null) {
			List<TblFood> result = foodService.getFoodUser((String) session.getAttribute("username"));
			model.addAttribute("foodPost", result);
			model.addAttribute("pageheader", "Quản lý bài đăng");//set header  at view
			model.addAttribute("activeTab", "ManagePost");//set active tab at view
			return "manageuserpost";
		}
		return "redirect:/Admin";
	}

	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	public String signOut(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("role");
		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		return new ModelAndView("register", "newUser", new TblUser());
	}
}
