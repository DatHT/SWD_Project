package com.cathl.icook.service;

import java.util.List;

import com.cathl.icook.dto.FoodDTO;

public interface SearchService {
	public List<FoodDTO> searchByMaterials(String materials, int start, int limit);
}
