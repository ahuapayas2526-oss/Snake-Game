package form;

import java.sql.*;
import java.time.LocalDateTime;

public class GuardarPartides {

    private static final String URL = "jdbc:mysql://localhost:3306/Snake";
    private static final String USER = "SnakeGame";
    private static final String PASS = "SnakeGame";

    // 🔹 Obtener o crear usuario
    public static int obtenerOCrearUsuario(String usuari) {

        int idUsuari = -1;

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            // Buscar usuario
            String select = "SELECT idUsuari FROM usuaris WHERE nomUsuari = ?";
            try (PreparedStatement ps = con.prepareStatement(select)) {
                ps.setString(1, usuari);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getInt("idUsuari");
                }
            }

            // Insertar usuario
            String insert = "INSERT INTO usuaris (nomUsuari) VALUES (?)";
            try (PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, usuari);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idUsuari = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idUsuari;
    }

    // 🔹 Guardar partida
    public static void guardarPartida(int idUsuari, int puntuacio, int duracio) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String sql = "INSERT INTO partides (puntuacio, dataPartida, duracio, idUsuari) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, puntuacio);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(3, duracio);
                ps.setInt(4, idUsuari);

                ps.executeUpdate();
                System.out.println("Partida guardada");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}