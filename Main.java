package org.example;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello 안녕 world!");

        default_gui homeGui = new default_gui();

        //GUI.revalidate();
        //GUI.repaint();



        Scanner scan = new Scanner(System.in);
        String s = scan.next();

        if(s.equals("hello")) {
            //GUI.changeInputAmout("30000");
        } else if (s.equals("replace")) {
            //GUI.changeUIScreen(3);
        }
    }


    public static void changeInputAmout(String newInput, JLabel inputAmountLabel){
        int prevAmount = Integer.parseInt(inputAmountLabel.getText());
        int currAmount = prevAmount + Integer.parseInt(newInput);

        inputAmountLabel.setText(String.valueOf(currAmount));

    }


}