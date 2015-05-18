package com.ijinus.cs2j.xmleditor.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Name")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"Name"})
public class Use implements ValueableObject{
	
	/*
	 * Attributes
	 */
	
	private String Name;
	
	/*
	 * Getters
	 */
	
	@Override
	public String getValue(){ return Name; }
	
	@Override
	public void setValue(String value){ Name = value; }

}
