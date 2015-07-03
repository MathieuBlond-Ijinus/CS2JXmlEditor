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

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import com.ijinus.cs2j.xmleditor.xml.XmlSerialization;
import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

/**
 * 
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 * The main class of CS2JXmlEditor. Launches the software in a javaFX window.
 *
 */
public class MainWindow extends Application{
	
	public static XmlSerialization serializer = new XmlSerialization();
	public static String path = "C:/Users/mblond/Documents/CS2J/cs2j/CSharpTranslator/src/CS2JTranslator/NetFramework/";
	
	private static MainWindow INSTANCE;
	private Stage primaryStage;
	
	private ObservableList<InterfaceRepTemplate> _interfacesList;
	
	private MainWindowController mainPane;
	

	public MainWindow(){
		
		_interfacesList = FXCollections.observableArrayList();
		
		INSTANCE = this;
		
	}

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		primaryStage = stage;
		
		mainPane = new MainWindowController();
		Scene scene = new Scene(mainPane);

		mainPane.setMainFrame(this);
		
		/*
		 * Creates the scene
		 */
		
		try{
			scene.getStylesheets().add(getClass().getResource("icons/DarkTheme.css").toExternalForm());
		}catch(Exception e){ System.out.println("Failed to load CSS"); }
			
		stage.setTitle("CS2J XML Editor");
		stage.setScene(scene);
		stage.show();
	
	}

	
	public ObservableList<InterfaceRepTemplate> getData(){
		return _interfacesList;
	}
	
	public Stage getStage(){ return primaryStage; }
	public static MainWindow getInstance(){ return INSTANCE; }

}
