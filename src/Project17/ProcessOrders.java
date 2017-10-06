package Project17;/*
 * Copyright Clint Staley 2015
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProcessOrders {
   public static class Catalog extends TreeMap<String, Component> {}

   static Catalog getCatalog(InputStream iStr) {
      Scanner in = new Scanner(iStr);
      String name;
      List<Component> pieces;
      Catalog rtn = new Catalog();

      while (in.hasNext()) {
         name = in.next();
         if (in.hasNextDouble()) // Part specification
            rtn.put(name, new Part(name, in.nextDouble()));
         else {
            pieces = new LinkedList<Component>();
            for (String pieceName: in.nextLine().split(" ")) {
               if (rtn.containsKey(pieceName))
                  pieces.add(rtn.get(pieceName));
            }
            rtn.put(name, new Assembly(name, pieces));
         }
      }
      in.close();
      return rtn;
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      Catalog catalog;

      try {
         catalog = getCatalog(System.in);

         for (Component cmp: catalog.values())
            System.out.printf("Component %s has %d parts.  Heaviest is %.2f.\n",
                    cmp.getName(), cmp.getPartCount(), cmp.getMaxWeight());
      }
      catch (Exception err) {
         System.out.println("Error: " + err.getMessage());
         err.printStackTrace();
      }
      in.close();
   }
}