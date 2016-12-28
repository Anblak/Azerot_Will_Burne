package com.azerot.service;

import java.util.List;

import com.azerot.entity.Materic;



public interface MatericAzerotService {
	void save(Materic materic);
	List<Materic> findAll();
	Materic findOne(int id);
	void delete(int id);
}
