package com.company.card;

import com.company.deck.UnoColor;

public class UnoCard extends Card {



    public UnoCard(int rank, String suit) {
        super(rank, suit);
    }



//    public UnoCard(int value, UnoColor color) {
//        super(true);
//        this.value = value;
//        this.color = color;
//    }



    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String display() {
        StringBuilder cardOutput=new StringBuilder();
        cardOutput.append(suit).append(rank).append(UnoColor.RESET);
        return  cardOutput.toString();
    }

    @Override
    public void flip() {
        isFaceDown = !isFaceDown;
    }

//    @Override
//    public String toString() {
//        StringBuilder cardOutput=new StringBuilder();

//        cardOutput.append(color).append(value).append(UnoColor.RESET);

//        cardOutput.append(suit).append(rank).append(UnoColor.RESET);

//        return  cardOutput.toString();
//               // color+UnoColor.RESET;
//    }

}

