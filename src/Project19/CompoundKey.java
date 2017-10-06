package Project19;/*
 * Copyright Clint Staley 2015
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CompoundKey {

    public static class KeyPair {
        public Comparable key1;
        public Comparable key2;

        public KeyPair(Comparable key1, Comparable key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        public int compareTo(KeyPair kp) {
            return !key1.equals(kp.key1) ? key1.compareTo(kp.key1) : key2.compareTo(kp.key2);
        }

        public boolean equals(KeyPair kp) {
            return key1.equals(kp.key1) && key2.equals(kp.key2);
        }



    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<KeyPair> kSet = new ArrayList<KeyPair>();

        // Pairs of Strings
        for (int i = 0; i < 4; i++)
            kSet.add(new KeyPair(in.next(), in.next()));
        for (KeyPair k: kSet)
            System.out.printf("(%s %s) ", k.key1, k.key2);
        System.out.println();

        KeyPair[] arrKP = new KeyPair[4];
        kSet.toArray(arrKP);

        // Check Equals
        System.out.println(arrKP[0].equals(arrKP[0]));
        System.out.println(arrKP[0].equals(arrKP[1]));
        System.out.println(arrKP[0].equals(arrKP[2]));
        System.out.println(arrKP[0].equals(arrKP[3]));

        // Check CompareTo
        System.out.println(arrKP[0].compareTo(arrKP[0]));
        System.out.println(arrKP[0].compareTo(arrKP[1]));
        System.out.println(arrKP[0].compareTo(arrKP[2]));
        System.out.println(arrKP[0].compareTo(arrKP[3]));

        // Pairs of Integers
        kSet.clear();
        for (int i = 0; i < 4; i++)
            kSet.add(new KeyPair(in.nextInt(), in.nextInt()));
        for (KeyPair k: kSet)
            System.out.printf("(%s %s) ", k.key1, k.key2);
        System.out.println();

        kSet.toArray(arrKP);

        // Check Equals
        System.out.println(arrKP[0].equals(arrKP[0]));
        System.out.println(arrKP[0].equals(arrKP[1]));
        System.out.println(arrKP[0].equals(arrKP[2]));
        System.out.println(arrKP[0].equals(arrKP[3]));

        // Check CompareTo
        System.out.println(arrKP[0].compareTo(arrKP[0]));
        System.out.println(arrKP[0].compareTo(arrKP[1]));
        System.out.println(arrKP[0].compareTo(arrKP[2]));
        System.out.println(arrKP[0].compareTo(arrKP[3]));
    }
}