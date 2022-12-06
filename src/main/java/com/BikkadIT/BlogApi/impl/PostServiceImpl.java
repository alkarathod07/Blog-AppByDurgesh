package com.BikkadIT.BlogApi.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.BlogApi.entites.Catagory;
import com.BikkadIT.BlogApi.entites.Post;
import com.BikkadIT.BlogApi.entites.User;
import com.BikkadIT.BlogApi.exception.ResourceNotFoundException;
import com.BikkadIT.BlogApi.repositries.CatagoryRepo;
import com.BikkadIT.BlogApi.repositries.PostRepo;
import com.BikkadIT.BlogApi.repositries.UserRepo;
import com.BikkadIT.BlogApi.service.PostServiceI;
import com.BikkadIT.BlogApi.util.PostDto;

@Service
public class PostServiceImpl implements PostServiceI {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CatagoryRepo catagoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId) {
		Post post = this.modelMapper.map(postDto, Post.class);
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		Catagory catagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("catagory", "catagoryId", catagoryId));

		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCatagory(catagory);
		Post newPost = this.postRepo.save(post);

		return this.modelMapper.map(newPost, PostDto.class);
	}

	
	//update post
	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatePost=this.postRepo.save(post);
		return this.modelMapper.map(updatePost, PostDto.class);
	}

//delete post
	public void deletePost(Integer postId) {
	Post post=	this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
  this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		 List<Post> allPosts = this.postRepo.findAll();
		List<PostDto>postDtos= allPosts.stream().map((post)->this.modelMapper.map(allPosts, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCatagory(Integer catagoryId) {
		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));
		List<PostDto> posts = this.postRepo.findByCatagory(cat);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		List<PostDto> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<Post> searchByPost(String ketword) {
		// TODO Auto-generated method stub
		return null;
	}

}
