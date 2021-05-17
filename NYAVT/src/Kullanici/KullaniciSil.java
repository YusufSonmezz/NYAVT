package Kullanici;

import java.sql.SQLException;

import VeriTabani.IVeriTabani;

public class KullaniciSil implements IKullaniciIslem{
	
	private IVeriTabani postgresql;
	String query;

	public KullaniciSil(IVeriTabani postgresql) {
		
		this.postgresql = postgresql;
	}

	@Override
	public void KIslem(Kullanici kullanici) throws SQLException {
		
		query = "delete from public.kullanici where kullanici_adi ='"+kullanici.getKullanici_adi()+"';";
		postgresql.executeQueryOnVT(query);
		
	}

}
