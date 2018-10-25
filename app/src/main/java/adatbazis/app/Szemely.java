package adatbazis.app;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Szemely {
	final String JDBC_DRIVER = "org.sqlite.JDBC";
	final String URL = "jdbc:sqlite:Szemely.db";
	
	Connection conn = null;
	Statement createStatement = null;
	DatabaseMetaData dbmd = null;
	
	public Szemely() {
		try {
			conn = DriverManager.getConnection(URL);
			System.out.println("A kapcsolat létrejött");
		} catch (SQLException e) {
			System.err.println("Valami baj van a kapcsolattal!"+e);
		}
		// megnézzük h üres-e az adatbázis
		if (conn != null) {
			try {
				createStatement = conn.createStatement();
			} catch (SQLException e) {
				System.err.println("Valami baj van a createStatement létrehozásakor!"+e);
			}
		}
	}
	
	public void showAllSzemely() {
		String sql = "SELECT * FROM Szemely";
		
		try {
			ResultSet rs = createStatement.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String veznev = rs.getString("vezeteknev");
				String knev = rs.getString("keresztnev");
				String szulido = rs.getString("szuldatum");
				System.out.println(id + " | "+ veznev +" | " + knev + " | "+ szulido);
			}
		} catch (SQLException e) {
			System.err.println("Hiba a személy kiolvasásakor! " + e);
		}

	}
	
	public void addSzemely(String veznev, String knev, String szuld) {
		String sql = "INSERT INTO Szemely(vezeteknev, keresztnev, szuldatum) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, veznev);
			ps.setString(2, knev);
			ps.setString(3, szuld);
			ps.execute();
			
		} catch (SQLException e) {
			System.err.println("Nem sikerült hozzáadni a személyt az adatbázishoz!"+e);
		}

	}
	
	public void removeSzemely(String id) {
		String sql = "DELETE FROM Szemely WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (Exception e) {
			System.err.println("Nem sikerült törölni a személyt az adatbázisból!"+e);
		}
	}
	
	public void updateSzemely(String id, String veznev, String knev, String szuld) {
		String sql = "UPDATE szemely SET vezeteknev=?, keresztnev=?, szuldatum=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, veznev);
			ps.setString(2, knev);
			ps.setString(3, szuld);
			ps.setString(4, id);
			ps.execute();
			
		} catch (SQLException e) {
			System.err.println("Nem sikerült hozzáadni a személyt az adatbázishoz!"+e);
		}

	}
}
