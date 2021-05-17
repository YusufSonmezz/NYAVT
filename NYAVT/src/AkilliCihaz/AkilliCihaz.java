package AkilliCihaz;

import java.sql.SQLException;

public class AkilliCihaz {
	
	public static void basla() throws SQLException
	{
		AnaIslemPlatformu aip = new AnaIslemPlatformu();
		
		aip.Menu();
	}

	public static void main(String[] args) throws SQLException{
		
		basla();
		
	}

}