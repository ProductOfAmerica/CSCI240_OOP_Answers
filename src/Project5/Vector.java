package Project5;/*
 * Copyright Clint Staley 2015
 */

import java.util.Scanner;

public class Vector {
   public final static double kEpsilon = .000001;

   protected double x;
   protected double y;
  
   public Vector() {}

   public Vector(/*Vector this,*/ double x, double y) {
      this.x = x;
      this.y = y;
   }

   public final double getX(/*Vector this*/) {return this.x;}
   public final double getY() {return y;}

   protected static double sqr(double val) {return val*val;}

   private static boolean dblEquals(double d1, double d2) {
      return d1 - kEpsilon < d2 && d1 + kEpsilon > d2;
   }

   public Vector minus(/*Vector this,*/ Vector other) {
      return new Vector(this.x - other.x, this.y - other.y);
   }

   public Vector plus(Vector other) {
      return new Vector(x + other.x, y + other.y);
   }

   public double length() {return Math.sqrt(sqr(x) + sqr(y));}

   // Return vector turned |rads| radians in ccwise direction
   public Vector turn(double rads) {
      return new Vector(Math.cos(rads)*x - Math.sin(rads)*y,
       Math.sin(rads)*x + Math.cos(rads)*y);
   }

   public Vector scaleBy(/*Vector this,*/ double scale) {
      this.x *= scale;
      this.y *= scale;

      return this;
   }

   public Vector augmentBy(Vector other) {
      x += other.x;
      y += other.y;

      return this;
   }

   @Override
   public boolean equals(Object other) {
      Vector reallyAVector = (Vector) other;

      return dblEquals(this.x, reallyAVector.x)
       && dblEquals(this.y, reallyAVector.y);
   }

   @Override
   public String toString() {return "[" + x + ", " + y + "]";}

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      double d1_1, d1_2, d2_1, d2_2;

      d1_1 = in.nextDouble();
      d1_2 = in.nextDouble();
      Vector vec1 = new Vector(d1_1, d1_2);

      d2_1 = in.nextDouble();
      d2_2 = in.nextDouble();
      Vector vec2 = new Vector(d2_1, d2_2);

      System.out.printf("v1 is: %s%nv2 is: %s%nv1 plus v2 is: %s%n", vec1.toString(), vec2.toString(), vec1.plus(vec2).toString());
      System.out.printf("v1 minus v2 is: %s%nLength of v1 is: %s%n", vec1.minus(vec2).toString(), vec1.length());
      System.out.printf("v1 augmentBy v2 is: %s%n", vec1.augmentBy(vec2).toString());
   }
}