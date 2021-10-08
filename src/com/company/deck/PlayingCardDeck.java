package com.company.deck;


import com.company.card.AltCard;
import com.company.card.PlayingCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCardDeck implements Deck {

    private final static UnoColor[] SUITS = {UnoColor.SPADES, UnoColor.HEARTS,UnoColor.CLUBS, UnoColor.DIAMONDS };
    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 13};
    private List<AltCard> altCards;
    private boolean isEmpty=false;

    public PlayingCardDeck() {
        altCards = new ArrayList<>();
        for (var suit : SUITS) {
            for (var value : VALUES) {
                altCards.add(new PlayingCard(value, suit));
            }
        }
    }


    public void shuffle() {
        Collections.shuffle(altCards);
    }


    public AltCard draw(boolean facing) {
        AltCard altCard = altCards.remove(altCards.size() - 1);
        if (facing) altCard.flip();
        return altCard;
    }


    public boolean deckEmpty() {
        return altCards.size() == 0;
    }

    public String toString() {
        return "Deck [cards=" + altCards.toString() + "]";
    }

}
