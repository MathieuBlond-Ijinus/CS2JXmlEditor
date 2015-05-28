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
