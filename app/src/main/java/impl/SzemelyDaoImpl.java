package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.SzemelyDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Szemely;

public class SzemelyDaoImpl implements SzemelyDao {

	private Szemely createSzemely(ResultSet rs) {
		Szemely sz = null;
		try {
			sz = new Szemely();
			sz.setId(rs.getString("id"));
			sz.setVeznev(rs.getString("vezeteknev"));
			sz.setKnev(rs.getString("keresztnev"));
			sz.setSzulido(rs.getString("szuldatum"));
			
			
		} catch (SQLException e) {
			System.err.println("Hiba a személyek kiolvasásakor!" + e);
		}
		return sz;
	}
	@Override
	public ObservableList<Szemely> get() {
		String sql = "SELECT * FROM szemely";
		ObservableList<Szemely> lista = FXCollections.observableArrayList();
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(URL);
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			
			while (rs.next()) {
				Szemely sz = createSzemely(rs);
				lista.add(sz);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
		}
		return lista;
	}

	@Override
	public void add(Szemely sz) {
		

	}

	@Override
	public void remove(Szemely sz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Szemely sz) {
		// TODO Auto-generated method stub

	}

}