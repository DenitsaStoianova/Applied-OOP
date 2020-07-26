package genericmatrices;

class Complex implements Comparable<Complex> {
    private double a;
    private double b;

    public Complex() {
    }

    Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex(double a) {
        this(a, 0);
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    public Complex add(Complex secondComplex) {
        double newA = a + secondComplex.a;
        double newB = b + secondComplex.b;
        return new Complex(newA, newB);
    }

    public Complex subtract(Complex secondComplex) {
        double newA = a - secondComplex.a;
        double newB = b - secondComplex.b;
        return new Complex(newA, newB);
    }

    public Complex multiply(Complex secondComplex) {
        double newA = a * secondComplex.a - b * secondComplex.b;
        double newB = b * secondComplex.a + a * secondComplex.b;
        return new Complex(newA, newB);
    }

    public Complex divide(Complex secondComplex) {
        double newA = (a * secondComplex.a + b * secondComplex.b)
                / (Math.pow(secondComplex.a, 2.0) + Math.pow(secondComplex.b,
                2.0));
        double newB = (b * secondComplex.a - a * secondComplex.b)
                / (Math.pow(secondComplex.a, 2.0) + Math.pow(secondComplex.b,
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


    @Override
    public int compareTo(Complex c) {
        double v1 = this.abs();
        double v2 = c.abs();
        return v1 < v2 ? -1 : ((v1 == v2) ? 0 : 1);
    }
}

