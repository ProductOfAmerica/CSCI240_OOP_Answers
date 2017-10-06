package Project15;/*
 * Copyright Clint Staley 2015
 */

import java.util.Scanner;
import java.util.TreeSet;
// Insert correct imports used for strs declaration.



public class SortStrings {

   static public void main(String[] args) {
      Scanner in = new Scanner(System.in);

      // Insert strs declaration and initialization here. 


      TreeSet<String> strs = new TreeSet<>();
      while (in.hasNext())
         strs.add(in.next());
      
      for (String str: strs) {
         System.out.println(str);
      }
   }
}