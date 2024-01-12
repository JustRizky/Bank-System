package Model.Json;

public class ModelJsonUser {
    public String id;
    public String namaUser;
    public String nomorRekening;
    public String pin;
    public String saldo;

    public ModelJsonUser() {
        this.id = "id";
        this.namaUser = "namaUser";
        this.nomorRekening = "nomorRekening";
        this.pin = "pin";
        this.saldo = "saldo";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

}