import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	public static List<MorzeABC> morzeABC() {
		List<MorzeABC> morzeABC = new ArrayList<>();
		
		try {
			
			List<String> beolvas = Files.readAllLines(Paths.get("morzeabc.txt"));
			
			// foreach az első sort kihagyva, aztán soronként
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split("\t");
				                            // 'A'        ,         .-
				MorzeABC o = new MorzeABC(split[0].charAt(0), split[1]);
				morzeABC.add(o); // listához ad
			}
			
		} catch (Exception e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		
		
		return morzeABC;

	}
	
	public static List<Morze> morze() {
		List<Morze> morze = new ArrayList<>();
		
		try {
			
			List<String> beolvas = Files.readAllLines(Paths.get("morze.txt"));
			
			// foreach az első sort kihagyva, aztán soronként
			for (String sor : beolvas) {
				String[] split = sor.split(";");
				                            
				Morze o = new Morze(split[0], split[1]);
				morze.add(o); // listához ad
			}
			
		} catch (Exception e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		
		
		return morze;

	}
	
	public static String morze2szoveg(String kodolatlanSzoveg, List<MorzeABC> morzeABC) {
		String kodolt = "";
		                                                    // 7db space
		String[] szoveg_szokoz = kodolatlanSzoveg.replaceAll("       ", "szóköz").split("szóköz");
		
		for (String s : szoveg_szokoz) {
			String[] szoveg = s.split("   ");
			for (String ss : szoveg) {
				for (MorzeABC abc : morzeABC) {
					if (ss.equals(abc.getJel())) {
						kodolt += abc.getBetu();
					}
				}
			}
			kodolt += " ";
		}
		return kodolt;
	}
	
	public static Scanner beolvas = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		List<MorzeABC> morzeABC = morzeABC();
		List<Morze> morze = morze();
		// morzeABC.forEach(System.out::println);
		
		System.out.println("3. feladat:  a morze ABC " + morzeABC.size() + " db karaqkter kódját tartalmazza.");
		
		System.out.println("4. feladat: Kérek egy karaktert: ");
		char beolvasott = beolvas.next().toUpperCase().charAt(0);
		String talalat = "Nem található a kódtárban ilyen karakter";
		
		for (MorzeABC abc : morzeABC) {
			if (abc.getBetu() == beolvasott)
				talalat = "A(az) " + beolvasott + " karakter morze kódja: " + abc.getJel();
		}
		System.out.println(talalat);
		// morze.forEach(System.out::println);
		// System.out.println(morze2szoveg("–.   .       .–   ––.   ––.   –––   –..   .–––       .–   ––..       .   ––.   ..–..   ...   ––..   ...   ..–..   ––.   .   –..       ––   ..   .–   –   –   ––.––       .   .–..   ––   ..–   .–..   ..   –.–   .–.–.–", morzeABC));
		System.out.println("7. feladat: az első idézet szerzője: "+ morze2szoveg(morze.get(0).getSzerzo(), morzeABC));
		
		int max = Integer.MIN_VALUE;
		String[] leghosszabbIdezet = new String[2];
		String arisztoteleszIdezetek = "";
		String fajlba = "";
		for (Morze fordit : morze) {
			String szerzo = morze2szoveg(fordit.getSzerzo(), morzeABC);
			String idezet = morze2szoveg(fordit.getIdezet(), morzeABC);
			fajlba += szerzo + ": " + idezet + "\n";
			
			if (szerzo.equals("ARISZTOTELESZ")) {
				arisztoteleszIdezetek += "\t " + idezet + "\n";
			}
			
			if ( idezet.length() > max) {
				max = idezet.length();
				leghosszabbIdezet[0] = szerzo;
				leghosszabbIdezet[1] = idezet;
			}
		}
		System.out.println("8. feladat: a leghosszabb idézet = " + leghosszabbIdezet[0] + ": " + leghosszabbIdezet[1]);
		System.out.println("9. feladat: arisztotelesz idézetek: " + arisztoteleszIdezetek);
		Files.write(Paths.get("forditas.txt"), fajlba.getBytes());
	}

}
