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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.ijinus.cs2j.xmleditor.xml.model.ClassRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Import;
import com.ijinus.cs2j.xmleditor.xml.model.Inherit;
import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Use;

public class UserFriendlyXmlPanel extends JPanel{
	
	InterfaceRepTemplate _xml;
	boolean isClass;
	
	public UserFriendlyXmlPanel(InterfaceRepTemplate xml){
		
		_xml = xml;
		isClass = _xml instanceof ClassRepTemplate;
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		//this.setBackground(Color.GRAY);

		/*
		 * Class properties
		 */
		
		this.add(new AttributeTemplatePanel("Type",isClass  ? "Class" : "Interface"));
		this.add(new AttributeTemplatePanel("C#",_xml.getName()));
		this.add(new AttributeTemplatePanel("Java",_xml.getJava()));
		if(isClass)
			this.add(new AttributeTemplatePanel("Boxed Java", ((ClassRepTemplate) _xml).getBoxedJava()));
		
		/*
		 * Imports
		 */
		
		this.add(new ComplexListTemplatePanel<Import>("Imports",_xml.getImports()));
		
		/*
		 * Uses
		 */
		
		this.add(new ComplexListTemplatePanel<Use>("Uses",_xml.getUses()));
		
		/*
		 * Inherits
		 */
		
		this.add(new ComplexListTemplatePanel<Inherit>("Inherits",_xml.getInherits()));
		
		/*
		 * Methods
		 */
		
		this.add(new ComplexListTemplatePanel("Methods", _xml.getMethods()));
		
	}

}
