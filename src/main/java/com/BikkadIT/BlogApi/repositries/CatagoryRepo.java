package com.BikkadIT.BlogApi.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.BlogApi.entites.Catagory;

public interface CatagoryRepo extends JpaRepository<Catagory, Integer> {

}
