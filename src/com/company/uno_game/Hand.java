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
        return output.toString();
    }

    public String displayValue() {
        int score = 0;
        boolean haveAce11 = false;
        for (Card card : cards) {
            int value = card.getRank();
            switch (value) {
                case 1 -> {
                    value = score + 11 > 21 ? 1 : 11;
                    if (value == 11) {
                        haveAce11 = true;
                    }
                    score += value;
                }
                case 11, 12, 13 -> score += 10;
                default -> score += value;
            }
            if(score > 21 && haveAce11) {
                score -= 10;
                haveAce11 = false;
            }
        }

        return Integer.toString(score);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }



    // removeCard method
    public Card removeCard(int index) {
        // take card at index out of hand and return to table.
        return cards.remove(index);
    }



//    public void revealHand() {
//        for (Card card : cards) {
//            if (card.getIsFaceDown()) {
//                card.flip();
//            }
//        }
//    }

    public void discardHand() {
        cards.clear();
    }

    public int getShownRank() {
        return cards.get(1).getRank();
    }

    public int getHandSize(){
        return cards.size();
    }

}
