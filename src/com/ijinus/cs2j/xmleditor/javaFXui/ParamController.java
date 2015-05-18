package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import com.ijinus.cs2j.xmleditor.xml.model.ParamRepTemplate;

public class ParamController extends HBox{

	private ParamRepTemplate _base;
	
	@FXML private EditableText type;
	@FXML private EditableText name;
	
	public ParamController(ParamRepTemplate base) {
		_base = base;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Param.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        name.populate("Name", _base);
        type.populate("Type", _base);
	}

}
