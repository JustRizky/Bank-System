package Model.Json;

public class ModelJsonTransaksi {
    public String id;
    public ModelJsonUser pengirim;
    public ModelJsonUser penerima;
    public String jumlah;
    public String tanggal;

    public ModelJsonTransaksi() {
        this.id = "id";
        this.pengirim = new ModelJsonUser();
        this.penerima = new ModelJsonUser();
        this.jumlah = "jumlah";
        this.tanggal = "tanggal";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

}
