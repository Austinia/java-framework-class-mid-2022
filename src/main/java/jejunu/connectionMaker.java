package jejunu;

import java.sql.Connection;
import java.sql.SQLException;

public interface connectionMaker {
    User findById(Integer id) throws ClassNotFoundException, SQLException;

    Connection getConnection() throws ClassNotFoundException, SQLException;
}
