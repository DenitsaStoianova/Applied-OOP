package genericmatrices;

public class RationalMatrix extends GenericMatrix<Rational> {
    @Override
    public Rational add(Rational element1, Rational element2) {
        return element1.add(element2);
    }

    @Override
    public Rational multiply(Rational element1, Rational element2) {
        return element1.multiply(element2);
    }

    @Override
    public Rational zero() {
        return new Rational(0,1);
    }
}
