package com.azerot.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azerot.dto.DtoUtilMapper;
import com.azerot.dto.WorldDTO;
import com.azerot.entity.World;
import com.azerot.service.WorldAzerotService;

@Controller
public class WorldController {
	@Autowired
	private WorldAzerotService worldAzerotService;
	
	@RequestMapping(value="/newWorld", method=RequestMethod.GET)
	public String newWorld(){
		return "views-admin-newWorld";
	}
	
	
	@RequestMapping(value="/saveWorld", method=RequestMethod.POST)
	public @ResponseBody List<WorldDTO> saveWorld(@RequestBody World world ){
//		Hibernate.initialize(world.getMateriky());
		worldAzerotService.save(world);
		return DtoUtilMapper.wolrdToWorldsDTOs(worldAzerotService.findAll());
	}
	
	@RequestMapping(value="/loadWorlds",method=RequestMethod.POST)
	public @ResponseBody List<WorldDTO> loadWorlds(){
		
		return DtoUtilMapper.wolrdToWorldsDTOs(worldAzerotService.findAll());
	}
	
	   @RequestMapping(value = "/deleteWorld/{id}", method = RequestMethod.POST)
	    public @ResponseBody List<WorldDTO> loadWorlds(@PathVariable String id){

	        worldAzerotService.delete(Integer.parseInt(id));

	        return DtoUtilMapper.wolrdToWorldsDTOs(worldAzerotService.findAll());

	    }
	

}
