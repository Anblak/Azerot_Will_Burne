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


import com.azerot.editor.AreaAzerotEditor;
import com.azerot.entity.Area;
import com.azerot.entity.Inst;
import com.azerot.service.AreaAzerotService;
import com.azerot.service.InstAzerotService;

@Controller
public class InstController {

	@Autowired
	private InstAzerotService instAzerotService;
	
	@Autowired
	private AreaAzerotService areaAzerotService;
	
	@InitBinder
	protected void innerBinder(WebDataBinder binder){
		binder.registerCustomEditor(Area.class, new AreaAzerotEditor(areaAzerotService));
	}
	@RequestMapping(value="/newInst",method=RequestMethod.GET)
	public String newInst(Model model){
		model.addAttribute("insts",instAzerotService.findAll());
		model.addAttribute("inst", new Inst());
		model.addAttribute("areas", areaAzerotService.findAll());
		return "views-admin-newInst";
	}
	@RequestMapping(value="/saveInst",method=RequestMethod.POST)
	public String saveInst(@ModelAttribute Inst inst){
		instAzerotService.save(inst);
		return "redirect:/newInst";
	}
	@RequestMapping(value = "/deleteInst/{id}", method = RequestMethod.GET)
	public String newInst(@PathVariable int id) {

		areaAzerotService.delete(id);

		return "redirect:/newInst";
	}
	
}
