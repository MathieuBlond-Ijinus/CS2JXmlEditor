package com.ijinus.cs2j.xmleditor.xml.model;

import java.util.List;

public class IndexerRepTemplate extends PropRepTemplate {

	/*
	 * Attributes
	 */
	
	private List<ParamRepTemplate> Params;
	
	/*
	 * Getters
	 */

	public List<ParamRepTemplate> getParams() {
		return Params;
	}
	
	/*
	 * Setters
	 */

	public void setParams(List<ParamRepTemplate> params) {
		Params = params;
	}
	
}
