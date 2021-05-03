import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostTest {

    IPost post = new Post();
    private  String text = "Первая запись";
    private  String text2 = "Вторая запись";

    @Before
    public void init() {
        post.setMessage( text );

    }

    @Test
    public void testGetMessage() {
        assertEquals(text, post.getMessage());
    }

    @Test
    public void testSetMessage() {
        assertEquals(text, post.getMessage());

        post.setMessage(text2);

        assertEquals(text2, post.getMessage());
    }
}