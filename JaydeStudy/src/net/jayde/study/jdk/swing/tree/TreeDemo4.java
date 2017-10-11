package com.jayde.codesamples.jdk.swing.tree;

import com.incors.plaf.alloy.AlloyLookAndFeel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by jayde on 2016-11-27 14:22.
 * 版权所有
 */
public class TreeDemo4 {
    public TreeDemo4() {
        JFrame f = new JFrame("TreeDemo");
        Container contentPane = f.getContentPane();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("资源管理器");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("我的公文包");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("我的电脑");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("收藏夹");
        DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("Readme");
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        treeModel.insertNodeInto(node1, root, root.getChildCount());
        treeModel.insertNodeInto(node2, root, root.getChildCount());
        treeModel.insertNodeInto(node3, root, root.getChildCount());
        treeModel.insertNodeInto(node4, root, root.getChildCount());

        DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("公司文件");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("个人信件");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("私人文件");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());

        leafnode = new DefaultMutableTreeNode("本机磁盘(C:)");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("本机磁盘(D:)");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("本机磁盘(E:)");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());

        DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("网站列表");
        treeModel.insertNodeInto(node31, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("奇摩站");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("职棒消息");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("网络书店");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        try {
            LookAndFeel alloyLnF = new AlloyLookAndFeel();
            UIManager.setLookAndFeel(alloyLnF);
        } catch (UnsupportedLookAndFeelException ex) {
            // You may handle the exception here
        }
        // this line needs to be implemented in order to make JWS work properly
        UIManager.getLookAndFeelDefaults().put("ClassLoader",
                getClass().getClassLoader());

        JTree tree = new JTree(treeModel);
        tree.setRowHeight(20);
        DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) tree
                .getCellRenderer();
        //cellRenderer.setLeafIcon(new ImageIcon("/Users/jayde/IdeaProjects/jaydemini/out/production/mini/icons/librarytreeicons/node.png"));
        cellRenderer.setOpenIcon(new ImageIcon("/Users/jayde/IdeaProjects/jaydemini/out/production/mini/icons/librarytreeicons/libraryopen.png"));
        cellRenderer.setClosedIcon(new ImageIcon("/Users/jayde/IdeaProjects/jaydemini/out/production/mini/icons/librarytreeicons/libraryclose.png"));

        cellRenderer.setFont(new Font("宋体", Font.PLAIN, 12));// 设置字体.
        cellRenderer.setBackgroundNonSelectionColor(Color.white);
        cellRenderer.setBackgroundSelectionColor(Color.yellow);
        cellRenderer.setBorderSelectionColor(Color.red);
		/*
		 * 设置选时或不选时，文字的变化颜色
		 */
        cellRenderer.setTextNonSelectionColor(Color.black);
        cellRenderer.setTextSelectionColor(Color.blue);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(tree);

        contentPane.add(scrollPane);
        f.pack();
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String args[]) {

        new TreeDemo4();
    }
}
