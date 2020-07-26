package genericmatrices;

public interface CanCompute<E> {

    E add(E element1, E element2);

    E multiply(E element1, E element2);

    E zero(); // return 0th element
}
