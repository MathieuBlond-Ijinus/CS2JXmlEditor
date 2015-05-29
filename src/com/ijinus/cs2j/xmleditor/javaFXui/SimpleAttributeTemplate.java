/*
 Copyright 2015 Mathieu Blond - Ijinus ( mathieu.blond@ijinus.fr )

 This file is part of CS2JXmlEditor.

    CS2JXmlEditor is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CS2JXmlEditor is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with CS2JXmlEditor.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * A couple key(Label) / value (TextField) to represent a field and its modifiable value.
 * 
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 */
public class SimpleAttributeTemplate extends GridPane{
	
	private Object _base;
	private String _varName;

	//@FXML private GridPane this;
	@FXML private Label key;
	@FXML private TextField value;
	
	/*
	 * Constructor
	 */
	
	public SimpleAttributeTemplate() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SimpleAttributeTemplate.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	/*
	 * Methods
	 */
	
	@FXML
	public void initialize() {
		
		AnchorPane.setTopAnchor(this, 0.0);
		AnchorPane.setLeftAnchor(this, 0.0);
		AnchorPane.setBottomAnchor(this, 0.0);
		AnchorPane.setRightAnchor(this, 0.0);
		
		value.setOnAction(new EventHandler<ActionEvent>() {  
			@Override  
			public void handle(ActionEvent event) {  
				try {
					_base.getClass().getMethod("set"+_varName, java.lang.String.class).invoke(_base, value.getText());
				} catch (Exception e){ e.printStackTrace(); }
			}  
		});

		value.focusedProperty().addListener(new ChangeListener<Boolean>() {  
			@Override  
			public void changed(ObservableValue<? extends Boolean> observable,  
					Boolean oldValue, Boolean newValue) {  
				if (! newValue) {  
				
					try {
						_base.getClass().getMethod("set"+_varName, java.lang.String.class).invoke(_base, value.getText());
					} catch (Exception e){ e.printStackTrace(); }
				
				}  
			}  
		});
		
	}

	public void populate(String key, String varName, Object base) {
		
		_base = base;
		_varName = varName;
		
		String initialValue = "Unable to read value";
		
		try { initialValue = (String) _base.getClass().getMethod("get"+varName).invoke(_base);} 
		catch (Exception e) {	e.printStackTrace(); }
		

		this.key.setText(key);
		this.value.setText(initialValue);
		
	}
	
}


