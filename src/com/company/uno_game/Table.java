package com.company.uno_game;

import com.company.actors.Player;
import com.company.card.Card;
import com.company.ui.Console;
import com.company.ui.Input;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;

import java.util.ArrayList;
import java.util.List;


public class Table {

    /*
       discard deck:
       build a new deck
       list Card
       LinkedList Card

     */
    private List<Card> discardPile = new ArrayList<>();
    private List<Hand> players = new ArrayList<>();
    private int card;
    private Card firstCard;

    public void playGame() {
        //Add Players
        players.add(new Hand(new Player("Player 1")));
    //    players.add(new Hand(new Player("Player 2")));
     //   Hand hand = new Hand(new Player("Player 1"));
        Hand hand=players.get(0);
        // Create Deck / Shuffle
        UnoDeck deck = new UnoDeck(10);
        deck.shuffle();


        //
           for (int idx = 0; idx < players.size(); idx++) {
               dealHand(players.get(idx), deck, 4);
               //        Hand hand = new Hand(new Player("Player 1"));
           }

        firstCard = deck.unoDraw();
        discardPile.add(firstCard);
        Console.displayTable(0, players.get(0), deck, discardPile, players);
      //  System.out.println("\n");
     //   Console.displayTable(1, players.get(1), deck, discardPile, players);
        gameTurn(hand, deck);
        //  }
    }

    private void gameTurn(Hand hand, UnoDeck deck) {

        while (true) {

            // Display Hand
            Console.displayTable(0, hand, deck, discardPile, players);

            // Pick Card by Index
            int min = 0;
            int max = hand.getHandSize() - 1;

            // Menu Prompt
            menuPrompt(hand, deck, min, max);

            //   Empty Hand breaks Loop
            if (hand.getHandSize() == 0 || deck.isDeckEmpty())
                break;
        }
        if(deck.isDeckEmpty()) {
            System.out.println("deck ran out of cards");
            Deck newDeck=restackDeck();
        }
        System.out.println("end of line.");
    }

    private Deck restackDeck() {
        Card topCard=discardPile.remove(discardPile.size()-1);
        Deck newDeck=new UnoDeck(discardPile);
        newDeck.shuffle();
        discardPile.clear();
        discardPile.add(topCard);
        return newDeck;
    }

    private void menuPrompt(Hand hand, UnoDeck deck, int min, int max) {
        int menu = Input.getInt("1. play\n2. draw", 0, 3, "enter a number.");
        switch (menu) {
            case 0 -> System.exit(0);
            case 1 -> {
                // Play Card
                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                playCard(hand);
            }
            case 2 -> hand.addCard(deck.unoDraw());
            case 3 -> Console.displayDiscardPile(discardPile);
            default -> System.out.println("Error!!");
        }
    }

    private void playCard(Hand hand) {
        Card playedCard = hand.getCard(card);
        Card pile = discardPile.get(discardPile.size() - 1);

       // if (validateCardColor(playedCard, pile) || validateCardValue(playedCard, pile)) {
            discardPile.add(playedCard);
            hand.removeCard(card);
       // }
      //  System.out.println("Can't Play card.");
    }


    private void dealHand(Hand hand, UnoDeck deck, int handCount) {
        for (int crd = 0; crd < handCount; crd++) {
            hand.addCard(deck.unoDraw());
        }
    }

    private boolean validateCardColor(Card cardA, Card cardB) {
        return cardA.getSuit().equals(cardB.getSuit());
    }

    private boolean validateCardValue(Card cardA, Card cardB) {
        return cardA.getRank() == cardB.getRank();
    }

    private static void validateCard(Card card) {
        if (card.getRank() == card.getRank() &&
                card.getSuit().equals(card.getSuit()))
            System.out.println("V/C: True");
        else
            System.out.println("V/C: False");
    }
}
