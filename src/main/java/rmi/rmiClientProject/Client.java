package rmi.rmiClientProject;

import java.rmi.Naming;
import java.rmi.Remote;

import interfaces.IVerbe;

/**
 * Client Singleton
 * @author Geoff-Portable
 */
public class Client {

	private static Client client;

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
			Remote r = Naming.lookup("rmi://192.168.0.17/Conjuguaison");
			System.out.println(r);
			if (r instanceof IVerbe)
			{
				String s = ((IVerbe) r).getInformation();
				System.out.println("chaine renvoyee = "+s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Fin du client");
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
