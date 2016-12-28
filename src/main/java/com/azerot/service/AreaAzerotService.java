package com.azerot.service;

import java.util.List;

import com.azerot.entity.Area;



public interface AreaAzerotService {
	void save(Area area);
	List<Area> findAll();
	Area findOne(int id);
	void delete(int id);
	
	void deleteInstFromArea(String idInst);
//	List<Area> findAreaWithInsts();
	void saveAndFlush(Area area);
}
