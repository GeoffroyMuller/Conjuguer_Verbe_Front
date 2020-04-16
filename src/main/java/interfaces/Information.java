package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Information extends Remote{
	public String getInformation() throws RemoteException;

	public String getManger(String verbe) throws RemoteException;
	
	public ArrayList<String> getTraduction(String verbe, String Temps) throws RemoteException;

}
