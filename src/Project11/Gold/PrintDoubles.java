package Project11.Gold;

import java.util.Scanner;

public class PrintDoubles {
   public static final int MAX_DOUBLES = 10;

   public static void printDoubles(double[] num, NumFormatter format) {
      for(int i = 0; i < num.length; i++) {
         format.print(num[i]);
      }
      format.end();
   }


   public static void main(String [] args) {
      Scanner scan = new Scanner(System.in);
      int count = 0, size;

      if (scan.hasNextInt()) {
         size = scan.nextInt();
         double num[]  = new double[size];

         while (count < size && scan.hasNextDouble()) {
            num[count] = scan.nextDouble();
            count++;
         }

         printDoubles(num, new NewlineFormatter());
         System.out.println("-------");
         printDoubles(num, new PairFormatter());
         System.out.println("-------");
      }
   }
}