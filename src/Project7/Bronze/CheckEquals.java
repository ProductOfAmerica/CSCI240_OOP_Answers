package Project7.Bronze;

import java.util.Scanner;

public class CheckEquals{
   public static void main(String [] args) {
      Scanner in = new Scanner(System.in);

      DeepEquals c1 = new DeepEquals();
      DeepEquals c2 = new SubDeepEquals();
      DeepEquals c3 = new OtherSubDeepEquals();
      String str = "I'm not a DeepEquals";
      String noStr = null;
      
      c1.readX(in);
      c2.readX(in);
      c3.readX(in);
      System.out.printf("c1.equals(c2): %b\nc1.equals(c3): %b\n" +
       "c2.equals(str): %b\nc3.equals(noStr): %b\nc2.equals(c1): %b",
       c1.equals(c2), c1.equals(c3), c2.equals(str), c3.equals(noStr),
       c2.equals(c1));
   }
}