package com.ijinus.cs2j.xmleditor.ui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.ijinus.cs2j.xmleditor.xml.model.TranslationBase;

public class TranslationBaseTemplatePanel extends JPanel{
	
	private TranslationBase _base;
	
	public TranslationBaseTemplatePanel(TranslationBase base){
		_base = base;

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);

		this.add(new ComplexListTemplatePanel("Imports", _base.getImports()));
		this.add(new AttributeTemplatePanel("Java", _base.getJava()));
		this.add(new AttributeTemplatePanel("Warning", _base.getWarning()));
	}
}
