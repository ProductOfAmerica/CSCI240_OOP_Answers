package Project19;/*
 * Copyright Clint Staley 2015
 */

import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class CaseInsensitiveName {

    static public class CIName implements Comparable<CIName> {
        String name;

        CIName(String next) {
            name = next;
        }

        @Override
        public int compareTo(CIName o) {
            return name.compareToIgnoreCase(o.name);
        }
    }

    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SortedSet<CIName> names = new TreeSet<CIName>();

        while (in.hasNext())
            names.add(new CIName(in.next()));

        for (CIName str: names) {
            System.out.println(str.name);
        }
    }
}