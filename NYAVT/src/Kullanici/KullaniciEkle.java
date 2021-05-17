package Kullanici;

import java.sql.SQLException;

import VeriTabani.IVeriTabani;

public class KullaniciEkle implements IKullaniciIslem{
	
	private IVeriTabani postgresql;
	String query;

	public KullaniciEkle(IVeriTabani postgresql) {
		
		this.postgresql = postgresql;
	}

	@Override
	public void KIslem(Kullanici kullanici) throws SQLException {
		
		query = "insert into public.kullanici(kullanici_adi, sifre) values ('"+kullanici.getKullanici_adi()+
				"','"+kullanici.getSifre()+"')";
		postgresql.executeQueryOnVT(query);
		
	}

}
