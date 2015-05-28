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

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListTemplatePanel<T> extends JPanel{
	
	/*
	 * Attributes
	 */
	
	List<T> _list;
	
	/*
	 * Constructors
	 */
	
	public ListTemplatePanel(String label, List<T> list){
		_list = list;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		this.add(new JLabel(label+" : "));
		if(_list != null && !_list.isEmpty()){
			for(T object : _list)
				this.add(new AttributeTemplatePanel("\t-", object.toString()));
		}
		else
			this.add(new JLabel("         No "+label));
	}

}
