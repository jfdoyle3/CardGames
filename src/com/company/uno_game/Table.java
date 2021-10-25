package com.company.uno_game;

import com.company.actors.Player;
import com.company.card.Card;
import com.company.card.UnoCard;
import com.company.deck.UnoColor;
import com.company.ui.Console;
import com.company.ui.Input;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;

import java.util.*;


public class Table {

    private final List<Card> discardPile = new ArrayList<>();
    private Queue<Hand> players = new LinkedList<>();
    private final static UnoColor[] COLORS = {UnoColor.RED_BOLD_BRIGHT, UnoColor.GREEN_BOLD_BRIGHT, UnoColor.BLUE_BOLD_BRIGHT, UnoColor.YELLOW_BOLD_BRIGHT};
    private int card;
    private Hand hand;
    private final String BREAK_LINE = "-";
    private boolean actionCardPlayed=false;


    public void playGame() {
        // *********************
        //Add Players
        // int playerCount = Input.getInt("How many players? 2-10", 2, 10, "Error");
        int playerCount = 21;
        for (int idx = 1; idx <= playerCount; idx++) {
            players.add(new Hand(new Player("Player " + idx)));

        }
        //*************************
        // Create Deck / Shuffle
        UnoDeck deck = new UnoDeck();
        deck.shuffle();

        // *************************
        //   Deal
        deal(playerCount, deck);
        Card firstCard = deck.unoDraw();
        int firstCardValue=firstCard.getRank();
        while(firstCardValue >=10){
               deck.shuffle();
            firstCard = deck.unoDraw();
           }
        discardPile.add(firstCard);


        /* ========================
           Start of Game Loop
         *  Check for empty deck - re-stack if is.
         *    hand=poll()   -  get player hand
         *    player chooses to play / draw - refactor
               input:menu
               play / draw ends turn
               play: plays card
               draw: add card to hand
         *    hand.add(Queue)
          *     end turn
          Game has to check for these cards at end of turn:
             Check discard Pile after turn.
                draw 2:   poll(), add cards , add() / itr: next(), add cards, add()
                skip:     poll, add() / itr: next(), add()
                reverse : call reverse method to reverse Queue

                wild:     during play, color menu
                wild +4:  poll(), add cards, add() / itr: next(), add cards, add()

             ==========================================

        */
        while (true) {

            // Check for empty Deck
            deck = getUnoDeck(deck);


            // Get Player
            hand = players.poll();

            // Console display
            System.out.print("Deck: |" + deck.deckSize() + "| |");

            if (discardPile.size() > 0) {
                System.out.println(discardPile.get(discardPile.size() - 1).display() + "| :Discard Pile");
            } else {
                System.out.println("empty| :Discard Pile");
            }
            System.out.print(UnoColor.CYAN_BOLD);
            System.out.print(hand.getName());
            System.out.print(UnoColor.RESET+"\n");
            System.out.println(hand.displayHand());
            for (int idx = 0; idx < hand.getHandSize(); idx++)
                System.out.print(idx + "\t");

            System.out.println();


            // UI: player turn - menu input
            int min = 0;
            int max = hand.getHandSize() - 1;
            int menu = Input.getInt("1. Play a card\n2. draw a card\n3. Display table", 0, 4, "enter a number.");
            switch (menu) {
                case 0:
                    System.exit(0);
                case 1: {
                    actionCardPlayed=true;
                    // Play Card
                    card = Input.getInt("If you don't have a card to play\npick any card and a card will be drawn.\npick a card " + min + " thru " + max,
                            min,
                            max,
                            "enter a number.");

                    Card playedCard = hand.getCard(card);
                    Card pile = discardPile.get(discardPile.size() - 1);
                    if (validateCardColor(playedCard, pile) || validateCardValue(playedCard, pile) || playedCard.getRank()>=13) {
                        discardPile.add(playedCard);
                        hand.removeCard(card);
                        break;
                    }
                    System.out.println("not a playable card - Drawing a card.");
                }
                case 2: {
                    actionCardPlayed=false;
                    hand.addCard(deck.unoDraw());
                    break;
                }
                case 3: {
                    Console.showTable(players);
                    break;
                }
                case 4:{
                    simpleItr();
                    break;
                }
                default: {
                    System.out.println("Error!!");
                    break;
                }
            }
            if (hand.getHandSize()==1){
                actionCardMessage(hand.getName()," UNO!!");
            }
            if(hand.getHandSize()==0){
                actionCardMessage(hand.getName()," WINS!!!");
                System.exit(0);
            }

            players.add(hand);
            // player made a choice
            // end turn
            int card;
            // Card played evaluation for Action/Wild card
            // Get Card value for Action Cards played
            if(actionCardPlayed)
                card = cardPlayed().getRank();
            else
                card=9;



            //Action cards
            switch (card){
                case 10 -> {
                    hand=players.poll();
                    actionCardMessage(hand.getName(), " Drew 2 Cards.");
                    hand.addCard(deck.unoDraw());
                    hand.addCard(deck.unoDraw());
                    players.add(hand);

                }
                case 11 -> {
                    players = reverse(players);
                    hand = players.poll();
                    actionCardMessage(">>--->"," Reverse");
                    players.add(hand);

                }
                case 12 -> {
                    hand=players.poll();
                    actionCardMessage(hand.getName()+"'s", " turn is Skipped");
                    players.add(hand);

                }
                case 13 ->{
                    int colorChoice=Input.getInt("Choose Color:\n1. Red\n2. Green\n3. Blue\n4. Yellow",1,4,"error");
                    Card dupeCard=new UnoCard(13, COLORS[colorChoice-1].toString());
                    discardPile.set(discardPile.size()-1,dupeCard);
                }
                case 14 ->{
                    int colorChoice=Input.getInt("Choose Color:\n1. Red\n2. Green\n3. Blue\n4. Yellow",1,4,"error");
                    Card dupeCard=new UnoCard(14, COLORS[colorChoice-1].toString());
                    discardPile.set(discardPile.size()-1,dupeCard);
                    hand=players.poll();
                    actionCardMessage(hand.getName(), " Drew 4 Cards.");
                    for(card=1; card<=4; card++)
                     hand.addCard(deck.unoDraw());

                    players.add(hand);

                }
                default -> {
                    System.out.println();
                }
            }

        }
    }

