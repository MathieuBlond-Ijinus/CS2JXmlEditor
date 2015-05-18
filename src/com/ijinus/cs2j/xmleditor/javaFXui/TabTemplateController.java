package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

public class TabTemplateController extends TabPane{

	public static FileTab ACTIVE_TAB;
	
	private FXFrameTest _mainFrame;	
	
	public TabTemplateController(){
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TabTemplate.fxml"));
		fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
	}
	
	@FXML
	public void initialize(){
	}
	
	public void setMainFrame(FXFrameTest mainFrame){ _mainFrame = mainFrame; }
	
	public void populate(){
		for(InterfaceRepTemplate file : _mainFrame.getData()){
			FileTab tab = new FileTab(file);
			
			ObservableList<Tab> tabs = this.getTabs();
			tabs.add(tab);
		}

	}

	public void refresh() {
		
		this.getTabs().clear();
		populate();
		
	}

	public void newTab(InterfaceRepTemplate newFile) {
		this.getTabs().add(new FileTab(newFile));		
	}
	
}
