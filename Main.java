package org.example;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main{
    static List<String> exchangeRequestList;

    public static void main(String[] args) {

        default_gui homeGui = new default_gui();




    }



    public static void changeInputAmout(String newInput, JLabel inputAmountLabel ){
        int prevAmount = Integer.parseInt(inputAmountLabel.getText());
        int currAmount = prevAmount + Integer.parseInt(newInput);

        inputAmountLabel.setText(String.valueOf(currAmount));
    }

    public static void requestedList(List<String> inputList){
        exchangeRequestList = inputList;
        System.out.println(exchangeRequestList);


    }



}