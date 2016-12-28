package com.azerot.editor;

import java.beans.PropertyEditorSupport;

import com.azerot.service.MobAzerotService;

public class MobAzerotEditor extends PropertyEditorSupport {

	private final MobAzerotService mobAzerotService;

	public MobAzerotEditor(MobAzerotService mobAzerotService) {
		super();
		this.mobAzerotService = mobAzerotService;
	}
	
	@Override
	public void setAsText(String text)throws IllegalArgumentException{
		setValue(mobAzerotService.findOne(Integer.parseInt(text)));
	}
	
}
