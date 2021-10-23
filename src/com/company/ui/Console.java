package com.company.ui;


import com.company.card.Card;


import java.util.List;

public class Console {

    private static final String BREAK_LINE="-";

    public static void displayDiscardPile(List<Card> discardPile) {
        String line = "-|-";
        System.out.println(line.repeat(4) + "| Discard Pile |" + line.repeat(4));
        for (Card card : discardPile)
            System.out.println(card.display());
        System.out.println(line.repeat(13));
    }
}
