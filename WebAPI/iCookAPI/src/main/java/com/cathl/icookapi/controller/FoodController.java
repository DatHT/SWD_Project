package com.cathl.icookapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathl.icookapi.dto.FoodDTO;
import com.cathl.icookapi.dto.FoodDetailDTO;
import com.cathl.icookapi.entity.Food;
import com.cathl.icookapi.entity.FoodDetail;
import com.cathl.icookapi.service.FoodDetailService;
import com.cathl.icookapi.service.FoodService;

@RestController
public class FoodController {	
	
	public FoodController() {
		System.out.println("FoodController()");
	}
	
	@Autowired
	private FoodService foodService;
//	@Autowired
//	private FoodDetailService foodDetailService;
	
	@RequestMapping("/food/{id}")
	public Food getFood(@PathVariable("id") int foodId) {
		Food food = foodService.getFood(foodId);
//		FoodDTO foodDTO = new FoodDTO(food);
		return food;
	}
	
	@RequestMapping("search/{materials}/{start}/{limit}")
	public List<FoodDTO> searchByMaterial(@PathVariable("materials") String materials,
			@PathVariable("start") int start, @PathVariable("limit") int limit) {
		List<Food> listFood = foodService.searchByMaterial(materials, start, limit);
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
		for (Food food : listFood) {
			listFoodDTO.add(new FoodDTO(food));
		}
		return listFoodDTO;
	}
	
//	@RequestMapping("search/detail/{id}")
//	public FoodDetailDTO getFoodDetail(@PathVariable("id") int id) {
//		FoodDetail foodDetail = foodDetailService.getFood(id);
//		FoodDetailDTO foodDetailDTO = new FoodDetailDTO(foodDetail);
//		return foodDetailDTO;
//	}
}
