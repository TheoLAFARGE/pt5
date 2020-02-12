import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class client {

    private static String requeteSimple (String cartefid) {
        param p1 = new param();
        String result = "";
        try {
            Statement smt = p1.getConnection().createStatement();
            String rqt = "select c.* from client c where c.cartefid = '" + cartefid + "'";
            ResultSet rs = smt.executeQuery(rqt);

            while (rs.next()) {
                result = result + " " +"idcli : " + rs.getString("idcli") +
                        ", cartefid : " + rs.getString("cartefid") +
                        ", sexe : " + rs.getInt("sexe") +
                        ", codepostal : " + rs.getString("codepostal") +
                        ", ville : " + rs.getString("ville") +
                        ", datenaissance : " + rs.getString("datenaissance") +
                        ", age :" + rs.getInt("age");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static String requeteJointure (String cartefid) {
        param p1 = new param();
        int i = 1;
        String result = "";
        try {
            Statement smt = p1.getConnection().createStatement();
            String rqt = "select v.parkod10,c.idcli, c.cartefid from vente v inner join client c on v.cartefidelite=c.cartefid where c.cartefid = '" + cartefid + "'";
            ResultSet rs = smt.executeQuery(rqt);

            while (rs.next()) {
                result = result + "L"+ i +"  idcli : " + rs.getString("idcli") +
                        ", cartefid : " + rs.getString("cartefid") +
                        ", parkod10 : "+rs.getString("PARKOD10");
                i += 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
        public static void main (String[] args){
        String r1 = requeteSimple("9990202685741");
        System.out.println("Resultat r1 : "+r1);
        String r2 = requeteJointure("9990202685741");
        System.out.println("Resultat r2 : " + r2);


//        p1 = new param();
//        String idcli ="";
//        String cartefid ="";
//        int sexe  =0;
//        String codepostal="" ;
//        String ville ="";
//        String datenaissance="" ;
//        String parkod10 = "";
//        int age = 0;
//        try {
//            Statement smt = p1.getConnection().createStatement();
//            String rqt = "select v.parkod10,c.idcli, c.cartefid from vente v inner join client c on v.cartefidelite=c.cartefid where c.cartefid = '"+"9990202685741"+"'";
//            ResultSet rs = smt.executeQuery(rqt);
//            //String result = resultSet.toString();
//
//            while (rs.next()) {
//                idcli = rs.getString("idcli") ;
//                cartefid = rs.getString("cartefid");
//                parkod10 = rs.getString("PARKOD10");
////                sexe    = rs.getInt("sexe");
////                codepostal = rs.getString("codepostal");
////                ville = rs.getString("ville");
////                datenaissance = rs.getString("datenaissance");
////                age = rs.getInt("age") ;
//                System.out.println("idcli : "+ idcli +
//                        ", cartefid : "+cartefid+
//                        ", parkod10 : "+parkod10);
//
////                                +", sexe : "+sexe+
////                                ", codepostal : "+codepostal+
////                                ", ville : "+ ville+
////                                ", datenaissance : "+datenaissance+
////                                ", age :" + age);
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
