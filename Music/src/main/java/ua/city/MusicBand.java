package ua.city;

public class MusicBand {
    private int bandId;
    private String bandName;

    // Конструктор за замовчуванням
    public MusicBand() {
    }

    // Конструктор з параметрами
    public MusicBand(int bandId, String bandName) {
        this.bandId = bandId;
        this.bandName = bandName;
    }

    // Геттери та сеттери
    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
