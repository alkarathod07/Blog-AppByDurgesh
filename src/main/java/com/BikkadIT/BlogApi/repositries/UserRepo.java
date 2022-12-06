package com.BikkadIT.BlogApi.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.BlogApi.entites.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
