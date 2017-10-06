package Project19;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortedNames {

    static class Name implements Comparable<Name> {
        String firstName;
        String lastName;

        Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Name o) {
            return !lastName.equals(o.lastName) ? lastName.compareTo(o.lastName) : firstName.compareTo(o.firstName) ;
        }
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Name &&
                    lastName.equals(((Name) obj).lastName) &&
                    firstName.equals(((Name) obj).firstName);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Name> names = new TreeSet<Name>();
        Name testName;

        testName = new Name(in.next(), in.next());
        while (in.hasNext())
            names.add(new Name(in.next(), in.next()));

        for (Name n: names)
            System.out.printf("%s %s %s\n", n.firstName, n.lastName, n.equals(testName) ? "equal" : "unequal");
    }
}