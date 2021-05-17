package Sistem;

public class SogutucuKapat implements ISistemIslem{

	private Sogutucu sogutucu;
	
	

	public SogutucuKapat(Sogutucu sogutucu) {
		super();
		this.sogutucu = sogutucu;
	}



	@Override
	public void SIslem() {
		
		if(sogutucu.isSogutucuDurum() == false)
			System.out.println("Sogutucu is already closed..!");
		else
			sogutucu.setSogutucuDurum(false);
		
	}


}
