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

import Model.Data.ModelTransaksi;
import Model.Json.ModelJsonTransaksi;
import Model.Json.ModelJsonUser;

public class ControllerJsonTransaksi {
    String fname = "src/DB/DBTransaksi.json";

    public JSONArray convertArrayListToJSON(ArrayList<ModelTransaksi> listTransaksi) {
        if (listTransaksi == null) {
            return null;
        } else {
            JSONArray arrayTransaksi = new JSONArray();
            ModelJsonTransaksi modelJsonTransaksi = new ModelJsonTransaksi();
            for (ModelTransaksi transaksi : listTransaksi) {
                JSONObject objTransaksi = new JSONObject();
                objTransaksi.put(modelJsonTransaksi.getId(), transaksi.getId());
                objTransaksi.put(modelJsonTransaksi.getPengirim().getId(), transaksi.getPengirim().getId());
                objTransaksi.put(modelJsonTransaksi.getPenerima().getId(), transaksi.getPenerima().getId());
                objTransaksi.put(modelJsonTransaksi.getJumlah(), transaksi.getJumlah());
                objTransaksi.put(modelJsonTransaksi.getTanggal(), transaksi.getTanggal());
                arrayTransaksi.add(objTransaksi);
            }
            return arrayTransaksi;
        }
    }

    public ArrayList<ModelTransaksi> convertJSONToArrayList(JSONArray arrayTransaksi) {
        if (arrayTransaksi == null) {
            return null;
        } else {
            ArrayList<ModelTransaksi> listTransaksi = new ArrayList<>();
            ModelJsonTransaksi modelJsonTransaksi = new ModelJsonTransaksi();
            for (Object objTransaksi : arrayTransaksi) {
                JSONObject transaksi = (JSONObject) objTransaksi;
                int id = Integer.parseInt(transaksi.get(modelJsonTransaksi.getId()).toString());
                ModelJsonUser pengirim = (ModelJsonUser) transaksi.get(modelJsonTransaksi.getPengirim().getId());
                ModelJsonUser penerima = (ModelJsonUser) transaksi.get(modelJsonTransaksi.getPenerima().getId());
                double jumlah = Double.parseDouble(transaksi.get(modelJsonTransaksi.getJumlah()).toString());
                listTransaksi.add(new ModelTransaksi(id, pengirim, penerima, jumlah));
            }
            return listTransaksi;
        }
    }

    public void writeFileJSON(ArrayList<ModelTransaksi> listTransaksi) throws IOException {
        JSONArray arrayTransaksi = convertArrayListToJSON(listTransaksi);
        FileWriter file = new FileWriter(fname);
        file.write(arrayTransaksi.toJSONString());
        file.flush();
        file.close();
    }

    public ArrayList<ModelTransaksi> readFromFile() throws IOException, ParseException, FileNotFoundException {
        ArrayList<ModelTransaksi> listTransaksi = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(fname)) {
            JSONArray arrayTransaksi = (JSONArray) parser.parse(reader);
            if (arrayTransaksi != null && !arrayTransaksi.isEmpty()) {
                listTransaksi = convertJSONToArrayList(arrayTransaksi);
            } else {
                System.out.println("JSON Masih Kosong!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listTransaksi;
    }
}
