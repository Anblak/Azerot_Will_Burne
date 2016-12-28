package com.azerot.editor;

import java.beans.PropertyEditorSupport;

import com.azerot.service.InstAzerotService;

public class InstAzerotEditor extends PropertyEditorSupport{
	
	private final InstAzerotService instAzerotService;

	public InstAzerotEditor(InstAzerotService instAzerotService) {
		super();
		this.instAzerotService = instAzerotService;
	}
	@Override
	public void setAsText(String text)throws IllegalArgumentException{
		setValue(instAzerotService.findOne(Integer.parseInt(text)));
	}
}
