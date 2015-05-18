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
