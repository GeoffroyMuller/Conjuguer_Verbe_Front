package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import rmi.rmiClientProject.Client;

public class ControleurPrincipal {

	@FXML
	private TextField textfield_ip;
	@FXML
	private TextField textfield_port;
	@FXML
	private TextField textfield_verbe;
	@FXML
	private ComboBox<String> combobox_temps;
	
	@FXML
	public void connection() {
		Client.connection(
				textfield_ip.getText(),
				textfield_port.getText());
	}
	
	@FXML
	public void conjuguer() {
		
	}

}
