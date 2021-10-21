package com.company;

import java.util.*;

public class itrList {
    private static List<Integer> intList = new ArrayList<>();

    public static void itrThruList() {

        populateList(10);
        display();
        itrOmniWrap();
    }

    private static void display() {
        System.out.println(intList);
    }

    private static void populateList(int entries) {
        for (int idx = 0; idx < entries; idx++)
            intList.add(idx);
    }

    private static void itrRev() {
        ListIterator li = intList.listIterator(intList.size());
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }

    private static void itrFwd() {
        ListIterator li = intList.listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }

    private static void itrFromFwd(int idx) {
        ListIterator li = intList.listIterator(idx);
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }

    private static void itrFromRev(int idx) {
        ListIterator li = intList.listIterator(idx);
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }

    private static void itrFwdRev() {
        itrFwd();

        itrRev();

    }

    private static void itrWrap() {
        int counterForward = 0;
        int counterPrevious = 0;
        int runLoop = 1;
        ListIterator li = intList.listIterator();
        switch (runLoop) {
            case 0 -> {
                while (li.hasNext()) {
                    if (counterForward == intList.size() * 2)
                        break;
                    System.out.println(li.next());
                    if (li.nextIndex() == 8)
                        li.next();

                    if (!li.hasNext())
                        li = intList.listIterator(0);
                    counterForward++;
                }
            }
            case 1 -> {
                li = intList.listIterator(intList.size());
                while (li.hasPrevious()) {
                    if (counterPrevious == intList.size() * 2)
                        break;
                    System.out.println(li.previous());
                    if (li.previousIndex() == 8)
                        li.previous();

                    if (!li.hasPrevious())
                        li = intList.listIterator(intList.size());
                    counterPrevious++;
                }
            }
        }
    }

    private static void itrOmniWrap() {
        int counterForward = 0;
        int counterPrevious = 0;
        int runLoop = 1;
        ListIterator li = intList.listIterator();
        switch (runLoop) {
            case 0 -> {
                while (li.hasNext()) {
                    if (counterForward == intList.size() * 2)
                        break;
                    System.out.println(li.next());
                    if (li.nextIndex() == 8)
                        li.next();

                    if (!li.hasNext())
                        li = intList.listIterator(0);
                    counterForward++;
                }
            }
            case 1 -> {
                li = intList.listIterator(intList.size());
                int index = revList();
                System.out.println("Player "+index+" is next");
            }
        }
    }

    private static int revList() {
        Random reverseCard = new Random();
     //   Random skipCard = new Random();

        int index = 0;
        int counterPrevious = 0;
        ListIterator li;
        li = intList.listIterator(intList.size());
        while (li.hasPrevious()) {

            if (counterPrevious == intList.size() * 2)
                break;

            if (reverseCard.nextBoolean()) {
                System.out.println(li.previous()+" played a reverse card.");
                li.next();
                if (!li.hasNext())
                    li = intList.listIterator(0);
                index = li.nextIndex();
                break;
            }

//            if (skipCard.nextBoolean()) {
//                li.previous();
//            }

            System.out.println(li.previous());
//                if (li.previousIndex() == 8)
//                    li.previous();

            if (!li.hasPrevious())
                li = intList.listIterator(intList.size());
            counterPrevious++;
        }
        return index;
    }
}
