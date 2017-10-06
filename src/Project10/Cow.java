package Project10;

public class Cow extends HerdAnimal {
   public Cow(int id, MarginVector loc, Vector vlc) {super(id, loc, vlc);}

   @Override
   public String getLabel() {return "C";}  // C for Cow

   @Override
   boolean isGoodLeader(HerdAnimal ldr) {
      return ldr instanceof Cow && ldr.loc.equals(loc);
   }
}