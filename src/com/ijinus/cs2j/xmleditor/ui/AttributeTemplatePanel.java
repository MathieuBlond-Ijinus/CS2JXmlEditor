package com.ijinus.cs2j.xmleditor.ui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AttributeTemplatePanel extends JPanel {
	
	public AttributeTemplatePanel(String label, String value){
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		this.add(new JLabel(label));
		this.add(new JTextField(value));
		
	}

}
