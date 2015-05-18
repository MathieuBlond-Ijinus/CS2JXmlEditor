package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import com.ijinus.cs2j.xmleditor.xml.model.ConstructorRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ParamRepTemplate;

public class ConstructorController extends TranslationBaseController{
	
	@FXML protected ComplexListTemplateController<ParamRepTemplate> params;

	public ConstructorController(ConstructorRepTemplate base) {
		super(base);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Constructor.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        initializeConstructorFields();
        populateConstructorFields();

	}

	public void initializeConstructorFields(){
		params.setType(ParamRepTemplate.class);
	}
	
	private void populateConstructorFields() {
        params.populate(((ConstructorRepTemplate) _base).getParams());
	}

}
