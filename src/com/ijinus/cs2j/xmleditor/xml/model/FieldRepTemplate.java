package com.ijinus.cs2j.xmleditor.xml.model;

public class FieldRepTemplate extends TranslationBase{

	/*
	 * Attributes
	 */
	
	protected String Type;
	protected String Name;
	
	/*
	 * Getters
	 */
	
	public String getType() {
		return Type;
	}
	public String getName() {
		return Name;
	}
	
	/*
	 * Setters
	 */
	
	public void setType(String type) {
		Type = type;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
