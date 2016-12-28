package com.azerot.service;

import java.util.List;

import com.azerot.entity.World;



public interface WorldAzerotService {

	void save(World world);
	List<World> findAll();
	World findOne(int id);
	void delete(int id);
	
//	World findWorldsWithMateriky(int id);
}
