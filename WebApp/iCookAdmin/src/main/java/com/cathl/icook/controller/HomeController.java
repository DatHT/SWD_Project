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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private CategoryService cstegoryService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodDetailSevices foodDetailService;
	@Autowired
	private UserService userService;
	private Integer foodID;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView userPage() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/Admin", method = RequestMethod.GET)
	public ModelAndView login(Model model, HttpSession session) {
		if (session.getAttribute("username") != null) {
			model.addAttribute("pageheader", "Admin");
			model.addAttribute("activeTab", "Dashboard");
			return new ModelAndView("dashboard");
		}
		return new ModelAndView("login", "user", new TblUser());
	}

	@RequestMapping(value = "/Admin", method = RequestMethod.POST)
	public String home(@ModelAttribute("user") TblUser user, Locale locale, Model model, HttpSession session) {
		TblUser checkUser = userService.checkLogin(user);
		if (checkUser != null) {
			session.setAttribute("username", checkUser.getUserName());
			model.addAttribute("pageheader", "Admin");
			model.addAttribute("activeTab", "Dashboard");
			return "dashboard";
		}
		return "login";
	}

	@RequestMapping(value = "/CreatePost", method = RequestMethod.GET)
	public String createPost(Model model, HttpSession session) {
		if (session.getAttribute("username") != null) {
			model.addAttribute("pageheader", "Create New Post");
			model.addAttribute("activeTab", "CreatePost");
			return "createpost";
		}
		return "login";
	}

	@RequestMapping(value = "/ManagePost", method = RequestMethod.GET)
	public String managePost(Model model, HttpSession session) {
		if (session.getAttribute("username") != null) {
			List<TblFood> result = new ArrayList<TblFood>();
			result = foodService.getFood();
			model.addAttribute("foodPost", result);
			model.addAttribute("pageheader", "Quản lý bài đăng");
			model.addAttribute("activeTab", "ManagePost");
			return "managepost";
		}
		return "login";
	}

	@RequestMapping(value = "/getCategory", method = RequestMethod.GET)
	@ResponseBody
	public List<TblCategory> getCategory(Model m, HttpSession session) {
		if (session.getAttribute("username") != null) {
		List<TblCategory> result = new ArrayList<TblCategory>();
		result = cstegoryService.getCategory();
		for (TblCategory tblCategory : result) {
			System.out.println(tblCategory.getCategoryName());
		}
		return result;
		}
		return null;
	}

	@RequestMapping(value = "/getFood", method = RequestMethod.GET)
	@ResponseBody
	public List<TblFood> getFood(HttpSession session) {
		if (session.getAttribute("username") != null) {
		List<TblFood> result = new ArrayList<TblFood>();
		result = foodService.getFood();
		return result;
		}
		return null;
	}

	@RequestMapping(value = "/getFoodID", method = RequestMethod.GET)
	@ResponseBody
	public TblFood getFoodID(@RequestParam("txtFoodID") String foodID, HttpSession session) {
		if (session.getAttribute("username") != null) {
		Integer foodIDInt = null;
		System.out.println(foodID);
		try {
			foodIDInt = Integer.parseInt(foodID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		TblFood result = foodService.getFoodID(foodIDInt);
		return result;
		}
		return null;
	}

	@RequestMapping(value = "/updateFood", method = RequestMethod.POST)
	public @ResponseBody TblFood updateFood(@RequestBody TblFood food, HttpSession session) {
		TblFood newFood = foodService.updateFood(food);
		return newFood;
	}

	@RequestMapping(value = "/createCaltalogue", method = RequestMethod.POST)
	public @ResponseBody TblCategory updateFood(@RequestBody TblCategory catalog, HttpSession session) {
		int count = 0;
		List<TblCategory> allCatalog = cstegoryService.getCategory();
		for (TblCategory tblCategory : allCatalog) {
			if (tblCategory.getCategoryName().toUpperCase().equals(catalog.getCategoryName().toUpperCase())) {
				count++;
			}
		}
		if (count == 0) {
			TblCategory newCalte = new TblCategory(catalog.getCategoryName());
			Serializable result = cstegoryService.createNewCatelog(newCalte);
			return newCalte;
		}
		return null;
	}

	@RequestMapping(value = "deleteFood", method = RequestMethod.GET)
	public void deleteFood(@RequestParam("txtFoodID") String foodID, HttpSession session) {
		if (session.getAttribute("username") != null) {
		Integer foodIDInt = null;
		System.out.println(foodID);
		try {
			foodIDInt = Integer.parseInt(foodID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		foodDetailService.deleteFoodDetail(foodIDInt);
		foodService.deleteFood(foodIDInt);
		}

	}

	@RequestMapping(value = "/getFoodDetail", method = RequestMethod.GET)
	@ResponseBody
	public TblFoodDetail getFoodDetailIDJson(@RequestParam("txtFoodID") String foodID, HttpSession session) {
		if (session.getAttribute("username") != null) {
		Integer foodIDInt = null;
		System.out.println(foodID);
		try {
			foodIDInt = Integer.parseInt(foodID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		TblFoodDetail foodDetail = foodDetailService.getFoodDetailID(foodIDInt);
		return foodDetail;
		}
		return null;
	}
	@RequestMapping(value = "/getFoodDetailUser", method = RequestMethod.GET)
	public String getFoodDetailID(@RequestParam("txtFoodID") String foodID, Model model) {
	
		Integer foodIDInt = null;
		System.out.println(foodID);
		try {
			foodIDInt = Integer.parseInt(foodID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		TblFoodDetail foodDetail = foodDetailService.getFoodDetailID(foodIDInt);
		TblFood food =foodService.getFoodID(foodIDInt);
		model.addAttribute("foodDetail", foodDetail);
		model.addAttribute("food", food);
		return "detail";
		
	}

	@RequestMapping(value = "/createFoodDetail", method = RequestMethod.POST)
	@ResponseBody
	public TblFoodDetail createFoodDetail(@RequestBody TblFoodDetail newFoodDetail, HttpSession session) {
		Serializable result;
		TblFoodDetail foodDetail = new TblFoodDetail(foodID, newFoodDetail.getMaterialDetail(),
				newFoodDetail.getTutorial(), newFoodDetail.getSource(), newFoodDetail.getUser());
		foodDetail.setFoodID(foodID);
		result = foodDetailService.createFoodDetail(foodDetail);

		System.out.println(result);
		return foodDetail;
	}

	@RequestMapping(value = "/createFood", method = RequestMethod.POST)
	@ResponseBody
	public TblFood createFood(@RequestBody TblFood newFood, HttpSession session) {
		Serializable result;
		TblFood food = new TblFood(newFood.getCategoryId(), newFood.getFoodName(), newFood.getDescription(),
				newFood.getLinkImage(), newFood.getListMaterial(), 0);

		result = foodService.createFood(food);
		foodID = food.getFoodId();
		System.out.println(foodID);
		return food;
	}
}
