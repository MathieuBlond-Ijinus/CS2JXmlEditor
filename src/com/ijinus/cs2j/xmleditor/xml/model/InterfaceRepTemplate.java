package com.ijinus.cs2j.xmleditor.xml.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class InterfaceRepTemplate extends TypeRepTemplate{

	/*
	 * Attributes 
	 */
	
	protected transient String _fileName;
	
	@XStreamAsAttribute
	@XStreamAlias("xmlns:xsi")
	public String xmlns_xsi; 
	
	@XStreamAsAttribute
	@XStreamAlias("xmlns:xsd")
	public String xmlns_xsd;
	
	@XStreamAsAttribute
	@XStreamAlias("xmlns")
	public String xmlns;
	
	@XStreamAsAttribute
	@XStreamAlias("has_boxed_rep")
	private Boolean hasBoxedRep;
	
	protected List<MethodRepTemplate> Methods;
	protected List<PropRepTemplate> Properties;
	protected List<ConstructorRepTemplate> Constructors;
	protected List<Event> Events;
	protected List<IndexerRepTemplate> Indexers;
	protected IterableRepTemplate Iterable;
	
	/*
	 * Getters
	 */
	
	public String getFileName() {
		return _fileName;
	}

	public List<MethodRepTemplate> getMethods() {
		// TODO Auto-generated method stub
		return Methods;
	}
	
	public List<PropRepTemplate> getProperties() {
		return Properties;
	}
	
	public List<ConstructorRepTemplate> getConstructors() {
		return Constructors;
	}

	public List<Event> getEvents() {
		return Events;
	}

	public List<IndexerRepTemplate> getIndexers() {
		return Indexers;
	}
	
	public IterableRepTemplate getIterable() {
		return Iterable;
	}
	
	/*
	 * Setters
	 */
	
	public void setFileName(String fileName){ _fileName = fileName; }

	public void setMethods(List<MethodRepTemplate> methods) {
		Methods = methods;
	}

	public void setProperties(List<PropRepTemplate> properties) {
		Properties = properties;
	}
	
	public void setConstructors(List<ConstructorRepTemplate> constructors) {
		Constructors = constructors;
	}

	public void setEvents(List<Event> events) {
		Events = events;
	}

	public void setIndexers(List<IndexerRepTemplate> indexers) {
		Indexers = indexers;
	}

	public void setIterable(IterableRepTemplate iterable) {
		Iterable = iterable;
	}

	public void setHasBoxedRep(boolean value) {
		hasBoxedRep = value;
	}

}
