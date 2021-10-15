package com.company;

import com.company.card.Card;
import com.company.ui.Input;
import com.company.deck.UnoDeck;

import java.util.ArrayList;
import java.util.List;

public class WorkingMain {


    public static void main(String[] args) {


        List<Card> hand=new ArrayList<>();

        UnoDeck deck = new UnoDeck();
        System.out.println(deck);
        deck.shuffle();
        for(int idx=0; idx<7; idx++)
            hand.add(deck.unoDraw());

        while(true) {
            System.out.println(hand);
            int card = Input.getInt("pick a card", 0, hand.size()-1, "enter a number.");
            Card held=hand.get(card);
            System.out.println("Card Chosen: "+held.display());
            Card discard=hand.remove(card);
//            validateCardColor(held, discard);
            if (hand.size() == 0)
                break;
        }
        System.out.println("ran out of cards");
        System.out.println("Card Validation: V= Value / C= Color");
        // Validation of Cards
        // Comparing cards Value and Color
     //   validateCard(carda, cardb);

        // Comparing Card Value
      //  validateCardValue(card);


        //Compare Card Color


    }

    private static void validateCardColor(Card cardA, Card cardB) {
        if( cardA.getSuit().equals(cardB.getSuit()))
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
//
//    private static void validateCard(Card card) {
//        if(card.getValue()== card.getValue() &&
//           card.getColor().equals(card.getColor()))
//            System.out.println("V/C: True");
//        else
//            System.out.println("V/C: False");
//    }


}

