package rmi.rmiClientProject;

import java.rmi.Naming;
import java.rmi.Remote;
import java.util.ArrayList;

import interfaces.IVerbe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Client Singleton
 * @author Geoff-Portable
 */
public class Client {
	public static IVerbe verbe;

	private static Client client;
	
	private static ObservableList<String> liste_temps = null;

	/**
	 * Renvoie l'instance de client 
	 * @return
	 */
	public static Client getInstance() {
		if(client == null) {
			client = new Client();
		}
		return client;
	}

	/**
	 * Permet de connecter le client
	 * @param ip du serveur
	 * @param port du serveur
	 */
	public static void connection(String ip, String port) {
		System.out.println( "Lancement du client!" );
		try {
			IVerbe r = (IVerbe)Naming.lookup("rmi://192.168.0.17/Conjuguaison");
			verbe = r;
			FXCollections.observableArrayList(verbe.getListeTempsDispo());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Fin du client");
	}

	public static ObservableList<String> getListe_temps() {
		return liste_temps;
	}
	
	
	
//	/**
//	 * Permet d'effectuer des test
//	 */
//	public static void testClient() {
//		System.out.println( "Lancement du client!" );
//		try {
//			Remote r = Naming.lookup("rmi://192.168.0.17:1098/client");
//			IClient ibanque = ((IClient)r).connexionClient("root", "root");
//			IPanier ipanier = ibanque.recupererPanier();
//			System.out.println(ipanier.calculerMontantPanier());
//			ipanier.ajouterProduit(2);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		System.out.println("Fin du client");
//	}
}
