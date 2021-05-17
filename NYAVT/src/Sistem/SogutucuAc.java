package Sistem;

public class SogutucuAc implements ISistemIslem{
	
	private Sogutucu sogutucu;
	
	

	public SogutucuAc(Sogutucu sogutucu) {
		super();
		this.sogutucu = sogutucu;
	}



	@Override
	public void SIslem() {
		
		if(sogutucu.isSogutucuDurum() == true)
		{
			System.out.println("Sogutucu is already opened...!");
		}
		else
			sogutucu.setSogutucuDurum(true);
		
	}

}
