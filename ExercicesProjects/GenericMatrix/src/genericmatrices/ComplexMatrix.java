package genericmatrices;

public class ComplexMatrix extends GenericMatrix<Complex> {
    @Override
    public Complex add(Complex element1, Complex element2) {
        return element1.add(element2);
    }

    @Override
    public Complex multiply(Complex element1, Complex element2) {
        return element1.multiply(element2);
    }

    @Override
    public Complex zero() {
        return new Complex(0,0);
    }
}
