package com.company;

import com.company.deck.UnoColor;
import com.company.deck.UnoDeck;

public class Main {


    public static void main(String[] args) {

        UnoDeck deck = new UnoDeck();
        System.out.println(deck);
        String line = "-|-";
        System.out.println(line.repeat(6));
        System.out.println(UnoColor.HEARTS+" "+UnoColor.SPADES+" "+UnoColor.CLUBS+" "+UnoColor.DIAMONDS);
        System.out.println(UnoColor.WILD);
        System.out.println(deck.getCard(20));
        System.out.println(line.repeat(6));

        // Validation of Cards
        // Comparing cards Value and Color
        validateCard(deck);

        // Comparing Card Value
        validateCardValue(deck);


        //Compare Card Color
        validateCardColor(deck);

    }

    private static void validateCardColor(UnoDeck deck) {
        if( deck.getColor(0).equals(deck.getColor(1)))
            System.out.println("C: True");
        else
            System.out.println("C: False");
    }

    private static void validateCardValue(UnoDeck deck) {
        if(deck.getValue(0)== deck.getValue(1))
            System.out.println("V: True");
        else
            System.out.println("V: False");
    }

    private static void validateCard(UnoDeck deck) {
        if(deck.getValue(0)== deck.getValue(1) &&
           deck.getColor(0).equals(deck.getColor(1)))
            System.out.println("V/C: True");
        else
            System.out.println("V/C: False");
    }
}

