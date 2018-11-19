
public class MorzeABC {
	
	private char betu;
	private String jel;
	
	
	
	public MorzeABC(char betu, String jel) {
		super();
		this.betu = betu;
		this.jel = jel;
	}



	public char getBetu() {
		return betu;
	}



	public void setBetu(char betu) {
		this.betu = betu;
	}



	public String getJel() {
		return jel;
	}



	public void setJel(String jel) {
		this.jel = jel;
	}



	@Override
	public String toString() {
		return "betu=  " + betu + "  Jel=  " + jel;
	}



}
