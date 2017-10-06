package Project11.Basic;

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
   public String toString() {
      return String.format("[%.3f, %.3f]", x, y);
   }
}