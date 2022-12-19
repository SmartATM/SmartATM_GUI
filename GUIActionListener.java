package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIActionListener implements ActionListener {
    private default_gui defaultGui;
    private gui_exchange guiExchange;
    private gui_result guiResult;
    public GUIActionListener(default_gui defaultGui){
        this.defaultGui = defaultGui;
    }

    public GUIActionListener(gui_exchange guiExchange){
        this.guiExchange = guiExchange;
    }

    public GUIActionListener(gui_result guiResult){
        this.guiResult = guiResult;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if(btn.getText().equals("교환하기")){
            defaultGui.getMainFrame().dispose();
            // 교환 화면으로 전환

            gui_exchange exchangeGui = new gui_exchange(defaultGui.getInputAmountLabel().getText());
        } else if (btn.getText().equals("교환")) {
            Main.requestedList(guiExchange.passExchangeRequestData());
        } else if (btn.getText().equals("reset")) {
            //리셋
            defaultGui.getMainFrame().dispose();
            default_gui newGui = new default_gui();
            JPanel returnForReset = newGui.getMoneyOutletPanel();
            //여기에 돈 반환코드 추가
        }
        else {
            //돈 버튼 클릭
            Main.changeInputAmout(btn.getText(),defaultGui.getInputAmountLabel());
        }

    }
}
