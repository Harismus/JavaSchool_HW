import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений



        String url = "jdbc:h2:~/test";
        //Имя пользователя БД

        String name = "sa";
        //Пароль
        String password = "";
        try {
            //Загружаем драйвер
            Class.forName( "org.h2.Driver" );
            System.out.println( "Драйвер подключен" );
            //Создаём соединение
            connection = DriverManager.getConnection( url, name, password );
            System.out.println( "Соединение установлено" );
            //Для использования SQL запросов существуют 3 типа объектов:
            //1.Statement: используется для простых случаев без параметров
            Statement statement = null;

            statement = connection.createStatement();
            //Выполним запрос
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM test" );
            //result это указатель на первую строку с выборки
            //чтобы вывести данные мы будем использовать
            //метод next() , с помощью которого переходим к следующему элементу
            System.out.println( "Выводим statement" );
            while (result1.next()) {
                System.out.println( "Номер в выборке #" + result1.getRow()
                        + "\t Номер в базе #" + result1.getInt( "id" )
                        + "\t" + result1.getString( "name" ) );
            }

        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
                }
            }
        }
    }
}
