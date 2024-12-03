package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicBandExp {
    // Insert (Create)
    public void insertMusicBand(String bandName) {
        String sql = "INSERT INTO music_band2 (bandName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bandName);
            pstmt.executeUpdate();
            System.out.println("Music band inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllMusicBands() {
        String sql = "SELECT * FROM band";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("band_id") +
                        ", Name: " + rs.getString("bandName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateMusicBand(int bandId, String newBandName) {
        String sql = "UPDATE band SET bandName = ? WHERE band_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newBandName);
            pstmt.setInt(2, bandId);
            pstmt.executeUpdate();
            System.out.println("Music band updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteMusicBand(int bandId) {
        String sql = "DELETE FROM band WHERE band_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bandId);
            pstmt.executeUpdate();
            System.out.println("Music band deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
