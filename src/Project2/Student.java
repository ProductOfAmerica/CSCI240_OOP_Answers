package Project2;

public class Student {
   private String name;
   private int age;
   private int numUnits;
   private double GPA;

   public Student(String name, int age, int numUnits, double GPA) {
      this.name = name;
      this.age = age;
      this.numUnits = numUnits;
      this.GPA = GPA;
   }

   public void getName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public int getAge() {
      return age;
   }

   public void setNumUnits(int numUnits) {
      this.numUnits = numUnits;
   }

   public int getNumUnits() {
      return numUnits;
   }

   public void setGPA(double GPA) {
      this.GPA = GPA;
   }

   public double getGPA() {
      return GPA;
   }

   /**
    * Put here a function called "print" that will output the name,
    * age, numUnits, and GPA of the student.
    */
   public void print(){
      System.out.printf("%s is %d years old, and is taking %d units with a GPA of %s%n", name, age, numUnits, GPA);
   }


}