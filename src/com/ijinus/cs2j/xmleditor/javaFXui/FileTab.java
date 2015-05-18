package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

public class FileTab extends Tab{
	
	private InterfaceRepTemplate _file;
	
	@FXML private UserFriendlyXmlTemplateController xmlFileDisplay;

	public FileTab(InterfaceRepTemplate file){
		TabTemplateController.ACTIVE_TAB = this;
		
		_file = file;
		
		this.setText(_file.getFileName());
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FileTab.fxml"));
		fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }	
        
		xmlFileDisplay.setFile(_file);			
		try {
			xmlFileDisplay.populate();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.setOnClosed(new EventHandler<Event>(){
		    @Override
			public void handle(Event e){
		        FXFrameTest.getInstance().getData().remove(_file);
		    }
		});
		
	}
	
	public InterfaceRepTemplate getData(){
		return _file;
	}
	
}
