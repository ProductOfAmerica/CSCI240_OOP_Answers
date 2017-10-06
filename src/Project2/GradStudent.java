package Project2;

public class GradStudent extends Student {
   public String advisor;

   public GradStudent(String name, int age, int numUnits, double GPA, String advisor) {
      super(name, age, numUnits, GPA);
      this.advisor = advisor;
   }

   /**
    * Write a function below that prints out the Graduate
    * Students name, age, numUnits, GPA, and advisor.
    */
   public void print(){
      super.print();
      System.out.printf("%s's advisor is %s%n", super.getName(), advisor);
   }


}