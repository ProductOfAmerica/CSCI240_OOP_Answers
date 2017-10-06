package Project9;/*
 * Copyright Clint Staley 2015
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Thermometer {
    private int degrees;
    private LinkedList<Person> listeners;

    public Thermometer() {
        listeners = new LinkedList<>();
    }

    public void addPerson(Person prs) {
        listeners.add(prs);
    }

    public void setDegrees(int val) {
        if(degrees != val)
            for(Person p : listeners){
                p.update(val);
            }
        degrees = val;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Thermometer thm = new Thermometer();
        Person p1 = new Person("George", in.nextInt(), in.nextInt());
        Person p2 = new Person("Sue", in.nextInt(), in.nextInt());
        Person p3 = new Person("Bill", in.nextInt(), in.nextInt());
        Person p4 = new Person("Sally", in.nextInt(), in.nextInt());
        int temp;

        p1.register(thm);
        p2.register(thm);
        p3.register(thm);
        // Don't register Sally

        while (in.hasNextInt()) {
            temp = in.nextInt();
            System.out.printf("\nSetting %d\n", temp);
            thm.setDegrees(temp);
        }
    }
}