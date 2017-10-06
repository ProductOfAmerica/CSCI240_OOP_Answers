package Project4;

import java.util.Scanner;

public class OverrideEquals {
   private int x;
   private String str;

   public OverrideEquals(int x, String str) {
      this.x = x;
      this.str = str;
   }


   // Override the equals method so the output below will 
   // print true if they have the same fields. Otherwise, false.
   public boolean equals(OverrideEquals obj) {
      return this.str.equals(obj.str) && this.x == obj.x;
   }


   public static void main(String [] args) {
      Scanner in = new Scanner(System.in);
      OverrideEquals obj1, obj2;
      int i;
      String str;

      i = in.nextInt();
      str = in.next();
      obj1 = new OverrideEquals(i, str);

      i = in.nextInt();
      str = in.next();
      obj2 = new OverrideEquals(i, str);

      System.out.println("obj1.equals(obj2): " + obj1.equals(obj2));
   }
}