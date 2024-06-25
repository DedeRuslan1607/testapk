package service;

import java.util.Scanner;

import model.Karyawan;
import repository.RepositoryKaryawan;

public class MenuService {

    private Scanner scanner;
    private Scanner scanner2;
    private Scanner scanner3;

    private KaryawanService karyawanService;
    private AbsenService absenService;

    private Karyawan selecteKaryawan;

    public MenuService() {
        this.scanner = new Scanner(System.in);
        this.scanner2 = new Scanner(System.in);
        this.scanner3 = new Scanner(System.in);

        this.karyawanService = new KaryawanService(new RepositoryKaryawan());
        this.absenService = new AbsenService();
        getLine();
        getTagLine();
    }

    public void getLine() {
        System.err.println("========================================================================");
    }

    public void getTagLine() {
        System.out.println("Selamat datang di perusahaan kami");
        auth();
    }

    public void auth() {
        boolean validChoice = false;
        do {
            System.out.println("Apakah kamu sudah punya akun?");
            System.out.println("1. Ya");
            System.out.println("2. Tidak");
            System.out.print("Pilihan : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // login
                    boolean isLogin = false;
                    do {
                        System.out.print("Masukan Username : ");
                        String username = scanner.next();
                        System.out.print("Masukan Password : ");
                        String password = scanner.next();
                        Karyawan karyawan = karyawanService.login(username, password);
                        if (karyawan != null) {
                            isLogin = true;
                            validChoice = true;
                            selecteKaryawan = karyawan;
                            dashboard();
                        } else {
                            System.out.println("Username atau Password salah");
                            isLogin = false;
                        }
                    } while (!isLogin);
                    break;
                case 2:
                    // register
                    this.getLine();
                    System.out.println("Register");
                    this.getLine();
                    int role = 0;
                    do {
                        System.out.println("Silahkan pilih role");
                        System.out.println("1 . Manager");
                        System.out.println("2 . Ob");
                        role = scanner2.nextInt();
                        if (role == 1) {
                            System.out.print("Masukan Username : ");
                            String username = scanner.next();
                            System.out.print("Masukan Name : ");
                            String name = scanner.next();
                            System.out.print("Masukan Password : ");
                            String password = scanner3.next();
                            System.out.print("Masukan Umur kamu : ");
                            int age = scanner2.nextInt();
                            System.out.print("Masukan Tunjangan : ");

                            int tunjanagan = scanner2.nextInt();
                            System.out.print("Masukan Gaji : ");
                            int gaji = scanner2.nextInt();
                            Karyawan karyawan = karyawanService.registerManager(username, password, age, tunjanagan,
                                    gaji,
                                    name);
                            if (karyawan != null) {
                                System.out.println("berhasil registrasi silahkan login");
                                role = 0;
                                validChoice = false;

                                break;
                            } else {
                                System.out.println("Gagal registrasi terjadi kesalahan");
                            }
                        } else if (role == 2) {
                            System.out.print("Masukan Username : ");
                            String username = scanner.next();
                            System.out.print("Masukan Name : ");
                            String name = scanner.next();
                            System.out.print("Masukan Password : ");
                            String password = scanner3.next();
                            System.out.print("Masukan Umur kamu : ");
                            int age = scanner2.nextInt();
                            System.out.print("Apakah kamu lembur 1 / 0 : ");
                            int lembur = scanner2.nextInt();
                            System.out.print("Masukan Gaji : ");
                            int gaji = scanner2.nextInt();
                            Karyawan registerOb = karyawanService.registerOb(username, password, age, gaji, name,
                                    lembur == 1 ? true : false);
                            if (registerOb != null) {
                                System.out.println("berhasil registrasi silahkan login");
                                role = 0;
                                validChoice = false;
                                break;
                            } else {
                                System.out.println("Gagal registrasi terjadi kesalahan");
                            }
                            validChoice = false;
                        }
                    } while (role > 2);
                    validChoice = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    // Panggil metode atau lakukan tindakan sesuai dengan kebutuhan Anda
                    break;
            }
        } while (!validChoice);
    }

    public void dashboard() {
        this.getLine();
        System.out.println("Dashboard");
        this.getLine();
        System.out.println("Halo " + selecteKaryawan.getName());
        int menu = 0;
        do {

            System.out.println("Menu");
            System.out.println("1. Lihat Biodata");
            System.out.println("2. Lihat Gaji");
            System.out.println("3. Lihat Absensi");
            System.out.println("4. Lakukan Absensi");
            System.out.println("5. Logout");
            System.out.print("Menu : ");
            menu = scanner2.nextInt();

            switch (menu) {
                case 1:
                    karyawanService.showDataLogin(selecteKaryawan, this);
                    menu = 10000;
                    break;
                case 2:
                    karyawanService.showGaji(selecteKaryawan, this);
                    menu = 10000;
                    break;
                case 3:
                    absenService.getAbsens(selecteKaryawan, this);
                    menu = 10000;

                    break;
                case 4:
                    System.out.print("Apakah kamu hadir ? 1/0 : ");
                    int absen = scanner2.nextInt();
                    absenService.absens(selecteKaryawan, absen == 1 ? true : false);
                    System.out.println("Sukses absensi");
                    menu = 10000;

                    break;
                case 5:
                    System.out.println("Logout . . .");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (menu > 5);
    }
}
