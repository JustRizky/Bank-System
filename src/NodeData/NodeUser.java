package NodeData;

public class NodeUser {
    public int pk;
    public String namaUser;
    public String nomorRekening;
    public int pin;

    public NodeUser(int pk, String namaUser, String nomorRekening, int pin) {
        this.pk = pk;
        this.namaUser = namaUser;
        this.nomorRekening = nomorRekening;
        this.pin = pin;
    }

}
