package com.cathl.icookapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cathl.icookapi.dto.FoodDTO;
import com.cathl.icookapi.dto.FoodDetailDTO;
import com.cathl.icookapi.entity.Food;
import com.cathl.icookapi.entity.FoodDetail;
import com.cathl.icookapi.service.FoodDetailService;
import com.cathl.icookapi.service.FoodService;
import com.cathl.icookapi.util.SearchObj;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

@RestController
public class FoodController {

	public FoodController() {
		System.out.println("FoodController()");
	}

	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodDetailService foodDetailService;

	/*//Function use for debugging
	@RequestMapping("/food/{id}")
	public Food getFood(@PathVariable("id") int foodId) {
		Food food = foodService.getFood(foodId);
		// FoodDTO foodDTO = new FoodDTO(food);
		return food;
	}*/

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public List<FoodDTO> searchByMaterial(@RequestBody SearchObj searchObj) {
		List<Food> listFood = foodService.searchByMaterial(searchObj.getMaterials(), searchObj.getStart(),
				searchObj.getLimit());
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
		for (Food food : listFood) {
			listFoodDTO.add(new FoodDTO(food));
		}
		return listFoodDTO;
	}

	@RequestMapping("search/{id}")
	public FoodDetailDTO getFoodDetail(@PathVariable("id") int id) {
		FoodDetail foodDetail = foodDetailService.getFood(id);
		FoodDetailDTO foodDetailDTO = new FoodDetailDTO(foodDetail);
		return foodDetailDTO;
	}
}
