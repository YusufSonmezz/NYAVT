package Kullanici;

import AkilliCihaz.AgArayuzu;

public class Kullanici {
	private String kullanici_adi;
	private String sifre;
	private AgArayuzu agArayuzu;
	
	public Kullanici(Builder builder)
	{
		this.kullanici_adi = builder.kullanici_adi;
		this.sifre = builder.sifre;
		
		agArayuzu = new AgArayuzu();
	}
	
	public String getKullanici_adi() {
		return kullanici_adi;
	}


	public String getSifre() {
		return sifre;
	}
	
	/*BUILDER*/
	public static class Builder
	{
		private String kullanici_adi;
		private String sifre;
		
		public Builder kullanici_adi(String kullanici_adi)
		{
			this.kullanici_adi = kullanici_adi;
			return this;
		}
		
		public Builder sifre(String sifre)
		{
			this.sifre = sifre;
			return this;
		}
		
		public Kullanici build()
		{
			return new Kullanici(this);
		}
	}
	/*END (BUILDER)*/

	@Override
	public String toString()
	{
		return "Kullanicinin--> adi..: "+kullanici_adi+"\n"+"sifresi..: "+sifre+"\n";
	}
	
	public Kullanici getKullanici()
	{
		agArayuzu.mesajBastir("Enter kullanici_adi..: ");
		String tmpKAd = agArayuzu.getConsole();
		
		agArayuzu.mesajBastir("Enter sifre..: ");
		String tmpSifre = agArayuzu.getConsole();
		
		Kullanici tmpKullanici = new Kullanici.Builder().kullanici_adi(tmpKAd).sifre(tmpSifre).build();
		
		return tmpKullanici;
	}
}
