package Project20;/*
 * Copyright Clint Staley 2015
 */

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class ReverseSortStrings {
    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeSet <Integer>treeadd = new TreeSet<Integer>();
        SortedSet<String> strs = new TreeSet<>();
        strs=(TreeSet)treeadd.descendingSet();

        while (in.hasNext())
            strs.add(in.next());

        for (String str: strs) {
            System.out.println(str);
        }
    }
}