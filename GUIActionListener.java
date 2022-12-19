package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIActionListener implements ActionListener {
    private default_gui defaultGui;
    public GUIActionListener(default_gui defaultGui){
        this.defaultGui = defaultGui;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        Main.changeInputAmout(btn.getText(),defaultGui.getInputAmountLabel());

    }
}
