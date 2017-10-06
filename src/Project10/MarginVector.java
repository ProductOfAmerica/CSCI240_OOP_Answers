package Project10;

public class MarginVector extends Vector {
   // Margin of error for equality comparison
   private static double margin = kEpsilon;

   public static void setMargin(double val) {margin = val;}
   public static double getMargin() {return margin;}

   public MarginVector(double initX, double initY) {
      super(initX, initY);
   }

   @Override
   public boolean equals(Object other) {
      Vector vct = (Vector) other;

      return sqr(this.x - vct.x) + sqr(this.y - vct.y) < sqr(margin);
   }
}