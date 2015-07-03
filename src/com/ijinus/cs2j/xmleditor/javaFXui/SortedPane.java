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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import com.ijinus.cs2j.xmleditor.xml.model.TranslationBase;

/**
 * The concept of complex list here is a list where both size and type are not hard-coded.
 * To create the content of this, we use some factory methods to behave the right way.
 *  
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 * @param <T>
 */
public class SortedPane<T extends TranslationBase> extends VBox{
	
	private Map<String,ComplexListTemplateController<T>> _listsByLetter;
	private Class<T> _type;	
	
	/*
	 * Constructor
	 */
	
	public SortedPane() {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SortedPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        _listsByLetter = new TreeMap<String, ComplexListTemplateController<T>>();

    }

	@FXML
	public void initialize() {
		
	}
	
	public void setType(Class<T> type){
		_type = type;
	}
	
	public void populate(List<T> values){
		if(_listsByLetter == null)
			_listsByLetter = new TreeMap<String,ComplexListTemplateController<T>>();
		
		_listsByLetter.clear();
		
		Collections.sort(values);
		
		int i = 0;
		while(i < values.size()){
			
			char letter = Character.toUpperCase(values.get(i).toString().charAt(0));
			List<T> tempList = new ArrayList<T>();
			
			while(i<values.size() && Character.toUpperCase(values.get(i).toString().charAt(0)) == letter){
				tempList.add(values.get(i));
				i++;
			}
			
			ComplexListTemplateController<T> tempUI =  new ComplexListTemplateController<T>();
			tempUI.populate(tempList);
			_listsByLetter.put(String.valueOf(letter), tempUI);
			
			i++;
		}
		
		
		populate();
	}

	public void populate(){
		if(_listsByLetter != null && !_listsByLetter.isEmpty()){

			for(String key : _listsByLetter.keySet()){
				
				BorderPane separator = new BorderPane();
				
				separator.setTop(new Label(key));
				separator.setCenter(_listsByLetter.get(key));
				this.getChildren().add(separator);
			}

		}
	}
	
	/**
	 * Adds a new element to the list and refresh <b>all the view</b>
	 * 
	 * TODO Look how we could <b>just</b> add the new element, instead of drop everything and rebuild the view.
	 */
	
	public void addNew(){
		/*Object temp;
		temp = ControllerFactory.getInstance(_type);
		
		if(_listsByLetter == null)
			_listsByLetter = new TreeMap<String, ComplexListTemplateController<T>>();
		
		_list.add((T) temp);
		*/
		populate();
	}

}
