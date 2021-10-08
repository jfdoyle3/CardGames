package com.company.card;

public abstract class Card {
    protected boolean faceUpDown;
    protected String cardFace;


    public Card(String cardFace) {
        this.faceUpDown = false;
        this.cardFace = cardFace;
    }

    public void flip() {
        faceUpDown = !faceUpDown;
    }

    public String getCardFace() {
        if (this.faceUpDown)
            return this.cardFace;
        return "[#]";
    }


    @Override
    public String toString() {
        return "Card{ faceUpDown: " + faceUpDown + ", cardFace: '" + cardFace + " }";
    }
}

