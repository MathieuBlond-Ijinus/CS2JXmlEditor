package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import com.ijinus.cs2j.xmleditor.xml.model.ClassRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ConstructorRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Import;
import com.ijinus.cs2j.xmleditor.xml.model.Inherit;
import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.MethodRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.PropRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Use;

public class UserFriendlyXmlTemplateController extends ScrollPane{
	
	/*
	 * Attributes
	 */
	
	private InterfaceRepTemplate _file;
	
	@FXML private VBox vBox;
	
	@FXML private Label fileName;
	
	@FXML private SimpleAttributeTemplate  csName;
	@FXML private SimpleAttributeTemplate  javaName;
	@FXML private SimpleAttributeTemplate  boxedJava;

	@FXML private ComplexListTemplateController<Import> imports;
	@FXML private ComplexListTemplateController<Use> uses;
	@FXML private ComplexListTemplateController<Inherit> inherits;
	@FXML private ComplexListTemplateController<ConstructorRepTemplate> constructors;
	@FXML private ComplexListTemplateController<MethodRepTemplate> methods;
	@FXML private ComplexListTemplateController<PropRepTemplate> properties;
	
	@FXML private Button newImport;
	@FXML private Button newUse;
	@FXML private Button newInherit;
	@FXML private Button newConstructor;
	@FXML private Button newMethod;
	@FXML private Button newProperty;
	
	/*
	 * Constructor
	 */
	
	public UserFriendlyXmlTemplateController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserFriendlyXmlTemplate.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	/*
	 * Methods
	 */
	
	@FXML
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	public void populate() throws IOException{
		/*
		 * Attributes
		 */
		
		boolean isClass = _file instanceof ClassRepTemplate;
		
		fileName.setText((isClass?"Class ":"Interface ") + _file.getFileName());
		csName.populate("C#", "Name", _file);	
		javaName.populate("Java", "Java", _file);
		
		if(isClass){
			boxedJava.populate("Boxed Java", "BoxedJava", (ClassRepTemplate)_file);
		}
		
		/*
		 * Initialization
		 */
		
		imports.setType(Import.class);
		uses.setType(Use.class);
		inherits.setType(Inherit.class);
		constructors.setType(ConstructorRepTemplate.class);
		methods.setType(MethodRepTemplate.class);
		properties.setType(PropRepTemplate.class);
		
		/*
		 * SimpleAttributes
		 */

		imports.populate(_file.getImports());
		uses.populate(_file.getUses());
		inherits.populate(_file.getInherits());
		
		/*
		 * ComplexAttributes
		 */

		constructors.populate(_file.getConstructors());
		methods.populate(_file.getMethods());
		properties.populate(_file.getProperties());
		
	}
	
	/*
	 * Setters
	 */
	
	public void setFile(InterfaceRepTemplate file){ _file = file; }

	/*
	 * Getters
	 */
	
	public InterfaceRepTemplate getFile(){ return _file; }
	
}
