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

public class FieldRepTemplate extends TranslationBase{

	/*
	 * Attributes
	 */
	
	protected String Type;
	protected String Name;
	
	/*
	 * Getters
	 */
	
	public String getType() {
		return Type;
	}
	public String getName() {
		return Name;
	}
	
	/*
	 * Setters
	 */
	
	public void setType(String type) {
		Type = type;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
