package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{

    @FXML
    private TableView<Szemely> tabla;

    @FXML
    private TextField mezo_ID;

    @FXML
    private TextField mezo_Veznev;

    @FXML
    private TextField mezo_Keresztn;

    @FXML
    private TextField mezo_Szulido;

    @FXML
    private TableColumn<Szemely, String> table_ID;

    @FXML
    private TableColumn<Szemely, String> table_Veznev;

    @FXML
    private TableColumn<Szemely, String> table_Knev;

    @FXML
    private TableColumn<Szemely, String> table_Szilido;
    
    @FXML
    void menuitem_Torol(ActionEvent event) {
    	Szemely szTorol = tabla.getSelectionModel().getSelectedItem();
    	tabla_Adatok.remove(szTorol);
    }
    
    @FXML
    void button_Add(ActionEvent event) {
    	/*
    	System.out.println(mezo_ID.getText());
    	System.out.println(mezo_Veznev.getText());
    	System.out.println(mezo_Keresztn.getText());
    	System.out.println(mezo_Szulido.getText());
    	*/
    	Szemely szAdd = new Szemely(
    			mezo_ID.getText(), 
    			mezo_Veznev.getText(), 
    			mezo_Keresztn.getText(), 
    			mezo_Szulido.getText());
    	
    	tabla_Adatok.add(szAdd);
    }
    
    private ObservableList<Szemely> tabla_Adatok = FXCollections.observableArrayList(); // egy üres lista személyekből

    
    
    
    @FXML
    void menuitem_Kilepes(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void menuitem_Nevjegy(ActionEvent event) {

    }
    
    private void kezdoAdatok() {
		Szemely sz1 = new Szemely("1", "Pusztai", "Bence", "123");
		Szemely sz2 = new Szemely("2", "Juhász", "Bence", "456");
		Szemely sz3 = new Szemely("3", "Kiss", "Balázs", "789");
		tabla_Adatok.add(sz1);
		tabla_Adatok.add(sz2);
		tabla_Adatok.add(sz3);
	}
    
    private void tablaAdatokBeallitasa() {
    	table_ID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
    	table_Veznev.setCellValueFactory(cellData -> cellData.getValue().veznevProperty());
    	table_Knev.setCellValueFactory(cellData -> cellData.getValue().knevProperty());
    	table_Szilido.setCellValueFactory(cellData -> cellData.getValue().szulidoProperty());
    	
    	tabla.setItems(tabla_Adatok);
    }

    // implements initializable <- view controllernél
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kezdoAdatok();
		tablaAdatokBeallitasa();
		
	}

}
