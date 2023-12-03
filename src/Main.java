import java.util.ArrayList;

import org.json.simple.JSONArray;

import ModelJSON.ModelJSONUser;
import NodeData.NodeUser;

public class Main {
    public static void main(String[] args) throws Exception {
        ModelJSONUser modelJSONUser = new ModelJSONUser();

        JSONArray arrayUser1 = modelJSONUser.convertArrayListToJSON(null);
        System.out.println("Array User1: " + arrayUser1);

        ArrayList<NodeUser> listUser2 = new ArrayList<>();
        listUser2.add(new NodeUser(1, "Panji", "07602", 07602));
        listUser2.add(new NodeUser(2, "Rizky", "07606", 07606));
        listUser2.add(new NodeUser(3, "Rangga", "07607", 07607));
        // listUser2.add(new NodeUser(0, null, null, 0))

        // JSONArray arrayUser2 = modelJSONUser.convertArrayListToJSON(listUser2);
        // System.out.println("Array User2: " + arrayUser2);

        modelJSONUser.writeFileJSON(listUser2);

        // ArrayList<NodeUser> listUser3 =
        // modelJSONUser.convertJSONToArrayList(arrayUser2);
        // for (NodeUser user : listUser3) {
        // System.out.println("====================================");
        // System.out.println("Nama Pengguna : " + user.namaUser);
        // System.out.println("Nomor Rekening : " + user.nomorRekening);
        // System.out.println("====================================");
        // }
    }

}
