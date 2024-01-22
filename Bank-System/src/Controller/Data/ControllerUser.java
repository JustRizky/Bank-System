package Controller.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import Controller.Json.ControllerJsonUser;
import Model.Data.ModelUser;

public class ControllerUser {
    private static ArrayList<ModelUser> users;
    private ControllerJsonUser controllerJsonUser;

    public ControllerUser() throws FileNotFoundException, IOException, ParseException {
        users = new ArrayList<>();
        controllerJsonUser = new ControllerJsonUser();
        loadUsers();
    }

    public void loadUsers() throws FileNotFoundException, IOException, ParseException {
        users = controllerJsonUser.readFromFile();
    }

    public static ArrayList<ModelUser> getUsers() {
        return users;
    }

    private int getLastKode() {
        int lastKode = users.size() - 1;
        return users.get(lastKode).id;
    }

    public void addUser(String namaUser, String nomorRekening, int pin) {
        int kodeUser = getLastKode() + 1;
        ModelUser user = new ModelUser(kodeUser, namaUser, nomorRekening, pin);
        users.add(user);
    }

    public ModelUser getUser(String nomorRekening) {
        ModelUser user1 = null;
        for (ModelUser user : users) {
            if (user.nomorRekening.equals(nomorRekening)) {
                return user;
            }
        }
        return user1;
    }

    public boolean updateUser(String namaUser, String nomorRekening, int pin) {
        ModelUser user2 = getUser(nomorRekening);
        if (user2 != null) {
            user2.namaUser = namaUser;
            user2.nomorRekening = nomorRekening;
            user2.pin = pin;
            return true;
        }
        return false;
    }

    public boolean deleteUser(String nomerRekening) {
        ModelUser user3 = getUser(nomerRekening);
        if (user3 != null) {
            users.remove(user3);
            return true;
        }
        return false;
    }

    public void commit() throws IOException {
        controllerJsonUser.writeFileJSON(users);
    }
    
}
