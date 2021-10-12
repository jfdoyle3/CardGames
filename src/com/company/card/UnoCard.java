package com.company.card;

import com.company.deck.UnoColor;

public class UnoCard extends Card {



    public UnoCard(int rank, String suit) {
        super(rank, suit);
    }




    // Abstract method for getters on Value/Rank , Color/Suit????

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

    }

//    @Override
//    public String toString() {
//        StringBuilder cardOutput=new StringBuilder();
//        cardOutput.append(suit).append(rank).append(UnoColor.RESET);
//        return  cardOutput.toString();
//               // color+UnoColor.RESET;
//    }

}

