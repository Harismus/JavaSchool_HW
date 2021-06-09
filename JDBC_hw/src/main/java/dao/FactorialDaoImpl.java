package dao;

import connection.DataBase;
import connection.H2DataBase;
import model.Factorial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactorialDaoImpl implements FactorialDao {
    private DataBase dataBase = new H2DataBase();
    private final String INSERT_ANIMAL_SQL = "insert into animal (name, type) values (?, ?)";
    private final String UPDATE_ANIMAL_PERSON_SQL = "update animal set person_id = ? where id = ?";


    @Override
    public Factorial createFactorial(int number, int result) {
        try (PreparedStatement statement = dataBase.connection()
                .prepareStatement(INSERT_ANIMAL_SQL)) {
            createFactorialStatement(statement, number, result);
            statement.execute();

            return findFactorial(number, result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFactorialStatement(PreparedStatement statement, int number, int result) throws SQLException {
        statement.setInt(1, number);
        statement.setInt(2, result);
    }

    private Factorial resultSetForAnimal(ResultSet resultSet) throws SQLException {
        Factorial factorial = new Factorial();
        factorial.setResult(resultSet.getInt(1));
        factorial.setResult(resultSet.getInt(2));
        return factorial;
    }

    @Override
    public Factorial findFactorial(int number, int result) {
        try (PreparedStatement statement = dataBase.connection()
                .prepareStatement("select * from animal a where a.name=? and a.type=?")) {

            statement.setInt(1, number);
            statement.setInt(2, result);
            statement.execute();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return resultSetForAnimal(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
