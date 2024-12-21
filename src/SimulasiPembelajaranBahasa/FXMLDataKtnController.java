package SimulasiPembelajaranBahasa;

import SimulasiPembelajaranBahasa.DBUjian;
import SimulasiPembelajaranBahasa.Koneksi;
import SimulasiPembelajaranBahasa.UjianModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;

public class FXMLDataKtnController implements Initializable {

    @FXML
    private Button btnexit;
    @FXML
    private ImageView imgbhs;
    @FXML
    private TextField txtjwb;
    @FXML
    private Button btncek;
    @FXML
    private Label lblsoal;
    @FXML
    private Button btnnext;

    private UjianModel soal;
    private DBUjian dbUjian;
    private Set<String> soalTerkirim = new HashSet<>();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbUjian = new DBUjian();
        loadSoal();
    }

    private void loadSoal() {
    Connection conn = null;
    try {
        Koneksi koneksi = new Koneksi();
        koneksi.bukaKoneksi();
        conn = koneksi.dbKoneksi;

        String query = "SELECT * FROM ujian WHERE kodesoal NOT IN (SELECT kodesoal FROM ujian WHERE kodesoal IN (?)) ORDER BY RAND() LIMIT 1";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, String.join(",", soalTerkirim));
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            soal = new UjianModel();
            soal.setKodesoal(rs.getString("kodesoal"));
            soal.setSoal(rs.getString("soal"));
            soal.setJawaban(rs.getString("jawaban"));
            soal.setGambar(rs.getString("gambar"));

            lblsoal.setText(soal.getSoal());
            txtjwb.setPromptText(soal.getSoal());

            String imagePath = soal.getGambar();
            if (imagePath != null && !imagePath.isEmpty()) {
                try {
                    Image gambar = new Image(new FileInputStream(imagePath));
                    imgbhs.setImage(gambar);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDataKtnController.class.getName()).log(Level.SEVERE, null, ex);
                    imgbhs.setImage(null);
                }
            }

            soalTerkirim.add(soal.getKodesoal());
        } else {
            showAlert(Alert.AlertType.WARNING, "Semua soal telah ditampilkan!");
        }
    } catch (Exception e) {
        Logger.getLogger(FXMLDataKtnController.class.getName()).log(Level.SEVERE, null, e);
        showAlert(Alert.AlertType.ERROR, "Terjadi kesalahan saat mengambil soal!");
    } finally {
        if (conn != null) {
            new Koneksi().tutupKoneksi();
        }
    }
}


    @FXML
    private void exitclick(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void cekjawaban(ActionEvent event) {
        if (soal != null) {
            String jawabanUser = txtjwb.getText().trim(); // Menghapus spasi ekstra
            boolean isCorrect = dbUjian.cekJawaban(soal.getKodesoal(), jawabanUser);

            if (isCorrect) {
                showAlert(Alert.AlertType.INFORMATION, "Jawaban benar!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Jawaban salah!");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Soal tidak tersedia!");
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message, ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void nextclick(ActionEvent event) {
        loadSoal();
    }
}
