package net.jayde.app.music.pojo;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MusicGroup {

  private static Logger logger = LogManager.getLogger(MusicGroup.class.getName());

  String id;
  String name;
  Set<MusicPerson> personSet = null;

  public MusicGroup() {

  }

  public MusicGroup(String inputId, String inputName) {
    id = inputId;
    name = inputName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<MusicPerson> getPersonSet() {
    if (personSet == null) personSet = new HashSet<>();
    return personSet;
  }

  public void setPersonSet(Set<MusicPerson> personSet) {
    this.personSet = personSet;
  }

  @Override
  public String toString() {
    return "MusicGroup{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
