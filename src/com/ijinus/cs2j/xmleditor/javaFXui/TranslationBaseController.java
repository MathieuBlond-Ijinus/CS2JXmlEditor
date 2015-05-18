package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import com.ijinus.cs2j.xmleditor.xml.model.Import;
import com.ijinus.cs2j.xmleditor.xml.model.TranslationBase;

public class TranslationBaseController extends VBox{
	
	protected TranslationBase _base;
	
	@FXML protected ComplexListTemplateController<Import> imports;
	@FXML protected EditableText java;
	@FXML protected EditableText warning;
	
	public TranslationBaseController(TranslationBase base){
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TranslationBase.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
		setSpacing(10);
		
		_base = base;
		
		initializeTranslationBaseFields();
		populateTranslationBaseFields();
		
	}

	private void populateTranslationBaseFields() {
		imports.populate(_base.getImports());	
		java.populate("Java", _base);
		warning.populate("Warning", _base);		
	}

	private void initializeTranslationBaseFields() {		
		imports.setType(Import.class);		
	}
	

}
