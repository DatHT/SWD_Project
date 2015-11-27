package com.cathl.icook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cathl.icook.entity.Food;
import com.cathl.icook.service.FoodService;

@Controller
public class FoodController {
	
	public FoodController() {
		System.out.println("FoodController()");
	}
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping("getFood")
	public ModelAndView getFood(@RequestParam(name="id") int foodId) {
		Food food = foodService.getFood(foodId);
		return new ModelAndView("index", "food", food);
	}
}
