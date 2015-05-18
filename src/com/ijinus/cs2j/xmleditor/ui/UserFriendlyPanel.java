package com.ijinus.cs2j.xmleditor.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

public class UserFriendlyPanel extends JPanel{

	InterfaceRepTemplate _xml;
	
	public UserFriendlyPanel(InterfaceRepTemplate xml){

		_xml = xml;
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.add(new TitlePanel(_xml.getFileName()), BorderLayout.NORTH);
		this.add(new UserFriendlyXmlPanel(_xml), BorderLayout.WEST);

	}

}
