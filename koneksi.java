package tokoabc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {

    // Konfigurasi database
    private static final String URL = "jdbc:mysql://localhost:3306/tokoabc"; // Pastikan URL sesuai dengan setup Anda
    private static final String USER = "root";  // Sesuaikan dengan username MySQL Anda
    private static final String PASSWORD = "";  // Sesuaikan dengan password MySQL Anda

    // Metode untuk mendapatkan koneksi ke database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Memastikan driver MySQL dapat ditemukan
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Mencoba untuk mendapatkan koneksi
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (ClassNotFoundException e) {
            // Menangani jika driver JDBC tidak ditemukan
            System.out.println("Driver JDBC tidak ditemukan: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            // Menangani jika terjadi masalah koneksi database
            System.out.println("Koneksi gagal: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Contoh pemanggilan koneksi
        Connection connection = getConnection();
        if (connection != null) {
            try {
                // Pastikan koneksi ditutup setelah digunakan
                connection.close();
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}
