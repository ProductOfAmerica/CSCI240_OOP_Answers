package Project10;/* An Animal moves in a straight line within |range|, at a constant velocity.
 * If this would take it out of range, it instead stays in place and turns 90
 * degrees to the right.
 */

public class Animal {
   /* Rectangular range in which all Animals may move */
   public static class Range {
      private double loX;
      private double hiX;
      private double loY;
      private double hiY;

      public Range(double loX, double hiX, double loY, double hiY) {
         this.loX = loX;
         this.hiX = hiX;
         this.loY = loY;
         this.hiY = hiY;
      }

      public boolean inRange(Vector loc) {
         return loX <= loc.getX() && loc.getX() <= hiX
                 && loY <= loc.getY() && loc.getY() <= hiY;
      }
   }

   protected static Range range;  // All Animals have a common range.
   public static void setRange(Range val) {range = val;}

   protected int id;              // Unique id per Animal
   protected Vector vlc;          // Velocity (per time unit)
   protected Vector loc;          // Location (will be a MarginVector in fact)

   public Animal(int id, MarginVector loc, Vector vlc) {
      this.id = id;
      this.loc = loc;
      this.vlc = vlc;
   }

   public int getId() {return id;}

   public Vector getLoc()  {return loc;}
   public Vector getVlc() {return vlc;}
   public void setVlc(Vector vlc) {this.vlc = vlc;}

   public void setLoc(MarginVector loc) {this.loc = loc;}

   // Take a step resulting from the passage of one time unit
   public void step() {
      Vector newLoc = new MarginVector(loc.getX(), loc.getY()).augmentBy(vlc);

      if (range == null || range.inRange(newLoc))
         loc = newLoc;
      else
         vlc = vlc.turn(-Math.PI/2);  // Hang a right if out of bounds
   }

   protected String getLabel() {return "?";}

   @Override
   public String toString() {return getLabel() + id;}
}