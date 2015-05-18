package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import com.ijinus.cs2j.xmleditor.xml.model.MethodRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.TypeParam;

public class MethodController extends ConstructorController{
	
	@FXML private EditableText name;
	@FXML private ComplexListTemplateController<TypeParam> typeParams;
	@FXML private EditableText returnType;
	
	public MethodController(MethodRepTemplate base) {
		super(base);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Method.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        initializeMethodFields();
        populateMethodFields();
	}
	
	private void initializeMethodFields() {
		typeParams.setType(TypeParam.class);
	}

	public void populateMethodFields(){
		name.populate("Name", _base);
        typeParams.populate(((MethodRepTemplate) _base).getTypeParams());
        returnType.populate("Return", _base);
	}

}
