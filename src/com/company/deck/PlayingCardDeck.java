package com.company.deck;


import com.company.card.Card;
import com.company.card.Color;
import com.company.card.PlayingCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCardDeck implements Deck {

    private final static UnoColor[] SUITS = {UnoColor.SPADES, UnoColor.HEARTS,UnoColor.CLUBS, UnoColor.DIAMONDS };
    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 13};
    private List<Card> cards;
    private boolean isEmpty=false;

    public PlayingCardDeck() {
        cards = new ArrayList<>();
        for (var suit : SUITS) {
            for (var value : VALUES) {
                cards.add(new PlayingCard(value, suit));
            }
        }
    }


    public void shuffle() {
        Collections.shuffle(cards);
    }


    public Card draw(boolean facing) {
        Card card = cards.remove(cards.size() - 1);
        if (facing) card.flip();
        return card;
    }


    public boolean deckEmpty() {
        return cards.size() == 0;
    }

    public String toString() {
        return "Deck [cards=" + cards.toString() + "]";
    }

}