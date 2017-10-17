package net.jayde.app.vcard.ui;

import net.jayde.app.baseui.baseLibraryFrame.BaseSwingLibraryPanel;
import net.jayde.app.vcard.VcardLibrary;
import net.jayde.app.vcard.VcfImport;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class VcardUI extends BaseSwingLibraryPanel {
    static String lafName = "com.incors.plaf.alloy.AlloyLookAndFeel";
    VcardCategoriesTree categoriesTree = new VcardCategoriesTree();

    public VcardUI() {
        super();

        VcfImport vcfImport = new VcfImport();
        VcardLibrary library = vcfImport.parseFile(new File(VcfImport.filename));
        categoriesTree.setLibrary(library);

        tabsTree.addTab("Categories", new JScrollPane(categoriesTree));
    }

    public static void main(String[] args) {
        try {
            //lookandfeel的风格主题
            javax.swing.plaf.metal.MetalLookAndFeel.setCurrentTheme( new javax.swing.plaf.metal.DefaultMetalTheme());
            //设置lookandfeel
            UIManager.setLookAndFeel(lafName);

            Font font = new Font("仿宋", Font.PLAIN, 12);
            //字体为宋体，样式为常规，字号12
            UIManager.put("MenuBar.font", font);
            UIManager.put("MenuItem.font", font);
            UIManager.put("Menu.font", font);
            UIManager.put("PopupMenu.font", font);
            UIManager.put("ToolBar.font", font);
            UIManager.put("ToolTip.font", font);
            UIManager.put("TabbedPane.font", font);
            UIManager.put("Label.font", font);
            UIManager.put("List.font", font);
            UIManager.put("ComboBox.font", font);
            UIManager.put("Button.font", font);
            UIManager.put("Table.font", font);
            UIManager.put("TableHeader.font", font);
            UIManager.put("Tree.font", font);
            UIManager.put("TextField.font", font);
            UIManager.put("TextArea.font", font);
            UIManager.put("TitledBorder.font", font);
            UIManager.put("OptionPane.font", font);
            UIManager.put("RadioButton.font", font);
            UIManager.put("CheckBox.font", font);
            UIManager.put("ToggleButton.font", font);
            UIManager.put("Dialog.font", font);
            UIManager.put("Panel.font", font);
        }
        catch ( UnsupportedLookAndFeelException e ) {
            System.out.println (lafName+" not supported on this platform. \nProgram Terminated");
            System.exit(0);
        }
        catch ( IllegalAccessException e ) {
            System.out.println (lafName+" could not be accessed. \nProgram Terminated");
            System.exit(0);
        }
        catch ( ClassNotFoundException e ) {
            System.out.println (lafName+" could not found. \nProgram Terminated");
            System.exit(0);
        }
        catch ( InstantiationException e ) {
            System.out.println (lafName+" could not be instantiated. \nProgram Terminated");
            System.exit(0);
        }
        catch ( Exception e ) {
            System.out.println ("Unexpected error. \nProgram Terminated");
            e.printStackTrace();
            System.exit(0);
        }
        
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setBounds(100, 100, 800, 600);
        jFrame.setContentPane(new VcardUI());
        jFrame.setVisible(true);
    }
}
