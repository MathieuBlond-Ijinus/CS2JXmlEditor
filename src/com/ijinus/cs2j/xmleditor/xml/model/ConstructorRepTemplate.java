package com.ijinus.cs2j.xmleditor.xml.model;

import java.util.ArrayList;
import java.util.List;

public class ConstructorRepTemplate extends TranslationBase {

	/*
	 * Attributes
	 */
	
	protected List<ParamRepTemplate> Params;
	
	/*
	 * Constructors
	 */
	
	public ConstructorRepTemplate(){
		Params = new ArrayList<ParamRepTemplate>();
	}
	
	/*
	 * Getters
	 */
	
	public List<ParamRepTemplate> getParams(){ return Params; }
	
	/*
	 * Setters
	 */

	public void setParams(List<ParamRepTemplate> params) {
		Params = params;
	}
	
}
