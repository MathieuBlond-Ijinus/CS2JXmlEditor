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

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import com.ijinus.cs2j.xmleditor.xml.model.ConstructorRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.FieldRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Import;
import com.ijinus.cs2j.xmleditor.xml.model.Inherit;
import com.ijinus.cs2j.xmleditor.xml.model.MethodRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ParamRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.PropRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.TypeParam;
import com.ijinus.cs2j.xmleditor.xml.model.Use;
import com.ijinus.cs2j.xmleditor.xml.model.ValueableObject;

/**
 * 
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 *	The general CS2JXmlEditor factory to dynamically create some content like controllers, panes, object instances...
 *
 *	TODO Rename the class, since ControllerFactory doesn't only create controllers.
 *
 */
public class ControllerFactory {
	
	/**
	 * Creates a controller depending of the type passed in parameter.
	 * A controller is basically a part of an interface.
	 * 
	 * @param object
	 * @return a new controller to show the object.
	 */
	public static <T> Node getController(T object){
		
		if(object instanceof MethodRepTemplate){
			return new MethodController((MethodRepTemplate)object);
		}
		else if(object instanceof ConstructorRepTemplate){
			return new ConstructorController((ConstructorRepTemplate)object);
		}
		else if(object instanceof PropRepTemplate){
			return new PropertyController((PropRepTemplate)object);
		}
		
		else if(object instanceof ParamRepTemplate){
			return new ParamController((ParamRepTemplate)object);
		}
		
		if(object instanceof ValueableObject){
			return new EditableText("Value", object);
		}
		
		/*
		 * Woaw. Did I really wrote this ? Wondering how to do it better, but no time for the moment.
		 */
		else{												
			try {
				throw new Exception("Unsuported type : "+object.getClass());
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return null;
	}
	
	/**
	 * Creates a content pane depending of the type passed in parameter.
	 * 
	 * @param object
	 * @return a new Pane
	 */
	public static <T> Pane getContentPane(T object){
		
		Pane newPane;
		
		if(object instanceof MethodRepTemplate){
			newPane = new TilePane(10.0,10.0);
			((TilePane) newPane).setPrefColumns(2);
		}
		else if(object instanceof ConstructorRepTemplate){
			newPane = new FlowPane(10.0,10.0);
		}
		else if(object instanceof PropRepTemplate){
			newPane = new FlowPane(10.0,10.0);
		}
		/*
		else if(object instanceof ParamRepTemplate){
			return new VBox(10.0);
		}*/
		else{												
			newPane = new VBox(10.0);
		}
		
		return newPane;
		
	}

	/**
	 * Create an instance of the Class passed in parameter.
	 * 
	 * @param type
	 * @return an instance of T
	 */
	public static <T> Object getInstance(Class<T> type){

		if(type.equals(MethodRepTemplate.class)){
			return new MethodRepTemplate();
		}
		else if(type.equals(ConstructorRepTemplate.class)){
			return new ConstructorRepTemplate();
		}
		else if(type.equals(PropRepTemplate.class)){
			return new PropRepTemplate();
		}

		else if(type.equals(FieldRepTemplate.class)){
			return new FieldRepTemplate();
		}

		else if(type.equals(ParamRepTemplate.class)){
			return new ParamRepTemplate();
		}

		else if(type.equals(Import.class)){
			return new Import();
		}
		
		else if(type.equals(Inherit.class)){
			return new Inherit();
		}
		
		else if(type.equals(TypeParam.class)){
			return new TypeParam();
		}
		
		else if(type.equals(Use.class)){
			return new Use();
		}

		// Much more better than the precedent version
		System.out.println("This type is actually unsupported :"+type);
		return null;
	}
	

}
