package com.ijinus.cs2j.xmleditor.xml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Name")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"Name"})
public class TypeParam implements ValueableObject{

	/*
	 * Attributes
	 */
	
	private String Name;

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		Name = value;
	}
	
}
