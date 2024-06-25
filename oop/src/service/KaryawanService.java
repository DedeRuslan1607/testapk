package service;

import java.util.List;

import model.Absen;
import model.Karyawan;
import model.Manager;
import model.Ob;
import repository.RepositoryKaryawan;
import repository.RepositoryKaryawanInterface;

public class KaryawanService {

    private RepositoryKaryawanInterface repositoryKaryawanInterface;

    public KaryawanService(RepositoryKaryawan repositoryKaryawan) {
        this.repositoryKaryawanInterface = repositoryKaryawan;
    }

    public Karyawan registerManager(String username, String password, int age, int tunjanagan, int gaji, String name) {
        Manager manager = new Manager();
        manager.setAge(age);
        manager.setUsername(username);
        manager.setPassword(password);
        manager.setName(name);
        manager.setTunjangan(tunjanagan);
        manager.setGaji(gaji);
        return repositoryKaryawanInterface.registerManager(manager);
    }

    public Karyawan registerOb(String username, String password, int age, int gaji, String name, boolean lembur) {
        Ob ob = new Ob();
        ob.setAge(age);
        ob.setUsername(username);
        ob.setPassword(password);
        ob.setName(name);
        ob.setLembur(lembur);
        if (lembur) {
            ob.setGaji(gaji + 2000);
        } else {
            ob.setGaji(gaji);
        }
        return repositoryKaryawanInterface.registerOb(ob);
    }

    public List<Karyawan> findAllKaryawan() {
        return this.repositoryKaryawanInterface.findKaryawans();
    }

    public Karyawan login(String username, String password) {
        List<Karyawan> allKaryawan = this.findAllKaryawan();
        for (Karyawan karyawan : allKaryawan) {
            if (karyawan != null) {
                if (karyawan.getUsername().equals(username) && karyawan.getPassword().equals(password)) {
                    return karyawan;
                }
            }
        }
        return null;
    }

    public void showDataLogin(Karyawan karyawan, MenuService menuService) {
        menuService.getLine();
        if (karyawan instanceof Manager) {
            System.out.println("1.Name\t\t: " + karyawan.getName());
            System.out.println("2.Username\t: " + karyawan.getUsername());
            System.out.println("3.Jabatan\t: Manager ");
            menuService.getLine();
            System.out.println("Jumlah Hadir : " + this.hitngHadir(karyawan));
            System.out.println("Jumlah Alpha : " + this.hitungAlpa(karyawan));
        } else {
            System.out.println("1.Name\t\t: " + karyawan.getName());
            System.out.println("2.Username\t: " + karyawan.getUsername());
            System.out.println("3.Jabatan\t: Ob ");
            menuService.getLine();
            System.out.println("Jumlah Hadir" + this.hitngHadir(karyawan));
            System.out.println("Jumlah Alpha" + this.hitungAlpa(karyawan));
        }
    }

    // ini untuk menghitung alfa dari karyawan
    private long hitungAlpa(Karyawan karyawan) {
        long jumlahTidakHadir = karyawan.getAbsens()
                .stream()
                .filter(absen -> !absen.isAbsen()) // Menyaring hanya yang bernilai false
                .count(); // Menghitung jumlahnya
        return jumlahTidakHadir;
    }

    private long hitngHadir(Karyawan karyawan) {
        long jumlahTidakHadir = karyawan.getAbsens()
                .stream()
                .filter(Absen::isAbsen) // Menyaring hanya yang bernilai false
                .count(); // Menghitung jumlahnya
        return jumlahTidakHadir;
    }

    public void showGaji(Karyawan karyawan, MenuService menuService) {
        menuService.getLine();
        if (karyawan instanceof Manager eManager) {
            int total = eManager.getGaji() + eManager.getTunjangan();
            System.out.println("Total Gaji : " + total);
        } else if (karyawan instanceof Ob ob) {
            int total = ob.getGaji();
            System.out.println("Total Gaji : " + total);
        }
    }

}
