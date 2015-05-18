package com.ijinus.cs2j.xmleditor.ui;
	
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import com.ijinus.cs2j.xmleditor.xml.model.ConstructorRepTemplate;

public class ConstructorTemplatePanel extends TranslationBaseTemplatePanel {

	ConstructorRepTemplate _constructor;

	public ConstructorTemplatePanel(ConstructorRepTemplate constructor) {
		super(constructor);
		_constructor = constructor;

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);

		this.setBorder(BorderFactory.createTitledBorder("Constructor"));

		this.add(new ComplexListTemplatePanel("Parameters", _constructor.getParams()));
	}



}
