package com.BikkadIT.BlogApi.service;

import java.util.List;

import com.BikkadIT.BlogApi.util.CatagoryDto;

public interface CatagoryServiceI {
	
	//create
	
	CatagoryDto  createCatagory(CatagoryDto catagoryDto);
	//updare
	
	CatagoryDto  updateCatagory(CatagoryDto catagoryDto,Integer catagoryId);
	
	void  deleteCatagory(Integer catagoryId);

//getsingle
	
	CatagoryDto  getCatagory(Integer catagoryId);
	
//allget
	
	List<CatagoryDto>  getAllCatagories();
	

}




