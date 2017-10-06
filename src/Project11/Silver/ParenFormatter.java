package Project11.Silver;

public class ParenFormatter implements NumFormatter {
    @Override
    public void print(double num) {
        System.out.printf("(%.6f)", num);
    }

    @Override
    public void end() {
        System.out.println();
    }
}