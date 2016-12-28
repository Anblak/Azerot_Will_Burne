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

import com.azerot.editor.WorldAzerotEditor;
import com.azerot.entity.Materic;
import com.azerot.entity.World;
import com.azerot.service.MatericAzerotService;
import com.azerot.service.WorldAzerotService;

@Controller
public class MatericController {

	@Autowired
	private MatericAzerotService matericAzerotService;
	@Autowired
	private WorldAzerotService worldAzerotService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(World.class, new WorldAzerotEditor(worldAzerotService));
	}
	
	@RequestMapping(value="/newMateric", method=RequestMethod.GET)
	public String newMateric(Model model){
		
		model.addAttribute("materic", new Materic());
		model.addAttribute("worlds", worldAzerotService.findAll());
		
		return "views-admin-newMateric";
	}
	@RequestMapping(value="/saveMateric",method=RequestMethod.POST)
	public String saveMateric(@ModelAttribute Materic materic){
		matericAzerotService.save(materic);
		return "redirect:/newMateric";	
	}
	@RequestMapping(value = "/deleteMatric/{id}", method = RequestMethod.GET)
	public String newMateric(@PathVariable int id) {

		matericAzerotService.delete(id);

		return "redirect:/newMateric";
	}
	
	
}
