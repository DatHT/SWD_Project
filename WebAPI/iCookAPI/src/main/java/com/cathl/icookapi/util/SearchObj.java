package com.cathl.icookapi.util;

public class SearchObj {
	private String materials;
	private int start;
	private int limit;
	
	public SearchObj() {
		// TODO Auto-generated constructor stub
	}

	public SearchObj(String materials, int start, int limit) {
		super();
		this.materials = materials;
		this.start = start;
		this.limit = limit;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
