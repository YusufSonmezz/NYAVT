package VeriTabani;

import java.sql.SQLException;

import Kullanici.Kullanici;

public interface IVeriTabani {
	void connect() throws SQLException;
	boolean KullaniciDogrula(Kullanici kullanici) throws SQLException;
	void printfDataBase() throws SQLException;
	void executeQueryOnVT(String query) throws SQLException;
}
