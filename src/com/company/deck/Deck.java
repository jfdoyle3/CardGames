package com.company.deck;

import com.company.card.AltCard;

public interface Deck {
    void shuffle();

    AltCard draw(boolean facing);

    boolean deckEmpty();
}