    private void actionCardMessage(String name, String s) {
        System.out.print(UnoColor.CYAN_BOLD);
        System.out.print(name);
        System.out.print(UnoColor.RESET);
        System.out.print(UnoColor.RED_BOLD);
        System.out.print(s);
        System.out.print(UnoColor.RESET + "\n");
    }

//    private void showTable() {
//        //TODO: Displays Players hands/Table need to not end turn
//        System.out.println(BREAK_LINE.repeat(25));
//        // Iterator iterator = players.iterator();
//        // while (iterator.hasNext()) {
//        //     hand = (Hand) iterator.next();
//        for (Hand hand: players) {
//
//            // Player's Names
//            System.out.print(UnoColor.CYAN_BOLD);
//            System.out.print(hand.getName() + ": ");
//            System.out.print(UnoColor.RESET);
//
//            // Player's cards face down
//            System.out.print(UnoColor.BLUE);
//            System.out.print(hand.displayHandFaceDown());
//            System.out.print(UnoColor.RESET);
//            System.out.println("\n"+BREAK_LINE.repeat(25));
//        }
//    }

    private void simpleItr(){
        for (Hand item: players) {
            System.out.println(item.getName());
        }
    }

    private UnoDeck getUnoDeck(UnoDeck deck) {
        if (deck.isDeckEmpty()) {
            Deck newDeck = restackDeck();
            deck = (UnoDeck) newDeck;
        }
        return deck;
    }


    private Queue reverse(Queue<Hand> q) {
        Stack<Hand> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.poll());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        return q;
    }


    private Card cardPlayed() {
        Card card = discardPile.get(discardPile.size() - 1);
        return card;
    }

    private void itrPlayers() {
        Iterator iterator = players.iterator();
        while (iterator.hasNext()) {
            hand = (Hand) iterator.next();
            System.out.println(hand.getName() + " " + hand.displayHand());
        }
    }

    private void deal(int playerCount, UnoDeck deck) {
        int UNO_HAND = 7;
        for (int card = 0; card < playerCount * UNO_HAND; card++) {
            hand = players.poll();
            hand.addCard(deck.unoDraw());
            players.add(hand);
        }
    }



    private Deck restackDeck() {
        Card topCard = discardPile.remove(discardPile.size() - 1);
        Deck newDeck = new UnoDeck(discardPile);
        newDeck.shuffle();
        discardPile.clear();
        discardPile.add(topCard);
        return newDeck;
    }


    private boolean validateCardColor(Card cardA, Card cardB) {
        return cardA.getSuit().equals(cardB.getSuit());
    }

    private boolean validateCardValue(Card cardA, Card cardB) {
        return cardA.getRank() == cardB.getRank();
    }
}
