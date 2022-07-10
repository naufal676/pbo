import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Koneksi {
    public static Connection conn;
    public static Statement stm;

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql:// localhost/parkir";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, pass);

            stm = (Statement) conn.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
    }
}
