package net.jayde.app.pm.ui;

import net.jayde.app.baseui.baseLibraryFrame.BaseSwingLibraryPanel;
import net.jayde.app.pm.PmReadDb;
import net.jayde.app.pm.ProjectLibrary;

import javax.swing.*;
import java.awt.*;

public class PmUI extends BaseSwingLibraryPanel {

    PmGroupsTree groupsTree = new PmGroupsTree();

    JPanel projectInfoPanel = new JPanel();
    JPanel projectQuestionPanel = new JPanel();

    public PmUI() {
        super();

        PmReadDb pmReadDb = new PmReadDb();
        ProjectLibrary library = pmReadDb.readByDb();
        groupsTree.setLibrary(library);

        iniInfoPanel();

        tabsTree.addTab("ProjectTree", new JScrollPane(groupsTree));
        tabsInfo.addTab("ProjectInfo",new JScrollPane(projectInfoPanel));
        tabsInfo.addTab("ProjectQuestions",new JScrollPane(projectQuestionPanel));
    }

    private void iniInfoPanel(){
        JTextField nameField = new JTextField("name:");
        projectInfoPanel.setLayout(new BorderLayout());
        projectInfoPanel.add(nameField,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setBounds(100, 100, 800, 600);
        jFrame.setContentPane(new PmUI());
        jFrame.setVisible(true);
    }
}
