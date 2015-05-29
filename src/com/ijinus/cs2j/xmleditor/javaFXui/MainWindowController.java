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

import static com.ijinus.utilities.IOUtilities.println;

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
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

/**
 * 
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 *	The controller used for MainWindow.fxml.
 *	Represents the main window of CS2JXmlEditor.
 *
 */
public class MainWindowController extends BorderPane{
	
	ArrayList<File> fileList;
	
	private MainWindow _mainFrame;
	@FXML private TabTemplateController tabController;
	
	@FXML private SplitPane splitPane;
	@FXML private AnchorPane tabAnchorPane;
	@FXML private VBox availableXmlList;
	@FXML private BorderPane mainPane;
	
	public MainWindowController(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
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
        
		/*
		 * Loads every file in the NetFramework directory
		 */
		fileList = new ArrayList<File>();
		File rootFile = new File(MainWindow.path);
		
		/*
		 * If the file doesn't exist at the default path, the user is asked to select it
		 */
		if(rootFile.exists())
			this.readAllFilesFromFolder(rootFile);
		else{
			DirectoryChooser chooser = new DirectoryChooser();
			chooser.setTitle("Please show me your NetFramework directory ... :(");
			File selectedDirectory = chooser.showDialog(MainWindow.getInstance().getStage());
			this.readAllFilesFromFolder(selectedDirectory);
			MainWindow.path = selectedDirectory.getAbsolutePath();
		}
			
		/*
		 * We compare the file names
		 */
		Collections.sort(fileList, new Comparator<File>() {

			@Override
			public int compare(File file1, File file2) {
				return file1.getName().compareTo(file2.getName());
			}
			
		});
		
		/*
		 * We add the files to availableXmlList.
		 * Files are wrapped into a Label, and opened on double-click.
		 */
		for(final File file : fileList){
			Label text = new Label(file.getName());
			text.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if(event.getClickCount()==2){
						if(file != null){
							println("Opening file "+file.getAbsolutePath());
							InterfaceRepTemplate newFile = MainWindow.serializer.deserialize(file.getParent()+"\\",file.getName());
							
							_mainFrame.getData().add(newFile);
							tabController.newTab(newFile);
						}
						
					}
					
				}
				
			});
			availableXmlList.getChildren().add(text);
		}
		
		/*
		 * We add some CSS styles
		 */
		availableXmlList.getStyleClass().add("xml-list");
		availableXmlList.getStyleClass().add("background");

	}
	
	/**
	 * Triggered when the "New" button is clicked.
	 * 
	 * Opens a new tab "Untitled.xml". We use a cleaned XML (e.g containing just every tag) representing a Class.
	 * This allows CS2J to instantiate every variable simply, and possibly to add some default text.
	 * 
	 * TODO Allow the user to create an Interface
	 */
	@FXML
	private void handleNewFile(){
		InterfaceRepTemplate newFile = MainWindow.serializer.deserialize(getClass().getResourceAsStream("Untitled.xml"),"Untitled.xml");
		_mainFrame.getData().add(newFile);
		//tabController.refresh();
		tabController.newTab(newFile);
	}
	
	/**
	 * Triggered when the "Open" button is clicked.
	 * 
	 * Opens a dialog to choose a file to open.
	 * 
	 * TODO Open a window explaining the exception if one is raised.
	 */
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
				InterfaceRepTemplate newFile = MainWindow.serializer.deserialize(new FileInputStream(file),file.getName());
				
				_mainFrame.getData().add(newFile);
				tabController.newTab(newFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Triggered when the "Save" button is clicked.
	 * 
	 * Directly saves the file to it's default location if found.
	 * Else, handleSaveAsFile() is called.
	 */
	@FXML
	private void handleSaveFile(){
		InterfaceRepTemplate fileToSave = ((FileTab)tabController.getSelectionModel().getSelectedItem()).getData();
		if(fileToSave.getFilePath()!=null && !fileToSave.getFilePath().equals("")){
			MainWindow.serializer.serialize(fileToSave, new File(fileToSave.getFilePath()+fileToSave.getFileName()));
		}
		else
			handleSaveAsFile();
	}
	
	/**
	 * Triggered by handleSaveFile() when no default location to save a file is found.
	 * 
	 * Opens a window at the NetFramework directory to select a file to overwrite, of create one.
	 * 
	 * TODO Update the file's default path and name to use handleSaveFile() at the next save.
	 * TODO Create a "Save as ... " button to trigger this function. (ATM, the @FXML tab is useless).
	 */
	@FXML 
	private void handleSaveAsFile(){
		InterfaceRepTemplate fileToSave = ((FileTab)tabController.getSelectionModel().getSelectedItem()).getData();
		FileChooser fileChooser = new FileChooser();

		//Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		//Show save file dialog
		fileChooser.setTitle("Save As");
        fileChooser.setInitialDirectory(new File(MainWindow.path)); 
		File file = fileChooser.showSaveDialog(null);

		if(file != null){
			MainWindow.serializer.serialize(fileToSave, file);
		}

	}
	
	/**
	 * Set tabController's main window reference to mainFrame and populates him with populate().
	 * This is no longer needed since we have a MainWindow.getInstance();
	 * 
	 * @param mainFrame
	 * 
	 * TODO Rename this function to populate() and remove every setMainFrame() calls : we have a MainWindow.getInstance();
	 */
	public void setMainFrame(MainWindow mainFrame){
		_mainFrame = mainFrame;
		
		tabController.setMainFrame(_mainFrame);
		tabController.populate();
		
		/*
		 * Make tabController full size
		 */
		AnchorPane.setTopAnchor(tabController, 0.0);
		AnchorPane.setLeftAnchor(tabController, 0.0);
		AnchorPane.setBottomAnchor(tabController, 0.0);
		AnchorPane.setRightAnchor(tabController, 0.0);

	}
	
	/**
	 * A recursive function that adds each files in NetFramework to fileList
	 * 
	 * @param folder
	 * 
	 * TODO Create a Map instead of a List and adapt the view, so we could see files in their directory.
	 */
	public void readAllFilesFromFolder(File folder){
		
		for(File fileEntry : folder.listFiles()) {
			if(fileEntry.isDirectory())
				readAllFilesFromFolder(fileEntry);
			else
				fileList.add(fileEntry);
		}

	}

}
