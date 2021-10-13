package com.company.uno_game;

import com.company.card.Card;
import com.company.console.Input;
import com.company.deck.UnoDeck;

public class Table {
     private int card;
    public void playGame() {
        Hand hand=new Hand();
        UnoDeck deck = new UnoDeck();
        deck.shuffle();
        for(int crd=0; crd<7; crd++) {
            hand.addCard(deck.unoDraw());
        }
        while(true) {
            System.out.println(hand.displayHand());
            int min =0;
            int max=hand.getHandSize()-1;
            System.out.println();
            int menu = Input.getInt("1. play\n2.draw", 1 ,2,"enter a number.");
            if(menu==1) {
                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                Card discard = hand.removeCard(card);
                System.out.println("Card Chosen: " + discard.display());
            } else{
                hand.addCard(deck.unoDraw());
            }
            if (hand.getHandSize() == 0)
                break;
        }
        System.out.println("ran out of cards");
    }


}
