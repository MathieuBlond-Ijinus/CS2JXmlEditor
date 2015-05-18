package com.ijinus.cs2j.xmleditor.ui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.ijinus.cs2j.xmleditor.xml.model.ParamRepTemplate;

public class ParamTemplatePanel extends JPanel{
	
	ParamRepTemplate _param;
	
	public ParamTemplatePanel(ParamRepTemplate param){
		_param = param;
		
		this.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);

		this.add(new AttributeTemplatePanel("Type : ", _param.getType()));
		this.add(new AttributeTemplatePanel("Name : ", _param.getName()));
	}

}
