package jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object obj, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update userinfo set name = ?, password = ? where id = ?"
        );
        User user = (User) obj;
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setInt(3, user.getId());
        return preparedStatement;
    }
}
