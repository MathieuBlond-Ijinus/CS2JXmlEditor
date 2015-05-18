package com.ijinus.cs2j.xmleditor.xml.model;

import java.util.ArrayList;
import java.util.List;

public abstract class TranslationBase {
	
	/*
	 * Attributes
	 */
	
	protected List<Import> Imports;
	protected String Java;
	protected String Warning;
	
	/*
	 * Constructors
	 */
	
	public TranslationBase() {
		Imports = new ArrayList<Import>();
		Java = "";
		Warning = "";
	}
	
	/*
	 * Getters
	 */
	
	public List<Import> getImports() { return Imports; }
	public String getJava(){ return Java; }
	public String getWarning(){ return Warning; }
	
	/*
	 * Setters
	 */
	
	public void setImports(List<Import> imports) { this.Imports = imports; }
	public void setJava(String java) { this.Java = java; }
	public void setWarning(String warning) { this.Warning = warning; }

}
