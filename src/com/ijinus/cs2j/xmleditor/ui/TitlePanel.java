package com.ijinus.cs2j.xmleditor.ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel{

	public TitlePanel(String title){
		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(new Font(titleLabel.getFont().getFontName(), Font.PLAIN, 28));
		this.add(titleLabel);
	}
	
}
