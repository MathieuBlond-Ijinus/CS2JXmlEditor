package com.ijinus.cs2j.xmleditor.ui;

import javax.swing.JPanel;

import com.ijinus.cs2j.xmleditor.xml.model.ConstructorRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.MethodRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ParamRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.PropRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ValueableObject;

public class TemplatePanelFactory {
	
	public static <T> JPanel getTemplatePanel(T object){
		if(object instanceof MethodRepTemplate) 			return new MethodTemplatePanel((MethodRepTemplate)object);
		else if(object instanceof ConstructorRepTemplate)	return new ConstructorTemplatePanel((ConstructorRepTemplate)object);
		else if(object instanceof PropRepTemplate)			return new PropTemplatePanel((PropRepTemplate)object);
		else if(object instanceof ValueableObject)			return new AttributeTemplatePanel("      - ",((ValueableObject)object).getValue());
		else if(object instanceof ParamRepTemplate)			return new ParamTemplatePanel((ParamRepTemplate)object);
		else if(object instanceof String)					return new AttributeTemplatePanel("      - ",(String)object);
		else												return null;
	}

}
