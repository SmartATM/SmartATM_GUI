package org.example;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class gui extends JFrame implements ActionListener {

    private JLabel inputAmountLabel;
    private JLayeredPane uiScreenPanel;
    private JPanel exchangePanel;
    private JButton exchangeButton;
    Container container;
    HashMap<String,JTextField> jTextFieldHashMap;
    //CardLayout cardLayout;

    public gui(){
        //cardLayout = new CardLayout(10,10);
        uiScreenPanel = new JLayeredPane();

        JFrame mainFrame= new JFrame(); //f라는 Frame 생성

        mainFrame.setTitle("스마트 지폐교환기"); //창제목을 설정
        mainFrame.setBounds(150, 50, 900, 700); //창크기를 설정
        mainFrame.setVisible(true); //창보이기 값 설정
        mainFrame.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton cashButton50000 = new JButton("50000");
        cashButton50000.setBounds(50,500, 70, 50);
        cashButton50000.addActionListener(this);
        mainFrame.add(cashButton50000);

        JButton cashButton10000 = new JButton("10000");
        cashButton10000.setBounds(125,500, 70, 50);
        cashButton10000.addActionListener(this);
        mainFrame.add(cashButton10000);

        JButton cashButton5000 = new JButton("5000");
        cashButton5000.setBounds(200,500, 70, 50);
        cashButton5000.addActionListener(this);
        mainFrame.add(cashButton5000);

        JButton cashButton1000 = new JButton("1000");
        cashButton1000.setBounds(275,500, 70, 50);
        cashButton1000.addActionListener(this);
        mainFrame.add(cashButton1000);

        JPanel machinePanel = new JPanel();
        machinePanel.setLayout(null);
        machinePanel.setSize(600,300);
        machinePanel.setBounds(50,30,800,400);
        machinePanel.setBackground(Color.white);
        machinePanel.setBorder(new LineBorder(Color.black,10,true));


        JPanel moneyOutletPanel = new JPanel();
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
        machinePanel.add(resetButton);

        mainFrame.add(machinePanel);

        uiScreenPanel.setBounds(50,30,500,240);
        uiScreenPanel.setBackground(Color.white);
        uiScreenPanel.setBorder(new LineBorder(Color.pink,10,true));
        uiScreenPanel.setLayout(null);
        uiScreenPanel.setName("uiScreen");
        machinePanel.add(uiScreenPanel);

        exchangeButton = new JButton();
        exchangeButton.setText("교환하기");
        exchangeButton.setBackground(Color.white);
        exchangeButton.setBounds(200, 100, 100, 40);
        uiScreenPanel.add(exchangeButton,JLayeredPane.DEFAULT_LAYER);

        jTextFieldHashMap = new HashMap<>();
        exchangePanel = new exchangePanel(jTextFieldHashMap,uiScreenPanel,exchangeButton);
        exchangePanel.setOpaque(true);
        exchangePanel.setBackground(Color.white);
        exchangePanel.setBounds(0,0,500,240);
        exchangePanel.setVisible(false);
        uiScreenPanel.add(exchangePanel, JLayeredPane.POPUP_LAYER);

        exchangeButton.addActionListener(e -> {
            jTextFieldHashMap.clear();

            for (Component jc : exchangePanel.getComponents()) {
                if ( jc instanceof JLabel) {
                    if(jc.getName().toString().equals("amountLabel"))
                        ((JLabel) jc).setText("투입한 금액은 "+inputAmountLabel.getText()+"원 입니다");
                }
            }

            exchangePanel.setVisible(true);
            exchangeButton.setEnabled(false);

        });


        uiScreenPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            }
        });




    }

    public void changeInputAmout(String newInput){
        int prevAmount = Integer.parseInt(inputAmountLabel.getText());
        int currAmount = prevAmount + Integer.parseInt(newInput);

        inputAmountLabel.setText(String.valueOf(currAmount));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String amount = btn.getText();
        changeInputAmout(amount);
    }
}
