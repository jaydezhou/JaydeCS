package net.jayde.app.pm;

import java.util.List;
import java.util.ArrayList;

public class ProjectObject {
	List<ProjectQuestion> questions = new ArrayList<ProjectQuestion>();
	String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<ProjectQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<ProjectQuestion> questions) {
		this.questions = questions;
	}
}
