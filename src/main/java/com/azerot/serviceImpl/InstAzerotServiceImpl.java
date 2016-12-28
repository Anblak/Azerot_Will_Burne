package com.azerot.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azerot.dao.InstAzerotDao;
import com.azerot.entity.Inst;

import com.azerot.service.InstAzerotService;
@Service
public class InstAzerotServiceImpl implements InstAzerotService{

	@Autowired
	private InstAzerotDao instAzerotDao;
	
	public void save(Inst inst) {
		instAzerotDao.save(inst);
	}
	
	public List<Inst> findAll() {
		return instAzerotDao.findAll();
	}
	
	public Inst findOne(int id) {
		return instAzerotDao.findOne(id);
	}
	
	public void delete(int id) {
		
		instAzerotDao.delete(id);
	}

	
}
