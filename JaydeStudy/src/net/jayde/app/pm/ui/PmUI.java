package net.jayde.app.pm.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import net.jayde.app.baseui.baseLibraryFrame.BaseSwingLibraryPanel;
import net.jayde.app.pm.PmReadDb;
import net.jayde.app.pm.ProjectLibrary;
import net.jayde.app.pm.ProjectObject;

public class PmUI extends BaseSwingLibraryPanel {

  PmGroupsTree groupsTree = new PmGroupsTree();

  PmInfoPanel projectInfoPanel = new PmInfoPanel();
  JPanel projectQuestionPanel = new JPanel();

  public PmUI() {
    super();

    PmReadDb pmReadDb = new PmReadDb();
    ProjectLibrary library = pmReadDb.readByDb();
    groupsTree.setLibrary(library);

    iniGroupsTree();
    iniInfoPanel();

    tabsTree.addTab("ProjectTree", new JScrollPane(groupsTree));
    tabsInfo.addTab("ProjectInfo", new JScrollPane(projectInfoPanel));
    tabsInfo.addTab("ProjectQuestions", new JScrollPane(projectQuestionPanel));
  }


  private void iniGroupsTree() {
    groupsTree.addTreeSelectionListener(new TreeSelectionListener() {
      @Override
      public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) groupsTree.getLastSelectedPathComponent();// 返回最后选定的节点
        System.out.println(selectedNode.getUserObject().getClass());
        Object obj = selectedNode.getUserObject();
        if(obj instanceof ProjectObject){
          ProjectObject po = (ProjectObject)obj;
          projectInfoPanel.setPmObject(po);
        }
      }
    });
  }

  private void iniInfoPanel() {
    // JTextField nameField = new JTextField("name:");
    // projectInfoPanel.setLayout(new BorderLayout());
    // projectInfoPanel.add(nameField, BorderLayout.NORTH);
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    jFrame.setBounds(100, 100, 800, 600);
    jFrame.setContentPane(new PmUI());
    jFrame.setVisible(true);
  }
}
