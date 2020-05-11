package interfaces.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IConjugueur extends Remote{

	public List<String> conjuguer(String verbe, String temps) throws RemoteException;

	public ArrayList<String> getlisteModeDispo() throws RemoteException;
	
	public ArrayList<String> getlisteTempsDispo() throws RemoteException;
	
	public void determinerMode(String _mode) throws RemoteException;
}