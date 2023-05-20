package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dao {


    private static String username = "root";
    private static String password = "";
    private static String con_string = "jdbc:mysql://localhost/siao";

    public static Connection connDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return DriverManager.getConnection(con_string, username, password);

    }

    public static void Update(Statement s) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Last name : ");
        String nom = br.readLine();
        System.out.println("First name : ");
        String prenom = br.readLine();
        System.out.println("Code apogee : ");
        String co = br.readLine();
        System.out.println("Age : ");
        String age = br.readLine();

        String sql = "UPDATE `etu` SET `NOM`=" + nom + ",`PRENOM`=" + prenom + ","
                + "`CODE_APO`=" + co + ",`AGE`=" + age + " WHERE 1";

        s.executeUpdate(sql);

    }

    public static void Delete(Statement s) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entrer code apogee : ");
        String co = br.readLine();

        String sql = "DELETE FROM `etu` WHERE `code_apo` = " + co;

        s.executeUpdate(sql);

    }

    public static void read(ResultSet rs) throws SQLException {

        while (rs.next()) {

            StringBuilder s = new StringBuilder();
            s.append("Nom : " + rs.getString("nom") + ", ");
            s.append("Prenom : " + rs.getString("prenom") + ", ");
            s.append("Code apogee : " + rs.getInt("code_apo") + ", ");
            s.append("Age : " + rs.getInt("age") + ", ");


            System.out.println(s.toString());


        }

    }


    public static void main(String[] args) {

        Connection con;

        try {
            con = connDB();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM center");
            read(rs);


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
