/* Encapsulation Class for Database Connection--JDBC
 * @author Tsing
 * @version 1.0
 * Date: $<20190626>
 */
package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static String username;
    private static String password;
    private static String url;
    private static String driver;

    static {
        Properties p = new Properties();
        try {
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            p.load(in);
            url = p.getProperty("jdbc.DB_URL");
            driver = p.getProperty("jdbc.JDBC_DRIVER");
            username = p.getProperty("jdbc.USER");
            password = p.getProperty("jdbc.PASSWORD");
        }catch(IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName(driver);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Statement createStatement(Connection connection)
    {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static void close(Connection connection) {
        try {
            if(connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        try {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement) {
        try {
            if(statement != null) {
                statement.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}