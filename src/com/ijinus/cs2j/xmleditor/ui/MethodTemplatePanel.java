package com.ijinus.cs2j.xmleditor.ui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import com.ijinus.cs2j.xmleditor.xml.model.MethodRepTemplate;

public class MethodTemplatePanel extends ConstructorTemplatePanel {

	MethodRepTemplate _method;
	
	public MethodTemplatePanel(MethodRepTemplate method) {
		super(method);
		_method = method;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		this.setBorder(BorderFactory.createTitledBorder(_method.getName()));
		
		this.add(new ComplexListTemplatePanel("Generic parameters", _method.getTypeParams()));
		this.add(new AttributeTemplatePanel("Return type", _method.getReturn()));
	}
	
	

}
