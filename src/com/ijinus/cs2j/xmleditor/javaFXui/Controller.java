package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

public class Controller extends BorderPane{
	
	ArrayList<File> fileList;
	
	private FXFrameTest _mainFrame;
	@FXML private TabTemplateController tabController;
	
	@FXML private SplitPane splitPane;
	@FXML private AnchorPane tabAnchorPane;
	@FXML private VBox availableXmlList;
	@FXML private BorderPane mainPane;
	
	public Controller(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("application.fxml"));
		fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}

	@FXML
	public void initialize() {
        
		//fileList = FXCollections.observableArrayList();
		fileList = new ArrayList<File>();
		this.readAllFilesFromFolder(new File(FXFrameTest.path));
		
		Collections.sort(fileList, new Comparator<File>() {

			@Override
			public int compare(File file1, File file2) {
				return file1.getName().compareTo(file2.getName());
			}
			
		});
		
		for(final File file : fileList){
			Text text = new Text(file.getName());
			text.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if(event.getClickCount()==2){
						if(file != null){
							try {
								InterfaceRepTemplate newFile = FXFrameTest.serializer.deserialize(new FileInputStream(file),file.getName());
								
								_mainFrame.getData().add(newFile);
								tabController.newTab(newFile);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
						}
					}
					
				}
				
			});
			availableXmlList.getChildren().add(text);
		}

	}
	
	@FXML
	private void handleNewFile(){
		InterfaceRepTemplate newFile = FXFrameTest.serializer.deserialize(getClass().getResourceAsStream("Untitled.xml"),"Untitled.xml");
		_mainFrame.getData().add(newFile);
		//tabController.refresh();
		tabController.newTab(newFile);
	}
	
	@FXML
	private void handleOpenFile(){
		FileChooser fileChooser = new FileChooser();

		//Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		//Show save file dialog
		File file = fileChooser.showOpenDialog(null);
		
		if(file != null){
			try {
				InterfaceRepTemplate newFile = FXFrameTest.serializer.deserialize(new FileInputStream(file),file.getName());
				
				_mainFrame.getData().add(newFile);
				tabController.newTab(newFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML 
	private void handleSaveFile(){
		InterfaceRepTemplate fileToSave = ((FileTab)tabController.getSelectionModel().getSelectedItem()).getData();
		FileChooser fileChooser = new FileChooser();

		//Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		//Show save file dialog
		File file = fileChooser.showSaveDialog(null);

		if(file != null){
			FXFrameTest.serializer.serialize(fileToSave, file);
		}

	}
	
	public void setMainFrame(FXFrameTest mainFrame){
		_mainFrame = mainFrame;
		
		tabController.setMainFrame(_mainFrame);
		tabController.populate();
		
		//mainPane.setCenter(tabController);
		tabAnchorPane.getChildren().remove(0);
		tabAnchorPane.getChildren().add(tabController);
		
		AnchorPane.setTopAnchor(tabController, 0.0);
		AnchorPane.setLeftAnchor(tabController, 0.0);
		AnchorPane.setBottomAnchor(tabController, 0.0);
		AnchorPane.setRightAnchor(tabController, 0.0);
		//splitPane.getItems().add(tabController);
	}
	
	public void readAllFilesFromFolder(File folder){
		
		for(File fileEntry : folder.listFiles()) {
			if(fileEntry.isDirectory())
				readAllFilesFromFolder(fileEntry);
			else
				fileList.add(fileEntry);
		}

	}

}
