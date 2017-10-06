package Project7.Bronze;/*
 * Copyright Clint Staley 2015
 */

import java.util.Scanner;

public class DeepEquals {
   protected int x;

   public void readX(Scanner in) {
      x = in.nextInt();
   }

   @Override
   public boolean equals(Object o) {
      return o == this || o != null && o.getClass() != String.class && ((DeepEquals) o).x == this.x;
   }
}