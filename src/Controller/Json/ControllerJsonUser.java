package Controller.Json;

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

import Model.Data.ModelUser;
import Model.Json.ModelJsonUser;

public class ControllerJsonUser {
    String fname = "src/DB/DBUser.json";

    public JSONArray convertArrayListToJSON(ArrayList<ModelUser> listUser) {
        if (listUser == null) {
            return null;
        } else {
            JSONArray arrayUser = new JSONArray();
            ModelJsonUser modelJsonUser = new ModelJsonUser();
            for (ModelUser user : listUser) {
                JSONObject objUser = new JSONObject();
                objUser.put(modelJsonUser.pk, user.pk);
                objUser.put(modelJsonUser.namaUser, user.namaUser);
                objUser.put(modelJsonUser.nomorRekening, user.nomorRekening);
                objUser.put(modelJsonUser.pin, user.pin);
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
            ModelJsonUser nodeJSONUser = new ModelJsonUser();
            for (Object objUser : arrayUser) {
                JSONObject user = (JSONObject) objUser;
                int pk = Integer.parseInt(user.get(nodeJSONUser.pk).toString());
                String namaUser = user.get(nodeJSONUser.namaUser).toString();
                String nomorRekening = user.get(nodeJSONUser.nomorRekening).toString();
                int pin = Integer.parseInt(user.get(nodeJSONUser.pin).toString());
                listUser.add(new ModelUser(pk, namaUser, nomorRekening, pin));
            }
            return listUser;
        }
    }

    public void writeFileJSON(ArrayList<ModelUser> listUser) throws IOException {
        JSONArray arrayUser = convertArrayListToJSON(listUser);
        FileWriter file = new FileWriter(fname);
        file.write(arrayUser.toJSONString());
        file.flush();
        file.close();
    }

    public ArrayList<ModelUser> readFromFile() throws IOException, ParseException, FileNotFoundException {
        ArrayList listUser;
        JSONParser parser = new JSONParser();

        Reader reader = new FileReader(fname);
        JSONArray arrayUser = (JSONArray) parser.parse(reader);
        listUser = convertJSONToArrayList(arrayUser);
        return listUser;
    }
}
