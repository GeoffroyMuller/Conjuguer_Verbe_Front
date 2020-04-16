package rmi.rmiClientProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main
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
}
