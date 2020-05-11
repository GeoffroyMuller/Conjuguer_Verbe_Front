package interfaces.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IVerbe extends Remote{
	
	public List<String> conjuguer(String verbe, String temps) throws RemoteException;

	public ArrayList<String> getListeTempsDispo() throws RemoteException;
}
