package connection;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class H2DataBase implements DataBase {

    private String URL = "jdbc:h2:~/test";
    private String USER = "user";
    private String PASS = "123";


    public Connection connection() throws SQLException {
        final Connection connection = DriverManager.getConnection( URL, USER, PASS );
        connection.setAutoCommit( true );
        return connection;
    }

    public void createDb() {
        String sql;
        try {
            sql = FileUtils.readFileToString( new File(
                            H2DataBase.class.getResource( "/data.sql" ).getFile() ),
                    Charset.defaultCharset() );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }

        try (PreparedStatement statement = connection()
                .prepareStatement( sql )) {
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException( e );
        }
    }
}
