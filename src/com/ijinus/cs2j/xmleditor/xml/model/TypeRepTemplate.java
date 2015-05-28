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

public abstract class TypeRepTemplate extends TranslationBase{

	/*
	 * Attributes
	 */
	
	protected String Name;
	protected List<TypeParam> TypeParams;
	protected List<Use> Uses;
	protected List<AliasRepTemplate> Aliases;
	protected List<CastRepTemplate> Casts;
	protected List<Inherit> Inherits;
	
	/*
	 * Getters
	 */
	
	public String getName() {
		return Name;
	}
	public List<TypeParam> getTypeParams() {
		return TypeParams;
	}
	public List<Use> getUses() {
		return Uses;
	}
	public List<AliasRepTemplate> getAliases() {
		return Aliases;
	}
	public List<CastRepTemplate> getCasts() {
		return Casts;
	}
	public List<Inherit> getInherits() {
		return Inherits;
	}
	
	/*
	 * Setters
	 */
	
	public void setName(String name) {
		Name = name;
	}
	public void setTypeParams(List<TypeParam> typeParams) {
		TypeParams = typeParams;
	}
	public void setUses(List<Use> uses) {
		Uses = uses;
	}
	public void setAliases(List<AliasRepTemplate> aliases) {
		Aliases = aliases;
	}
	public void setCasts(List<CastRepTemplate> casts) {
		Casts = casts;
	}
	public void setInherits(List<Inherit> inherits) {
		Inherits = inherits;
	}

}
