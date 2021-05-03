import java.util.NoSuchElementException;

public class MatrixIterator<T> implements java.util.Iterator<T> {
    T[][] array;
    int row = 0;
    int column = 0;

    MatrixIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (column < array[row].length - 1) {
            return !array[row][column + 1].equals( null ) ? true : false;
        } else if (column >= array[row].length - 1 && row < array.length - 1) {
            return !array[row + 1][0].equals( null ) ? true : false;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        if (row > array.length)
            throw new NoSuchElementException();

        T element = array[row][column];
        column++;
        if (column >= array[row].length) {

            row++;
            if (row > array.length)
                throw new NoSuchElementException();

            column = 0;
        }

        return element;
    }
}
