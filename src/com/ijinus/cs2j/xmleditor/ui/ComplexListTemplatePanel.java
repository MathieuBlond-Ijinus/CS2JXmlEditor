package com.ijinus.cs2j.xmleditor.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComplexListTemplatePanel<T> extends JPanel{
	
	/*
	 * Attributes
	 */
	
	List<T> _list;
	JButton _add;
	
	/*
	 * Constructors
	 */
	
	public ComplexListTemplatePanel(String label, List<T> list){
		_list = list;
		_add = new JButton("Add");
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		this.add(new JLabel(label+" : "));
		
		if(_list != null && !_list.isEmpty())
			for(T object : _list){
				this.add(TemplatePanelFactory.getTemplatePanel(object));
		}
		
		JPanel panel = new JPanel( new BorderLayout() );
		
		_add.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(_add);
		this.add(panel);
	}

}
