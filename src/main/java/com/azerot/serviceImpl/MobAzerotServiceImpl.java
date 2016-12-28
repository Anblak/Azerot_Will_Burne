package com.azerot.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.azerot.dao.MobAzerotDao;
import com.azerot.entity.Mob;
import com.azerot.service.MobAzerotService;


@Service
public class MobAzerotServiceImpl implements MobAzerotService {
	
	@Autowired
	private MobAzerotDao mobAzerotDao;
	
	
	public void save(Mob mob) {
		mobAzerotDao.save(mob);
	}

	public List<Mob> findAll() {
		return mobAzerotDao.findAll();
	}

	public Mob findOne(int id) {
		return mobAzerotDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
//		Mob mob=mobAzerotDao.findOne(id);
//		for(Area area: area.getMobs()){
//			area.setMobs(null);
//			mobAzerotDao.save(area);
//		}
		
		mobAzerotDao.delete(id);
	}
}
