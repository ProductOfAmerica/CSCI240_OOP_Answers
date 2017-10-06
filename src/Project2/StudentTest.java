package Project2;

public class StudentTest {
   public static void main(String []args) {
      Student studentArray[] = new Student[5];
      studentArray[0] = new GradStudent("Gus Alphonzo Dvorak", 25, 25, 3.0,
       "Agnija Tipene Hruska");
      studentArray[1] = new Student("Sorina Helen", 23, 14, 3.5);
      studentArray[2] = new GradStudent("Vitalik Jeanine", 28, 4, 3.9,
       "Augustus Aulay");
      studentArray[3] = new Student("Royston Randa", 27, 13, 2.5);
      studentArray[4] = new Student("Thorvald Edison", 22, 11, 2.5);

      // Loop through the studentArray array and print each student/grad student.
      for(Student student : studentArray){
         student.print();
      }
   }
}