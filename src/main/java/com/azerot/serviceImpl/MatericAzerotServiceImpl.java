package com.azerot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azerot.dao.MatericAzerotDao;
import com.azerot.entity.Materic;
import com.azerot.service.MatericAzerotService;
@Service
public class MatericAzerotServiceImpl implements MatericAzerotService{

	@Autowired
	private MatericAzerotDao matericAzerotDao;
	
	public void save(Materic materic) {
		matericAzerotDao.save(materic);
		
	}

	public List<Materic> findAll() {
		
		return matericAzerotDao.findAll();
	}

	public Materic findOne(int id) {
		
		return matericAzerotDao.findOne(id);
	}

	public void delete(int id) {
		matericAzerotDao.delete(id);
		
	}

}
