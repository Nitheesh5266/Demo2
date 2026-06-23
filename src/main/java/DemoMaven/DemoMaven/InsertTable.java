package DemoMaven.DemoMaven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class InsertTable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
 
        String url = "jdbc:mysql://localhost:3306/wiprodemo";
        String user = "root1";
        String pass = "12345678";
 
        
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            Connection con = DriverManager.getConnection(url, user, pass);
 
            String query = "INSERT INTO employee (id, name, age) VALUES (?, ?, ?)";
 
            PreparedStatement ps = con.prepareStatement(query);
 
            ps.setInt(1, 1);
            ps.setString(2, "Sai");
            ps.setInt(3, 23);
 
            ps.executeUpdate();
 
            System.out.println("Data inserted successfully");
 
            ps.close();
            con.close();
 
        
    }
}
