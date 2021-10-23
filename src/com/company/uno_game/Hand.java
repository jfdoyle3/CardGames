package com.company.uno_game;

import com.company.actors.Player;
import com.company.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int bet = 0;
    private Player player;

    public Hand(Player player){
        this.player=player;
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

    public String displayHandFaceDown() {
        StringBuilder output = new StringBuilder();
        for (Card card : cards) {
            output.append(card.faceDown()).append(" ");
        }
        return output.toString();
    }
    public String getName(){
        return player.getName();
    }

    public Card getCard(int index) {
        return cards.get(index);
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

    public int getHandSize(){
        return cards.size();
    }

}
