package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import rmi.rmiClientProject.Client;

public class ControleurPrincipal {

	@FXML
	private TextField textfield_ip_port;
	@FXML
	private TextField textfield_verbe;
	@FXML
	private ComboBox<String> combobox_temps;
	
	@FXML
	public void connection() {
		String[] res = textfield_ip_port.getText().trim().split(":");
		Client.connection(res[0], res[1]);
	}
	
	@FXML
	public void conjuguer() {
		
	}

}
