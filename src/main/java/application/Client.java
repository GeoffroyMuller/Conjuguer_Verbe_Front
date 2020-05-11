package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import interfaces.remote.IVerbe;
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
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void connection(String ip, String port) throws MalformedURLException, RemoteException, NotBoundException {
		System.out.println( "connexion ... " );
		IVerbe obj = (IVerbe)Naming.lookup("rmi://"+ip+":"+port+"/Conjuguaison");
		verbe = obj;
		liste_temps = FXCollections.observableArrayList(verbe.getListeTempsDispo());
		System.out.println("client lancé");
	}

	/**
	 * Get une liste des temps disponible
	 * @return
	 */
	public static ObservableList<String> getListe_temps() {
		return liste_temps;
	}

	public static IVerbe getVerbe() {
		return verbe;
	}



}
