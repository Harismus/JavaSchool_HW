import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MatrixIteratorTest {

    Integer[][] array;
    MatrixIterator<Integer> iterator;

    @Before
    public void init() {
        array = new Integer[][]{{1, 2, 3}, {3, 4, 5}, {6, 7, 8}};
        iterator = new MatrixIterator<>( array );
    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testNext() {
        for (Integer it; iterator.hasNext(); ) {
            it = iterator.next();
            System.out.println( "it = " + it );
        }
    }
}