package com.azerot.editor;

import java.beans.PropertyEditorSupport;

import com.azerot.service.AreaAzerotService;

public class AreaAzerotEditor extends PropertyEditorSupport{

	private final AreaAzerotService areaAzerotService;

	public AreaAzerotEditor(AreaAzerotService areaAzerotService) {
		super();
		this.areaAzerotService = areaAzerotService;
	}
	@Override
	public void setAsText(String text)throws IllegalArgumentException{
		setValue(areaAzerotService.findOne(Integer.parseInt(text)));
	}
	
}
