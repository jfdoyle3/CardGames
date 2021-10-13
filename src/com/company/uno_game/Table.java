package com.company.uno_game;

import com.company.card.Card;
import com.company.console.Input;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;

import java.util.List;



public class Table {

    /*
       discard deck:
       build a new deck
       list Card
       LinkedList Card

     */
     private int card;

    public void playGame() {
        Hand hand=new Hand();
        UnoDeck deck = new UnoDeck(10);
        System.out.println(deck.toString());
        deck.shuffle();

        dealHand(hand, deck, 7);

        while(true) {
            System.out.println(hand.displayHand());
            int min =0;
            int max=hand.getHandSize()-1;

            int menu = Input.getInt("1. play\n2. draw", 1 ,2,"enter a number.");
            if(menu==1) {
                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                Card discard = hand.removeCard(card);

            } else{
                hand.addCard(deck.unoDraw());
            }
            if (hand.getHandSize() == 0)
                break;
        }
        System.out.println("ran out of cards");
    }

    private void dealHand(Hand hand, UnoDeck deck, int handCount) {
        for(int crd=0; crd<handCount; crd++) {
            hand.addCard(deck.unoDraw());
        }
    }


}
