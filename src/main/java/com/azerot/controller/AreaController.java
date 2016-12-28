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

import com.azerot.editor.InstAzerotEditor;
import com.azerot.editor.MatericAzerotEditor;
import com.azerot.entity.Area;
import com.azerot.entity.Inst;
import com.azerot.entity.Materic;
import com.azerot.service.AreaAzerotService;
import com.azerot.service.InstAzerotService;
import com.azerot.service.MatericAzerotService;



@Controller
public class AreaController {
	
	@Autowired
	private AreaAzerotService areaAzerotService;
	@Autowired
	private MatericAzerotService matericAzerotService;
	@Autowired
	private InstAzerotService instAzerotService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Inst.class, new InstAzerotEditor(instAzerotService));
		binder.registerCustomEditor(Materic.class, new MatericAzerotEditor(matericAzerotService));
	}
	
	@RequestMapping(value="/newArea",method=RequestMethod.GET)
	public String newArea(Model model){
		model.addAttribute("area", new Area());
		model.addAttribute("areas",areaAzerotService.findAll());
		model.addAttribute("materiky", matericAzerotService.findAll());
		model.addAttribute("inst", new Inst());
		model.addAttribute("insts", instAzerotService.findAll());
		return "views-admin-newArea";
	}
	@RequestMapping(value="/saveArea",method=RequestMethod.POST)
	public String saveArea(@ModelAttribute Area area){
		areaAzerotService.save(area);
		return "redirect:/newArea";
	}
	
	@RequestMapping(value = "/deleteArea/{id}", method = RequestMethod.GET)
	public String newAuthor(@PathVariable String id) {
		areaAzerotService.delete(Integer.parseInt(id));
		return "redirect:/newArea";
	}
	
	
	@RequestMapping(value="/deleteInstFromArea/{idInst}")
	public String deleteInstFromArea(@PathVariable String idInst){
		
		areaAzerotService.deleteInstFromArea(idInst);
		
		return "redirect:/newArea";
	}
	
	
	
}
