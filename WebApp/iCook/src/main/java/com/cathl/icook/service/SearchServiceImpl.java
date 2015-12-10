package com.cathl.icook.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cathl.icook.dao.FoodDAO;
import com.cathl.icook.dto.FoodDTO;
import com.cathl.icook.entity.TblFood;
import com.cathl.icook.util.ConstantDataManager;
import com.cathl.icook.util.SearchObj;
import com.cathl.icook.util.TokenObj;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
	public final static String AUTHEN_URL = ConstantDataManager.SERVER_URL + ConstantDataManager.API_AUTHEN_URL;
	public final static String SEARCH_URL = ConstantDataManager.SERVER_URL + "search";
	RestTemplate restTemplate;
	@Autowired
	private FoodDAO foodDAO;
	
	@Override
	public List<FoodDTO> searchByAPI(String materials, int start, int limit) {
		restTemplate = new RestTemplate();
		
		//get token_access
		TokenObj tokenObj = restTemplate.getForObject(AUTHEN_URL, TokenObj.class);
		//init json object to send request 
		SearchObj searchObj = new SearchObj(materials, start, limit);
		//init header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + tokenObj.getAccessToken());
		headers.add("Content-Type", "application/json");
		//get message converters
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		//set header + body to request
		HttpEntity<SearchObj> request = new HttpEntity<SearchObj>(searchObj, headers);
		//get result
		List<FoodDTO> result = (List<FoodDTO>) restTemplate.postForObject(SEARCH_URL, request, List.class);
		return result;
	}

	public List<FoodDTO> searchByMaterials(String materials, int start, int limit) {
		List<TblFood> listTblFood = foodDAO.searchByMaterial(materials, start, limit);
		List<FoodDTO> listFoodDTO = new ArrayList<FoodDTO>();
		for (TblFood food : listTblFood) {
			listFoodDTO.add(new FoodDTO(food));
		}
		return listFoodDTO;
	}
}
