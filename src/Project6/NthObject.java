package Project6;/*
 * Copyright Clint Staley 2015
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NthObject {

    static public Object getNth(Iterator itr, int n) {
        if(n <= 0)
            return null;
        int count = 0;
        while (itr.hasNext() && count++ < n){
            Object wef = itr.next();
            if(count == n)
                return wef;
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        int count;
        Scanner in = new Scanner(System.in);

        count = in.nextInt();
        while (count-- > 0)
            data.add(in.next());

        System.out.println("Nth is " + getNth(data.iterator(), in.nextInt()));

    }
}