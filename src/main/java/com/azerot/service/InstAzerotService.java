package com.azerot.service;

import java.util.List;

import com.azerot.entity.Inst;



public interface InstAzerotService {
	void save(Inst inst);
	List<Inst> findAll();
	Inst findOne(int id);
	void delete(int id);
	
}
