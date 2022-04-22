package jejunu;

import java.sql.*;

public abstract class UserDao implements connectionMaker {
    @Override
    public User findById(Integer id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        //sql
        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "select * from userinfo where id = ?"
                );
        preparedStatement.setInt(1, id);
        //sql 실행
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        //데이터 매핑
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원 해지
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //리턴
        return user;
}
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
