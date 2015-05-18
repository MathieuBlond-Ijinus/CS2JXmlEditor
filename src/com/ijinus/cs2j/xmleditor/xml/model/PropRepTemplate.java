package com.ijinus.cs2j.xmleditor.xml.model;

public class PropRepTemplate extends FieldRepTemplate{

	/*
	 * Attributes
	 */
	
	protected String Get;
	protected String Set;
	
	/*
	 * Getters
	 */
	
	public String getGet(){ return Get; }
	public String getSet(){ return Set; }
	
	/*
	 * Setters
	 */
	
	public void setGet(String get) {
		Get = get;
	}
	public void setSet(String set) {
		Set = set;
	}
	
}
