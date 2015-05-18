package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ComplexListTemplateController<T> extends BorderPane{
	
	private List<T> _list;
	private Class<T> _type;	
	
	/*
	 * Constructor
	 */
	
	public ComplexListTemplateController() {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ComplexListTemplate.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        _list = new ArrayList<T>();

    }

	@FXML
	public void initialize() {
		
	}
	
	public void setType(Class<T> type){
		_type = type;
	}
	
	public void populate(List<T> values){
		_list = values;
		
		populate();
	}

	public void populate(){
		if(_list != null && !_list.isEmpty()){

			Pane contentPane = ControllerFactory.getContentPane(_list.get(0));
			final ObservableList<Node> children;

			this.setCenter(contentPane);
			
			children = contentPane.getChildren();

			for(final T object : _list){
				final BorderPane separator = new BorderPane();
				Button closeButton = new Button();
				closeButton.getStyleClass().add("close-button");
				
				closeButton.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						_list.remove(object);
						children.remove(separator);
					}
					
				});
				
				separator.setLeft(ControllerFactory.getController(object));
				separator.setRight(closeButton);
				children.add(separator);
			}

		}
	}
	
	public void addNew(){
		Object temp;
		temp = ControllerFactory.getInstance(_type);
		
		_list.add((T) temp);
		populate();
	}

}
