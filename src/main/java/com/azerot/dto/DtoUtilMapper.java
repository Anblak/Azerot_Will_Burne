package com.azerot.dto;

import java.util.ArrayList;
import java.util.List;

import com.azerot.entity.Area;
import com.azerot.entity.Inst;
import com.azerot.entity.Mob;
import com.azerot.entity.User;
import com.azerot.entity.World;

public class DtoUtilMapper {
	
	public static List<UserDTO> userTOUserDTOs(List<User>users){
		List<UserDTO> userDTOs=new ArrayList<UserDTO>();
		for(User user:users){
			UserDTO userDTO=new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}
	
	
	
	

	public static List<AreaDTO> areaToAreasDTOs(List<Area> areas){
		List<AreaDTO> areaDTOs=new ArrayList<AreaDTO>();
		 
		for (Area area : areas) {
//			AreaDTO areaDTO=new AreaDTO();
//			areaDTO.setName(area.getName());
//			areaDTO.setMinLvlOfMob(area.getMinLvlOfMob());
//			areaDTO.setMaxLvlOfMob(area.getMaxLvlOfMob());
			areaDTOs.add(new AreaDTO(area.getId(),area.getName()));
		}
		
		return areaDTOs;	
	}
	
	public static List<MobDTO> mobToMobsDTOs(List<Mob> mobs){
		List<MobDTO> mobDTOs=new ArrayList<MobDTO>();
		for (Mob mob : mobs) {
			MobDTO mobDTO=new MobDTO();
			mobDTO.setName(mob.getName());
			mobDTO.setLvl(mob.getLvl());
			mobDTO.setHp(mob.getHp());
			mobDTO.setManapool(mob.getManapool());
			mobDTO.setAttack(mob.getAttack());
			mobDTO.setAgr(mob.getAgr());
			
			mobDTOs.add(mobDTO);		
		}
		return mobDTOs;
	}
	public static List<WorldDTO>wolrdToWorldsDTOs(List<World> worlds){
		List<WorldDTO> worldDTOs=new ArrayList<WorldDTO>();
		for(World world : worlds){
			worldDTOs.add(new WorldDTO(world.getId(),world.getName()));
		}
		return worldDTOs;
	}
	
	public static List<InstDTO> instToInstsDTOs(List<Inst> insts){
		List<InstDTO>instDTOs=new ArrayList<InstDTO>();
		for(Inst inst : insts){
			
			instDTOs.add(new InstDTO(inst.getId(), inst.getName()));
		}
		return instDTOs;
	}
	
}
