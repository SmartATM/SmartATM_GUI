package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gui_exchange extends JFrame implements ActionListener {

    JFrame mainFrame;
    JTextField quantityTextField1;
    JTextField quantityTextField2;
    JTextField quantityTextField3;
    JTextField quantityTextField4;
    JTextField quantityTextField5;
    JTextField quantityTextField6;
    JTextField quantityTextField7;
    JTextField quantityTextField8;
    JLabel inputForExchangeLabel;
    JLabel inputAmountLabel;
    JLabel warningLabel;



    List<String> list = new ArrayList<String>();

    public gui_exchange(String inputAmount) {
        initList();
        default_gui defaultGui = new default_gui();


        mainFrame= defaultGui.getMainFrame();

        //돈버튼 비활성화 해야하는데,
        //버튼의 개수&종류를 하나하나ㅏ 다받아오지 않는 방법 -> factory 활용? 필요

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel uiScreenPanel = defaultGui.getUIScreenPanel();

        inputAmountLabel = defaultGui.getInputAmountLabel();
        inputAmountLabel.setText(inputAmount);

        inputForExchangeLabel = new JLabel();
        inputForExchangeLabel.setName("amountLabel");
        inputForExchangeLabel.setText("투입한 금액은 " + inputAmount + "원 입니다");    //'원' 부분 수정
        inputForExchangeLabel.setBounds(15, 10, 300, 30);
        inputForExchangeLabel.setFont(inputForExchangeLabel.getFont().deriveFont(20.0f));
        uiScreenPanel.add(inputForExchangeLabel);


        quantityTextField1 = new JTextField();
        quantityTextField1.setBounds(110, 60, 50, 30);
        uiScreenPanel.add(quantityTextField1);

        quantityTextField2 = new JTextField();
        quantityTextField2.setBounds(110, 90, 50, 30);
        uiScreenPanel.add(quantityTextField2);

        quantityTextField3 = new JTextField();
        quantityTextField3.setBounds(110, 120, 50, 30);
        uiScreenPanel.add(quantityTextField3);

        quantityTextField4 = new JTextField();
        quantityTextField4.setBounds(110, 150, 50, 30);
        uiScreenPanel.add(quantityTextField4);


        quantityTextField5 = new JTextField();
        quantityTextField5.setBounds(230, 60, 50, 30);
        uiScreenPanel.add(quantityTextField5);

        quantityTextField6 = new JTextField();
        quantityTextField6.setBounds(230, 90, 50, 30);
        uiScreenPanel.add(quantityTextField6);

        quantityTextField7 = new JTextField();
        quantityTextField7.setBounds(230, 120, 50, 30);
        uiScreenPanel.add(quantityTextField7);

        quantityTextField8 = new JTextField();
        quantityTextField8.setBounds(230, 150, 50, 30);
        uiScreenPanel.add(quantityTextField8);

        warningLabel = new JLabel();
        warningLabel.setText("0만큼 금액이 부족합니다!");
        warningLabel.setName("warningLabel");
        warningLabel.setBounds(20, 200, 200, 20);
        warningLabel.setForeground(Color.white);
        uiScreenPanel.add(warningLabel);

        JButton exchangeConfirmButton = new JButton();
        exchangeConfirmButton.setBounds(400, 180, 80, 40);
        exchangeConfirmButton.setText("교환");
        exchangeConfirmButton.addActionListener(guiListener);
        uiScreenPanel.add(exchangeConfirmButton);

        JButton startButton = defaultGui.getStartButton();
        startButton.setEnabled(false);
        startButton.setVisible(false);


        uiScreenPanel.revalidate();
        uiScreenPanel.repaint();


        //돈 종류 만큼 label 생성
        for (int i = 0; i < list.size()/2; i++) {
            JLabel tempLabel = new JLabel(list.get(i));
            tempLabel.setBounds(60, i * 30 + 60, 50, 30);
            tempLabel.setName("tempLabel");
            uiScreenPanel.add(tempLabel);
        }
        for (int i = list.size()/2; i < list.size(); i++) {
            JLabel tempLabel = new JLabel(list.get(i));
            tempLabel.setBounds(180, (i-(list.size()/2)) * 30 + 60, 50, 30);
            tempLabel.setName("tempLabel");
            uiScreenPanel.add(tempLabel);
        }
    }

    //대강 4종류라고 치고 초기화.. 거의 테스트용이라서 코드 다시 짜야함
    public void initList(){
        list.add("50000");
        list.add("10000");
        list.add("5000");
        list.add("1000");
        list.add("500");
        list.add("100");
        list.add("50");
        list.add("10");
    }

    //요
    public Integer calculateRequestCashAmount(String tf1, String tf2,
                                              String tf3, String tf4){
        Integer calculatedAmount;
        tf1 = nullToZero(tf1);
        tf2 = nullToZero(tf2);
        tf3 = nullToZero(tf3);
        tf4 = nullToZero(tf4);

        calculatedAmount =
                50000*Integer.parseInt(tf1)+10000*Integer.parseInt(tf2)+
                        5000*Integer.parseInt(tf3)+ 1000*Integer.parseInt(tf4);

        System.out.println("calculated : "+calculatedAmount);
        return calculatedAmount;
    }

    public String nullToZero(String input){
        if (input.equals(""))
            return "0";
        else return input;
    }

    ActionListener guiListener = new GUIActionListener(this);

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn.getText().equals("교환")){
            //사용자 입력값을 quantity에 저장 //돈 종류 개수 관련해서 코드정리 필요,,,
            String quantity1 = quantityTextField1.getText();
            String quantity2 = quantityTextField2.getText();
            String quantity3 = quantityTextField3.getText();
            String quantity4 = quantityTextField4.getText();

            Integer calculatedAmount = calculateRequestCashAmount(quantity1, quantity2, quantity3, quantity4);
            Integer amountInt = Integer.valueOf(inputAmountLabel.getText());

            // 금액 동일
            if(calculatedAmount.equals(amountInt)){
                quantityTextField1.setText("");
                quantityTextField2.setText("");
                quantityTextField3.setText("");
                quantityTextField4.setText("");

                mainFrame.dispose();

                //꼭 해시맵 아니어두 되긴 함..
                HashMap<String, String> resultHashMap = new HashMap<>();
                resultHashMap.put(list.get(0),quantity1);
                resultHashMap.put(list.get(1),quantity2);
                resultHashMap.put(list.get(2),quantity3);
                resultHashMap.put(list.get(3),quantity4);

                //결과 출력
                gui_result resultGui = new gui_result(resultHashMap,list, inputAmountLabel.getText());
            }
            else if(calculatedAmount<amountInt){
                // 요구치 < 투입금액
                warningLabel.setForeground(Color.red);
                warningLabel.setText((amountInt-calculatedAmount)+ " 만큼 투입금이 많습니다");

                revalidate();
                repaint();
            }
            else if(calculatedAmount>amountInt){
                // 요구치 > 투입금액
                warningLabel.setForeground(Color.red);
                warningLabel.setText((calculatedAmount-amountInt)+ " 만큼 반환 요구액이 많습니다");

                revalidate();
                repaint();
            }
        }

    }

    public List<String> passExchangeRequestData(){
        List<String> exchangeRequestList = new ArrayList<>();
        String quantity1 = quantityTextField1.getText();
        String quantity2 = quantityTextField2.getText();
        String quantity3 = quantityTextField3.getText();
        String quantity4 = quantityTextField4.getText();
        String quantity5 = quantityTextField5.getText();
        String quantity6 = quantityTextField6.getText();
        String quantity7 = quantityTextField7.getText();
        String quantity8 = quantityTextField8.getText();


        exchangeRequestList.add(nullToZero(quantity1));
        exchangeRequestList.add(nullToZero(quantity2));
        exchangeRequestList.add(nullToZero(quantity3));
        exchangeRequestList.add(nullToZero(quantity4));
        exchangeRequestList.add(nullToZero(quantity5));
        exchangeRequestList.add(nullToZero(quantity6));
        exchangeRequestList.add(nullToZero(quantity7));
        exchangeRequestList.add(nullToZero(quantity8));

        return exchangeRequestList;
    }

    public JLabel getInputAmountLabel(){
        return inputAmountLabel;
    }

    public JTextField getQuantityTextField1(){
        return quantityTextField1;
    }

}
