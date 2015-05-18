package test.com.ijinus.cs2j.xmleditor.xml;

import java.util.ArrayList;

import org.junit.Test;

import com.ijinus.cs2j.xmleditor.xml.XmlSerialization;
import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

public class XmlSerializationTest {
	
	static XmlSerialization serializer = new XmlSerialization();
	static String path = "C:/Users/mblond/Documents/CS2J/cs2j/CSharpTranslator/src/CS2JTranslator/NetFramework/System/";
	
	ArrayList<InterfaceRepTemplate> templates;
	
	@Test
	public void test(){
		
		templates = new ArrayList<InterfaceRepTemplate>();
		
		deserializeTest();
		interfaceTest();
	}
	
	public void serializeTest(){}
	public void deserializeTest(){		
		templates.add(serializer.deserialize(path,"Boolean.xml"));
		templates.add(serializer.deserialize(path,"IDisposable.xml"));
		templates.add(serializer.deserialize(path,"IEquatable.xml"));
		templates.add(serializer.deserialize(path,"Array'1.xml"));
		templates.add(serializer.deserialize(path,"DateTime.xml"));
	}
	
	public void interfaceTest(){
		
	}
	
}
