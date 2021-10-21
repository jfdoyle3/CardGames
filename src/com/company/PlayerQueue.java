package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PlayerQueue {


    private static Queue<Integer> players= new LinkedList<>();
    public static void main(String args[])
    {
        populateQueue(4);
        display();


        //Game Loop need while(true) loop
        for(int i=0; i<3; i++)
            qFwd();
        // players turn
        // skip cars use qfwd();
        // reverse replace currebt queue


        display();
        System.out.println("Reverse Card Played");
        reverse(players);
        display();
        for(int i=0; i<4; i++)
            qFwd();
        display();

    }
    private static void populateQueue(int amount){
        for (int nums=0; nums<=amount; nums++)
            players.add(nums);
    }

    private static void display(){
        System.out.println(players);
    }

    private static void qFwd(){
        int playerNum=players.poll();
        System.out.println("Player "+playerNum);
        players.add(playerNum);
    }

    private static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();  //create a stack

        //while the queue is not empty
        while(!q.isEmpty())
        {  //add the elements of the queue onto a stack
            s.push(q.poll());
        }

        //while the stack is not empty
        while(!s.isEmpty())
        { //add the elements in the stack back to the queue
            q.add(s.pop());
        }

    }
}