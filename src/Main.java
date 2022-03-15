import java.sql.*;
import java.sql.Connection;
import java.util.concurrent.Callable;

public class Main {
    private static final String url = "jdbc:postgresql://localhost:5433/";
    private static final String user = "postgres";
    private static final String password = "master";

    public static void main(String[] args) {
        connect();
        getProducts();
    }

    public static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static int getProducts() {
        String SQL = "SELECT count * FROM product WHERE product_name LIKE 'Ch%'";
        int count = 0;
        try {
            Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getLong("id")  + " - " + rs.getString("product_name"));
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
