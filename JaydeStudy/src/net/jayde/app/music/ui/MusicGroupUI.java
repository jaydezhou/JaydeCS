package net.jayde.app.music.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.jayde.app.music.pojo.MusicGroup;

public class MusicGroupUI extends JPanel {

  private static Logger logger = LogManager.getLogger(MusicGroupUI.class.getName());

  JButton jbReflesh = new JButton("Reflesh");
  JButton jbSave = new JButton("Save");
  JTable tablePersons = new JTable();

  GridBagLayout gbl = new GridBagLayout();
  GridBagConstraints gbc = new GridBagConstraints();

  MusicGroup currentGroup = null;

  public MusicGroupUI() {
    setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BorderLayout());
    buttonPanel.add(jbReflesh, BorderLayout.WEST);
    buttonPanel.add(jbSave, BorderLayout.EAST);
    add(buttonPanel, BorderLayout.NORTH);

    JScrollPane jScrollPane = new JScrollPane(tablePersons);
    add(jScrollPane,BorderLayout.CENTER);
  }

  public MusicGroup getCurrentGroup() {
    return currentGroup;
  }

  public void setCurrentGroup(MusicGroup currentGroup) {
    this.currentGroup = currentGroup;
  }
}
