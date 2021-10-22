package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PlayerQueue {


    private static Queue<Integer> players= new LinkedList<>();
    private static String line="-|-";
    public static void main(String args[])
    {
        populateQueue(3);
        display();


        //Game Loop need while(true) loop
        for(int i=0; i<3; i++)
            qFwd();
        // players turn
        // skip cards use qFwd();
        // reverse replace current queue

        display();
        System.out.println("\n"+line.repeat(6));
        System.out.println("Reverse Card Played");
        System.out.println(line.repeat(6));
        reverse(players);
        display();
        for(int i=0; i<2; i++)
            qFwd();
        display();

    }
    private static void populateQueue(int amount){
        for (int nums=0; nums<=amount; nums++)
            players.add(nums);
    }

    private static void display(){
        System.out.print("Player Queue: ");
        System.out.print(players+"\n");
    }

    private static void qFwd(){
        int playerNum=players.poll();
        System.out.println("Player "+playerNum+" take their turn");
        players.add(playerNum);
    }

    private static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.poll());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }
}