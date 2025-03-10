package controleur;

import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert.AlertType;

/**
 * Controleur principal qui gére la vue pricipale
 */
public class ControleurPrincipal implements Initializable{

	@FXML
	private TextField textfield_ip_port;
	@FXML
	private TextField textfield_verbe;
	@FXML
	private TextArea ta_conjugue;
	@FXML 
	private ComboBox<String> combobox_modes;
	@FXML 
	private ComboBox<String> combobox_temps;
	@FXML
	private Pane panel_general;

	/**
	 * Initialise la vue à sa creation
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String ip = "127.0.0.1";
		panel_general.setDisable(true);
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}                                                
		textfield_ip_port.setText(""+ip+":"+1099);
	}

	/**
	 * Connecte le client avec ip port rentré dans le textfield
	 */
	@FXML
	public void connection() {
		try {
			//connexion rmi
			String[] res = textfield_ip_port.getText().trim().split(":");
			Client.connection(res[0], res[1]);
			
			//init les comboboxs
			initComboboxs();
			
			panel_general.setDisable(false);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			alertAttention("Connexion échoué", "L'ip ou le port saisi est incorrect :"
					+"\n  format attendu : <ip serveur>:<port serveur>"
					+"\n  exemple : 192.168.43.1:1099");
		}
	}
	
	@FXML
	public void conjuguer() {
		try {
			ArrayList<String> listeVerbe = new ArrayList<String>();
			listeVerbe = (ArrayList<String>) Client.getConjugueur().conjuguer(textfield_verbe.getText(), ""+combobox_temps.getValue());
			System.out.println("res : "+listeVerbe);
			String res = "";
			for (String string : listeVerbe) {
				res = res+string+"\n";
			}
			ta_conjugue.setText(res);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void miseAJourComboTemps() throws RemoteException {
		Client.selectListeTemps(combobox_modes.getValue());
		initCombobox(combobox_temps, Client.getListe_temps(), 0);
	}
	
	/**
	 * initialise les comboboxes
	 */
	private void initComboboxs() {
		int indexDefault = 0;
		
		initCombobox(combobox_modes, Client.getliste_mode(), 0);
				
		initCombobox(combobox_temps, Client.getListe_temps(), 0);
		
	}
	
	/**
	 * initialise la combobox avec la liste avec pour element par default l'index indexDefault de la liste
	 * @param combobox a initialise
	 * @param liste 
	 * @param indexDefault
	 */
	private void initCombobox(ComboBox<String> combobox, ObservableList<String> liste, int indexDefault) {	
		combobox.setItems(liste);
		combobox.getSelectionModel().select(indexDefault);
	}

	/**
	 * affiche une alert specifique à l'ip et le port
	 */
	public void alertAttention(String header, String msg) {
		Alert alert = new Alert(AlertType.WARNING); alert = new Alert(AlertType.WARNING);
		alert.setTitle("Attention");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}

}
