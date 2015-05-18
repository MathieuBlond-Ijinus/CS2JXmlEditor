package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import com.ijinus.cs2j.xmleditor.xml.XmlSerialization;
import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;


public class FXFrameTest extends Application{
	
	public static XmlSerialization serializer = new XmlSerialization();
	public static String path = "C:/Users/mblond/Documents/CS2J/cs2j/CSharpTranslator/src/CS2JTranslator/NetFramework/System/";
	
	private static FXFrameTest INSTANCE;
	
	private ObservableList<InterfaceRepTemplate> _interfacesList;
	
	private Controller mainPane;
	

	public FXFrameTest(){
		
		_interfacesList = FXCollections.observableArrayList();
		
		_interfacesList.add(serializer.deserialize(path,"Boolean.xml"));
		_interfacesList.add(serializer.deserialize(path,"IDisposable.xml"));
		_interfacesList.add(serializer.deserialize(path,"IEquatable.xml"));
		_interfacesList.add(serializer.deserialize(path,"Array'1.xml"));
		_interfacesList.add(serializer.deserialize(path,"DateTime.xml"));
		
		INSTANCE = this;
		
	}

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//FXMLLoader loader = new FXMLLoader(getClass().getResource("application.fxml"));
		
		//mainPane = (Controller) loader.load();
		mainPane = new Controller();
		Scene scene = new Scene(mainPane);

		mainPane.setMainFrame(this);
		
		/*
		 * Creates the scene
		 */
		
		scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
		
		stage.setTitle("CS2J XML Editor");
		stage.setScene(scene);
		stage.show();
	
	}

	
	public ObservableList<InterfaceRepTemplate> getData(){
		return _interfacesList;
	}
	
	public static FXFrameTest getInstance(){ return INSTANCE; }

}
