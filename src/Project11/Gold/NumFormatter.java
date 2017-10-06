package Project11.Gold;/*
 * Copyright SoftwareInventions Inc. 2015
 */

public interface NumFormatter {

   /**
    * Function that prints a double with a specific format.
    *
    * @param num the number to print
    */
   public void print(double num);

   /**
    * Called after the last double prints
    */
   public void end();
}