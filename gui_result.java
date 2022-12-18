package org.example;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;

public class gui_result extends JFrame {
    public gui_result(HashMap resultHashMap,List cashList, String inputAmount){
        default_gui defaultGui = new default_gui();

        JPanel uiScreenPanel = defaultGui.getUIScreenPanel();
        JPanel moneyOutletPanel = defaultGui.getMoneyOutletPanel();
        moneyOutletPanel.setLayout(null);
        JButton startButton = defaultGui.getStartButton();
        startButton.setEnabled(false);
        startButton.setVisible(false);

        JLabel resultTitleLabel = new JLabel();
        resultTitleLabel.setBounds(50,20,300,20);
        resultTitleLabel.setText(inputAmount+" 의 교환결과");
        uiScreenPanel.add(resultTitleLabel);

        defaultGui.getInputAmountLabel().setText(inputAmount);

        for(int i=0;i<resultHashMap.size();i++){
            JLabel receitLabel = new JLabel();
            if(resultHashMap.get(cashList.get(i)).equals("")){
                resultHashMap.put(cashList.get(i),"0");
            }
            receitLabel.setText(cashList.get(i)+" : "+resultHashMap.get(cashList.get(i))+"개");
            receitLabel.setBounds(200,i*30+70,100,30);
            uiScreenPanel.add(receitLabel);

            // 투출구
            JLabel resultLabel = new JLabel();
            resultLabel.setText(cashList.get(i)+" : "+resultHashMap.get(cashList.get(i))+"개");
            resultLabel.setBounds(200,i*20+10,100,20);
            moneyOutletPanel.add(resultLabel);

        }

        uiScreenPanel.revalidate();
        uiScreenPanel.repaint();
        moneyOutletPanel.revalidate();
        moneyOutletPanel.repaint();


    }

}
