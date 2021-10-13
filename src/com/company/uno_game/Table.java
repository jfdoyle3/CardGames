package com.company.uno_game;

import com.company.card.Card;
import com.company.console.Input;
import com.company.deck.UnoDeck;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<Card> discardPile;

    public void playGame() {
        discardPile=new ArrayList<>();
        Hand hand = new Hand();
        UnoDeck deck = new UnoDeck();
       // System.out.println(deck);
        deck.shuffle();
        deal(hand, deck);
        playCard(hand);
        System.out.println("ran out of cards");
    }

    private void playCard(Hand hand) {

        while (true) {
            System.out.println(hand.displayHand());
            int min = 0;
            int max = hand.getHandSize() - 1;
            int card = Input.getInt("pick a card from " + min + " thru " + max, min, max, "enter a number.");
            Card discardCard = hand.removeCard(card);
            System.out.println("Card in Play: " + discardCard.display());
            Card cardInPlay=discardCard;
            discardPile.add(discardCard);
            if (hand.getHandSize() == 0)
                break;

            System.out.println("Discarded: ");
            showDiscardPile();
        }
    }

    private void showDiscardPile(){
        for(Card card : discardPile)
            System.out.println(card.display());
    }
    private void deal(Hand hand, UnoDeck deck) {
        for (int crd = 0; crd < 7; crd++) {
            hand.addCard(deck.unoDraw());
        }
    }
}
