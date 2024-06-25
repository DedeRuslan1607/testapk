package model;

import java.sql.Timestamp;

/**
 * Absen
 */
public class Absen {

    private boolean absen;
    private Timestamp timestamp;

    public Absen() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public boolean isAbsen() {
        return absen;
    }

    public void setAbsen(boolean absen) {
        this.absen = absen;
    }

}