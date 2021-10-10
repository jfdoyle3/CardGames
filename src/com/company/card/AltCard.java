package com.company.card;

import com.company.deck.UnoColor;

public abstract class AltCard {

    protected int rank;
    protected String suit;
    protected boolean isFaceDown = true;

    public AltCard(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public boolean getIsFaceDown() {
        return isFaceDown;
    }

    public abstract String display();

    public void flip() {
        isFaceDown = !isFaceDown;
    }


    public String getCardFace() {
//        if (this.isFaceDown)
//            return this.cardFace;
        return "[#]";
    }
}