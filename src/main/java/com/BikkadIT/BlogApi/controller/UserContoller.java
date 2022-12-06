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
import com.BikkadIT.BlogApi.service.UserServiceI;
import com.BikkadIT.BlogApi.util.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserContoller {
@Autowired
private UserServiceI userServiceI;

@PostMapping("")
public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
	UserDto createUserDto = this.userServiceI.createUser(userDto);
	return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
}

@PutMapping(value= ("/{userId}"))
public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
	UserDto updateUser = this.userServiceI.updateUser(userDto, userId);
	return  ResponseEntity.ok(updateUser);
	
}
@DeleteMapping(value= ("/{userId}"))
public ResponseEntity<ApiResponse> deleteUser(@PathVariable  Integer userId){
	this.userServiceI.deleteUser(userId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successful",true), HttpStatus.OK);
	
}
@GetMapping("/")
public  ResponseEntity<List<UserDto>> getAllUsers(){
	return  ResponseEntity.ok(this.userServiceI.getAllUsers());
	
	
}

@GetMapping("/{userId}")
public  ResponseEntity<UserDto> getSinggleUser(@PathVariable Integer userId){
	return ResponseEntity.ok( this.userServiceI.getUserById(userId));
}
}
