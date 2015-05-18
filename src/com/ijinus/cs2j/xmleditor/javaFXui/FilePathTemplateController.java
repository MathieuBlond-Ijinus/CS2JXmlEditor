package com.ijinus.cs2j.xmleditor.javaFXui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class FilePathTemplateController {
	
	private FXFrameTest _mainFrame;
	
	@FXML
	private Text filePath;
	
	public FilePathTemplateController(){
		
		
		
	}
	
	@FXML
	private void initialize(){
		
		filePath.setText(TabTemplateController.ACTIVE_TAB.getData().getFileName());
		
	}
	
	public void setMainFrame(FXFrameTest mainFrame){ _mainFrame = mainFrame; }

}
