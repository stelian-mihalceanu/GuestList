import java.util.ArrayList;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Ati venit la evenimentul Devmind!");
		System.out.println();
		System.out.println("Bun venit! Introduceti numarul de locuri disponibile: ");
		
		int nrPlaces = sc.nextInt();		
		GuestList participants = new GuestList(nrPlaces);
		System.out.println();

		while(nrPlaces != 0) {			
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			String s2 = sc.next();			
			System.out.println();
			
				switch(s2) {
				
				case "help": {
					participants.help();
					break;		
				}
			
				case "add": {					
					Guest g1 = new Guest("","","","");
										
					System.out.println("Se adauga o noua persoana...");
					System.out.println();
					
					System.out.println("Introduceti numele de familie: ");
					String newName = sc.next();
					g1.setFirstName(newName);
					System.out.println();
					
					System.out.println("Introduceti prenumele: ");
					String newLastName = sc.next();
					g1.setLastName(newLastName);
					System.out.println();
					
					System.out.println("Introduceti adresa de mail: ");
					String newEmail = sc.next();
					g1.setEmail(newEmail);
					System.out.println();
					
					System.out.println("Introduceti numarul de telefon (format \"+40733386463\"): ");
					String newPhone = sc.next();
					g1.setMobilePhone(newPhone);
					System.out.println();
					
					int a = participants.add(g1);
					System.out.println(a);
					
					break;		
				}
			
				case "check": {
					System.out.println("Se cauta o persoana existenta din lista de participanti…");
					System.out.println();
					System.out.println("Alege un criteriu de cautare, tastand:");
					System.out.println("\t \"1\" - Nume si prenume");
					System.out.println("\t \"2\" - Email");
					System.out.println("\t \"3\" - Numar de telefon (format \"+40733386463\" )");
					String n;
							
					int opt = sc.nextInt();
						
					switch(opt) {
						
						case 1: {
							System.out.println("Introduceti nume si prenume");
							n = sc.next() + " " + sc.next();
							System.out.println();
							participants.check(n,1);
						    break;		
						}
						
						case 2: {
							System.out.println("Introduceti adresa de mail");
							n = sc.next();
							System.out.println();
							participants.check(n,2);
						    break;		
						}
						
						case 3: {
							System.out.println("Introduceti numarul de telefon");
							n = sc.next();
							System.out.println();
							participants.check(n,3);
						    break;		
						}
								
					}	
					break;		
				}
		
				case "remove": {
					System.out.println("Se sterge o persoana existenta din lista…");
					System.out.println();
					System.out.println("Alege un criteriu dupa care sa se faca stergerea, tastand:");
					System.out.println("\t \"1\" - Nume si prenume");
					System.out.println("\t \"2\" - Email");
					System.out.println("\t \"3\" - Numar de telefon (format \"+40733386463\" )");
					int opt = sc.nextInt();
					String n;
					
					switch(opt) {
								
						case 1: {						
							System.out.println("Introduceti nume si prenume");
							n = sc.next() + " " + sc.next();
							participants.remove(n,1);
							break;		
						}
								
						case 2: {
							System.out.println("Introduceti adresa de mail");
							n = sc.next();
							participants.remove(n,2);
							break;		
						}
								
						case 3: {
							System.out.println("Introduceti numarul de telefon");
							n = sc.next();
							participants.remove(n,3);
							break;		
						}
										
					}	

					break;
				}
	
				case "update": {
					System.out.println("Se actualizeaza detaliile unei persoane…");
					
					System.out.println("Alege campul de actualizat, tastand:");
					System.out.println("\t \"1\" - Nume");
					System.out.println("\t \"2\" - Prenume");
					System.out.println("\t \"3\" - Email");
					System.out.println("\t \"4\" - Numar de telefon (format \"+40733386463\")");
					int var = sc.nextInt();
					System.out.println();
					String n;
							
						if(var == 1) {
							System.out.println("Introduceti numele de familie: ");
							n = sc.next();
							for (int i = 0; i < participants.getList().size(); i++ )
								participants.getList().get(i).setFirstName(n);
							participants.update(n,1);
							System.out.println("Numele de familie a fost actualizat.");
						}
							
						if(var == 2) {
							System.out.println("Introduceti prenumele: ");
							n = sc.next();
							for (int i = 0; i < participants.getList().size(); i++ )
								participants.getList().get(i).setLastName(n);
							participants.update(n,2);
							System.out.println("Prenumele a fost actualizat.");
						}
							
						if(var == 3) {
							System.out.println("Introduceti adresa de mail: ");
							n = sc.next();
							for (int i = 0; i < participants.getList().size(); i++ )
								participants.getList().get(i).setEmail(n);
							participants.update(n,3);
							System.out.println("Adresa de mail a fost actualizata.");
						}
							
						if(var == 4) {
							System.out.println("Introduceti numarul de telefon: ");
							n = sc.nextLine();
							for (int i = 0; i < participants.getList().size(); i++ )
								participants.getList().get(i).setMobilePhone(n);
							participants.update(n,4);
							System.out.println("Numarul de telefon a fost actualizat.");
						}						
						System.out.println();				
					break;		
				}
			
				case "guests": {
					participants.guests();
					break;		
				}
			
				case "waitlist": {
					participants.waitlist();
					break;		
				}
			
				case "available": {
					participants.available();
					break;		
				}
			
				case "guests_no": {
					participants.guests_no();
					break;		
				}
			
				case "waitlist_no": {
					participants.waitlist_no();
					break;		
				}
			
				case "subscribe_no": {
					participants.subscribe_no();
					break;		
				}
			
				case "search": {
					System.out.println("Introduceti un sir:");
					String string = sc.next();
					participants.search(string);
					break;		
				}
			
				case "quit": {
					participants.quit();
					break;		
				}
			
			}
		
	}
			
		sc.close();
	}

}
