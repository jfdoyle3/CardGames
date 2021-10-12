package com.company.uno_game;


import com.company.card.Card;
import com.company.card.UnoCard;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int bet = 0;

    private String holder;
    

    public Hand(String holder) {
        this.holder = holder;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String displayHand() {
        StringBuilder output = new StringBuilder();
        for (Card card : cards) {
            output.append(card.display()).append(" ");
        }

        return output.toString().trim();
    }





    // removeCard method
    public Card removeCard(int index) {
        // take card at index out of hand and return to table.
        return cards.remove(index);
    }


    public void revealHand() {
        for (Card card : cards) {
            if (card.getIsFaceDown()) {
                card.flip();
            }
        }
    }

    public void discardHand() {
        cards.clear();
    }

    public int getShownRank() {
        return cards.get(1).getRank();
    }

}
