package com.company.deck;

import com.company.card.Card;
import com.company.card.UnoCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnoDeck implements Deck{


    private final static UnoColor[] COLORS = {UnoColor.RED_BOLD_BRIGHT,UnoColor.GREEN_BOLD_BRIGHT,UnoColor.BLUE_BOLD_BRIGHT,UnoColor.YELLOW_BOLD_BRIGHT};
    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 4 colors of each 2 per color,   Zero Card: 4 colors 1 per color = 76 cards
    private final static int[] ACTIONS={10,11,12}; // 10 = Draw 2, 11 = Reverse, 12 = Skip - 4 of each 2 per color = 24 cards
    private final static int WILD_RANK=13;// 4 Wild Cards  / ( 4  4+ Wild ) not used- extra challenge = 8 cards
    private final static UnoColor[] WILD_COLOR={UnoColor.WILD};
    private List<Card> cards;


    public UnoDeck() {

        cards = new ArrayList<>();
        for (UnoColor color : COLORS) {
            for (int value : VALUES) {
                cards.add(new UnoCard(value, color.toString()));
                cards.add(new UnoCard(value, color.toString()));
            }
            cards.add(new UnoCard(0, color.toString()));
        //    cards.add(new UnoCard(WILD_RANK,UnoColor.WILD.toString()));
        }
    }
//        for (int idx=0; idx<12; idx++) {
//            for (UnoColor color : COLORS) {
//                for (int value : ACTIONS)
//                    cards.add(new UnoCard(value, color));
//            }
//        }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public int getValue(int index){
        return getCard(index).getRank();
    }

    public String getColor(int index){
       return getCard(index).getSuit();
    }

    @Override
    public String toString() {
        return "UnoDeck: " +
                cards.toString();
    }
    public Card unoDraw(){
        return cards.remove(cards.size() - 1);
    }

    @Override
    public void shuffle() {Collections.shuffle(cards);}

    @Override
    public Card draw(boolean facing) {
        return null;
    }

    @Override
    public boolean isDeckEmpty() {
        if(cards.size()==0)
            return true;
        return false;
    }
}