import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Morze {
	private String szerzo, idezet;
	
	
	

	public Morze(String szerzo, String idezet) {
		super();
		this.szerzo = szerzo;
		this.idezet = idezet;
	}

	public String getSzerzo() {
		return szerzo;
	}

	public void setSzerzo(String szerzo) {
		this.szerzo = szerzo;
	}

	public String getIdezet() {
		return idezet;
	}

	public void setIdezet(String idezet) {
		this.idezet = idezet;
	}

	@Override
	public String toString() {
		return szerzo + "   " + idezet;
	}
	
}
