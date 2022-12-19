package org.example;

import java.awt.*;
import java.awt.event.*;
import java.net.http.WebSocket;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class default_gui extends JFrame implements ActionListener {

    JFrame mainFrame;
    private JLabel inputAmountLabel;
    private JPanel uiScreenPanel;
    private JPanel moneyOutletPanel;
    JButton startButton;


    public default_gui(){
        //cardLayout = new CardLayout(10,10);
        uiScreenPanel = new JPanel();

        mainFrame= new JFrame();

        mainFrame.setTitle("스마트 지폐교환기"); //창제목을 설정
        mainFrame.setBounds(150, 50, 900, 700); //창크기를 설정
        mainFrame.setVisible(true); //창보이기 값 설정
        mainFrame.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton cashButton50000 = new JButton("50000");
        cashButton50000.setBounds(50,500, 70, 50);
        cashButton50000.addActionListener(guiListener);
        mainFrame.add(cashButton50000);

        JButton cashButton10000 = new JButton("10000");
        cashButton10000.setBounds(125,500, 70, 50);
        cashButton10000.addActionListener(guiListener);
        mainFrame.add(cashButton10000);

        JButton cashButton5000 = new JButton("5000");
        cashButton5000.setBounds(200,500, 70, 50);
        cashButton5000.addActionListener(guiListener);
        mainFrame.add(cashButton5000);

        JButton cashButton1000 = new JButton("1000");
        cashButton1000.setBounds(275,500, 70, 50);
        cashButton1000.addActionListener(guiListener);
        mainFrame.add(cashButton1000);

        JPanel machinePanel = new JPanel();
        machinePanel.setLayout(null);
        machinePanel.setSize(600,300);
        machinePanel.setBounds(50,30,800,400);
        machinePanel.setBackground(Color.white);
        machinePanel.setBorder(new LineBorder(Color.black,10,true));


        moneyOutletPanel = new JPanel();
        moneyOutletPanel.setBounds(50,280,500,100);
        moneyOutletPanel.setBackground(Color.gray);
        machinePanel.add(moneyOutletPanel);

        JLabel inputAmountTitleLabel = new JLabel();
        inputAmountTitleLabel.setText("투입금액 : ");
        inputAmountTitleLabel.setFont(inputAmountTitleLabel.getFont().deriveFont(20.0f));
        inputAmountTitleLabel.setBounds(570,30,120,30);
        machinePanel.add(inputAmountTitleLabel);

        inputAmountLabel = new JLabel();
        inputAmountLabel.setText("0");
        inputAmountLabel.setBounds(690,30,80,30);
        inputAmountLabel.setFont(inputAmountLabel.getFont().deriveFont(20.0f));
        machinePanel.add(inputAmountLabel);

        JLabel inputSlotLabel = new JLabel();
        inputSlotLabel.setBounds(570,75, 200, 15);
        inputSlotLabel.setOpaque(true);
        inputSlotLabel.setBackground(Color.gray);
        inputSlotLabel.setBorder(new LineBorder(Color.black,2,true));
        machinePanel.add(inputSlotLabel);

        JButton resetButton = new JButton();
        resetButton.setText("reset");
        resetButton.setBounds(700,300,80,80);
        resetButton.setBorder(new LineBorder(Color.black,2,true));
        resetButton.addActionListener(guiListener);
        machinePanel.add(resetButton);

        mainFrame.add(machinePanel);

        uiScreenPanel.setBounds(50,30,500,240);
        uiScreenPanel.setBackground(Color.white);
        uiScreenPanel.setBorder(new LineBorder(Color.pink,10,true));
        uiScreenPanel.setLayout(null);
        uiScreenPanel.setName("uiScreen");
        machinePanel.add(uiScreenPanel);


        startButton = new JButton();
        startButton.setText("교환하기");
        startButton.setBackground(Color.white);
        startButton.setBounds(200, 100, 100, 40);
        startButton.addActionListener(guiListener);
        uiScreenPanel.add(startButton);

    }

    //버튼 누른 것 텍스트라벨에 반영
/*    public void changeInputAmout(String newInput){
        int prevAmount = Integer.parseInt(inputAmountLabel.getText());
        int currAmount = prevAmount + Integer.parseInt(newInput);

        inputAmountLabel.setText(String.valueOf(currAmount));

    }*/


    ActionListener guiListener = new GUIActionListener(this);

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        /*if(btn.getText().equals("교환하기")){
            mainFrame.dispose();
            // 교환 화면으로 전환
            gui_exchange exchangeGui = new gui_exchange(inputAmountLabel.getText());
        } else if (btn.getText().equals("reset")) {
            //리셋
            mainFrame.dispose();
            default_gui newGui = new default_gui();
            JPanel returnForReset = newGui.getMoneyOutletPanel();
            //여기에 돈 반환코드 추가
        } else {
            //돈 버튼 클릭
            //changeInputAmout(btn.getText());
        }*/
    }



    public JPanel getUIScreenPanel(){
        return uiScreenPanel;
    }

    public JButton getStartButton(){
        return startButton;
    }

    public JFrame getMainFrame(){
        return mainFrame;
    }

    public JLabel getInputAmountLabel(){
        return inputAmountLabel;
    }

    public JPanel getMoneyOutletPanel(){
        return moneyOutletPanel;
    }
}
