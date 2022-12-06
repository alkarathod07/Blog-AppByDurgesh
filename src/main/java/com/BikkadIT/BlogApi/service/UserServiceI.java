package com.BikkadIT.BlogApi.service;

import java.util.List;

import com.BikkadIT.BlogApi.util.UserDto;

public interface UserServiceI {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
