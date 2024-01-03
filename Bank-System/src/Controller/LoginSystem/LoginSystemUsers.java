package Controller.LoginSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import Controller.Json.ControllerJsonUser;
import Model.Data.ModelUser;

public class LoginSystemUsers {
    private ControllerJsonUser modelJSONUser = new ControllerJsonUser();
    private List<ModelUser> users;

    public LoginSystemUsers() throws FileNotFoundException, IOException, ParseException {
        users = modelJSONUser.readFromFile();
    }

    public boolean LoginUsers(String nomorRekening, int pin) {
        for (ModelUser user : users) {
            if (user.getNomorRekening().equals(nomorRekening) && user.getPin() == (pin)) {
                return true;
            }
        }
        return false;
    }

}