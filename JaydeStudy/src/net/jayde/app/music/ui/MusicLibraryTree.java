package net.jayde.app.music.ui;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.jayde.app.music.pojo.MusicGroup;
import net.jayde.app.music.pojo.MusicLibrary;
import net.jayde.app.music.pojo.MusicPerson;
import net.jayde.app.pm.pojo.ProjectGroup;
import net.jayde.app.pm.pojo.ProjectLibrary;
import net.jayde.app.pm.pojo.ProjectObject;

public class MusicLibraryTree  extends JTree {

    private static Logger logger = LogManager.getLogger(MusicLibraryTree.class.getName());
    MusicLibrary library = null;

    public MusicLibrary getLibrary() {
        return library;
    }

    public void setLibrary(MusicLibrary inputLibrary) {
        library = inputLibrary;

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultTreeModel model = new DefaultTreeModel(root);

        for (MusicGroup group : library.getGroups()) {
            DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group);
            model.insertNodeInto(groupNode, root, root.getChildCount());
            for (MusicPerson person: group.getPersonSet()) {
                DefaultMutableTreeNode personNode = new DefaultMutableTreeNode(person);
                model.insertNodeInto(personNode, groupNode, groupNode.getChildCount());
            }
        }


        setModel(model);
    }

}
