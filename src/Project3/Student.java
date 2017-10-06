package Project3;

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

   public void print() {
      System.out.println(name + " is " + age + " years old, and is taking " + numUnits + " units with a GPA of " + GPA);
   }
}
