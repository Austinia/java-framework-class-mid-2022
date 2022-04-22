package jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JejuConnectionMaker implements ConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        //드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        //커넥션
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jejunu",
                "jeju",
                "jeju"
        );
    }
}