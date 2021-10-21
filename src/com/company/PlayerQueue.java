package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerQueue {


    private static Queue<Integer> players = new LinkedList<>();

    public static void main(String args[]) {
        populateQueue(4);
        display();
        qFwd();

        // example();

        // poll the player
        // player takes turn
        // player added to queue
        // next player

    }

    private static void populateQueue(int amount) {
        for (int nums = 0; nums <= amount; nums++)
            players.add(nums);
    }

    private static void display() {
        System.out.println(players);
    }

    private static void qFwd() {
        //   int player=players.poll(){
        for (Integer player : players) {
            int playerNum = players.poll();
            System.out.println("Player " + playerNum);
            players.add(playerNum);
        }
    }
}