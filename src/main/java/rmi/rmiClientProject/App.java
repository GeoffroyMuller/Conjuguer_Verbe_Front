package rmi.rmiClientProject;

import java.rmi.Naming;
import java.rmi.Remote;

import interfaces.Information;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Lancement du client!" );
        try {
			Remote r = Naming.lookup("rmi://192.168.0.24/TestRMI");
			System.out.println(r);
			if (r instanceof Information)
			{
				String s = ((Information) r).getInformation();
				System.out.println("chaine renvoyee = "+s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        System.out.println("Fin du client");
    }
}
