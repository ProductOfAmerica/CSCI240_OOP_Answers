package Project11.Basic;

public class VectorCC {
    public final static VectorCC kZero = new VectorCC();

    protected int x;
    protected int y;

    public VectorCC() {
    }

    public VectorCC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy Constructor


    public VectorCC(VectorCC v) { // Base: 3, Surcharge: 0
        this(v.x, v.y);        // Base: 4, Surcharge: 0
    }


    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return y;
    }

    protected static int sqr(int val) {
        return val * val;
    }

    public VectorCC plus(VectorCC other) {
        return

                new VectorCC(this).plusBy(other)
                ;
    }

    public VectorCC minus(VectorCC other) {
        return

                new VectorCC(this).minusBy(other)
                ;
    }

    public VectorCC scale(double scale) {
        return

                new VectorCC(this).scaleBy(scale)
                ;
    }

    public VectorCC turn90(boolean left) {
        return

                new VectorCC(this).turn90By(left)
                ;
    }

    public VectorCC scaleBy(double scale) {
        this.x *= scale;
        this.y *= scale;

        return this;
    }

    public VectorCC plusBy(VectorCC other) {
        x += other.x;
        y += other.y;

        return this;
    }

    public VectorCC minusBy(VectorCC other) {
        x -= other.x;
        y -= other.y;

        return this;
    }

    public VectorCC turn90By(boolean left) {
        x = left ? -y : y;
        y = left ? x : -x;

        return this;
    }

    public double length() {
        return Math.sqrt(sqr(x) + sqr(y));
    }

    @Override
    public boolean equals(Object other) {
        VectorCC reallyAVector = (VectorCC) other;

        return this.x == reallyAVector.x && this.y == reallyAVector.y;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }

    public static void main(String[] args) {
        VectorCC v = new VectorCC(10, 1);
        VectorCC v2 = new VectorCC(v);

        System.out.printf("v is: %s\n", v);
        System.out.printf("Copy of v is: %s\n", new VectorCC(v));
        System.out.printf("v.equals(new VectorCC(v)): %s\n\n", v.equals(new VectorCC(v)));
        System.out.printf("v.scale(5) is: %s\n", v.scale(5));
        System.out.printf("v + v2.scale(2) = %s\n", v.plus(v2.scale(2)));
        System.out.printf("v - v2 = %s\n", v.minus(v2));
        System.out.printf("v.turn90(true) = %s\n", v.turn90(true));
        System.out.printf("v - [15, 19] = %s\n\n", v.minus(new VectorCC(15, 19).scale(0.5)));
        System.out.printf("v is still: %s\n", v);
        System.out.printf("v2 is still: %s\n", v2);
    }
}