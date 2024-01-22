package Model.Data;

public class ModelUser {
    public int pk;
    public String namaUser;
    public ModelRekening rekening;

    public ModelUser(int pk, String namaUser, ModelRekening rekening) {
        this.pk = pk;
        this.namaUser = namaUser;
        this.rekening = rekening;
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

    public ModelRekening getRekening() {
        return rekening;
    }

    public void setRekening(ModelRekening rekening) {
        this.rekening = rekening;
    }
}
