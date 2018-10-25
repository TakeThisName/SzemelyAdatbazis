package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.SzemelyDao;
import impl.SzemelyDaoImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Szemely;

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
    
    private SzemelyDao db = new SzemelyDaoImpl();
    
    private ObservableList<Szemely> tabla_Adatok = db.get();
    
    @FXML
    void menuitem_Torol(ActionEvent event) {
    	Szemely szTorol = tabla.getSelectionModel().getSelectedItem();
    	tabla_Adatok.remove(szTorol);
    }
    
    @FXML
    void menuitem_Szerkeszt(ActionEvent event) {
    	Szemely szSZerkeszt = tabla.getSelectionModel().getSelectedItem();
    	tabla_Adatok.remove(szSZerkeszt);
    	mezo_ID.setText(szSZerkeszt.getId());
    	mezo_Veznev.setText(szSZerkeszt.getVeznev());
    	mezo_Keresztn.setText(szSZerkeszt.getKnev());
    	mezo_Szulido.setText(szSZerkeszt.getSzulido());
    	
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
    
   

    
    
    
    @FXML
    void menuitem_Kilepes(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void menuitem_Nevjegy(ActionEvent event) {

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
		
		tablaAdatokBeallitasa();
		
	}

}
