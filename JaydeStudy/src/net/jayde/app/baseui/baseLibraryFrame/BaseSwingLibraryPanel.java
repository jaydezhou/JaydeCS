package net.jayde.app.baseui.baseLibraryFrame;

import javax.swing.*;
import java.awt.*;

public class BaseSwingLibraryPanel extends JPanel{
    JSplitPane center = new JSplitPane();
    JPanel bottom = new JPanel();
    protected JTabbedPane tabsTree = new JTabbedPane();
    protected JTabbedPane tabsInfo = new JTabbedPane();

    public BaseSwingLibraryPanel() {
        initCenter();
        initBottom();
        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public void initCenter() {
        center.setDividerLocation(50);

        center.setLeftComponent(tabsTree);
//        center.setLeftComponent(new JScrollPane(tabsTree));
        center.setRightComponent(tabsInfo);
//        center.setRightComponent(new JScrollPane(tabsInfo));
    }

    public void initBottom() {
        setLayout(new FlowLayout());
        add(new JLabel("info"));
    }
}
