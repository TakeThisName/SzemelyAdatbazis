package adatbazis.app;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {


		static Szemely adatbazis = new Szemely();
		static Scanner beolvas = new Scanner(System.in);
		
		public static void listaz () {
			adatbazis.showAllSzemely();
		}
		
		public static void hozzaad() {
			System.out.println("Kérem a vezetéknevet: ");
			String veznev = beolvas.next();
			System.out.println("Kérem a keresztnevet: ");
			String knev = beolvas.next();
			System.out.println("Kérem a születési időt: ");
			String szuld = beolvas.next();
			
			adatbazis.addSzemely(veznev, knev, szuld);
		}
		
		public static void torles() {
			System.out.println("Kérem a felhasználó id-ját a törléshez: ");
			String id = beolvas.next();
			adatbazis.removeSzemely(id);
		}
		
		
		public static void modosit() {
			System.out.println("Kérem a felhasználó id-ját: ");
			String id = beolvas.next();
			System.out.println("Kérem a vezetéknevet: ");
			String veznev = beolvas.next();
			System.out.println("Kérem a keresztnevet: ");
			String knev = beolvas.next();
			System.out.println("Kérem a születési időt: ");
			String szuld = beolvas.next();
			
			adatbazis.updateSzemely(id, veznev, knev, szuld);
		}

		public static void main(String[] args) {
			
			boolean kilep = false;
			String valasztas = null;
			
			while (kilep != true) {
				System.out.println("1) Személyek kilistázása");
				System.out.println("2) Új szeméyl hozzáadása");
				System.out.println("3) Személy törlése");
				System.out.println("4) Meglévő személy módosítása");
				System.out.println("5) Kilépés");
				
				System.out.println("\n\n Kérem válasszon menüpontot!");
				valasztas = beolvas.next();
				System.out.println();
				
				switch (valasztas) {
				case "1":
					listaz();
					System.out.println();
					break;
				case "2":
					hozzaad();
					System.out.println();
					break;
				case "3":
					torles();
					System.out.println();
					break;
				case "4":
					modosit();
					System.out.println();
					break;
				case "5":
					kilep = true;
					beolvas.close();
					System.exit(0);
					break;
				default:
					System.out.println(" - nem létező menüpont!");
					break;
				}
			}
			
			

		}

	}


