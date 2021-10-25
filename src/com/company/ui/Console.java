package com.company.ui;


import com.company.card.Card;
import com.company.deck.UnoColor;
import com.company.deck.UnoDeck;
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

    public static void actionCardMessage(String name, String s) {
        System.out.print(UnoColor.CYAN_BOLD);
        System.out.print(name);
        System.out.print(UnoColor.RESET);
        System.out.print(UnoColor.RED_BOLD);
        System.out.print(s);
        System.out.print(UnoColor.RESET + "\n");
    }

    public static void displayPlayer(UnoDeck deck, List<Card> discardPile,Hand hand) {
        System.out.print("Deck: |" + deck.deckSize() + "| |");

        if (discardPile.size() > 0) {
            System.out.println(discardPile.get(discardPile.size() - 1).display() + "| :Discard Pile");
        } else {
            System.out.println("empty| :Discard Pile");
        }
        System.out.print(UnoColor.CYAN_BOLD);
        System.out.print(hand.getName());
        System.out.print(UnoColor.RESET + "\n");
        System.out.println(hand.displayHand());
        for (int idx = 0; idx < hand.getHandSize(); idx++)
            System.out.print(idx + "\t");

        System.out.println();
    }
}

