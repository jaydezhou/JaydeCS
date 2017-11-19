package net.jayde.app.music.pojo;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MusicLibrary {

  private static Logger logger = LogManager.getLogger(MusicLibrary.class.getName());
  List<MusicGroup> groups = new LinkedList<>();

  public List<MusicGroup> getGroups() {
    return groups;
  }

  public void setGroups(List<MusicGroup> groups) {
    this.groups = groups;
  }
}
