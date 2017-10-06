package Project3;

public class GradStudent extends Student {
   public String advisor;

   public GradStudent(String name, int age, int numUnits, double GPA,
    String advisor) {
      super(name, age, numUnits, GPA);
      this.advisor = advisor;
   }

   @Override
   public void print() {
     super.print();
     System.out.println(this.getName() + "'s advisor is " + advisor);
   }
}