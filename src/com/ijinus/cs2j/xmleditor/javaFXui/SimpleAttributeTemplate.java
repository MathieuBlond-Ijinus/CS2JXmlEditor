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


