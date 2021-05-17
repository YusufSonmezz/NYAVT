package Sistem;

public class SicaklikGoruntule implements ISistemIslem{

	private int sicaklik;
	
	
	public SicaklikGoruntule(int sicaklik) {
		this.sicaklik = sicaklik;
	}

	@Override
	public void SIslem() {
		
		System.out.println("Ortamin Sicakligi..: "+ sicaklik +" derecedir.");
		
	}

}
