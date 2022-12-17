package org.example;

import javax.swing.*;
import java.awt.*;

public class resultPanel extends JPanel {
    public resultPanel(JLayeredPane parentPane, JButton exchangeButton){
        JPanel resultPanel = new JPanel();
        resultPanel.setOpaque(true);
        resultPanel.setBackground(Color.white);
        resultPanel.setBounds(0,0,500,240);
        resultPanel.setLayout(null);
        resultPanel.setVisible(true);

        JButton exitButton = new JButton("종료하기");
        exitButton.setBounds(200,200,100,30);
        exitButton.addActionListener(e -> {
            resultPanel.setVisible(false);
            exchangeButton.setEnabled(true);
        });
        resultPanel.add(exitButton);

        parentPane.add(resultPanel,JLayeredPane.POPUP_LAYER);


    }
}
