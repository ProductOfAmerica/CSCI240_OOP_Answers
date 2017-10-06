package Project11.Silver;

import java.util.Scanner;

public class PrintDoubles {
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

         printDoubles(num, new ParenFormatter());
         printDoubles(num, new RoundFormatter());
      }
   }
}