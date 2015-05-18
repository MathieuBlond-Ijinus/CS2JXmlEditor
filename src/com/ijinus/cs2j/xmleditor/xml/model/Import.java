package com.ijinus.cs2j.xmleditor.xml.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Import")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"Import"})
public class Import implements ValueableObject{
	
	/*
	 * Attributes
	 */
	
	private String Import;
	
	@Override
	public String getValue() {
		return Import;
	}

	@Override
	public void setValue(String value) {
		Import = value;
	}

}
