/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author fuzzb
 */
public class ClickOperand implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String oldValue = CalcWindow.display.getText();
        if (oldValue.equals("0")){
            CalcWindow.display.setText(command);
        }else{
        CalcWindow.display.setText(oldValue + command);
    }
    
}
}
