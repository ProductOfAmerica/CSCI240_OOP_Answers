package Project3;

public class StudentTest {
   public static void main(String []args) {
      Student studentArray[] = new Student[7];
      studentArray[0] = new GradStudent("Gus Alphonzo Dvorak", 25, 25, 3.0,
       "Agnija Tipene Hruska");
      studentArray[1] = new Student("Sorina Helen", 23, 14, 3.5);
      studentArray[2] = new ForeignStudent("Hui Shi", 18, 16, 3.6, "China");
      studentArray[3] = new GradStudent("Vitalik Jeanine", 28, 4, 3.9,
       "Augustus Aulay");
      studentArray[4] = new Student("Royston Randa", 27, 13, 2.5);
      studentArray[5] = new Student("Thorvald Edison", 22, 11, 2.2);
      studentArray[6] = new ForeignStudent("Maximiliano Ceferino", 20, 15, 3.3, "Spain");

      // Loop through the studentArray array and print out their information.
      for (Student student : studentArray){
         student.print();
      }
   }
}