package com.BikkadIT.BlogApi.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.BlogApi.entites.Catagory;
import com.BikkadIT.BlogApi.exception.ResourceNotFoundException;
import com.BikkadIT.BlogApi.repositries.CatagoryRepo;
import com.BikkadIT.BlogApi.service.CatagoryServiceI;
import com.BikkadIT.BlogApi.util.CatagoryDto;
@Service
public class CatagoryServiceImpl implements CatagoryServiceI{
	
  @Autowired
	private CatagoryRepo catagoryRepo;
  
  @Autowired
   private ModelMapper modelMapper;
	@Override
	public CatagoryDto createCatagory(CatagoryDto catagoryDto) {
		Catagory cat= this.modelMapper.map(catagoryDto, Catagory.class);
		Catagory addcatagory = this.catagoryRepo.save(cat);
		return this.modelMapper.map(addcatagory, CatagoryDto.class) ;
	}
	
	//update

	@Override
	public CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer catagoryId) {
		Catagory cat=this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));
  cat.setCatagoryTitle(catagoryDto.getCatagoryTitle());
  cat.setCatagoryDecription(catagoryDto.getCatagoryDecription());
  Catagory catagory = this.catagoryRepo.save(cat);
		return this.modelMapper.map(catagory,CatagoryDto.class );
	}

	
	//delete
	@Override
	public void deleteCatagory(Integer catagoryId) {
	Catagory cat=this.catagoryRepo.findById(catagoryId).orElseThrow(()->new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));
	this.catagoryRepo.delete(cat);
	}

	@Override
	public CatagoryDto getCatagory(Integer catagoryId) {
		Catagory cat=this.catagoryRepo.findById(catagoryId).orElseThrow(()-> new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));
		return this.modelMapper.map(cat, CatagoryDto.class);
	}

	@Override
	public List<CatagoryDto> getAllCatagories() {
		List<Catagory> catagories = this.catagoryRepo.findAll();
		List<CatagoryDto> catDtos = catagories.stream().map((cat)->this.modelMapper.map(cat, CatagoryDto.class)).collect(Collectors.toList());
		
		return  catDtos;
	}

}
