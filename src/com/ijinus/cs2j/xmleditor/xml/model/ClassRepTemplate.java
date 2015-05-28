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
package com.ijinus.cs2j.xmleditor.xml.model;

import java.util.List;

public class ClassRepTemplate extends InterfaceRepTemplate{

	/*
	 * Attributes
	 */
	
	protected String BoxedJava;

	//protected List<ConstructorRepTemplate> Constructors;                     NOW IN InterfaceRepTemplate 
	protected List<FieldRepTemplate> Fields;
	protected List<UnaryOp> UnaryOps;
	protected List<BinaryOp> BinaryOps;
	
	/*
	 * Getters
	 */

	public String getBoxedJava() {
		return BoxedJava;
	}
	
	/*
	public List<ConstructorRepTemplate> getConstructors() {
		return Constructors;
	}*/

	public List<FieldRepTemplate> getFields() {
		return Fields;
	}

	public List<UnaryOp> getUnaryOps() {
		return UnaryOps;
	}

	public List<BinaryOp> getBinaryOps() {
		return BinaryOps;
	}
	
	/*
	 * Setters
	 */

	public void setBoxedJava(String boxedJava) {
		BoxedJava = boxedJava;
	}

	/*
	public void setConstructors(List<ConstructorRepTemplate> constructors) {
		Constructors = constructors;
	}*/

	public void setFields(List<FieldRepTemplate> fields) {
		Fields = fields;
	}

	public void setUnaryOps(List<UnaryOp> unaryOps) {
		UnaryOps = unaryOps;
	}

	public void setBinaryOps(List<BinaryOp> binaryOps) {
		BinaryOps = binaryOps;
	}
	
}
