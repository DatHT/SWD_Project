package com.cathl.icook.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cathl.icook.entity.Food;
import com.cathl.icook.entity.TblCategory;
import com.cathl.icook.entity.TblFood;
import com.cathl.icook.service.CategoryService;
import com.cathl.icook.service.CategoryServiceImpl;
import com.cathl.icook.service.FoodService;


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
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		model.addAttribute("pageheader", "Admin");
		model.addAttribute("activeTab", "Dashboard");
		return "dashboard";
	}

	@RequestMapping(value = "/CreatePost", method = RequestMethod.GET)
	public String createPost(Model model) {

		model.addAttribute("pageheader", "Create New Post");
		model.addAttribute("activeTab", "CreatePost");
		return "createpost";
	}

	@RequestMapping(value = "/ManagePost", method = RequestMethod.GET)
	public String managePost(Model model) {
		List<Food> result = new ArrayList<Food>();
		result = foodService.getFood();
		model.addAttribute("foodPost", result);
		model.addAttribute("pageheader", "Quản lý bài đăng");
		model.addAttribute("activeTab", "ManagePost");
		return "managepost";
	}

	@RequestMapping(value = "/getCategory", method = RequestMethod.GET)
	@ResponseBody
	public List<TblCategory> getCategory(Model m) {
		List<TblCategory> result = new ArrayList<TblCategory>();
		result = cstegoryService.getCategory();
		for (TblCategory tblCategory : result) {
			System.out.println(tblCategory.getCategoryName());
		}
		return result;
	}

	@RequestMapping(value = "/getFood", method = RequestMethod.GET)
	@ResponseBody
	public List<Food> getFood() {
		List<Food> result = new ArrayList<Food>();
		result = foodService.getFood();
		return result;
	}

	@RequestMapping(value = "/getFoodID", method = RequestMethod.GET)
	@ResponseBody
	public TblFood getFoodID(@RequestParam("txtFoodID") String foodID) {
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

	@RequestMapping(value = "/updateFood", method = RequestMethod.POST)
	public @ResponseBody TblFood updateFood(@RequestBody TblFood food) {
		TblFood newFood = foodService.updateFood(food);
		return newFood;
	}
	@RequestMapping(value = "/createCaltalogue", method = RequestMethod.POST)
	public @ResponseBody TblCategory updateFood(@RequestBody TblCategory catalog) {
		int count=0;
		List<TblCategory> allCatalog = cstegoryService.getCategory();
		for (TblCategory tblCategory : allCatalog) {
			if (tblCategory.getCategoryName().toUpperCase().equals(catalog.getCategoryName().toUpperCase())) {
				count++;
			}
		}
		if (count==0) {
			TblCategory newCalte = new TblCategory(catalog.getCategoryName());
			Serializable result= cstegoryService.createNewCatelog(newCalte);
			return newCalte;
		}
		return null;
	}
	@RequestMapping(value="deleteFood",method = RequestMethod.GET)
	public int deleteFood(@RequestParam("txtFoodID") String foodID) {
		Integer foodIDInt = null;
		System.out.println(foodID);
		try {
			foodIDInt = Integer.parseInt(foodID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		foodService.deleteFood(foodIDInt);
		return 200;
	}
}
