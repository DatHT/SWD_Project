package com.cathl.icook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cathl.icook.dto.FoodDTO;
import com.cathl.icook.entity.TblFood;
import com.cathl.icook.service.FoodDetailSevices;
import com.cathl.icook.service.FoodService;
import com.cathl.icook.util.SearchObj;
import com.cathl.icook.util.TokenObj;

@Controller
public class SearchController {

	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodDetailSevices foodDetailService;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	// public List<FoodDTO> searchByMaterial(@RequestBody SearchObj searchObj) {
	public FoodDTO[] searchByMaterial() {
		String authenURL = "http://localhost:8080/iCookAPI/oauth/token?grant_type=password&client_id=mobileapp&client_secret=mobileapp&username=datht&password=datht@cathl";
		String searchURL = "http://localhost:8080/iCookAPI/search";
		RestTemplate restTemplate = new RestTemplate();
		
		TokenObj tokenObj = restTemplate.getForObject(authenURL, TokenObj.class);
		SearchObj searchObj = new SearchObj("thit bo", 0, 20);
		
//		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//		headers.add("Authorization", "Bearer " + tokenObj.getAccessToken());
//		headers.add("Content-Type", "application/json");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + tokenObj.getAccessToken());
		headers.add("Content-Type", "application/json");

		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<SearchObj> request = new HttpEntity<SearchObj>(searchObj, headers);

		FoodDTO[] result = restTemplate.postForObject(searchURL, request, FoodDTO[].class);

		System.out.println(result.length);
		return result;
	}
}
