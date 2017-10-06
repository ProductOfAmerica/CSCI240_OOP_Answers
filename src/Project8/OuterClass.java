package Project8;/*
 * Copyright Clint Staley 2015
 */

public class OuterClass {
   // Declare Setter class here with the setVal function that will set the value of the outer class.
   private class Setter {
      public void setVal(int val) {
         OuterClass.this.val = val;
      }
   }

   private int val;

   public OuterClass(int x) {this.val = x;}
   public int getVal() {return val;}

   // Write a getInnerClass function that will return a Setter object.
   public Setter getInnerClass(){
      return new Setter();
   }


   public static void main(String[] args) {
      OuterClass sample1 = new OuterClass(42), sample2 = new OuterClass(50);

      sample1.getInnerClass().setVal(43);
      sample2.getInnerClass().setVal(100);

      System.out.printf("%d %d\n", sample1.getVal(), sample2.getVal());
   }
}