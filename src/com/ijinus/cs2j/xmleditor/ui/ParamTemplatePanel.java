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
