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
