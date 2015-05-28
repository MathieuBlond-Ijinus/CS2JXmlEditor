/*
 Copyright 2015 Mathieu Blond - Ijinus ( mathieu.blond@ijinus.fr )

 This file is part of CS2JXmlEditor.

    CS2JXmlEditor is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CS2JXmlEditor is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with CS2JXmlEditor.  If not, see <http://www.gnu.org/licenses/>.
 */
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
