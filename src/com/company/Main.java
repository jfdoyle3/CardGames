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
       if(deck.getCard(0)==deck.getCard(1))
           System.out.println("True");
       else
           System.out.println("False");

    }
}

