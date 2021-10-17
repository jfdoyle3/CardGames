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
     //   System.out.println("Display Method");
        StringBuilder cardOutput=new StringBuilder();
        if(rank==10)
            cardOutput.append(suit).append("D2").append(UnoColor.RESET);
        else
            cardOutput.append(suit).append(rank).append(UnoColor.RESET);

        return  cardOutput.toString();

    }

    @Override
    public void flip() {

    }

    @Override
    public String toString() {
        StringBuilder cardOutput=new StringBuilder();
       // cardOutput.append("toString: ").append(suit).append(rank).append(UnoColor.RESET);
        cardOutput.append(suit).append(rank).append(UnoColor.RESET);
        return  cardOutput.toString();
               // color+UnoColor.RESET;
    }

}

