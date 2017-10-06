package Project13;/*
 * Copyright Clint Staley 2015
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SumIntFiles {

    // Return the total of all ints in |str|, assuming |str| has only
    // whitespace-delimited ints in it.
    public static int sumInts(InputStream str) {
        Scanner wef = new Scanner(str);
        int val = 0;
        while (wef.hasNextInt()){
            val += wef.nextInt();
        }
        return val;
    }

    public static void main(String[] args) {
        int grandTotal = 0;
        for(String s : args){
            try {
                grandTotal += sumInts(new FileInputStream(s));
            } catch (IOException e) {
                System.out.println("Error opening file");
                System.exit(0);
            }
        }
        grandTotal += sumInts(System.in);

        System.out.println("Total is: " + grandTotal);
    }
}