
package Project12.Bronze;

public class InputBytes {
   public static void main(String[] args)throws Exception {
      int val;

      while ((val = System.in.read()) > 10){
         System.out.println(val);
      }
   }   
}