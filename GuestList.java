import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {
	
	private ArrayList<Guest> list = new ArrayList<Guest>();
	private ArrayList<Guest> waitingList = new ArrayList<Guest>();
	private int numberOfPlaces;
	
	Scanner sc = new Scanner(System.in);
	
	public GuestList(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public ArrayList<Guest> getList() {
		return list;
	}

	public void setList(ArrayList<Guest> list) {
		this.list = list;
	}

	public ArrayList<Guest> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(ArrayList<Guest> waitingList) {
		this.waitingList = waitingList;
	}

	public int add(Guest g) {
		
		for (int i = 0; i < list.size(); i++ )
			if (g.getEmail().equals(list.get(i).getEmail()) ||
				g.getMobilePhone().equals(list.get(i).getMobilePhone()) ||
				g.getFirstName().equals(list.get(i).getFirstName()) ||
				g.getLastName().equals(list.get(i).getLastName())) {
				
				System.out.println("Persoana este deja in lista de participanti");
				System.out.println();
				
				return -1;
			}
		
		
		for (int i = 0; i < waitingList.size(); i++ )
			if (g.getEmail().equals(waitingList.get(i).getEmail()) ||
				g.getMobilePhone().equals(waitingList.get(i).getMobilePhone()) ||
				g.getFirstName().equals(waitingList.get(i).getFirstName()) ||
				g.getLastName().equals(waitingList.get(i).getLastName())) {
				
				System.out.println("Persoana este deja in lista de asteptare");
				System.out.println();
				
				return (i + 1);
			}
		
		if (this.numberOfPlaces > list.size()) {
			this.list.add(g);
			System.out.println("[" + g.getFirstName() + " " + g.getLastName() + "] " 
					+ "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			System.out.println();
			return 0;
		}
		
		if (this.numberOfPlaces <= list.size()) {
			this.waitingList.add(g);		
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "
						 + this.waitingList.size() + ". Te vom notifica daca un loc devine disponibil.");
			return this.waitingList.size();
		}
	
		return 0;		
	}
	
	public void check(String s, int a) {
		if (a == 1) {
			for (int i = 0; i < list.size(); i++ ) {
				String p = list.get(i).getFirstName() + " " + list.get(i).getLastName();
				if (s.equals(p)) {		  			
						System.out.println("Persoana este deja in lista de participanti.");
						System.out.println();
				} else {
					System.out.println("Persoana nu este in lista de participanti");
				}
			}
		}
		
		if (a == 2) {
			for (int i = 0; i < list.size(); i++ )
				if (s.equals(list.get(i).getEmail())) {
					System.out.println("Persoana este deja in lista de participanti");
				} else {
					System.out.println("Persoana nu este in lista de participanti");
				}
		}
		
		if(a == 3) {
			for (int i = 0; i < list.size(); i++ )
				if (s.equals(list.get(i).getMobilePhone())) {
					System.out.println("Persoana este deja in lista de participanti");
				} else {
					System.out.println("Persoana nu este in lista de participanti");
				}
		}
		
	}
	
	public boolean remove(String str, int a) {
		if (a == 1) {
			for (int i = 0; i < list.size(); i++ ) {
				String p = list.get(i).getFirstName() + " " + list.get(i).getLastName();
				if (str.equals(p)) {
					this.list.remove(list.get(i));
					System.out.println("Stergerea persoanei s-a realizat cu succes.");
					System.out.println();
				}
			}
		}
		
		if (a == 2) {
			for (int i = 0; i < list.size(); i++ )
				if (str.equals(list.get(i).getEmail())) {
					this.list.remove(list.get(i));
					System.out.println("Stergerea persoanei s-a realizat cu succes.");
					System.out.println();
				}
		}
		
		if(a == 3) {
			for (int i = 0; i < list.size(); i++ )
				if (str.equals(list.get(i).getMobilePhone())) {
					this.list.remove(list.get(i));
					System.out.println("Stergerea persoanei s-a realizat cu succes.");
					System.out.println();
				}
		}
					     				
		return true;
	}
	
	public void update(String s, int a) {
		if (a == 1) {
			for (int i = 0; i < list.size(); i++ ) {
				if (s.equals(list.get(i).getFirstName())) {
					list.get(i).setFirstName(s);
				}
			}
		}
		
		if (a == 2) {
			for (int i = 0; i < list.size(); i++ )
				if (s.equals(list.get(i).getLastName())) {
					list.get(i).setLastName(s);
				}
		}
		
		if(a == 3) {
			for (int i = 0; i < list.size(); i++ )
				if (s.equals(list.get(i).getEmail())) {
					list.get(i).setEmail(s);
				}
		}
		
		if(a == 4) {
			for (int i = 0; i < list.size(); i++ )
				if (s.equals(list.get(i).getMobilePhone())) {
					list.get(i).setMobilePhone(s);
				}
		}
				
	}
	
	public void guests() {				
		int index = 1;
		if(this.list.size() == 0) {
			System.out.println("Niciun participant inscris…");
		}
					
		for (Guest g : this.list) {
				System.out.println(index + "." + " " + "Nume: " + g.getFirstName() + " " + ", Prenume: " + g.getLastName() 
					+ ", Email: " + g.getEmail() + ", Telefon: " + g.getMobilePhone());									
				index++;
		}
		
		System.out.println();
	}
	
	public void waitlist() {
		int index2 = 1;		
		if(this.waitingList.size() == 0) {
			System.out.println("Lista de asteptare este goala...");
		}
		
		for (Guest g : this.waitingList) {
			System.out.println(index2 + "." + " " + "Nume: " + g.getFirstName() + " " + ", Prenume: " + g.getLastName() 
					+ ", Email: " + g.getEmail() + ", Telefon: " + g.getMobilePhone());							
			index2++;
		}
		
		System.out.println();
	}
	
	public int available() {
		System.out.println("Numarul de locuri libere: " + (this.numberOfPlaces - list.size()));
		System.out.println();
		return (this.numberOfPlaces - list.size());
	}
	
	public int guests_no() {
		System.out.println("Numarul de persoane care participa la eveniment: " + list.size());
		System.out.println();
		return list.size();
	}
	
	public int waitlist_no() {
		System.out.println("Numarul de persoane din lista de asteptare: " + waitingList.size());
		System.out.println();
		return waitingList.size();
	}
	
	public int subscribe_no() {
		System.out.println("Numarul total de persoane inscrise: " + (list.size() + waitingList.size()));
		System.out.println();
		return (list.size() + waitingList.size());	
	}
	
	public void search(String s) {
		System.out.println("Se cauta o persoana existenta din lista…");
		System.out.println();
		s = s.toLowerCase();
		int ok = 1;

		
		for (Guest g : this.list) {
			if (g.getEmail().toLowerCase().contains(s) ||
					g.getMobilePhone().toLowerCase().contains(s) ||
					g.getFirstName().toLowerCase().contains(s) ||
					g.getLastName().toLowerCase().contains(s))
				
				System.out.println(ok + "." + "\t Numele: " + g.getFirstName() + "\t Prenumele " + g.getLastName()
				+ "\t Adresa de mail " + g.getEmail() + "\t Numarul de telefon " + g.getMobilePhone());
			ok++;				
			
		}
		
		System.out.println();

	}
	
		
	public void help() {
								
		System.out.println();
		System.out.println(" Alegeti o optiune");
		System.out.println();
		System.out.println("help         - Afiseaza aceasta lista de comenzi");
		System.out.println(" add         - Adauga o noua persoana (inscriere)");
		System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
		System.out.println("remove       - Sterge o persoana existenta din lista");
		System.out.println("update       - Actualizeaza detaliile unei persoane");
		System.out.println("guests       - Lista de persoane care participa la eveniment");
		System.out.println("waitlist     - Persoanele din lista de asteptare");
		System.out.println("available    - Numarul de locuri libere");
		System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
		System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
		System.out.println("subscribe_no - Numarul total de persoane inscrise");
		System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
		System.out.println("quit         - Inchide aplicatia");
		System.out.println();
	
	}
	
		
	public void quit() {		
		System.out.println("Aplicatia s-a inchis.");
		System.out.println();
	}
	

}
