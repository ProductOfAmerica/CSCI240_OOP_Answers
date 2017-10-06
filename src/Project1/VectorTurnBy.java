package Project1;

import java.io.PrintStream;

public class VectorTurnBy {
   public final static double kEpsilon = .000001;

   protected double x;
   protected double y;

   public VectorTurnBy(/*Vector this,*/ double x, double y) {
      this.x = x;
      this.y = y;
   }

   public final double getX(/*Vector this*/) {return this.x;}
   public final double getY() {return y;}

   private static double sqr(double val) {return val*val;}

   private static boolean dblEquals(double d1, double d2) {
      return d1 - kEpsilon < d2 && d1 + kEpsilon > d2;
   }

   public VectorTurnBy minus(/*Vector this,*/ VectorTurnBy other) {
      return new VectorTurnBy(this.x - other.x, this.y - other.y);
   }

   public VectorTurnBy plus(VectorTurnBy other) {
      return new VectorTurnBy(x + other.x, y + other.y);
   }

   public double length() {return Math.sqrt(sqr(x) + sqr(y));}

   // Return vector turned |rads| radians in ccwise direction
   public VectorTurnBy turn(double rads) {
      return new VectorTurnBy(Math.cos(rads)*x - Math.sin(rads)*y,
              Math.sin(rads)*x + Math.cos(rads)*y);
   }

   public VectorTurnBy scaleBy(/*Vector this,*/ double scale) {
      this.x *= scale;
      this.y *= scale;

      return this;
   }

   public VectorTurnBy augmentBy(VectorTurnBy other) {
      x += other.x;
      y += other.y;

      return this;
   }

   // Write the function turnBy that turns the current
   // vector and returns it.
   public VectorTurnBy turnBy(double rads){
      double oldX = this.x;
      this.x = (float)(this.x * Math.cos(rads) - this.y * Math.sin(rads));
      this.y = (float)(oldX * Math.sin(rads) + this.y * Math.cos(rads)) ;
      return this;
   }


   public boolean equals(/*Vector this,*/ VectorTurnBy other) {
      return dblEquals(this.x, other.x) && dblEquals(this.y, other.y);
   }

   public String toString() {return "[" + x + ", " + y + "]";}

   public static void main(String [] args) {
      VectorTurnBy v = new VectorTurnBy(0.0, 1.0);
      VectorTurnBy v2 = new VectorTurnBy(0.0, 1.0);

      System.out.printf("v is: %s\n", v);
      System.out.printf("v2.turn(3.14/2).turnBy(-3.14/2) is: %s\n", v2.turn(3.14/2).turnBy(-3.14/2));
      System.out.printf("However, v2 is still: %s\n", v2);

      v2.turnBy(3.14/2); // Turn v2 by PI/2
      System.out.printf("v.turn(3.14/2).equals(v2)? %s\n", v.turn(3.14/2).equals(v2));
   }
}