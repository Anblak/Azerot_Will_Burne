package com.azerot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azerot.dao.WorldAzerotDao;
import com.azerot.entity.World;
import com.azerot.service.WorldAzerotService;

@Service
public class WorldAzerotServiceImpl implements WorldAzerotService {

	@Autowired
	private WorldAzerotDao worldAzerotDao;
	
	public void save(World world) {
		worldAzerotDao.save(world);
		
	}

	public List<World> findAll() {
		
		return worldAzerotDao.findAll();
	}

	public World findOne(int id) {
		
		return worldAzerotDao.findOne(id);
	}

	public void delete(int id) {
		
		worldAzerotDao.delete(id);
		
	}
	
	
//	public World findWorldsWithMateriky(int id) {
//		
//		return worldAzerotDao.findWorldsWithMateriky(id);
//	}
	
	
}
