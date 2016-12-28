package com.azerot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.azerot.dto.DtoUtilMapper;
import com.azerot.editor.AreaAzerotEditor;

import com.azerot.entity.Area;
import com.azerot.entity.Mob;

import com.azerot.service.AreaAzerotService;
import com.azerot.service.MobAzerotService;


@Controller
public class MobController {
	
	@Autowired
	private MobAzerotService mobAzerotService;
	

	
	@Autowired
	private AreaAzerotService areaAzerotService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Area.class, new AreaAzerotEditor(areaAzerotService));
	}
	
	@RequestMapping(value="/newMob",method=RequestMethod.GET)
	public String newMob(Model model){
		model.addAttribute("mobs", mobAzerotService.findAll());
		model.addAttribute("mob", new Mob());
		model.addAttribute("areasDTOs",DtoUtilMapper.areaToAreasDTOs(areaAzerotService.findAll()));
		
		return "views-admin-newMob";
	}
		
	@RequestMapping(value="/saveMob",method=RequestMethod.POST)
	public String saveMob(@ModelAttribute Mob mob){
		mobAzerotService.save(mob);
		
		return"redirect:/newMob";
	}
	@RequestMapping(value="/deleteMob/{id}",method=RequestMethod.GET)
	public String newBook(@PathVariable String id){
		mobAzerotService.delete(Integer.parseInt(id));
		return"redirect:/newMob";
	}
	
}
