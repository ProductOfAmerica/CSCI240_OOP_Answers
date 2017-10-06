
package Project10;/*
 * Copyright Clint Staley 2015
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class HerdAnimal extends Animal {
   private static ArrayList all = new ArrayList();

   private HerdAnimal myLeader = null;

   public HerdAnimal(int id, MarginVector loc, Vector vlc) {
      super(id, loc, vlc);
      all.add(this);
   }

   abstract boolean isGoodLeader(HerdAnimal possibleLeader);

   @Override
   public void step() {
      HerdAnimal leader;

      if (myLeader == null) {  // If leaderless
         super.step();             // plod on per usual Animal behavior 
         leadFollowers(vlc);       // and lead your followers

         // Seek a leader
         for (Iterator itr = all.iterator(); itr.hasNext();) {
            leader = (HerdAnimal)itr.next();
            leader = leader.myLeader != null ? leader.myLeader : leader;

            if (leader != this && isGoodLeader(leader)) {
               System.out.println(id + " has found a leader " + leader.id);
               myLeader = leader;
               myLeader.addFollower(this);
               handOffFollowers(myLeader);
               break;
            }
         }
      }
   }

   // Follower code ----------------------------------

   private LinkedList<HerdAnimal> myFollowers = new LinkedList<HerdAnimal>();

   public void addFollower(HerdAnimal follower) {myFollowers.add(follower);}


   public void changeLeader(HerdAnimal ldr) {
      System.out.println(id + " is setting " + ldr.id + " as leader.");
      myLeader = ldr;
      ldr.myFollowers.add(this);
   }

   public void leadFollowers(Vector incr) {
      for(HerdAnimal a : myFollowers){
         a.loc = a.getLoc().augmentBy(incr);
      }
   }

   public void handOffFollowers(HerdAnimal newLeader) {
      for(HerdAnimal animal : myFollowers){
         animal.changeLeader(newLeader);
      }
      myFollowers.clear();
   }

   public static void main(String[] args) {
      // Create four cows A, B, C, and D.  Set them up with location and velocity so that A and B start 
      // by following C, and then eventually C follows D, so that A, B, and C are following D at the end.
      Scanner in = new Scanner(System.in);

      Animal.setRange(new Animal.Range(0.0, 10.0, 0.0, 10.0));

      Animal A, B, C, D;
      A = new Cow(in.nextInt(),
              new MarginVector(in.nextDouble(), in.nextDouble()),
              new Vector(in.nextDouble(), in.nextDouble()));

      B = new Cow(in.nextInt(),
              new MarginVector(in.nextDouble(), in.nextDouble()),
              new Vector(in.nextDouble(), in.nextDouble()));

      C = new Cow(in.nextInt(),
              new MarginVector(in.nextDouble(), in.nextDouble()),
              new Vector(in.nextDouble(), in.nextDouble()));

      D = new Cow(in.nextInt(),
              new MarginVector(in.nextDouble(), in.nextDouble()),
              new Vector(in.nextDouble(), in.nextDouble()));

      for (int i = 0; i < 8; i++) {
         System.out.println("Step " + i);
         System.out.printf("%s is at %s moving %s\n", A.toString(),
                 A.getLoc(), A.getVlc());
         System.out.printf("%s is at %s moving %s\n", B.toString(),
                 B.getLoc(), B.getVlc());
         System.out.printf("%s is at %s moving %s\n", C.toString(),
                 C.getLoc(), C.getVlc());
         System.out.printf("%s is at %s moving %s\n", D.toString(),
                 D.getLoc(), D.getVlc());

         System.out.println();

         A.step();
         B.step();
         C.step();
         D.step();
      }
   }
}