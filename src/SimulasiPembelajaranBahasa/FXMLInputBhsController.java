package SimulasiPembelajaranBahasa;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLInputBhsController implements Initializable {

    boolean editdata = false;

    private TextField txttarif;
    private TextField txtstok;
    @FXML
    private Button btnsave;
    @FXML
    private Button btncancel;
    @FXML
    private Button btnexit;
    @FXML
    private Button btngambar;
    @FXML
    private TextField txtgambar;
    @FXML
    private TextField txtkodebhs;
    @FXML
    private TextField txtnamabhs;
    @FXML
    private TextField txtcarabaca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(BhsModel d) {
        if (!d.getKodebhs().isEmpty()) {
            editdata = true;
            txtkodebhs.setText(d.getKodebhs());
            txtnamabhs.setText(d.getNamabhs());
            txtcarabaca.setText(d.getCarabaca());
            txtgambar.setText(d.getGambar());
            txtkodebhs.setEditable(false);
            txtnamabhs.requestFocus();
        }
    }

    @FXML
    private void saveclick(ActionEvent event) {
        BhsModel n = new BhsModel();
        n.setKodebhs(txtkodebhs.getText());
        n.setNamabhs(txtnamabhs.getText());
        n.setCarabaca(txtcarabaca.getText());
        n.setGambar(txtgambar.getText());

        FXMLDocumentController.dtbhs.setBhsModel(n);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (editdata) {
            if (FXMLDocumentController.dtbhs.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                txtkodebhs.setEditable(true);
                cancelclick(event);
                stage.close();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtbhs.validasi(n.getKodebhs()) <= 0) {
            if (FXMLDocumentController.dtbhs.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                cancelclick(event);
                stage.close();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            txtkodebhs.requestFocus();
        }
    }

    @FXML
    private void cancelclick(ActionEvent event) {
        txtkodebhs.setText("");
        txtnamabhs.setText("");
        txtcarabaca.setText("");
        txtgambar.setText("");
        txtkodebhs.requestFocus();
    }

    @FXML
    private void exitclick(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void gambarclick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Gambar Barang");
        // Filter hanya menampilkan file gambar
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                // Mendapatkan nama file asli
                String fileName = selectedFile.getName();

                // Tentukan lokasi tujuan di folder proyek NetBeans
                String projectDir = System.getProperty("user.dir"); // Mendapatkan direktori proyek
                File destDir = new File(projectDir + "\\img"); // Direktori tujuan

                // Jika folder img belum ada, buat foldernya
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }

                // Lokasi tujuan file di folder img
                File destFile = new File(destDir, fileName);
                
                // Salin file ke folder img
                Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Set path gambar relatif
                txtgambar.setText("img\\" + fileName);

            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Gagal memindahkan gambar", ButtonType.OK);
                a.showAndWait();
            }
        }
    }
}
