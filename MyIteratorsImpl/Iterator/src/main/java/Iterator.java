import java.util.NoSuchElementException;

public class Iterator<T> implements java.util.Iterator<T> {
    T[] array;
    int index = 0;


    Iterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < (array.length - 1);
    }

    @Override
    public T next() {
        if (index >= array.length)
            throw new NoSuchElementException();

        return array[index++];
    }
}
