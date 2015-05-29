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

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

/**
 * 
 *	Represents a Tab containing a file (e.g an InterfaceRepTemplate)
 * 
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 */
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
		
		/*
		 * When we close the tab, we remove the file from the files list.
		 */
		this.setOnClosed(new EventHandler<Event>(){
		    @Override
			public void handle(Event e){
		        MainWindow.getInstance().getData().remove(_file);
		    }
		});
		
	}
	
	public InterfaceRepTemplate getData(){
		return _file;
	}
	
}
