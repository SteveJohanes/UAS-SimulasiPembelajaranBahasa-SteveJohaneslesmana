package SimulasiPembelajaranBahasa;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBBhs {

    private BhsModel dt = new BhsModel();

    public BhsModel getBhsModel() {
        return (dt);
    }

    public void setBhsModel(BhsModel s) {
        dt = s;
    }

    public ObservableList<BhsModel> Load() {
        try {
            ObservableList<BhsModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodebhs, namabhs, carabaca, gambar from bahasa");

            int i = 1;
            while (rs.next()) {
                BhsModel d = new BhsModel();
                d.setKodebhs(rs.getString("kodebhs"));
                d.setNamabhs(rs.getString("namabhs"));
                d.setCarabaca(rs.getString("carabaca"));
                d.setGambar(rs.getString("gambar"));

                // Jenis
                String kodebhs = rs.getString("kodebhs");
                char kode = kodebhs.charAt(0);
                String jenis;

                if (kode == 'H') {
                    jenis = "Hiragana";
                } else if (kode == 'K') {
                    jenis = "Katakana";
                } else {
                    jenis = "-";
                }
                d.setJenis(jenis);

                tableData.add(d);
                i++;
            }

            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ObservableList<BhsModel>  CariBhs(String kode, String nama) {
        try {
            ObservableList<BhsModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
            "select * from bahasa WHERE kodebhs LIKE '" + kode + "%' OR namabhs LIKE '" + nama + "%'");
            int i = 1;
            while (rs.next()) {
                BhsModel d=new BhsModel();
                d.setKodebhs(rs.getString("kodebhs"));                
                d.setNamabhs(rs.getString("namabhs"));
                d.setCarabaca(rs.getString("carabaca"));        
                d.setGambar(rs.getString("gambar")); 
                
                String kodebhs = rs.getString("kodebhs");
                char kode2 = kodebhs.charAt(0);
                String jenis;
                
                if (kode2 == 'H') jenis = "Hiragana";
                else if (kode2 == 'K') jenis = "Katakana";
                else jenis = "-";
                d.setJenis(jenis);
              
                              
                tableData.add(d);                
                i++;            
            }
            con.tutupKoneksi();            
            return tableData;
        } catch (Exception e) {            
            e.printStackTrace();            
            return null;        
          }
    }

    public int validasi(String nomor) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from bahasa where kodebhs = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into bahasa (kodebhs, namabhs, carabaca, gambar ) values (?,?,?,?)");
            con.preparedStatement.setString(1, getBhsModel().getKodebhs());
            con.preparedStatement.setString(2, getBhsModel().getNamabhs());
            con.preparedStatement.setString(3, getBhsModel().getCarabaca());
            con.preparedStatement.setString(4, getBhsModel().getGambar());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from bahasa where kodebhs  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update bahasa set namabhs = ?, carabaca = ?, gambar = ? where kodebhs = ? ");
            con.preparedStatement.setString(1, getBhsModel().getNamabhs());
            con.preparedStatement.setString(2, getBhsModel().getCarabaca());
            con.preparedStatement.setString(3, getBhsModel().getGambar());
            con.preparedStatement.setString(4, getBhsModel().getKodebhs());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
}
