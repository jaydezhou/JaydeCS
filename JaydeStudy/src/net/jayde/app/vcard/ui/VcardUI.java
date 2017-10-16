package net.jayde.app.vcard.ui;

import net.jayde.app.baseui.baseLibraryFrame.BaseSwingLibraryPanel;

import javax.swing.*;
import java.awt.*;

public class VcardUI extends BaseSwingLibraryPanel {

    public VcardUI(){
        super();
        tabsTree.addTab("Categories",new JScrollPane(new JTree()));
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setBounds(100, 100, 800, 600);
        jFrame.setContentPane(new VcardUI());
        jFrame.setVisible(true);
    }
}
