package model;

import java.util.LinkedList;

public class Project {

	private String name;
	private boolean active;
	private String colorCode;
	private LinkedList<String> subProjects;

	public Project(String name, String c, boolean active){
		this.name = name;
		this.colorCode = c;
		this.active = active;
		this.subProjects = new LinkedList<String>();
	}

	public Project(String name, String c, boolean active, LinkedList<String> sp){
		this.name = name;
		this.colorCode = c;
		this.active = active;
		this.subProjects = sp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void createSubproject(String name){
		subProjects.add(name);
	}

}
