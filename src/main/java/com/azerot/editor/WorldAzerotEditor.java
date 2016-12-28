package com.azerot.editor;


import java.beans.PropertyEditorSupport;

import com.azerot.service.WorldAzerotService;

public class WorldAzerotEditor extends PropertyEditorSupport {
	
	private final WorldAzerotService worldAzerotService;

	public WorldAzerotEditor(WorldAzerotService worldAzerotService) {
		super();
		this.worldAzerotService = worldAzerotService;
	}
	
	
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(worldAzerotService.findOne(Integer.parseInt(text)));
	}
}
