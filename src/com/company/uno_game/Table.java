package com.company.uno_game;

import com.company.deck.UnoDeck;

public class Table {

    public void playGame() {
        Hand hand=new Hand();
        UnoDeck deck = new UnoDeck();
        System.out.println(deck);
        deck.shuffle();
        hand.addCard(deck.unoDraw());
        System.out.println(deck.getCard(0).display());
    }
}
