import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/postgres";
        final String user = "postgres";
        final String password = "postgres";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (java.sql.Statement st = conn.createStatement()) {
            String sql = "SELECT * FROM db113";
            st.execute(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}