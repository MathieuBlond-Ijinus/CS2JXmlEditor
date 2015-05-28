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
import javafx.scene.layout.VBox;

import com.ijinus.cs2j.xmleditor.xml.model.Import;
import com.ijinus.cs2j.xmleditor.xml.model.TranslationBase;

public class TranslationBaseController extends VBox{
	
	protected TranslationBase _base;
	
	@FXML protected ComplexListTemplateController<Import> imports;
	@FXML protected EditableText java;
	@FXML protected EditableText warning;
	
	public TranslationBaseController(TranslationBase base){
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TranslationBase.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
		setSpacing(10);
		
		_base = base;
		
		initializeTranslationBaseFields();
		populateTranslationBaseFields();
		
	}

	private void populateTranslationBaseFields() {
		imports.populate(_base.getImports());	
		java.populate("Java", _base);
		warning.populate("Warning", _base);		
	}

	private void initializeTranslationBaseFields() {		
		imports.setType(Import.class);		
	}
	

}
