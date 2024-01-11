package Controller.Data;

import Model.Data.ModelUser;

public class ControllerTransaksi {
    public boolean tarikTunai(ModelUser user, double jumlah) {
        double saldoSekarang = getSaldo(user);
        if (saldoSekarang >= jumlah) {
            user.setSaldo(saldoSekarang - jumlah);
            return true;
        } else {
            return false;
        }
    }

    public boolean setor(ModelUser user, double jumlah) {
        double saldoSekarang = getSaldo(user);
        user.setSaldo(saldoSekarang + jumlah);
        return true;
    }

    public double cekSaldo(ModelUser user) {
        return user.getSaldo();
    }

    public boolean transfer(ModelUser userPengirim, ModelUser userPenerima, double jumlah) {
        double saldoPengirim = getSaldo(userPengirim);
        double saldoPenerima = getSaldo(userPenerima);
        if (saldoPengirim >= jumlah) {
            userPengirim.setSaldo(saldoPengirim - jumlah);
            userPenerima.setSaldo(saldoPenerima + jumlah);
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo(ModelUser user) {
        return user.getSaldo();
    }
}
