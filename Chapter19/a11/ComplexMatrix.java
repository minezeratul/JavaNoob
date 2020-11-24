package Chapter19.a11;

public class ComplexMatrix extends GenericMatrix<Complex> {
    @Override /** Add two rational numbers */
    protected Complex add(Complex r1, Complex r2) {
        return r1.add(r2);
    }

    @Override /** Multiply two rational numbers */
    protected Complex multiply(Complex r1, Complex r2) {
        return r1.multiply(r2);
    }

    @Override /** Specify zero for a Complex number */
    protected Complex zero() {
        return new Complex(0, 0);
    }
}

