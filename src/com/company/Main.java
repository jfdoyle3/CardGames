package com.company;

import com.company.deck.UnoDeck;

public class Main {


    public static void main(String[] args) {

        UnoDeck deck = new UnoDeck();
        System.out.println(deck);
        String line = "-|-";
        System.out.println(line.repeat(6));
        System.out.println(deck.getCard(20));
        System.out.println(line.repeat(6));

        // Validation of Cards
        // Comparing cards Value and Color
       if(deck.getValue(0)==deck.getValue(1) &&
          deck.getColor(0).equals(deck.getColor(1)))
           System.out.println("V/C: True");
       else
           System.out.println("V/C: False");

       // Comparing Card Value
        if(deck.getValue(0)==deck.getValue(1))
            System.out.println("V: True");
        else
            System.out.println("V: False");


       //Compare Card Color
        if( deck.getColor(0).equals(deck.getColor(1)))
            System.out.println("C: True");
        else
            System.out.println("C: False");

    }
}

