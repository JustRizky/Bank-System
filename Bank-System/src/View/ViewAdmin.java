package View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import Controller.Data.ControllerUser;
import Controller.LoginSystem.LoginSystemAdmins;
import Model.Json.ModelJsonUser;
import Model.Data.ModelUser;

public class ViewAdmin {

    private Scanner scanner;

    public ViewAdmin(ModelJsonUser modelUser) {
        this.scanner = new Scanner(System.in);
    }

    public void adminMenu() {
        System.out.println("=== Admin Menu ===");
        System.out.println("1. Buat Akun");
        System.out.println("2. Lihat Semua Data Nasabah");
        System.out.println("3. Update Data Nasabah");
        System.out.println("4. Hapus Nasabah");
        System.out.println("5. Cari Data Nasabah");
        System.out.println("6. Kembali");
        System.out.println("7. Keluar Program!");
        System.out.print("Masukkan Pilihan: ");
    }

    public void searchUser(ControllerUser controllerUser) {
    System.out.print("\033\143");
    System.out.println("=== Menu Cari Data Nasabah ===");
    System.out.print("Masukkan Kata Kunci: ");
    String keyword = scanner.nextLine();

    ArrayList<ModelUser> matchingUsers = new ArrayList<>();

    for (ModelUser user : controllerUser.getUsers()) {
        if (user.getNomorRekening().contains(keyword) ||
            user.getNamaUser().contains(keyword)) {
            matchingUsers.add(user);
        }
    }

    if (!matchingUsers.isEmpty()) {
        System.out.println("Data Ditemukan:");
        for (ModelUser matchingUser : matchingUsers) {
            System.out.println("ID: " + matchingUser.id);
            System.out.println("Nama Nasabah: " + matchingUser.namaUser);
            System.out.println("Nomor Rekening: " + matchingUser.nomorRekening);
            System.out.println("Pin: " + matchingUser.pin);
            System.out.println("Saldo: " + matchingUser.saldo);
            System.out.println("-------------------------");
        }
    } else {
        System.out.println("Data Tidak Ditemukan!");
    }
}


    public void loginAdmin(LoginSystemAdmins loginSystem) throws FileNotFoundException, IOException, ParseException {
        ControllerUser controllerUser = new ControllerUser();
        System.out.print("Masukkan Username: ");
        String usernameAdmin = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String passwordAdmin = scanner.nextLine();

        if (loginSystem.loginAdmins(usernameAdmin, passwordAdmin)) {
            System.out.println("Login Berhasil!");
            System.out.print("\033\143");
            int pilihan = 0;
            do {
                adminMenu();

                pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1:
                        System.out.print("\033\143");
                        System.out.println("=== Menu Tambah Nasabah ===");
                        System.out.print("Masukkan Nama Nasabah: ");
                        String addNamaNasabah = scanner.nextLine();
                        System.out.print("Masukkan Nomor Rekening: ");
                        String addNomorRekening = scanner.nextLine();
                        System.out.print("Masukkan Pin: ");
                        int addPin = scanner.nextInt();
                        controllerUser.addUser(addNamaNasabah, addNomorRekening, addPin);
                        controllerUser.commit();
                        break;
                    case 2:
                        System.out.println("=== Menu Lihat Data Nasabah ===");
                        controllerUser.getUsers().forEach((users) -> {
                            System.out.println("ID: " + users.id);
                            System.out.println("Nama Nasabah: " + users.namaUser);
                            System.out.println("Nomor Rekening: " + users.nomorRekening);
                            System.out.println("Pin: " + users.pin);
                            System.out.println("Saldo: " + users.saldo);
                        });
                        break;
                    case 3:
                        System.out.print("\033\143");
                        System.out.println("=== Menu Update Data Nasabah ===");
                        System.out.println("Masukkan Nomor Rekening: ");
                        String updateNomorRekening = scanner.nextLine();
                        System.out.println("Masukkan Nama Terbaru: ");
                        String updateUserName = scanner.nextLine();
                        System.out.println("Masukkan Pin Terbaru: ");
                        int updatePin = scanner.nextInt();
                        Boolean updateNasabah = controllerUser.updateUser(updateUserName, updateNomorRekening,
                                updatePin);
                        if (updateNasabah) {
                            System.out.println("Update Berhasil!");
                            controllerUser.commit();
                        } else {
                            System.out.println("Update Gagal!");
                        }
                        break;
                    case 4:
                        System.out.print("\033\143");
                        System.out.println("=== Menu Hapus Nasabah ===");
                        System.out.println("Masukkan Nomor Rekening: ");
                        String deleteNomorRekening = scanner.nextLine();
                        boolean deleted = controllerUser.deleteUser(deleteNomorRekening);
                        if (deleted) {
                            System.out.println("Hapus Berhasil!");
                            controllerUser.commit();
                        } else {
                            System.out.println("Hapus Gagal!");
                        }
                        break;
                    case 5:
                        searchUser(controllerUser);
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println("Program Selesai!");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan Tidak Ada!");
                        break;
                }
            } while (pilihan != 6);
        } else {
            System.out.println("Login Gagal!");
        }
    }
}
