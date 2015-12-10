package com.cathl.icook.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cathl.icook.entity.Food;
import com.cathl.icook.entity.TblCategory;
import com.cathl.icook.entity.TblFood;
import com.cathl.icook.entity.TblFoodDetail;
import com.cathl.icook.entity.TblUser;
import com.cathl.icook.service.CategoryService;
import com.cathl.icook.service.CategoryServiceImpl;
import com.cathl.icook.service.FoodDetailSevices;
import com.cathl.icook.service.FoodService;
import com.cathl.icook.service.UserService;
import com.cathl.icook.controller.*;

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
	private CategoryService cstegoryService;
	@Autowired
	private FoodDetailSevices foodDetailService;
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
				model.addAttribute("pageheader", "Admin");
				model.addAttribute("activeTab", "Dashboard");
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
			model.addAttribute("pageheader", "Admin");
			model.addAttribute("activeTab", "Dashboard");
			return "dashboard";
		}
		if (checkUser != null && checkUser.getRole() == 1) {
			session.setAttribute("username", checkUser.getUserName());
			session.setAttribute("role", checkUser.getRole());
			model.addAttribute("pageheader", "Dashboard");
			model.addAttribute("activeTab", "Dashboard");
			return "dashboard_user";
		}
		model.addAttribute("error", "wrong");
		return "login";
	}

	@RequestMapping(value = "/CreatePost", method = RequestMethod.GET)
	public String createPost(Model model, HttpSession session) {
		if (session.getAttribute("username") != null && (Integer)session.getAttribute("role") == 0) {
			model.addAttribute("pageheader", "Create New Post");
			model.addAttribute("activeTab", "CreatePost");
			return "createpost";
		}
		return "redirect:/Admin";
	}

	@RequestMapping(value = "/ManagePost", method = RequestMethod.GET)
	public String managePost(Model model, HttpSession session) {
		if (session.getAttribute("username") != null && (Integer)session.getAttribute("role") == 0) {
			List<TblFood> result = new ArrayList<TblFood>();
			result = foodService.getFood();
			model.addAttribute("foodPost", result);
			model.addAttribute("pageheader", "Quản lý bài đăng");
			model.addAttribute("activeTab", "ManagePost");
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
			model.addAttribute("pageheader", "Quản lý bài đăng");
			model.addAttribute("activeTab", "ManagePost");
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

}
