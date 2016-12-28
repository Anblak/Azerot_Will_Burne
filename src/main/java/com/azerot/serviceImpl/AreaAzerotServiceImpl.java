package com.azerot.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azerot.dao.AreaAzerotDao;
import com.azerot.dao.InstAzerotDao;
import com.azerot.entity.Area;
import com.azerot.entity.Inst;
import com.azerot.service.AreaAzerotService;
@Service
public class AreaAzerotServiceImpl implements AreaAzerotService {

	@Autowired
	private AreaAzerotDao areaAzerotDao;
	@Autowired
	private InstAzerotDao instAzerotDao;
	
	public void save(Area area) {
		areaAzerotDao.save(area);
	}
	
	public List<Area> findAll() {
		
		return areaAzerotDao.findAll();
	}

	public Area findOne(int id) {
		return areaAzerotDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
		Area area=areaAzerotDao.findOne(id);
		for(Inst inst: area.getInsts()){
			inst.setArea(null);
			instAzerotDao.save(inst);
		}
		
		
		areaAzerotDao.delete(area);
		
	}
	
	public void saveAndFlush(Area area) {
		
		areaAzerotDao.saveAndFlush(area);
	}
	
	@Transactional
	public void deleteInstFromArea(String idInst) {
		Inst inst=instAzerotDao.findOne(Integer.parseInt(idInst));
		inst.setArea(null);
		instAzerotDao.save(inst);
	}

//	public List<Area> findAreaWithInsts() {
//		
//		return areaAzerotDao.findAreaWithInst();
//	}

	



}
