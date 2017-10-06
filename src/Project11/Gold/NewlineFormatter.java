package Project11.Gold;

/**
 * Format a series of doubles, in lines of four
 * comma-separated doubles, except for possibly the final line which may
 * have fewer doubles, but will always end with a newline.
 */
public class NewlineFormatter implements NumFormatter {
    int lineNum = 1;
    boolean newl = true;
    @Override
    public void print(double num) {
        if(lineNum%4 == 0){
            System.out.print(", " + num);
            newl = true;
        }else if(newl && lineNum == 1){
            System.out.print(num);
            newl = false;
        }else if(newl){
            System.out.print("\n" + num);
            newl = false;
        }else{
            System.out.print(", " + num);
        }
        lineNum++;
    }

    @Override
    public void end() {
        System.out.println();
    }
}