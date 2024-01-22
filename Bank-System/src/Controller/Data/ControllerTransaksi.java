package Controller.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import Controller.Json.ControllerJsonTransaksi;
import Model.Data.ModelTransaksi;
import Model.Data.ModelUser;

public class ControllerTransaksi {
    private ArrayList<ModelTransaksi> transaksis;
    private ControllerJsonTransaksi controllerJsonTransaksi;
    private ArrayList<ModelUser> users;
    private ControllerUser controllerUser;

    public ControllerTransaksi() throws FileNotFoundException, IOException, ParseException {
        transaksis = new ArrayList<>();
        controllerUser = new ControllerUser();
        users = ControllerUser.getUsers();
        controllerJsonTransaksi = new ControllerJsonTransaksi();
        loadTransaksis();
    }

    public void loadTransaksis() throws FileNotFoundException, IOException, ParseException {
        transaksis = controllerJsonTransaksi.readFromFile();
    }

    public ArrayList<ModelTransaksi> getTransaksis() {
        return transaksis;
    }

    private int getLastKode() {
        int lastKode = transaksis.size() - 1;
        return transaksis.get(lastKode).id;
    }

    public boolean tarikTunai(ModelUser user, double jumlah) {
        double saldoSekarang = getSaldo(user);
        if (saldoSekarang >= jumlah) {
            user.setSaldo(saldoSekarang - jumlah);
            return true;
        } else {
            return false;
        }
    }

    public boolean setor(ModelUser user, double jumlah) {
        double saldoSekarang = getSaldo(user);
        user.setSaldo(saldoSekarang + jumlah);
        System.out.println(saldoSekarang+jumlah);
        try {
            controllerUser.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public double cekSaldo(ModelUser user) {
        return user.getSaldo();
    }

    public boolean transfer(ModelUser userPengirim, ModelUser userPenerima, double jumlah) {
        double saldoPengirim = getSaldo(userPengirim);
        double saldoPenerima = getSaldo(userPenerima);
        if (saldoPengirim >= jumlah) {
            userPengirim.setSaldo(saldoPengirim - jumlah);
            userPenerima.setSaldo(saldoPenerima + jumlah);
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo(ModelUser user) {
        return user.getSaldo();
    }

    public void commit() throws IOException {
        controllerJsonTransaksi.writeFileJSON(transaksis);
        controllerUser.commit(); // Menulis kembali data JSON pengguna setelah update saldo
    }
    
    

    public ModelUser getUser(String nomorRekening) {
        for (ModelUser user : users) {
            if (user.getNomorRekening().equals(nomorRekening)) {
                return user;
            }
        }
        return null;
    }
}
