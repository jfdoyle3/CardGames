package com.company.card;

import com.company.deck.UnoColor;

public abstract class AltCard {

    protected int rank;
    protected UnoColor suit;
    protected boolean isFaceDown = true;

    public AltCard(int rank, UnoColor suit) {
        this.rank = rank;
        this.suit = suit;
    }




    public int getRank() {return rank;}
    public UnoColor getSuit() {return suit;}
    public boolean getIsFaceDown() {return isFaceDown;}
    public abstract String display();

    public void flip() {
        isFaceDown = !isFaceDown;
    }
}
