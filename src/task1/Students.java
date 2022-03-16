package task1;

import java.sql.*;

public class Students {
    private static final String url = "jdbc:postgresql://localhost:5433/";
    private static final String user = "postgres";
    private static final String password = "master";

    public static void main(String[] args) {
        connect();
        getStudents_university();
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static int getStudents_university() {
        String SQL = "SELECT id, group_code FROM university_group";
        System.out.println("В группе N студентов: ");
        int count = 0;
        Connection conn = null;
        try {
            conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" + rs.getString("group_code"));
            }
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return count;
    }

}

