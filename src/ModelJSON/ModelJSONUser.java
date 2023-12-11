package ModelJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import NodeData.NodeUser;
import NodeJSON.NodeJSONUser;

public class ModelJSONUser {
    String fname = "src/DB/DBUser.json";

    public JSONArray convertArrayListToJSON(ArrayList<NodeUser> listUser) {
        if (listUser == null) {
            return null;
        } else {
            JSONArray arrayUser = new JSONArray();
            NodeJSONUser nodeJSONUser = new NodeJSONUser();
            for (NodeUser user : listUser) {
                JSONObject objUser = new JSONObject();
                objUser.put(nodeJSONUser.pk, user.pk);
                objUser.put(nodeJSONUser.namaUser, user.namaUser);
                objUser.put(nodeJSONUser.nomorRekening, user.nomorRekening);
                objUser.put(nodeJSONUser.pin, user.pin);
                arrayUser.add(objUser);
            }
            return arrayUser;
        }
    }

    public ArrayList convertJSONToArrayList(JSONArray arrayUser) {
        if (arrayUser == null) {
            return null;
        } else {
            ArrayList listUser = new ArrayList<>();
            NodeJSONUser nodeJSONUser = new NodeJSONUser();
            for (Object objUser : arrayUser) {
                JSONObject user = (JSONObject) objUser;
                int pk = Integer.parseInt(user.get(nodeJSONUser.pk).toString());
                String namaUser = user.get(nodeJSONUser.namaUser).toString();
                String nomorRekening = user.get(nodeJSONUser.nomorRekening).toString();
                int pin = Integer.parseInt(user.get(nodeJSONUser.pin).toString());
                listUser.add(new NodeUser(pk, namaUser, nomorRekening, pin));
            }
            return listUser;
        }
    }

    public void writeFileJSON(ArrayList<NodeUser> listUser) throws IOException {
        JSONArray arrayUser = convertArrayListToJSON(listUser);
        FileWriter file = new FileWriter(fname);
        file.write(arrayUser.toJSONString());
        file.flush();
        file.close();
    }

    public ArrayList<NodeUser> readFromFile() throws IOException, ParseException, FileNotFoundException {
        ArrayList listUser;
        JSONParser parser = new JSONParser();

        Reader reader = new FileReader(fname);
        JSONArray arrayUser = (JSONArray) parser.parse(reader);
        listUser = convertJSONToArrayList(arrayUser);
        return listUser;
    }
}
