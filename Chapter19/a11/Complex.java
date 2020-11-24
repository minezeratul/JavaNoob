package Chapter19.a11;

public class Complex{
    private double a , b;

    public Complex() {
        this(0 ,0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Complex add(Complex secondComplex) {
        double newA = a + secondComplex.getA();
        double newB = b + secondComplex.getB();
        return new Complex(newA, newB);
    }

    public Complex subtract(Complex secondComplex) {
        double newA = a - secondComplex.getA();
        double newB = b - secondComplex.getB();
        return new Complex(newA, newB);
    }

    public Complex multiply(Complex secondComplex) {
        double newA = a * secondComplex.getA() - b * secondComplex.getB();
        double newB = b * secondComplex.getA() + a * secondComplex.getB();
        return new Complex(newA, newB);
    }

    public Complex divide(Complex secondComplex) {
        double newA = (a * secondComplex.getA() + b * secondComplex.getB())
                / (Math.pow(secondComplex.getA(), 2.0) + Math.pow(secondComplex.getB(),
                2.0));
        double newB = (b * secondComplex.getA() - a * secondComplex.getB())
                / (Math.pow(secondComplex.getA(), 2.0) + Math.pow(secondComplex.getB(),
                2.0));
        return new Complex(newA, newB);
    }

    public double abs() {
        return Math.sqrt(a * a + b * b);
    }

    @Override
    public String toString() {
        if (b != 0)
            return a + " + " + b + "i";
        return a + "";
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

}