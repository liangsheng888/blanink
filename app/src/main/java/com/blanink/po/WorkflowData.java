package com.blanink.po;

import java.io.Serializable;
import java.util.Map;

public class WorkflowData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String,String> transitions;
	
	private Map<String,String> names;
	
	private Map<String,Object> positions;
	
	private String container;

	public Map<String, String> getTransitions() {
		return transitions;
	}

	public void setTransitions(Map<String, String> transitions) {
		this.transitions = transitions;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public Map<String, Object> getPositions() {
		return positions;
	}

	public void setPositions(Map<String, Object> positions) {
		this.positions = positions;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	
	
}
