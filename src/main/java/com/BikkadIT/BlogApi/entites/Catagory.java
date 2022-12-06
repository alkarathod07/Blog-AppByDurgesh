package com.BikkadIT.BlogApi.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Catagory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catagoryId;
	private String catagoryTitle;
	private String catagoryDecription;
	
	@OneToMany(mappedBy="catagory", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post>posts=new ArrayList<>();
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
		return "Catagory [catagoryId=" + catagoryId + ", catagoryTitle=" + catagoryTitle + ", catagoryDecription="
				+ catagoryDecription + "]";
	}
	public Catagory(Integer catagoryId, String catagoryTitle, String catagoryDecription) {
		super();
		this.catagoryId = catagoryId;
		this.catagoryTitle = catagoryTitle;
		this.catagoryDecription = catagoryDecription;
	}
	public Catagory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}