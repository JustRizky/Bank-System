package Controller.LoginSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import ModelJSON.ModelJSONUser;
import NodeData.NodeUser;

public class LoginSystemUsers {
    private ModelJSONUser modelJSONUser = new ModelJSONUser();
    private List<NodeUser> users;

    public LoginSystemUsers() throws FileNotFoundException, IOException, ParseException {
        users = modelJSONUser.readFromFile();
    }

    public boolean LoginUsers(String nomorRekening, int pin) {
        for (NodeUser user : users) {
            if (user.getNomorRekening().equals(nomorRekening) && user.getPin() == (pin)) {
                return true;
            }
        }
        return false;
    }

}