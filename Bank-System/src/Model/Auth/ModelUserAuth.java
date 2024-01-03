package Model.Auth;

public class ModelUserAuth {
    private String nomorRekening;
    private String pin;

    public ModelUserAuth(String nomorRekening, String pin) {
        this.nomorRekening = nomorRekening;
        this.pin = pin;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getPin() {
        return pin;
    }

}
