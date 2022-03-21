package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public int insertUser(User user){
       Connection conn = DatabaseConnection.connect();
       try {
           String SQL = "INSERT INTO users (id, login, email, password, date_of_registration) " + "VALUES (?,?,?,?, now())";
           PreparedStatement statement = conn.prepareStatement(SQL);
           statement.setInt(1, user.getId());
           statement.setString(2, user.getLogin());
           statement.setString(3, user.getEmail());
           statement.setString(4, user.getPassword());
           return statement.executeUpdate();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
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

    public ResultSet getUser(User user) {
        ResultSet rs = null;

        try {
            String SQL = "SELECT * FROM users WHERE login =='?' AND password == '?'";
            PreparedStatement statement = DatabaseConnection.connect().prepareStatement(SQL);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            rs = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }
}
