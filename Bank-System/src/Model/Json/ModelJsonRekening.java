package Model.Json;

public class ModelJsonRekening {
    public String nomorRekening;
    public String pin;
    public String saldo;

    public ModelJsonRekening(String nomorRekening, String pin, String saldo) {
        this.nomorRekening = nomorRekening;
        this.pin = pin;
        this.saldo = saldo;
    }
}
