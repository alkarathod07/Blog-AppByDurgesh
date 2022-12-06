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
import com.BikkadIT.BlogApi.service.PostServiceI;
import com.BikkadIT.BlogApi.util.PostDto;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
private PostServiceI postServiceI;
	
	@PostMapping("/user/{userId}/catagory/{catagoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer catagoryId){
		PostDto createPost = this.postServiceI.createPost(postDto, userId, catagoryId);
				return  new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
		
	}
	//get buy user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postServiceI.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
		
	}
	@GetMapping("/catagory/{catagoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCatagory(@PathVariable Integer catagoryId){
		List<PostDto> catagoryPosts = this.postServiceI.getPostsByCatagory(catagoryId);
		return new ResponseEntity<List<PostDto>>(catagoryPosts, HttpStatus.OK);
		
	}
	
	//get all posts
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>>getAllPosts(){
		List<PostDto> allPost = this.postServiceI.getAllPost();
		return  new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
		
	}	
	
	//get post by id
	
	@GetMapping("posts/{postId}")
	public ResponseEntity<PostDto>getAllPosts(@PathVariable Integer postId){
		PostDto postDto = this.postServiceI.getPostById(postId);
		return  new ResponseEntity<PostDto>(postDto ,HttpStatus.OK);
		
	
}

//delete post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postServiceI.deletePost(postId);
		return  new ApiResponse("Post Deleted successfully!",true);
		
	}


//update post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
		PostDto updatePost = this.postServiceI.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
	}

















}








