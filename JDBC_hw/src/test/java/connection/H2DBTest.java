package connection;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class H2DBTest {

    H2DataBase h2DB = new H2DataBase();

    @Test
    public void connection() {
        try {
            assertNotNull( h2DB.connection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void createDb() {
        h2DB.createDb();
    }
}