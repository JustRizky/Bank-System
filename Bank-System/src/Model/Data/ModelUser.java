package Model.Data;

public class ModelUser {
    public int pk;
    public String namaUser;
    public String nomorRekening;
    public int pin;
    public double saldo;

    public ModelUser(int pk, String namaUser, String nomorRekening, int pin, double saldo) {
        this.pk = pk;
        this.namaUser = namaUser;
        this.nomorRekening = nomorRekening;
        this.pin = pin;
        this.saldo = saldo;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
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

}
