package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class exchangePanel extends JPanel {
    List<String> list = new ArrayList<String>();
    static HashMap<String, JTextField> jTextFieldHashMap;

    public exchangePanel(HashMap jTextFieldHashMap,
                         JLayeredPane parentPane,JButton exchangeButton){
        initList();
        this.setLayout(null);
        JLabel inputAmountLabel = new JLabel();
        inputAmountLabel.setName("amountLabel");
        inputAmountLabel.setText("투입한 금액은 "+"0"+"원 입니다");    //'원' 부분 수정
        inputAmountLabel.setBounds(15,10,300,30);
        inputAmountLabel.setFont(inputAmountLabel.getFont().deriveFont(20.0f));
        this.add(inputAmountLabel);


        JTextField quantityTextField1 = new JTextField();
        quantityTextField1.setBounds(110, 60,50,30);
        this.add(quantityTextField1);

        JTextField quantityTextField2 = new JTextField();
        quantityTextField2.setBounds(110, 90,50,30);
        this.add(quantityTextField2);

        JTextField quantityTextField3 = new JTextField();
        quantityTextField3.setBounds(110, 120,50,30);
        this.add(quantityTextField3);

        JTextField quantityTextField4 = new JTextField();
        quantityTextField4.setBounds(110, 150,50,30);
        this.add(quantityTextField4);

        JLabel warningLabel = new JLabel();
        warningLabel.setText("0만큼 금액이 부족합니다!");
        warningLabel.setName("warningLabel");
        warningLabel.setBounds(0,200,200,20);
        warningLabel.setForeground(Color.white);
        this.add(warningLabel);


        for(int i=0;i<list.size();i++){
            JLabel tempLabel = new JLabel(list.get(i));
            tempLabel.setBounds(60, i*30+60,50,30);
            tempLabel.setName("tempLabel");
            this.add(tempLabel);
        }
        jTextFieldHashMap.put("50000",quantityTextField1);
        jTextFieldHashMap.put("10000",quantityTextField2);
        jTextFieldHashMap.put("5000",quantityTextField3);
        jTextFieldHashMap.put("1000",quantityTextField4);

        JButton exchangeConfirmButton = new JButton("교환");
        exchangeConfirmButton.setBounds(400,200,80,30);
        exchangeConfirmButton.addActionListener(e -> {

            System.out.println(quantityTextField1.getText());
            System.out.println(quantityTextField2.getText());
            System.out.println(quantityTextField3.getText());
            System.out.println(quantityTextField4.getText());

            Integer calculatedAmount = calculateRequestCashAmount(
                    quantityTextField1.getText(),
                    quantityTextField2.getText(),
                    quantityTextField3.getText(),
                    quantityTextField4.getText());

            Integer amountInt = Integer.valueOf(inputAmountLabel.getText().replaceAll("\\D+",""));
            System.out.println("amount is " +amountInt);

            if(calculatedAmount.equals(amountInt)){
                quantityTextField1.setText("");
                quantityTextField2.setText("");
                quantityTextField3.setText("");
                quantityTextField4.setText("");

                this.setVisible(false);




                resultPanel resultPanel = new resultPanel(parentPane,exchangeButton);
            }
            else if(calculatedAmount<amountInt){
                warningLabel.setForeground(Color.red);
                warningLabel.setText((amountInt-calculatedAmount)+ " 만큼 투입금이 많습니다");

                revalidate();
                repaint();
            }
            else if(calculatedAmount>amountInt){
                warningLabel.setForeground(Color.red);
                warningLabel.setText((calculatedAmount-amountInt)+ " 만큼 반환 요구액이 많습니다");

                revalidate();
                repaint();
            }


        });

        this.add(exchangeConfirmButton);

    }

    public void initList(){
        list.add("50000");
        list.add("10000");
        list.add("5000");
        list.add("1000");
    }

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
}



