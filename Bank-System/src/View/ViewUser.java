package View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import Controller.Data.ControllerTransaksi;
import Controller.LoginSystem.LoginSystemUsers;
import Model.Data.ModelUser;
import Model.Json.ModelJsonUser;

public class ViewUser {
    private Scanner scanner;

    public ViewUser(ModelJsonUser modelUser) {
        this.scanner = new Scanner(System.in);
    }

    public void userMenu() {
        System.out.println("=== User Menu ===");
        System.out.println("1. Tarik Tunai");
        System.out.println("2. Setor");
        System.out.println("3. Transfer");
        System.out.println("4. Cek Saldo");
        System.out.println("5. Kembali");
        System.out.println("6. Keluar Program!");
        System.out.print("Masukkan Pilihan: ");
    }

    public void loginUser(LoginSystemUsers loginSystem) throws FileNotFoundException, IOException, ParseException {
        ControllerTransaksi controllerTransaksi = new ControllerTransaksi();
        System.out.print("Masukkan Nomor Rekening: ");
        String usernameUser = scanner.nextLine();
        System.out.print("Masukkan Pin: ");
        int passwordUser = scanner.nextInt();

        ModelUser user = controllerTransaksi.getUser(usernameUser);

        if (loginSystem.LoginUsers(usernameUser, passwordUser)) {
            System.out.println("Login Berhasil!");
            userMenu();

            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("\033\143");
                    System.out.println("=== Menu Tarik Tunai Nasabah ===");
                    System.out.print("Masukkan Jumlah Tarik Tunai: ");
                    double jumlahTarik = scanner.nextDouble();
                    controllerTransaksi.tarikTunai(user, jumlahTarik);
                    if (user != null && controllerTransaksi.tarikTunai(user, jumlahTarik)) {
                        System.out.println("Tarik Tunai Berhasil!");
                    } else {
                        System.out.println("Gagal Melakukan Tarik Tunai!");
                    }
                    break;
                case 2:
                    System.out.print("\033\143");
                    System.out.println("=== Menu Setor ===");
                    System.out.print("Masukkan Jumlah Setor: ");
                    double jumlahSetor = scanner.nextDouble();
                    if (user != null && controllerTransaksi.setor(user, jumlahSetor)) {
                        System.out.println("Setor Berhasil!");
                    } else {
                        System.out.println("Gagal Melakukan Setor");
                    }
                    break;
                case 3:
                    System.out.print("\033\143");
                    System.out.println("=== Menu Tranfer ===");
                    System.out.print("Masukkan Nomor Rekening Penerima: ");
                    String nomorRekeningPenerima = scanner.nextLine();
                    System.out.print("Masukkan Jumlah Transfer: ");
                    double jumlahTransfer = scanner.nextDouble();
                    ModelUser penerima = controllerTransaksi.getUser(nomorRekeningPenerima);
                    if (user != null && penerima != null
                            && controllerTransaksi.transfer(user, penerima, jumlahTransfer)) {
                        System.out.println("Transfer Berhasil!");
                    } else {
                        System.out.println("Gagal Melakukan Transfer!");
                    }
                    break;
                case 4:
                    System.out.print("\033\143");
                    System.out.println("=== Menu Cek Saldo ===");
                    if (user != null) {
                        System.out.println("Saldo Anda Saat Ini: " + user.getSaldo());
                    } else {
                        System.out.println("Nomor Rekening Tidak Valid!");
                    }
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Exit!");
                    System.exit(0);
            }
        } else {
            System.out.println("Login Gagal!");
        }

    }

}
