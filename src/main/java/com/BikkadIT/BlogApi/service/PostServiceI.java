package com.BikkadIT.BlogApi.service;

import java.util.List;

import com.BikkadIT.BlogApi.entites.Post;
import com.BikkadIT.BlogApi.util.PostDto;

public interface PostServiceI {

	//create
	PostDto createPost(PostDto postDto ,Integer userId,Integer catagoryId);
	
	//updare
	 PostDto updatePost(PostDto postDto,Integer postId);
	 
	 
	//Delete
	 void deletePost(Integer postId);
	 
	 //getall
	List<PostDto> getAllPost();
	 
	 //getsingle
	 PostDto getPostById(Integer postId);
	 
	 //catagory
	 
	 List<PostDto> getPostsByCatagory(Integer catagoryId);
	  
	 
	 //by user
	 List<PostDto>getPostsByUser(Integer userId);
	 
	 //search
	 List<Post> searchByPost(String  ketword);
}
