package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Client
 */
public class App extends Application
{
    public static void main( String[] args )
    {
    	launch(args);
    }
    
    /**
     * Creer et lance l' interface graphique (IHM)
     * @param windows 
     */
	@Override
	public void start(Stage windows){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/principal.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,740,450);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			windows.setMaxWidth(790);
			windows.setMaxHeight(490);
			
			windows.setMinWidth(740);
			windows.setMinHeight(450);
			
			windows.setTitle("Client : Conjugue Verbe");
			windows.setScene(scene);
			windows.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	/** 
//	 * un main classique pr test des appels a methodes
//	 * @param args
//	 */
//	 public static void main(String[] args) {
//		System.out.println( "Lancement du client!" );
//		try {
//			String unVerbeTest = "manger";
//			Remote r = Naming.lookup("rmi://192.168.0.17/Conjuguaison");
//			System.out.println(r);
//			if (r instanceof IVerbe)
//			{
//				String s = ((IVerbe) r).getInformation();
//				System.out.println("chaine renvoyee = "+s);
//				
//				List<String> verbesConj = ((IVerbe) r).conjuguerFutur(unVerbeTest);
//				for (String verbeC : verbesConj)
//				{
//					System.out.println(verbeC);
//				}
//				
//				verbesConj = ((IVerbe) r).conjuguerPresent(unVerbeTest);
//				for (String verbeC : verbesConj)
//				{
//					System.out.println(verbeC);
//				}
//				
//				verbesConj = ((IVerbe) r).conjuguerPasseComp(unVerbeTest);
//				for (String verbeC : verbesConj)
//				{
//					System.out.println(verbeC);
//				}
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		System.out.println("Fin du client");
//	}
}
