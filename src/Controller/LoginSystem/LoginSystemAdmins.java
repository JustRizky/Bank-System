package Controller.LoginSystem;

import java.util.ArrayList;
import java.util.List;

import Model.ModelAdminAuth;

public class LoginSystemAdmins {
    private List<ModelAdminAuth> admins;

    public LoginSystemAdmins() {
        admins = new ArrayList<>();
        admins.add(new ModelAdminAuth("admin", "admin"));
    }

    public boolean loginAdmins(String usernameAdmin, String passwordAdmin) {
        for (ModelAdminAuth admin : admins) {
            if (admin.getUsernameAdmin().equals(usernameAdmin) && admin.getPasswordAdmin().equals(passwordAdmin)) {
                return true;
            }
        }
        return false;
    }
}