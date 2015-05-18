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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class EditableText extends HBox{
	
	private Object _file;
	private String _fieldName;
	
	private Label text;
	private TextField textField;
	
	public EditableText(){
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditableText.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
	}
	
	public EditableText(String fieldName, Object file){
		
		this();
		populate(fieldName, file);
		
	}
	
	@FXML
	public void initialize(){

	}
	
	public void populate(String fieldName, Object file){
		
		_file = file;
		_fieldName = fieldName;
		
		String initialValue = "Unable to read value";
		
		try {
			initialValue = (String) _file.getClass().getMethod("get"+_fieldName).invoke(_file);
		} catch (Exception e) { e.printStackTrace(); }
		
		text = new Label(initialValue);
		textField = new TextField();
		
		textField.setMinHeight(20);
		
		/*
		 * Avoids a null area unclickable
		 */
		
		if(initialValue != null && initialValue.length()>0)
			this.getChildren().add(text);
		else
			this.getChildren().add(textField);
		
		/*
		 * Events
		 */
		
		text.setOnMouseClicked(new EventHandler<MouseEvent>() {  
			@Override  
			public void handle(MouseEvent event) {  
				if (event.getClickCount()==2) {  
					textField.setText(text.getText());

					EditableText.this.getChildren().add(textField);
					EditableText.this.getChildren().remove(text);

					textField.requestFocus(); 
					textField.selectAll();  

				}  
			}});

		textField.setOnAction(new EventHandler<ActionEvent>() {  
			@Override  
			public void handle(ActionEvent event) {  
				
				text.setText(textField.getText());  

				if(textField.getText().length() > 0 && EditableText.this.getChildren().contains(textField)){
					EditableText.this.getChildren().add(text);
					EditableText.this.getChildren().remove(textField);
				}

				try {
					_file.getClass().getMethod("set"+_fieldName, java.lang.String.class).invoke(_file, text.getText());
				} catch (Exception e) { e.printStackTrace(); }

			}

		});

		textField.focusedProperty().addListener(new ChangeListener<Boolean>() {  
			@Override  
			public void changed(ObservableValue<? extends Boolean> observable,  
					Boolean oldValue, Boolean newValue) {  
				if (! newValue) {  
					text.setText(textField.getText());

					if(textField.getText().length() > 0 && EditableText.this.getChildren().contains(textField)){
						EditableText.this.getChildren().add(text);
						EditableText.this.getChildren().remove(textField);
					}
				}
				
				try {
					_file.getClass().getMethod("set"+_fieldName, java.lang.String.class).invoke(_file, text.getText());
				} catch (Exception e) { e.printStackTrace(); }
			}  
		}); 
		
	}
	
	/*
	 * Getters
	 */
	
	public Label getText(){ return text; }
	public TextField getTextField(){ return textField; }
}
