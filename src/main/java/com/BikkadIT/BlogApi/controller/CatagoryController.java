package com.BikkadIT.BlogApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.BikkadIT.BlogApi.payload.ApiResponse;
import com.BikkadIT.BlogApi.service.CatagoryServiceI;
import com.BikkadIT.BlogApi.util.CatagoryDto;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/categories")
public class CatagoryController {
	@Autowired
	private CatagoryServiceI catagoryServiceI;
	@PostMapping("/")
	public ResponseEntity<CatagoryDto> createCatgory(@Valid @RequestBody CatagoryDto catagoryDto){
		CatagoryDto createCatagory = this.catagoryServiceI.createCatagory(catagoryDto);
		
		return new ResponseEntity<CatagoryDto>(createCatagory,HttpStatus.CREATED);
		
	}
	@PutMapping("/{catId}")
	public ResponseEntity<CatagoryDto> updateCatgory(@Valid @RequestBody CatagoryDto catagoryDto ,@PathVariable Integer catId){
		CatagoryDto updateCatagory = this.catagoryServiceI.updateCatagory(catagoryDto, catId);
		
		return new ResponseEntity<CatagoryDto>(updateCatagory,HttpStatus.OK);
		
	}
	

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCatgory(@PathVariable Integer catId){
		 this.catagoryServiceI.deleteCatagory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Delete catagory sucessful !!",true),HttpStatus.OK);
		
	}

	@GetMapping("/{catId}")
	public ResponseEntity<CatagoryDto> getCatgory(@PathVariable Integer catId){
		 CatagoryDto catagoryDto = this.catagoryServiceI.getCatagory(catId);
		
		return new ResponseEntity<CatagoryDto>(catagoryDto,HttpStatus.OK);
		
	}



	@GetMapping("/")
	public ResponseEntity <List<CatagoryDto>> getCatgories(){
		List<CatagoryDto> catagories = this.catagoryServiceI.getAllCatagories();
		return ResponseEntity.ok(catagories);
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	












}


