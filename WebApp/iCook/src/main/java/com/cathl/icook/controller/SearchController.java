package com.cathl.icook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cathl.icook.dto.FoodDTO;
import com.cathl.icook.service.FoodDetailSevices;
import com.cathl.icook.service.FoodService;
import com.cathl.icook.service.SearchService;
import com.cathl.icook.util.SearchObj;
import com.cathl.icook.util.TokenObj;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public List<FoodDTO> searchByMaterial(@RequestParam("materials") String materials, @RequestParam("start") int start,
										@RequestParam("limit") int limit) {
		System.out.println("Param: " + materials + "||" + start + "|| "+ limit);
		return searchService.searchByMaterials(materials, start, limit);
	}
}
