import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UI {
	static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		List<Preke> prekes = Asortimentas.getInstance().getAll();
		
		prekes.forEach( item -> System.out.println(    
					String.format( "%d - %-20s kaina : %.2f" -%s , 
							item.id(),
							item.name(),
							BL.getSalePrice(item.price()),
						        item.getDescription())

				));

	}
	
	public static Order createNewOrder(Long orderId) {
		Order order = new Order(orderId);
		
		do {
			Preke preke = getItemFromUser();
			int quantity = getQuantityForPreke(preke);
		
			Long id = order.getNextAvailableId();
			order.addItem(new OrderItem(id, preke, quantity, preke.price()));
			
		} while (arTesti());
		 return order;
	}
	
	private static boolean arTesti() {
		System.out.println("Ar norite dar ko nors? TAIP/NE");
		String atsakymas = sc.nextLine();
		
		return atsakymas.startsWith("T") || atsakymas.startsWith("t");
		
	}
	
	
	private static int getQuantityForPreke(Preke preke) {
		System.out.println("Jus pasirinkote " + preke.name());
		while(true) {
			System.out.println("Iveskite kieki");
			try {
			
				int skaicius = Integer.parseInt(  sc.nextLine() );
				
				if(skaicius >= 0)
					return skaicius;
				
				System.out.println("Pasirinkite nuo 0 ir daugiau");
				
			} catch(Exception e) {
				System.out.println("turi buti skaicius");
			}
		}				
	}

	public static Preke getItemFromUser() {
		printMenu();

		while(true) {
			System.out.println("Iveskite patiekalo numeri");
			String line = sc.nextLine();
			
			try {
				Long id = Long.parseLong(line);
				Optional<Preke> preke = Asortimentas
						.getInstance()
						.getById(id);
				
				if(preke.isPresent())
					return preke.get();
				
				System.out.println("Tokios prekes nera sarase");
				
			} catch(Exception e) {
				System.out.println("Turi buti numeris");
			}
	
		}

	}
	

}
