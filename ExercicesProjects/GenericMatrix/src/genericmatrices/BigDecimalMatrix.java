package genericmatrices;

import java.math.BigDecimal;

public class BigDecimalMatrix extends GenericMatrix<BigDecimal> {
    @Override
    public BigDecimal add(BigDecimal element1, BigDecimal element2) {
        return element1.add(element2);
    }

    @Override
    public BigDecimal multiply(BigDecimal element1, BigDecimal element2) {
        return element1.multiply(element2);
    }

    @Override
    public BigDecimal zero() {
        return BigDecimal.ZERO;
    }
}
