package AkilliCihaz;

import java.sql.SQLException;

import Kullanici.IKullaniciIslem;
import Kullanici.Kullanici;
import Kullanici.KullaniciEkle;
import Kullanici.KullaniciGuncelle;
import Kullanici.KullaniciSil;
import Sistem.Eyleyici;
import Sistem.ISistemIslem;
import Sistem.SicaklikAlgilayicisi;
import Sistem.SicaklikGoruntule;
import Sistem.Sogutucu;
import Sistem.SogutucuAc;
import Sistem.SogutucuKapat;
import VeriTabani.IVeriTabani;
import VeriTabani.PostgreSqlVT;

public class AnaIslemPlatformu {
	
	private IVeriTabani postgresql;
	private SicaklikAlgilayicisi sicaklikAlgilayicisi;
	private Sogutucu sogutucu;
	private Eyleyici eyleyici;
	private AgArayuzu agArayuzu;
	private IKullaniciIslem kEkle;
	private IKullaniciIslem kSil;
	private IKullaniciIslem kGuncelle;
	

	public AnaIslemPlatformu() throws SQLException
	{
		postgresql = new PostgreSqlVT();
		sicaklikAlgilayicisi = new SicaklikAlgilayicisi();
		sogutucu = new Sogutucu();
		eyleyici = new Eyleyici();
		agArayuzu = new AgArayuzu();
		
		sogutucu.addObserver(agArayuzu);
		
		kEkle = new KullaniciEkle(postgresql);
		kSil = new KullaniciSil(postgresql);
		kGuncelle = new KullaniciGuncelle(postgresql);
	}
	
	public void Menu() throws SQLException
	{
		boolean control = false;
		do
		{
			//Notifications
			
			agArayuzu.mesajBastir("Please enter the informations...");
			
			
			Kullanici confirm = getKullanici();
			
			//control if DataBase has a kullanici member like that is given to program
			control = postgresql.KullaniciDogrula(confirm);
			
		}while(!control);
		
		int islem = 0;
		
		do
		{
			agArayuzu.mesajBastir("Please choose an operation...\n");
			agArayuzu.mesajBastir("1) Kullanici Islemleri\n2) Sistem Islemleri\n3) Exit");
			String value = agArayuzu.getConsole();
			
			if(value.equals("1"))
			{
				KullaniciMenu();
			}
			
			else if(value.equals("2"))
			{
				SistemMenu();
			}
			
			else if(value.equals("3"))
			{
				islem++;
			}
			
		}while(islem == 0);
	}
	
	
	
	
	
	
	public void KullaniciMenu() throws SQLException
	{
		int islem = 0;
		do
		{
			agArayuzu.mesajBastir("Choose an operation that you want to make program do...");
			agArayuzu.mesajBastir("1) Kullanici Ekle\n"
					+ "2) Kullanici Sil\n"
					+ "3) Kullanici Guncelle\n"
					+ "4) Exit");
			String value = agArayuzu.getConsole();
			if(value.equals("1"))
			{
				agArayuzu.mesajBastir("Please enter informations of kullanici that you want to insert?..");
				Kullanici tmp = getKullanici();
				kEkle.KIslem(tmp);
			}
			
			else if(value.equals("2"))
			{
				agArayuzu.mesajBastir("Which kullanici do you want to delete?..");
				postgresql.printfDataBase();
				Kullanici tmp = getKullanici();
				kSil.KIslem(tmp);
			}
			
			else if(value.equals("3"))
			{
				agArayuzu.mesajBastir("Which kullanici do you want to update?..");
				postgresql.printfDataBase();
				kGuncelle.KIslem(getKullanici());
			}
			
			else if(value.equals("4"))
			{
				islem++;
			}
		}while(islem == 0);
	}
	
	public void SistemMenu()
	{
		int islem = 0;
		
		do
		{
			agArayuzu.mesajBastir("Choose an operation that you want to make program do...");
			agArayuzu.mesajBastir("1) Sogutucu Ac\n"
					+ "2) Sogutucu Kapat\n"
					+ "3) Sicaklik Goruntule\n"
					+ "4) Exit");
			String value = agArayuzu.getConsole();
			
			if(value.equals("1"))
			{
				ISistemIslem sogutucuAc = new SogutucuAc(sogutucu);
				eyleyici.islemYap(sogutucuAc);
			}
			
			else if(value.equals("2"))
			{
				ISistemIslem sogutucuKapat = new SogutucuKapat(sogutucu);
				eyleyici.islemYap(sogutucuKapat);
			}
			
			else if(value.equals("3"))
			{
				ISistemIslem sicaklikGoruntule = new SicaklikGoruntule(sicaklikAlgilayicisi.sicaklikOku());
				sicaklikAlgilayicisi.islemYap(sicaklikGoruntule);
			}
			
			else if(value.equals("4"))
			{
				islem++;
			}
			
		}while(islem == 0);
	}
	
	public Kullanici getKullanici()
	{
		//getting informations..
		
		agArayuzu.mesajBastir("Kullanici Adi..: ");
		String kullAd = agArayuzu.getConsole();
		agArayuzu.mesajBastir("Sifre..: ");
		String sifre = agArayuzu.getConsole();
		
		//creating temporary kullanici
		
		Kullanici tmp = new Kullanici.Builder().kullanici_adi(kullAd).sifre(sifre).build();
		
		return tmp;
	}
}
