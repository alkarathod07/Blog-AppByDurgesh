package com.BikkadIT.BlogApi.util;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CatagoryDto {
	
	private Integer catagoryId;
	@NotNull
	@Size(min=4 ,message="minimum 4 character")
	private String catagoryTitle;
	@NotNull
	@Size(min=10 ,message="minimum 10 character" )
	private String catagoryDecription;
	public Integer getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}
	public String getCatagoryTitle() {
		return catagoryTitle;
	}
	public void setCatagoryTitle(String catagoryTitle) {
		this.catagoryTitle = catagoryTitle;
	}
	public String getCatagoryDecription() {
		return catagoryDecription;
	}
	public void setCatagoryDecription(String catagoryDecription) {
		this.catagoryDecription = catagoryDecription;
	}
	@Override
	public String toString() {
		return "CatagoryDto [catagoryId=" + catagoryId + ", catagoryTitle=" + catagoryTitle + ", catagoryDecription="
				+ catagoryDecription + "]";
	}
	public CatagoryDto(Integer catagoryId,
			@NotNull @Size(min = 4, message = "minimum 4 character") String catagoryTitle,
			@NotNull @Size(min = 10, message = "minimum 10 character") String catagoryDecription) {
		super();
		this.catagoryId = catagoryId;
		this.catagoryTitle = catagoryTitle;
		this.catagoryDecription = catagoryDecription;
	}
	public CatagoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
