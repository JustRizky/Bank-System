package Controller.LoginSystem;

import java.util.ArrayList;
import java.util.List;

import Model.ModelUserAuth;

public class LoginSystemUsers {
    private List<ModelUserAuth> users;

    public LoginSystemUsers() {
        users = new ArrayList<>();
        users.add(new ModelUserAuth("07606", "07606"));
    }

    public boolean LoginUsers(String nomorRekening, String pin) {
        for (ModelUserAuth user : users) {
            if (user.getNomorRekening().equals(nomorRekening) && user.getPin().equals(pin)) {
                return true;
            }
        }
        return false;
    }

}
