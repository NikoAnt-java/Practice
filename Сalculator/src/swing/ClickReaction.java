/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author fuzzb
 */
public class ClickReaction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Calculator":
                System.out.println("Выбран калькулятор");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        CalcWindow.getInstance();
                    }
                });
                break;
            case "Color Picker":
                System.out.println("Выбран выбор цвета");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ColorPickerWindow.getInstance();
                    }
                });
                break;
                              
        }
    }

}
