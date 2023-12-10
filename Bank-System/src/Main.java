import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import Controller.LoginSystem.LoginSystemAdmins;
import Controller.LoginSystem.LoginSystemUsers;
import Model.ModelUser;
import View.ViewAdmin;
import View.ViewUser;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        ModelUser modelUser = new ModelUser();
        LoginSystemAdmins loginSystemAdmins = new LoginSystemAdmins();
        LoginSystemUsers loginSystemUsers = new LoginSystemUsers();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Bank System");
            System.out.println("1. Login Admin");
            System.out.println("2. Login User");
            System.out.println("3. Exit");
            System.out.println("Masukkan Pilihan: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    ViewAdmin viewAdmin = new ViewAdmin(modelUser);
                    viewAdmin.loginAdmin(loginSystemAdmins);
                    break;
                case 2:
                    ViewUser viewUser = new ViewUser(modelUser);
                    viewUser.loginUser(loginSystemUsers);
                    break;
                case 3:
                    System.out.println("Program Selesai!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan Tidak Ada!");
            }
        }
    }
}
