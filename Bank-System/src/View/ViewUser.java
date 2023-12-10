package View;

import java.util.Scanner;

import Controller.LoginSystem.LoginSystemUsers;
import Model.ModelUser;

public class ViewUser {
    private Scanner scanner;

    public ViewUser(ModelUser modelUser) {
        this.scanner = new Scanner(System.in);
    }

    public void userMenu() {
        System.out.println("=== User Menu ===");
        System.out.println("1. Tarik Tunai");
        System.out.println("2. Setor");
        System.out.println("3. Cek Saldo");
        System.out.println("4. Transfer");
        System.out.println("5. Kembali");
        System.out.println("6. Keluar Program!");
        System.out.println("Masukkan Pilihan: ");
    }

    public void loginUser(LoginSystemUsers loginSystem) {
        System.out.println("Masukkan Nomor Rekening: ");
        String usernameUser = scanner.nextLine();
        System.out.println("Masukkan Pin: ");
        String passwordUser = scanner.nextLine();

        if (loginSystem.LoginUsers(usernameUser, passwordUser)) {
            System.out.println("Login Berhasil!");
            userMenu();

            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1 -> System.out.println("Create");
                case 2 -> System.out.println("Lihat Akun");
                case 3 -> System.out.println("Update Akun");
                case 4 -> System.out.println("Hapus Akun");
                case 5 -> System.out.println("Kembali");
                case 6 -> System.out.println("Exit");
                default -> System.out.println("Pilihan Tidak Ada!");
            }
        } else {
            System.out.println("Login Gagal!");
        }
    }
}
