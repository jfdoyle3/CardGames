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

    private List<Card> discardPile = new ArrayList<>();
    private List<Hand> players = new ArrayList<>();
    private int card;
    private Card firstCard;
    private boolean isDraw2 = false;
    private boolean isSkip=false;


    public void playGame() {
        //Add Players
        players.add(new Hand(new Player("Player 1")));
        players.add(new Hand(new Player("Player 2")));

        // Create Deck / Shuffle
        UnoDeck deck = new UnoDeck();
        System.out.println(deck);
        deck.shuffle();

        for (Hand hand : players)
            dealHand(hand, deck, 7);

        firstCard = deck.unoDraw();
        discardPile.add(firstCard);

        while (true) {
            for (Hand hand : players) {
                if (deck.isDeckEmpty()) {
                  //  System.out.println("deck ran out of cards\nCreating a new deck!");
                    Deck newDeck = restackDeck();
                    deck = (UnoDeck) newDeck;
                }
                // Console.displayTable(hand, deck, discardPile);
                //turn ends game on empty hand
                if (hand.getHandSize() != 0)
                    gameTurn(hand, deck);
                else {
                    endGame(hand);
                    break;
                }
            }
        }

    }

    private void endGame(Hand hand) {
        System.out.println(hand.getName() + " Wins");
        System.exit(0);
    }


    private void gameTurn(Hand hand, UnoDeck deck) {

        //  while (true) {
        boolean end = false;
        // Display Hand
        int min = 0;
        int max = hand.getHandSize() - 1;
        Console.displayTable(hand, deck, discardPile);
//        switch (discardPile.get(discardPile.size()-1).getRank()){
//            case 10 -> {drawTwo(hand, deck);
//                        isDraw2=false;}
//            case 12 -> System.out.println("Skipped");
//            case 11 -> System.out.println("Reverse");
//            default -> menuPrompt(hand, deck, min, max);
//
//        }

        if(isDraw2){
            System.out.println("-->"+hand.getName()+" Hand: "+hand.getHandSize());
            drawTwo(hand,deck);
            System.out.println("--> +2 : "+hand.getHandSize());
            isDraw2=false;
        }
        else {

            // Pick Card by Index
//            int min = 0;
//            int max = hand.getHandSize() - 1;

            // Menu Prompt
            menuPrompt(hand, deck, min, max);
        }
//        if(isSkip){
//            isSkip=false;
//        }
//        else {
//
//            // Pick Card by Index
//            int min = 0;
//            int max = hand.getHandSize() - 1;
//
//            // Menu Prompt
//            menuPrompt(hand, deck, min, max);
//        }

        System.out.println("end of Turn");
    }

    private Deck restackDeck() {
        Card topCard = discardPile.remove(discardPile.size() - 1);
        Deck newDeck = new UnoDeck(discardPile);
        newDeck.shuffle();
        discardPile.clear();
        discardPile.add(topCard);
        return newDeck;
    }

    private void menuPrompt(Hand hand, UnoDeck deck, int min, int max) {
        int menu = Input.getInt("1. play\n2. draw", 0, 4, "enter a number.");
        switch (menu) {
            case 0 -> System.exit(0);
            case 1 -> {
                // Play Card
                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                playCard(hand, deck);
            }
            case 2 -> hand.addCard(deck.unoDraw());
            case 3 -> Console.displayDiscardPile(discardPile);
            case 4 -> {
                boolean end = true;
            }
            default -> System.out.println("Error!!");
        }
    }

    private void playCard(Hand hand, Deck deck) {

        Card playedCard = hand.getCard(card);
        Card pile = discardPile.get(discardPile.size() - 1);

        if (validateCardColor(playedCard, pile) || validateCardValue(playedCard, pile)) {
            discardPile.add(playedCard);
            hand.removeCard(card);

            if (playedCard.getRank() == 10) {
                isDraw2 = true;
            }
//        if (playedCard.getRank() == 10) {
//            isDraw2 = true;
//        }

        }
    }
       // System.out.println("Can't Play card.");



    private void drawTwo(Hand hand, Deck deck) {
        hand.addCard(deck.unoDraw());
        hand.addCard(deck.unoDraw());

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
