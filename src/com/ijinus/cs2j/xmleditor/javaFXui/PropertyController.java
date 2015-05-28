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

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import com.ijinus.cs2j.xmleditor.xml.model.PropRepTemplate;

public class PropertyController extends FieldController{
	
	private PropRepTemplate _base;

	@FXML private EditableText get;
	@FXML private EditableText set;
	
	public PropertyController(PropRepTemplate base) {
		super(base);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Property.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
		_base = base;
		// TODO Auto-generated constructor stub
		//populate();
		get.populate("Get", _base);
		set.populate("Set", _base);
		
	}

}
