package net.jayde.app.pm;

import java.util.List;
import java.util.ArrayList;

public class ProjectGroup {
    List<ProjectObject> projects = new ArrayList<ProjectObject>();
    String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectObject> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectObject> projects) {
        this.projects = projects;
    }
}
