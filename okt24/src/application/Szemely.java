package application;

import javafx.beans.property.SimpleStringProperty;

public class Szemely {
	
	private SimpleStringProperty id;
	private SimpleStringProperty veznev;
	private SimpleStringProperty knev;
	private SimpleStringProperty szulido;
	
	
	public Szemely(String id, String veznev, String knev, String szulido) {
		super();
		this.id = new SimpleStringProperty(id);
		this.veznev = new SimpleStringProperty(veznev);
		this.knev = new SimpleStringProperty(knev);
		this.szulido = new SimpleStringProperty(szulido);
	}

	public final SimpleStringProperty idProperty() {
		return this.id;
	}
	
	public final String getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final String id) {
		this.idProperty().set(id);
	}
	
	public final SimpleStringProperty veznevProperty() {
		return this.veznev;
	}
	
	public final String getVeznev() {
		return this.veznevProperty().get();
	}
	
	public final void setVeznev(final String veznev) {
		this.veznevProperty().set(veznev);
	}
	
	public final SimpleStringProperty knevProperty() {
		return this.knev;
	}
	
	public final String getKnev() {
		return this.knevProperty().get();
	}
	
	public final void setKnev(final String knev) {
		this.knevProperty().set(knev);
	}
	
	public final SimpleStringProperty szulidoProperty() {
		return this.szulido;
	}
	
	public final String getSzulido() {
		return this.szulidoProperty().get();
	}
	
	public final void setSzulido(final String szulido) {
		this.szulidoProperty().set(szulido);
	}
	
	
}
