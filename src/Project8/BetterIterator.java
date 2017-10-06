package Project8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

 /* BetterIterator provides a better iterator interface.  It has these methods
 *
 * isGood -- true iff we haven't gone past the end of the collection.
 * getCurrent -- returns the object at the current point of the iteration.  May
 *               be called over and over without advancing the iteration.
 * advance -- Step the iteration forward.  Don't return anything.
 *
 * BetterIterator works by taking a Java Iterator, supplied via its constructor,
 * and "working" this Iterator to provide the behavior just described.  It's a
 * wrapper or adapter around Java Iterator, in other words.
 */

/**
 * Design a class BetterIterator that provides a better iterator
 * behavior than Java's Iterator interface, per the comments.
 * See main for an example of use.
 */
public class BetterIterator {
    private ArrayList list;
    private int count;
    public BetterIterator(Iterator iterator) {
        list = new ArrayList<>();
        while(iterator.hasNext())
            list.add(iterator.next());
        count = 0;
    }

    public boolean isGood(){
        return count < list.size();
    }

    public Object getCurrent(){
        return list.get(count);
    }

    public void advance(){
        count++;
    }

    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        int count;
        Scanner in = new Scanner(System.in);

        count = in.nextInt();
        while (count-- > 0)
            data.add(in.next());

        BetterIterator bItr = new BetterIterator(data.iterator());
        while (bItr.isGood()) {  // While we're not past the end
            if (!bItr.getCurrent().equals("N/A"))
                System.out.println(bItr.getCurrent().toString());
            bItr.advance();
        }
    }
}