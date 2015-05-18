package com.ijinus.cs2j.xmleditor.ui;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.ijinus.cs2j.xmleditor.xml.XmlSerialization;
import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

public class FrameTest {
	
	static XmlSerialization serializer = new XmlSerialization();
	static String path = "C:/Users/mblond/Documents/CS2J/cs2j/CSharpTranslator/src/CS2JTranslator/NetFramework/System/";
	
	static ArrayList<InterfaceRepTemplate> templates = new ArrayList<InterfaceRepTemplate>();

	public static void main(String[] args) {
		
		templates.add(serializer.deserialize(path,"Boolean.xml"));
		templates.add(serializer.deserialize(path,"IDisposable.xml"));
		templates.add(serializer.deserialize(path,"IEquatable.xml"));
		templates.add(serializer.deserialize(path,"Array'1.xml"));
		templates.add(serializer.deserialize(path,"DateTime.xml"));
		
		JFrame frame = new JFrame("Akekoukou le test !");
		frame.setContentPane(new UserFriendlyPanel(templates.get(0)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		
		frame.setVisible(true);

	}

}
