package Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import ModelJSON.ModelJSONUser;
import NodeData.NodeUser;

public class ModelUser {
    private ArrayList<NodeUser> users;
    private ModelJSONUser modelJSONUser;

    public ModelUser() throws FileNotFoundException, IOException, ParseException {
        users = new ArrayList<>();
        modelJSONUser = new ModelJSONUser();
        loadUsers();
    }

    public void loadUsers() throws FileNotFoundException, IOException, ParseException {
        users = modelJSONUser.readFromFile();
    }

    public ArrayList<NodeUser> getUsers() {
        return users;
    }

    private int getLastKode() {
        int lastKode = users.size() - 1;
        return users.get(lastKode).pk;
    }

    public void addUser(String namaUser, String nomorRekening, String pin) {
        int kodeUser = getLastKode() + 1;
        NodeUser user = new NodeUser(kodeUser, namaUser, nomorRekening, pin);
        users.add(user);
    }

    public NodeUser getUsers(String nomorRekening) {
        NodeUser user1 = null;
        for (NodeUser user : users) {
            if (user.nomorRekening == nomorRekening) {
                return user;
            }
        }
        return user1;
    }

    public boolean updateUsers(String nomerRekening, String namaUser, String pin) {
        NodeUser user2 = getUsers(nomerRekening);
        if (user2 != null) {
            user2.namaUser = namaUser;
            user2.nomorRekening = nomerRekening;
            user2.pin = pin;
            return true;
        }
        return false;
    }

    public boolean deleteUser(String nomerRekening) {
        NodeUser user3 = getUsers(nomerRekening);
        if (user3 != null) {
            users.remove(user3);
            return true;
        }
        return false;
    }

    public void commit() throws IOException {
        modelJSONUser.writeFileJSON(users);
    }
}
