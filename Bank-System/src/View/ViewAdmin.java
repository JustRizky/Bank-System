package View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import Controller.LoginSystem.LoginSystemAdmins;
import Model.ModelUser;

public class ViewAdmin {

    private Scanner scanner;

    public ViewAdmin(ModelUser modelUser) {
        this.scanner = new Scanner(System.in);
    }

    public void adminMenu() {
        System.out.println("=== Admin Menu ===");
        System.out.println("1. Buat Akun");
        System.out.println("2. Lihat Semua Akun");
        System.out.println("3. Update Akun");
        System.out.println("4. Hapus Akun");
        System.out.println("5. Kembali");
        System.out.println("6. Keluar Program!");
        System.out.println("Masukkan Pilihan: ");
    }

    public void loginAdmin(LoginSystemAdmins loginSystem) throws FileNotFoundException, IOException, ParseException {
        ModelUser modelUser = new ModelUser();
        System.out.println("Masukkan Username: ");
        String usernameAdmin = scanner.nextLine();
        System.out.println("Masukkan Password");
        String passwordAdmin = scanner.nextLine();

        if (loginSystem.loginAdmins(usernameAdmin, passwordAdmin)) {
            System.out.println("Login Berhasil!");
            System.out.print("\033\143");
            adminMenu();

            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:

                    System.out.println("Masukkan Nama Nasabah: ");
                    String namaNasabah = scanner.nextLine();
                    System.out.println("Masukkan Nomor Rekening: ");
                    String nomorRekening = scanner.nextLine();
                    System.out.println("Masukkan Pin: ");
                    String pin = scanner.nextLine();
                    modelUser.addUser(namaNasabah, nomorRekening, pin);
                    modelUser.commit();
                    break;
                case 2:
                    modelUser.getUsers().forEach((users) -> {
                        System.out.println("Pk: " + users.pk);
                        System.out.println("Nama Nasabah: " + users.namaUser);
                        System.out.println("Nomor Rekening: " + users.nomorRekening);
                        System.out.println("Pin: " + users.pin);
                    });
                    break;
                case 3:
                    break;
            }
        } else {
            System.out.println("Login Gagal!");
        }
    }
}
