package SimulasiPembelajaranBahasa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLDataBhsController implements Initializable {

    @FXML
    private Button btnexit;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnlast;
    @FXML
    private Button btnnext;
    @FXML
    private Button btnprev;
    @FXML
    private Button btnfirst;
    @FXML
    private Button btnsearch;
    @FXML
    private TableView<BhsModel> tbvbhs;
    @FXML
    private TextField searchbhs;
    @FXML
    private ImageView imgbhs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
        tbvbhs.getSelectionModel().selectFirst();
        showgambar();
    }

    public void showdata() {
        ObservableList<BhsModel> data = FXMLDocumentController.dtbhs.Load();
        if (data != null) {
            tbvbhs.getColumns().clear();
            tbvbhs.getItems().clear();

            TableColumn col = new TableColumn("kodebhs");
            col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("kodebhs"));
            tbvbhs.getColumns().addAll(col);

            col = new TableColumn("namabhs");
            col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("namabhs"));
            tbvbhs.getColumns().addAll(col);

            col = new TableColumn("carabaca");
            col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("carabaca"));
            tbvbhs.getColumns().addAll(col);

            col = new TableColumn("jenis");
            col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("jenis"));
            tbvbhs.getColumns().addAll(col);


            tbvbhs.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvbhs.getScene().getWindow().hide();
        }
    }

    public void showgambar() {
        Image gambar = null;
        try {
            gambar = new Image(new FileInputStream(tbvbhs.getSelectionModel().getSelectedItem().getGambar()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDataBhsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        imgbhs.setImage(gambar);
    }

    @FXML
    private void exitclick(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

    @FXML
    private void updateclick(ActionEvent event) {
        BhsModel s = new BhsModel();
        s = tbvbhs.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInputBhs.fxml"));
            Parent root = (Parent) loader.load();
            FXMLInputBhsController isidt = (FXMLInputBhsController) loader.getController();
            isidt.execute(s);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
        firstclick(event);
    }

    @FXML
    private void deleteclick(ActionEvent event) {
        BhsModel s = new BhsModel();
        s = tbvbhs.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtbhs.delete(s.getKodebhs())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showdata();
            firstclick(event);
        }
    }

    @FXML
    private void insertclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInputBhs.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
        firstclick(event);
    }

    @FXML
    private void lastclick(ActionEvent event) {
        tbvbhs.getSelectionModel().selectLast();
        showgambar();
        tbvbhs.requestFocus();
    }

    @FXML
    private void nextclick(ActionEvent event) {
        tbvbhs.getSelectionModel().selectNext();
        showgambar();
        tbvbhs.requestFocus();
    }

    @FXML
    private void prevclick(ActionEvent event) {
        tbvbhs.getSelectionModel().selectPrevious();
        showgambar();
        tbvbhs.requestFocus();
    }

    @FXML
    private void firstclick(ActionEvent event) {
        tbvbhs.getSelectionModel().selectFirst();
        showgambar();
        tbvbhs.requestFocus();
    }

    @FXML
    private void tableclick(MouseEvent event) {
        showgambar();
    }

    @FXML
    private void searchclick(ActionEvent event) {
        BhsModel s = new BhsModel();
        String key = searchbhs.getText();
        if (key != "") {
            ObservableList<BhsModel> data = FXMLDocumentController.dtbhs.CariBhs(key, key);
            if (data != null) {
                tbvbhs.getColumns().clear();
                tbvbhs.getItems().clear();
                TableColumn col = new TableColumn("kodebhs");
                col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("kodebhs"));
                tbvbhs.getColumns().addAll(col);
                col = new TableColumn("namabhs");

                col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("namabhs"));
                tbvbhs.getColumns().addAll(col);

                col = new TableColumn("jenis");
                col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("jenis"));
                tbvbhs.getColumns().addAll(col);

                col = new TableColumn("gambar");
                col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("gambar"));
                tbvbhs.getColumns().addAll(col);
                tbvbhs.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
                a.showAndWait();
                tbvbhs.getScene().getWindow().hide();;
            }
        } else {
            showdata();
        }
    }

    @FXML
    private void cariData(KeyEvent event) {
        BhsModel s = new BhsModel();
        String key = searchbhs.getText();
        if (key != "") {
            ObservableList<BhsModel> data = FXMLDocumentController.dtbhs.CariBhs(key, key);
            if (data != null) {
                tbvbhs.getColumns().clear();
                tbvbhs.getItems().clear();

                TableColumn col = new TableColumn("kodebhs");
                col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("kodebhs"));
                tbvbhs.getColumns().addAll(col);
                col = new TableColumn("namabhs");
                col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("namabhs"));
                tbvbhs.getColumns().addAll(col);
                col = new TableColumn("tarif");
                col.setCellValueFactory(new PropertyValueFactory<BhsModel, String>("tarif"));
                tbvbhs.getColumns().addAll(col);

                tbvbhs.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
                a.showAndWait();
                tbvbhs.getScene().getWindow().hide();;
            }
        } else {
            showdata();
        }
    }
}
