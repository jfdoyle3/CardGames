package com.company;

import com.company.card.AltCard;
import com.company.deck.UnoColor;
import com.company.deck.UnoDeck;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        List<AltCard> hand=new ArrayList<>();
        UnoDeck deck = new UnoDeck();
        System.out.println(deck);
        deck.shuffle();
        for(int idx=0; idx<7; idx++)
            hand.add(deck.unoDraw());


        System.out.println(hand);





        String line = "\n";
        System.out.println(line.repeat(12));
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

