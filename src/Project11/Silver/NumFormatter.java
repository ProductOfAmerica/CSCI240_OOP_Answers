package Project11.Silver;

public interface NumFormatter {

   /**
    * Function that prints a double with a specific format.
    *
    * @param num the number to print
    */
   public void print(double num);

   /**
    * Called after the last number prints, to "wrap up"
    * a multinumber printing sequence.
    */
   public void end();
}