package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
