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

/**
 * The concept of complex list here is a list where both size and type are not hard-coded.
 * To create the content of this, we use some factory methods to behave the right way.
 *  
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 * @param <T>
 */
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
	
	/**
	 * Adds a new element to the list and refresh <b>all the view</b>
	 * 
	 * TODO Look how we could <b>just</b> add the new element, instead of drop everything and rebuild the view.
	 */
	public void addNew(){
		Object temp;
		temp = ControllerFactory.getInstance(_type);
		
		if(_list == null)
			_list = new ArrayList<T>();
		
		_list.add((T) temp);
		populate();
	}

}
