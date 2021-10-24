package com.company.ui;


import com.company.card.Card;
import com.company.deck.UnoColor;
import com.company.uno_game.Hand;


import java.util.List;
import java.util.Queue;

public class Console {

    private static final String BREAK_LINE="-";

    public static void displayDiscardPile(List<Card> discardPile) {
        String line = "-|-";
        System.out.println(line.repeat(4) + "| Discard Pile |" + line.repeat(4));
        for (Card card : discardPile)
            System.out.println(card.display());
        System.out.println(line.repeat(13));
    }

    public static void showTable(Queue<Hand> players) {
        //TODO: Displays Players hands/Table need to not end turn
        System.out.println(BREAK_LINE.repeat(25));
        // Iterator iterator = players.iterator();
        // while (iterator.hasNext()) {
        //     hand = (Hand) iterator.next();
        for (Hand hand: players) {

            // Player's Names
            System.out.print(UnoColor.CYAN_BOLD);
            System.out.print(hand.getName() + ": ");
            System.out.print(UnoColor.RESET);

            // Player's cards face down
            System.out.print(UnoColor.BLUE);
            System.out.print(hand.displayHandFaceDown());
            System.out.print(UnoColor.RESET);
            System.out.println("\n"+BREAK_LINE.repeat(25));
        }
    }
}
