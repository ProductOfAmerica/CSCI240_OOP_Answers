package Project7.Silver;/*
 * Copyright Clint Staley 2015
 */

import java.util.Iterator;
import java.util.Scanner;

/**
 * Fill in ArrayIterator so that it provides an Iterator that walks
 * through an array of Strings, which array is passed to its constructor.
 */
public class ArrayIterator implements Iterator {
    private String[] strings;
    private int count;


    public ArrayIterator(String[] data) {
        strings = data;
        count = 0;
    }

    @Override
    public boolean hasNext() {
        return count++ <= strings.length;
    }

    @Override
    public Object next() {
        return strings[count++];
    }

    // Ignore this line.  It provides an implementation for an abstract Iterator
    // method that we haven't discussed yet.
    @Override
    public void remove() {
    }

    public static void main(String[] args) {
        int count;
        String[] data;
        Scanner in = new Scanner(System.in);

        count = in.nextInt();
        data = new String[count];

        for (int idx = 0; idx < count && in.hasNext(); idx++) {
            data[idx] = in.next();
        }

        ArrayIterator itr = new ArrayIterator(data);

        while (itr.hasNext()) {
            System.out.printf("%s ", itr.next());
        }
    }
}