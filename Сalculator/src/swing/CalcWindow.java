/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author fuzzb
 */
public class CalcWindow extends JFrame {

    public static CalcWindow window = null;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    public static JLabel display = null;
    private static JPanel buttonPanel = null;

    private CalcWindow() {
        final int WIDTH = 500;
        final int HEIGHT = 500;
        window = this;
        setTitle("Calculator");
        setSize(new Dimension(WIDTH, HEIGHT));
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        display = new JLabel("0", JLabel.RIGHT);

        display.setPreferredSize(new Dimension(this.getWidth(), 70));

        display.setFont(new Font("Arial", Font.BOLD, 40));

        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        this.setLayout(new BorderLayout());

        this.add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10));

        buttonPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY));

        ActionListener clickCommand = new ClickCommand();
        ActionListener clickOperand = new ClickOperand();

        addButton("7", clickOperand);
        addButton("8", clickOperand);
        addButton("9", clickOperand);
        addButton("+", clickCommand);

        addButton("4", clickOperand);
        addButton("5", clickOperand);
        addButton("6", clickOperand);
        addButton("-", clickCommand);

        addButton("3", clickOperand);
        addButton("2", clickOperand);
        addButton("1", clickOperand);
        addButton("*", clickCommand);

        addButton("CE", clickOperand);
        addButton("0", clickOperand);
        addButton(".", clickOperand);
        addButton("/", clickCommand);

        this.add(buttonPanel, BorderLayout.CENTER);

        JButton resultButton = new JButton("=");
        resultButton.setFont(new Font("Arial", Font.PLAIN, 30));
        resultButton.addActionListener(clickCommand);
        resultButton.setPreferredSize(new Dimension(this.getWidth(), 70));
        resultButton.setBorder(BorderFactory.createMatteBorder(0, 10, 10, 10, Color.LIGHT_GRAY));

        this.add(resultButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addButton(String text, ActionListener al) {
        JButton button = new JButton(text);

        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.addActionListener(al);
        button.setMnemonic((int) text.charAt(0));
        buttonPanel.add(button);

    }

    static CalcWindow getInstance() {
        if (window == null) {
            return new CalcWindow();
        }
        return window;
    }

}
