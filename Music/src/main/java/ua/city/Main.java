package ua.city;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Створення об'єктів DAO
        GenreExp genreExp = new GenreExp();
        MusicBandExp musicBandExp = new MusicBandExp();
        SongExp songExp = new SongExp();

        // Приклад додавання жанру
        Genre genre = new Genre();
        genre.setGenreName("Industrial Metal");
        int genreId = genreExp.addGenre(genre);
        genre.setGenreId(genreId);

        if (genreId > 0) {
            System.out.println("Жанр додано: " + genre);
        } else {
            System.out.println("Помилка: не вдалося додати жанр.");
        }

        // Приклад додавання музичного гурту
        MusicBand musicBand = new MusicBand();
        musicBand.setBandName("Rammstein");
        int bandId = musicBandExp.addMusicBand(musicBand);
        musicBand.setBandId(bandId);

        if (bandId > 0) {
            System.out.println("Музичний гурт додано: " + musicBand);
        } else {
            System.out.println("Помилка: не вдалося додати музичний гурт.");
        }

        // Приклад додавання пісні
        Song song = new Song();
        song.setSongName("Zick Zack");
        song.setSongDuration("00:04:05");
        int songId = songExp.addSong(song);
        song.setSongId(songId);

        if (songId > 0) {
            System.out.println("Пісню додано: " + song);
        } else {
            System.out.println("Помилка: не вдалося додати пісню.");
        }

        // Виведення всіх жанрів
        System.out.println("\nСписок жанрів:");
        List<Genre> genres = genreExp.getAllGenres();
        for (Genre g : genres) {
            System.out.println("ID: " + g.getGenreId() + ", Назва: " + g.getGenreName());
        }

        // Виведення всіх музичних гуртів
        System.out.println("\nСписок музичних гуртів:");
        List<MusicBand> musicBands = musicBandExp.getAllMusicBands();
        for (MusicBand b : musicBands) {
            System.out.println("ID: " + b.getBandId() + ", Назва: " + b.getBandName());
        }

        // Виведення всіх пісень
        System.out.println("\nСписок пісень:");
        List<Song> songs = songExp.getAllSongs();
        for (Song s : songs) {
            System.out.println("ID: " + s.getSongId() + ", Назва: " + s.getSongName() + ", Тривалість: " + s.getSongDuration());
        }
    }
}
