package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.text.DateFormatter;

import model.Absen;
import model.Karyawan;

public class AbsenService {

    public List<Absen> absens(Karyawan karyawan, boolean statusAbsen) {
        Absen absen = new Absen();
        absen.setAbsen(statusAbsen);
        karyawan.getAbsens().add(absen);
        return karyawan.getAbsens();
    }

    public void getAbsens(Karyawan karyawan, MenuService menuService) {
        menuService.getLine();
        System.out.println("Daftar hadir");
        menuService.getLine();
        System.out.println("|Waktu\t\t\t|Status");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<Absen> absens = karyawan.getAbsens();
        for (Absen absen : absens) {
            LocalDateTime timestamp = absen.getTimestamp().toLocalDateTime();
            String formattedDateTime = timestamp.format(formatter);
            String status = absen.isAbsen() ? "Hadir" : "Tidak hadir";
            System.out.println("|" + formattedDateTime + "\t|" + status);
        }
    }

}
