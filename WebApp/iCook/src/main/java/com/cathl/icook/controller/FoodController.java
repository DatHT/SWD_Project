package com.cathl.icook.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cathl.icook.entity.TblFood;
import com.cathl.icook.entity.TblFoodDetail;
import com.cathl.icook.service.FoodDetailSevices;
import com.cathl.icook.service.FoodService;
import com.cathl.icook.service.UserService;

@Controller
public class FoodController {
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodDetailSevices foodDetailService;
	@Autowired
	private UserService userService;
	private Integer foodID;
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

	@RequestMapping(value = "/updateFoodDetail", method = RequestMethod.POST)
	public @ResponseBody TblFoodDetail updateFood(@RequestBody TblFoodDetail foodDetail, HttpSession session) {
		TblFoodDetail newFoodDetail = foodDetailService.updateFoodDetail(foodDetail);
		return newFoodDetail;
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
		TblFood food = foodService.getFoodID(foodIDInt);
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
		foodDetail.setUser((String) (session.getAttribute("username")));
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
}
