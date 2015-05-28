package com.ijinus.cs2j.xmleditor.xml.model;

import java.util.ArrayList;
import java.util.List;

public class MethodRepTemplate extends ConstructorRepTemplate {

	/*
	 * Attributes
	 */
	
	private String Name;
	private List<TypeParam> TypeParams;
	private List<TypeParam> ParamArray;
	private String Return;
	
	/*
	 * Constructor
	 */
	
	public MethodRepTemplate() {
		super();
		Name = "";
		TypeParams = new ArrayList<TypeParam>();
		Return = "";
	}
	
	/*
	 * Getters
	 */
	

	public String getName(){ return Name; }
	public List<TypeParam> getTypeParams(){ return TypeParams; }
	public String getReturn(){ return Return; }
	
	/*
	 * Setters 
	 */
	
	public void setName(String name) {
		Name = name;
	}
	public void setTypeParams(List<TypeParam> typeParams) {
		TypeParams = typeParams;
	}
	public void setReturn(String return1) {
		Return = return1;
	}
	
}
