package com.ijinus.cs2j.xmleditor.xml.model;

import java.util.List;

public class ClassRepTemplate extends InterfaceRepTemplate{

	/*
	 * Attributes
	 */
	
	protected String BoxedJava;

	//protected List<ConstructorRepTemplate> Constructors;                     NOW IN InterfaceRepTemplate 
	protected List<FieldRepTemplate> Fields;
	protected List<UnaryOp> UnaryOps;
	protected List<BinaryOp> BinaryOps;
	
	/*
	 * Getters
	 */

	public String getBoxedJava() {
		return BoxedJava;
	}
	
	/*
	public List<ConstructorRepTemplate> getConstructors() {
		return Constructors;
	}*/

	public List<FieldRepTemplate> getFields() {
		return Fields;
	}

	public List<UnaryOp> getUnaryOps() {
		return UnaryOps;
	}

	public List<BinaryOp> getBinaryOps() {
		return BinaryOps;
	}
	
	/*
	 * Setters
	 */

	public void setBoxedJava(String boxedJava) {
		BoxedJava = boxedJava;
	}

	/*
	public void setConstructors(List<ConstructorRepTemplate> constructors) {
		Constructors = constructors;
	}*/

	public void setFields(List<FieldRepTemplate> fields) {
		Fields = fields;
	}

	public void setUnaryOps(List<UnaryOp> unaryOps) {
		UnaryOps = unaryOps;
	}

	public void setBinaryOps(List<BinaryOp> binaryOps) {
		BinaryOps = binaryOps;
	}
	
}
