package com.ijinus.cs2j.xmleditor.javaFXui;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
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

public class ControllerFactory {
	
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
		
		else{												
			try {
				throw new Exception("Unsuported type : "+object.getClass());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return null;
	}
	
	public static <T> Pane getContentPane(T object){
		
		if(object instanceof MethodRepTemplate){
			return new FlowPane(10.0,10.0);
		}
		else if(object instanceof ConstructorRepTemplate){
			return new FlowPane(10.0,10.0);
		}
		else if(object instanceof PropRepTemplate){
			return new FlowPane(10.0,10.0);
		}
		/*
		else if(object instanceof ParamRepTemplate){
			return new VBox(10.0);
		}*/
		else{												
			return new VBox(10.0);
		}
		
	}

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

		System.out.println("This type is actually unsupported :"+type);
		return null;
	}
	

}
