package Model.Data;

public class ModelRekening {
    public String nomorRekening;
    public int pin;
    public double saldo;

    public ModelRekening(String nomorRekening, int pin, double saldo) {

        this.nomorRekening = nomorRekening;
        this.pin = pin;
        this.saldo = saldo;
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
