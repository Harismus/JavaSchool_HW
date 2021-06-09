package connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBase {
    Connection connection() throws SQLException;
    void createDb();
}
