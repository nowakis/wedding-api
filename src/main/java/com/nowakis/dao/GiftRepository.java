package com.nowakis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nowakis.model.Gift;

public interface GiftRepository extends CrudRepository<Gift, String> {
	List<Gift> findByCategoria(String categoria);
}
