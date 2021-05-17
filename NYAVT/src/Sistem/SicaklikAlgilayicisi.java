package Sistem;


import java.util.Random;


public class SicaklikAlgilayicisi{

	public int sicaklikOku()
	{
		Random rand = new Random();
		int low = -5;
		int high = 40;
		
		int randomSicaklik = rand.nextInt(high - low) + low;
		
		return randomSicaklik;
	}
	
	public void islemYap(ISistemIslem islem)
	{
		islem.SIslem();
	}
	

}
