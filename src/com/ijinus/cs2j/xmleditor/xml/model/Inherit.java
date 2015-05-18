package com.ijinus.cs2j.xmleditor.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Type")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"Type"})
public class Inherit implements ValueableObject{
	
	/*
	 * Attributes
	 */
	
	private String Type;

	/*
	 * Getters
	 */


	@Override
	public String getValue(){ return Type; }
	
	@Override
	public void setValue(String value){ Type = value; }

}
