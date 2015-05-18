package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import com.ijinus.cs2j.xmleditor.xml.model.PropRepTemplate;

public class PropertyController extends FieldController{
	
	private PropRepTemplate _base;

	@FXML private EditableText get;
	@FXML private EditableText set;
	
	public PropertyController(PropRepTemplate base) {
		super(base);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Property.fxml"));
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
		get.populate("Get", _base);
		set.populate("Set", _base);
		
	}

}
