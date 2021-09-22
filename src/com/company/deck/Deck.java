package com.company.deck;

import com.company.card.Card;

public interface Deck {
    void shuffle();

    Card draw(boolean facing);

    boolean deckEmpty();
}
