package Model.Data;

import java.util.Date;

import Model.Json.ModelJsonUser;

public class ModelTransaksi {
    public int id;
    public ModelJsonUser pengirim;
    public ModelJsonUser penerima;
    public double jumlah;
    public Date tanggal;

    public ModelTransaksi(int id, ModelJsonUser pengirim, ModelJsonUser penerima, double jumlah) {
        this.id = id;
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.jumlah = jumlah;
        this.tanggal = new Date();
    }

    public ModelJsonUser getPengirim() {
        return pengirim;
    }

    public void setPengirim(ModelJsonUser pengirim) {
        this.pengirim = pengirim;
    }

    public ModelJsonUser getPenerima() {
        return penerima;
    }

    public void setPenerima(ModelJsonUser penerima) {
        this.penerima = penerima;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
