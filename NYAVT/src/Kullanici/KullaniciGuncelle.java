package Kullanici;

import java.sql.SQLException;
import java.util.Scanner;

import VeriTabani.IVeriTabani;

public class KullaniciGuncelle implements IKullaniciIslem{

	private IVeriTabani postgresql;
	String query;

	public KullaniciGuncelle(IVeriTabani postgresql) {
		
		this.postgresql = postgresql;
	}

	@Override
	public void KIslem(Kullanici kullanici) throws SQLException {
		System.out.println("Enter NEW kullanici_adi..:");
		Scanner in = new Scanner(System.in);
		String tmp_kullanici_adi = in.nextLine();
		System.out.println("Enter NEW sifre..:");
		String tmp_sifre = in.nextLine();
		
		
		query = "update public.kullanici set kullanici_adi = '"+tmp_kullanici_adi+
				"', sifre = '"+tmp_sifre+"' where kullanici_adi = '"+kullanici.getKullanici_adi()+"';";
		postgresql.executeQueryOnVT(query);
		
	}

}
