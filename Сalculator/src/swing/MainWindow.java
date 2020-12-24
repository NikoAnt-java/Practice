/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author fuzzb
 */
public class MainWindow extends JFrame {

    private static MainWindow mainWindow = null;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private MainWindow() {

        this.setTitle("Application selection");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);// центрирование по экрану

        JButton toCalculator = new JButton("Calculator");
        JButton toColorPicker = new JButton("Color Picker");

        ActionListener actionListion = new ClickReaction();

        toCalculator.addActionListener(actionListion);
        toColorPicker.addActionListener(actionListion);

        add(toCalculator, JButton.CENTER);
        add(toColorPicker, JButton.CENTER);

        setLayout(new FlowLayout());
        pack();

        mainWindow = this;
        setVisible(true);
    }

    public static MainWindow getInstance() {
        if (mainWindow == null) {
            return new MainWindow();
        }
        return mainWindow;
    }

}
