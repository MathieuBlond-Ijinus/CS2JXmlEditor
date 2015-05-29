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
package com.ijinus.cs2j.xmleditor.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;

import com.ijinus.cs2j.xmleditor.xml.model.AliasRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.BinaryOp;
import com.ijinus.cs2j.xmleditor.xml.model.CastRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ClassRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ConstructorRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Event;
import com.ijinus.cs2j.xmleditor.xml.model.FieldRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Import;
import com.ijinus.cs2j.xmleditor.xml.model.IndexerRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.Inherit;
import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.IterableRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.MethodRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.ParamRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.PropRepTemplate;
import com.ijinus.cs2j.xmleditor.xml.model.TypeParam;
import com.ijinus.cs2j.xmleditor.xml.model.UnaryOp;
import com.ijinus.cs2j.xmleditor.xml.model.Use;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * An abstraction for an easier XStream serialization use.
 * 
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 */
public class XmlSerialization {
	
	/*
	 * Attributes
	 */
	
	private XStream xstream;
	
	/*
	 * Constructeur
	 */
	
	public XmlSerialization(){
		
		/*
		 * The XmlFriendlyNameCoder change the way some XStream fields are named.
		 * It basically allows to use "has_boxed_rep" without it to become "has__boxed__rep"
		 */
		xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
		makeAliases();
	}
	
	/*
	 * Methods
	 */

	/**
	 * Serialize a Java class into an CS2J readable XML
	 * 
	 * @param object
	 * @param file
	 */
	public void serialize(InterfaceRepTemplate object, File file){		
		
		object.xmlns_xsi = "http://www.w3.org/2001/XMLSchema-instance";
		object.xmlns_xsd= "http://www.w3.org/2001/XMLSchema";
		object.xmlns = "urn:www.twigletsoftware.com:schemas:txtemplate:1:0";
		
		if(object instanceof ClassRepTemplate && ((ClassRepTemplate) object).getBoxedJava() != null)
			object.setHasBoxedRep(true);
		

		String xmlString = xstream.toXML(object);
		System.out.println(xmlString);
		try {
			FileWriter fileWriter = null;

			fileWriter = new FileWriter(file);
			fileWriter.write(xmlString);
			fileWriter.close();
		} catch (Exception e) {
			System.out.println("Couldn't save "+object.getFileName()+" ... "+e.getMessage());
		}

	}

	/**
	 * Deserialize an object
	 * 
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public InterfaceRepTemplate deserialize(String filePath, String fileName){
		
		try {
			InterfaceRepTemplate object = deserialize(new FileInputStream(filePath+fileName), fileName);
			object.setFilePath(filePath);
			return object;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
		
	/**
	 * Deserialize an object without setting its path
	 * 
	 * @param fileStream
	 * @param fileName
	 * @return
	 */
	public InterfaceRepTemplate deserialize(InputStream fileStream, String fileName){
		InterfaceRepTemplate object = null; 
		object = (InterfaceRepTemplate) xstream.fromXML(fileStream);
		object.setFileName(fileName);
		return object;
	}
	
	/**
	 * Binds XML tags to Java classes.
	 */
	public void makeAliases(){
		
		/*
		 * Nodes
		 */

		xstream.processAnnotations(InterfaceRepTemplate.class);
		
		xstream.alias("Class", ClassRepTemplate.class);
		xstream.alias("Interface", InterfaceRepTemplate.class);
		
		xstream.alias("Method", MethodRepTemplate.class);
		xstream.alias("Param", ParamRepTemplate.class);
		xstream.alias("Property", PropRepTemplate.class);
		xstream.alias("Iterable", IterableRepTemplate.class);
		xstream.alias("Indexer", IndexerRepTemplate.class);
		xstream.alias("Field", FieldRepTemplate.class);
		xstream.alias("Alias", AliasRepTemplate.class);
		xstream.alias("Cast", CastRepTemplate.class);
		xstream.alias("Constructor", ConstructorRepTemplate.class);
		
		/*
		 * Leaves
		 */

		xstream.processAnnotations(Inherit.class);
		xstream.processAnnotations(TypeParam.class);
		xstream.processAnnotations(Import.class);
		xstream.processAnnotations(Use.class);
		xstream.alias("Event", Event.class);
		xstream.alias("BinaryOp", BinaryOp.class);
		xstream.alias("UnaryOp", UnaryOp.class);
		
		/*
		 * Converters
		 */
		
	}

}
