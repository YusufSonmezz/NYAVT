package AkilliCihaz;

import java.util.Scanner;

import Observer.Observable;
import Observer.Observer;
import Sistem.Sogutucu;

public class AgArayuzu implements Observer{

	public void mesajBastir(String message)
	{
		System.out.println(message);
	}
	
	public String getConsole()
	{
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	
	public void update(Observable observable)
	{
		Sogutucu sogutucu = (Sogutucu) observable;
		
		if(sogutucu.isSogutucuDurum() == true)
			System.out.println("Sogutucu is just opened.");
		else if(sogutucu.isSogutucuDurum() == false)
			System.out.println("Sogutucu is just closed.");
	}
}