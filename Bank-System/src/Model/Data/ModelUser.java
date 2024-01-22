package Model.Data;

public class ModelUser {
    public int id;
    public String namaUser;
    public String nomorRekening;
    public int pin;
    public double saldo;

    public ModelUser(int id, String namaUser, String nomorRekening, int pin) {
        this.id = id;
        this.namaUser = namaUser;
        this.nomorRekening = nomorRekening;
        this.pin = pin;
        this.saldo = 0;
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

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
