package Project3;

public class ForeignStudent extends Student {
    String from;
    public ForeignStudent(String s, int i, int i1, double v, String from) {
        super(s, i, i1, v);
        this.from = from;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("%s is visiting from %s%n", super.getName(), from);
    }
}
