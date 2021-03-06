package net.jayde.study.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class JSliderVertical extends JPanel {
    public JSliderVertical() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 300));

        //
        // Creates a vertical JSlider that accept value in the
        // range between 0 and 20. The initial value is set to 4.
        //
        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 20, 4);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(4);

        add(slider, BorderLayout.CENTER);
    }

    public static void showFrame() {
        JPanel panel = new JSliderVertical();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Vertical JSlider");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JSliderVertical.showFrame();
            }
        });
    }
}
