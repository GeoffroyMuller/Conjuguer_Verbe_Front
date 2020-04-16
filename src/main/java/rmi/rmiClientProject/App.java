package rmi.rmiClientProject;

import java.rmi.Naming;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sc = new Scanner (System.in);
		
		System.out.println("Veuillez entrer un mot :");
		String str = sc.nextLine();
        try {
			Remote r = Naming.lookup("rmi://192.168.0.17/TestRMI");
			System.out.println(r);
			if (r instanceof Information)
			{
				ArrayList<String> verbeConj = ((Information) r).getTraduction(str, "futur");
				verbeConj.forEach(s -> System.out.println(s));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        System.out.println("Fin du client");
    }
}
