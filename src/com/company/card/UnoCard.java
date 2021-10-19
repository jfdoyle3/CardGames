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

        switch(rank) {
            case 10 -> cardOutput.append(suit).append("D2").append(UnoColor.RESET);
            case 11 -> cardOutput.append(suit).append("Reverse").append(UnoColor.RESET);
            case 12 -> cardOutput.append(suit).append("Skip").append(UnoColor.RESET);
            default->
                cardOutput.append(suit).append(rank).append(UnoColor.RESET);
        }
//
//        if(rank==10)
//
//

//        if(rank==11)
//       cardOutput.append(suit).append("Reverse").append(UnoColor.RESET);
//                else
//        cardOutput.append(suit).append(rank).append(UnoColor.RESET);

//        if(rank==12)
//            cardOutput.append(suit).append("Skip").append(UnoColor.RESET);


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

