package com.BikkadIT.BlogApi.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.BikkadIT.BlogApi.entites.User;
import com.BikkadIT.BlogApi.exception.ResourceNotFoundException;
import com.BikkadIT.BlogApi.repositries.UserRepo;
import com.BikkadIT.BlogApi.service.UserServiceI;
import com.BikkadIT.BlogApi.util.UserDto;
@Service
public class UserServiceImpl implements UserServiceI {
	@Autowired
private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
				
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout() );
		User updatedUser = userRepo.save(user);
		
		UserDto userDto2 = this.userToDto(updatedUser);
		return userDto2;
	}

	@Override
	public UserDto getUserById( Integer userId) {
		User user = this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user) ;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
	List<UserDto>userDtos=	users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		
	}
private User dtoToUser(UserDto userDto) {
	User user=this.modelMapper.map(userDto, User.class);
	/*user.setId(userDto.getId());
	user.setName(userDto.getName());
	user.setEmail(userDto.getEmail());
	user.setPassword(userDto.getPassword());
	user.setAbout(userDto.getAbout());*/
	
		return user;
}
	public UserDto userToDto(User user) {
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		
		return userDto;
		
	}
}
	
	

