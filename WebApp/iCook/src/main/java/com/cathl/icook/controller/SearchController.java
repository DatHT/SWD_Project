package com.cathl.icook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cathl.icook.dto.FoodDTO;
import com.cathl.icook.entity.TblFood;
import com.cathl.icook.entity.TblFoodDetail;
import com.cathl.icook.service.FoodDetailSevices;
import com.cathl.icook.service.FoodService;
import com.cathl.icook.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodDetailSevices foodDetailService;

	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public List<FoodDTO> searchByMaterial(@RequestParam("materials") String materials, @RequestParam("start") int start,
										@RequestParam("limit") int limit) {
		System.out.println("Param: " + materials + "||" + start + "|| "+ limit);
		return searchService.searchByMaterials(materials, start, limit);
	}
	
	@RequestMapping(value = "/food/{id}")
	public String searchByMaterial(@PathVariable("id") int foodID, Model model) {
		TblFoodDetail foodDetail = foodDetailService.getFoodDetailID(foodID);
		TblFood food = foodService.incrVisitNum(foodID);
		model.addAttribute("foodDetail", foodDetail);
		model.addAttribute("food", food);
		return "detail";
	}
}
