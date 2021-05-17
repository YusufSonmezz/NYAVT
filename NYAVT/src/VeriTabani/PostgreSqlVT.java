package VeriTabani;

import java.sql.Connection;

import Kullanici.Kullanici;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import AkilliCihaz.AgArayuzu;

public class PostgreSqlVT implements IVeriTabani{
	
	private Connection conn;
	private String url;
	private AgArayuzu agArayuzu;

	public PostgreSqlVT() throws SQLException {
		this.conn = null;
		this.url = "jdbc:postgresql://localhost:5432/NYAVT";
		agArayuzu = new AgArayuzu();
		this.connect();
	}
	
	public void connect() throws SQLException
	{
		conn = DriverManager.getConnection(url, "postgres", "yusufkayra54");
		System.out.println("Connected to DataBase...:)");
	}


	@Override
	public boolean KullaniciDogrula(Kullanici kullanici) throws SQLException {
		boolean isCorrect = false;
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select public.iscorrect(kullaniciAdi =>'"+kullanici.getKullanici_adi()+
				"' , sifre_function => '"+ kullanici.getSifre()+"');");
		while(rs.next())
		{
			isCorrect = rs.getBoolean("iscorrect");
		}
		
		return isCorrect;
	}

	@Override
	public void printfDataBase() throws SQLException {
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from public.kullanici;");
		while(rs.next())
		{
			System.out.println("Kullanicinin..: \nAdi..: "+ rs.getString("kullanici_adi")+", Sifresi..: "+ rs.getString("sifre")
			+", id'si..: "+ rs.getInt("id")+"\n");
		}
		
	}

	@Override
	public void executeQueryOnVT(String query) throws SQLException {
		
		Statement st = conn.createStatement();
		st.executeUpdate(query);
		
	}
}
