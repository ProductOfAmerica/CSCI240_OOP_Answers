package Project12.Basic;/*
 * Copyright Clint Staley 2015
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Wrappers {
   public static void main(String[] args) {

      LinkedList<Number> nums = new LinkedList<>();
      Scanner in = new Scanner(System.in);
      double total = 0.0;

      int count = 0;
      while (in.hasNext() && count++ < 3) {
         nums.add(in.nextInt());
         nums.add(in.nextLong());
         nums.add(in.nextDouble());
      }   
    

      for(Number n : nums){
         total += n.doubleValue();
      }



      System.out.printf("Total: %.2f\n", total);
   }   
}