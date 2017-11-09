package net.jayde.app.music.pojo;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MusicAlbum {

    private static Logger logger = LogManager.getLogger(MusicAlbum.class.getName());

    String id;
    String name;
    String mgId;
    String mpId;
    private MusicGroup mg;
    private MusicPerson mp;
    Set<MusicCd> cdSet = new HashSet<>();

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

    public String getMgId() {
        return mgId;
    }

    public void setMgId(String mgId) {
        this.mgId = mgId;
    }

    public String getMpId() {
        return mpId;
    }

    public void setMpId(String mpId) {
        this.mpId = mpId;
    }

    public MusicGroup getMg() {
        return mg;
    }

    public void setMg(MusicGroup mg) {
        this.mg = mg;
    }

    public MusicPerson getMp() {
        return mp;
    }

    public void setMp(MusicPerson mp) {
        this.mp = mp;
    }

    public Set<MusicCd> getCdSet() {
        return cdSet;
    }

    public void setCdSet(Set<MusicCd> cdSet) {
        this.cdSet = cdSet;
    }
}
