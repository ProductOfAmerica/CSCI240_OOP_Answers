package Project11.Silver;

public class RoundFormatter implements NumFormatter {
    @Override
    public void print(double num) {
        System.out.printf("%.4f ", Math.round(num * 10000.0) / 10000.0);
    }

    @Override
    public void end() {
        System.out.println();
    }
}