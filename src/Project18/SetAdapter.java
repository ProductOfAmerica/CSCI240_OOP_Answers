package Project18;/*
 * Copyright Clint Staley 2015
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class SetAdapter<T> implements Set<T> {
    private List<T> toAdapt;

    public SetAdapter(List<T> toAdapt) {
        this.toAdapt = toAdapt;
    }

    // add Method
    @Override
    public boolean add(T t) {
        return !toAdapt.contains(t) && toAdapt.add(t);
    }



    // addAll Method
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for(T t : c)
            if(!toAdapt.contains(t)) {
                changed = true;
                toAdapt.add(t);
            }
        return changed;
    }



    // clear Method
    @Override
    public void clear() {
        toAdapt.clear();
    }



    // contains Method
    @Override
    public boolean contains(Object o) {
        return toAdapt.contains(o);
    }



    // iterator Method

    @Override
    public Iterator<T> iterator() {
        return toAdapt.iterator();
    }





    @Override public boolean isEmpty()          {return toAdapt.isEmpty();}
    @Override public boolean remove(Object o)   {return toAdapt.remove(o);}
    @Override public boolean containsAll(Collection<?> c) {
        return toAdapt.containsAll(c);
    }

    // IHS do these like the ones above, pls.
    @Override
    public boolean removeAll(Collection<?> c) {
        return toAdapt.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return toAdapt.retainAll(c);
    }

    @Override
    public int size() {
        return toAdapt.size();
    }

    @Override
    public Object[] toArray() {
        return toAdapt.toArray();
    }
    @Override
    public <T> T[] toArray(T[] a) {
        return toAdapt.toArray(a);
    }

    public static void main(String[] args) {
        Set<String> set = new SetAdapter<String>(new LinkedList<String>());

        // Read in input
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.next();
            set.add(s);
        }

        // Get Iterator
        Iterator<String> itr = set.iterator();

        System.out.printf("Items in set:\n");
        // Loop through iterator to print Strings
        while(itr.hasNext()) {
            System.out.printf(itr.next() + "\n");
        }

        System.out.printf("Size: %d\n", set.size());

        // Checking clear method
        set.clear();

        System.out.printf("Cleared Size: %d\n", set.size());

        System.out.println();

        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("World");
        arrList.add("House");
        arrList.add("Goose");
        arrList.add("Hello");
        arrList.add("World");
        arrList.add("Duck");
        arrList.add("Duck");
        arrList.add("Goose");

        // Add all to set and checking if it changed the set.
        boolean changed = set.addAll(arrList);
        System.out.printf("Set Changed? " + changed + "\n");

        changed = set.addAll(new ArrayList<String>());
        System.out.printf("Set Changed? " + changed + "\n");

        itr = set.iterator();

        System.out.printf("Items in set:\n");
        while(itr.hasNext()) {
            System.out.printf(itr.next() + "\n");
        }

        // Checking contains method
        System.out.printf("Set contains Duck?: " + set.contains("Duck") + "\n");

        System.out.printf("Removing World\n");
        set.remove("World");

        System.out.printf("Set contains World?: " + set.contains("World") + "\n");

        System.out.printf("Size: %d\n", set.size());
        System.out.printf("Clearing.... ");
        set.clear();
        if (set.isEmpty()) {
            System.out.printf("Done!\n");
        }
    }
}