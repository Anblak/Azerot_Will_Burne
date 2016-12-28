package com.azerot.editor;

import java.beans.PropertyEditorSupport;

import com.azerot.service.MatericAzerotService;


public class MatericAzerotEditor extends PropertyEditorSupport {

	private final MatericAzerotService matericAzerotService;

	public MatericAzerotEditor(MatericAzerotService matericAzerotService) {
		super();
		this.matericAzerotService = matericAzerotService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(matericAzerotService.findOne(Integer.parseInt(text)));
	}
	
}
