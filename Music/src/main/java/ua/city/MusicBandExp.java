package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicBandExp {

	// Метод для додавання нової музичної групи
	public int addMusicBand(MusicBand musicBand) {
		String sql = "INSERT INTO band (bandName) VALUES (?)";
		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, musicBand.getBandName());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Метод для отримання музичної групи за ID
	public MusicBand getMusicBandById(int bandId) throws SQLException {
		String sql = "SELECT * FROM band WHERE band_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, bandId); // Встановлюємо значення band_id
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new MusicBand(rs.getInt("band_id"), rs.getString("bandName"));
			}
		}
		return null;
	}

	// Метод для оновлення назви музичної групи
	public boolean updateMusicBand(int bandId, String newBandName) throws SQLException {
		String sql = "UPDATE band SET bandName = ? WHERE band_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, newBandName);
			stmt.setInt(2, bandId);
			int rowsAffected = stmt.executeUpdate();

			return rowsAffected > 0; // Повертаємо true, якщо оновлення успішне
		}
	}

	// Метод для отримання всіх музичних груп
	public List<MusicBand> getAllMusicBands() throws SQLException {
		List<MusicBand> musicBands = new ArrayList<>();
		String sql = "SELECT * FROM band";

		try (Connection conn = DatabaseControl.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				musicBands.add(new MusicBand(rs.getInt("band_id"), rs.getString("bandName")));
			}
		}
		return musicBands;
	}

	// Метод для видалення музичної групи за ID
	public boolean deleteMusicBand(int bandId) throws SQLException {
		String sql = "DELETE FROM band WHERE band_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, bandId);
			int rowsAffected = stmt.executeUpdate();

			return rowsAffected > 0; // Повертаємо true, якщо видалення успішне
		}
	}
}
