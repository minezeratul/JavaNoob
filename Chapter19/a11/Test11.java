package Chapter19.a11;

public class Test11 {
    public static void main(String[] args) {
        Complex[][] m1 = new Complex[3][3];
        Complex[][] m2 = new Complex[3][3];
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] = new Complex(i + 1, j + 5);
                m2[i][j] = new Complex(i + 1, j + 6);
            }

        ComplexMatrix rationalMatrix = new ComplexMatrix();

        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(m1, m2, rationalMatrix.addMatrix(m1, m2), '+');

        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
    }
}
