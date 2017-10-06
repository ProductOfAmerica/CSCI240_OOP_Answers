package Project8;/*
 * Copyright Clint Staley 2015
 */

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Person {
    private String first;
    private String last;

    private static List<Person> roster = new LinkedList<>();


    public Person(String first, String last) {
        this.first = first;
        this.last = last;
        roster.add(this);
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return first + " " + last;
    }


    public static void printPeople(){
        for(Iterator<Person> itr = roster.iterator(); itr.hasNext();){
            System.out.println(itr.next().toString());
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            new Person(in.next(), in.next());
        }

        printPeople();
    }
}