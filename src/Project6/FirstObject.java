package Project6;/*
 * Copyright Clint Staley 2015
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FirstObject {

   static public Object getFirst(Iterator itr) {
      return itr.hasNext() ? itr.next() : null;
   }

   public static void main(String[] args) {
      ArrayList data = new ArrayList();
      int count;
      Scanner in = new Scanner(System.in);

      count = in.nextInt();
      while (count-- > 0)
         data.add(in.next());

      System.out.println("First is " + getFirst(data.iterator()));
   }
}