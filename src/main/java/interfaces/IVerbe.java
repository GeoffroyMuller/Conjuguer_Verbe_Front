package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IVerbe extends Remote{
	
	public List<String> conjuguerFutur(String verbe) throws RemoteException;
	
	public List<String> conjuguerPresent(String verbe) throws RemoteException;
	
	public List<String> conjuguerPasseComp(String verbe) throws RemoteException;
	
	public String getInformation() throws RemoteException;

	public String getManger(String verbe) throws RemoteException;
	
	public ArrayList<String> getListeTempsDispo() throws RemoteException;
	
	public ArrayList<String> getTraduction(String verbe, String Temps) throws RemoteException;

}
