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

public class XmlSerialization {
	
	/*
	 * Attributes
	 */
	
	private XStream xstream;
	
	/*
	 * Constructeur
	 */
	
	public XmlSerialization(){
		
		xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
		makeAliases();
	}
	
	/*
	 * Methods
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
		
		
	public InterfaceRepTemplate deserialize(InputStream fileStream, String fileName){
		InterfaceRepTemplate object = null; 
		object = (InterfaceRepTemplate) xstream.fromXML(fileStream);
		object.setFileName(fileName);
		return object;
	}
	
	public void makeAliases(){
		
		//xstream.registerConverter(new JavaBeanConverter(xstream.getMapper(), "class"), 0);
		
		/*
		 * Templates
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
