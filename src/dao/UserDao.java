package dao;

import config.DatabaseConnection;
import enams.Success;
import model.User;
import model.UserForAuthorize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private final static Connection conn = DatabaseConnection.connect();

    public static Success authorize(UserForAuthorize user) {
        String sql = "SELECT count (*) as cnt FROM users WHERE password = " + user.getPassword() + " " +
                "AND (login = " + user.getLoginOrEmail() + " or email = " + user.getLoginOrEmail() + ")";

        try (ResultSet resultSet = conn.createStatement().executeQuery(sql)) {
            resultSet.next();

            if (resultSet.getInt("cnt") != 0)
                return Success.OK;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Success.NOT_FOUND;
    }


    public int insertUser(User user) {

        String SQL = "INSERT INTO users (id, login, email, password, date_of_registration) " + "VALUES (?,?,?,?, now())";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();

                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public int deleteUser(Integer id) {
        return 0;
    }

    public List<User> selectUser() {
        return null;
    }

}
