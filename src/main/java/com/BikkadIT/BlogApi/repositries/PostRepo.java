package com.BikkadIT.BlogApi.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.BlogApi.entites.Catagory;
import com.BikkadIT.BlogApi.entites.Post;
import com.BikkadIT.BlogApi.entites.User;
import com.BikkadIT.BlogApi.util.PostDto;

public interface PostRepo extends JpaRepository<Post,Integer> {
	List<PostDto>findByUser(User user);

	List<PostDto>findByCatagory(Catagory catagory);
}
