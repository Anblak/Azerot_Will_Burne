package com.azerot.service;

import java.util.List;

import com.azerot.entity.Mob;



public interface MobAzerotService {
	void save(Mob mob);
	List<Mob> findAll();
	Mob findOne(int id);
	void delete(int id);
}
