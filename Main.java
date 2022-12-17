package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello 안녕 world!");

        gui GUI = new gui();

        Scanner scan = new Scanner(System.in);
        String s = scan.next();

        if(s.equals("hello")) {
            GUI.changeInputAmout("30000");
        } else if (s.equals("replace")) {
            //GUI.changeUIScreen(3);
        }
    }




}