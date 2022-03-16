package task1;

import java.sql.*;

public class Trenery {
    private static final String url = "jdbc:postgresql://localhost:5433/";
    private static final String user = "postgres";
    private static final String password = "master";

    public static void main(String[] args) {
        connect();
        getTrenery();
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

    public static int getTrenery() {
        String SQL = "SELECT fullname, salary FROM trenery t join vid_sporta vs on vs.id = vid_sporta_id";
        String SQL1 = "SELECT SUM(salary) FROM vid_sporta";
        String SQL2 = "SELECT fullname FROM trenery WHERE fullname LIKE '%' > 3";

        int sum = 0;
        Connection conn = null;
        try {
            conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString("fullname") + "-" + rs.getInt("salary"));

            }
            sum = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return sum;
    }

}

