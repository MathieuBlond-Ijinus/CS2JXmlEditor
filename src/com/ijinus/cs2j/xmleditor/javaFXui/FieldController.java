package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import com.ijinus.cs2j.xmleditor.xml.model.FieldRepTemplate;

public class FieldController extends TranslationBaseController{

	@FXML protected EditableText type;
	@FXML protected EditableText name;
	
	private FieldRepTemplate _base;
	
	public FieldController(FieldRepTemplate base) {
		super(base);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Field.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
		_base = base;
		// TODO Auto-generated constructor stub
		//populate();
		type.populate("Type", _base);
		name.populate("Name", _base);
		
	}

}
