package com.company.uno_game;

import com.company.card.Card;
import com.company.console.Input;
import com.company.deck.UnoDeck;

public class Table {

    public void playGame() {
        Hand hand=new Hand();
        UnoDeck deck = new UnoDeck();
        deck.shuffle();
        for(int crd=0; crd<7; crd++) {
            hand.addCard(deck.unoDraw());
        }
        while(true) {
            System.out.println(hand.displayHand());
            int card = Input.getInt("pick a card", 0, hand.getHandSize()-1, "enter a number.");
            Card discard=hand.removeCard(card);
            System.out.println("Card Chosen: "+discard.display());
            if (hand.getHandSize() == 0)
                break;
        }
        System.out.println("ran out of cards");
    }


}
