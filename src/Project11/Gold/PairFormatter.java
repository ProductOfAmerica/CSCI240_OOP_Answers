package Project11.Gold;

/**
 * The PairFormatter class groups each pair of doubles, separating them by a
 * comma and surrounding them in parentheses.  If the final double has no partner
 * it goes in parentheses alone.
 */
public class PairFormatter implements NumFormatter {
    int numCount = 0;
    @Override
    public void print(double num) {
        if ((numCount++ & 1) == 0){
            System.out.print("(" + num);
        }else{
            System.out.print(", " + num + ")");
        }
    }

    @Override
    public void end() {
        if(numCount % 2 != 0){
            System.out.print(")");
        }
        System.out.println();
    }
}