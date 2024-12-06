import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Asortimentas{

	private List<Preke> prekes = new ArrayList<>();
	
	//SINGLETON PATTERN 
	private static Asortimentas instance;
	
	private Asortimentas() {
		seedDummyData();
	}
	
	public static Asortimentas getInstance() {
		if(instance == null)
			instance = new Asortimentas();
		
		return instance;
	}
		
	public void seedDummyData() {
		Long nextIndex = 1L;
		prekes.add( new Preke(nextIndex++, "Margarita", "Mocarela ir pomidorai", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Studentu", "Desra ir agurkai", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Astrioji", "Keptas farsas ir cili", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Siciliana", "Astri su padazu", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Cezario", "Cezario su kepta vistiena", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Svieziu darzoviu", "Svieziu salonu derinys", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Graikiskos", "Su feta suriu", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Coca-Cola", "Saldi su cukrum", 2.4d) );
		prekes.add( new Preke(nextIndex++, "Koldunai", "Kepti koldunai", 2.4d) );
	}

	
	
	public List<Preke> getAll(){
		return prekes;
	}
	
	public Optional<Preke> getById(Long id){
		return prekes.stream()
				.filter( item -> item.id() == id)
				.findFirst();
	}
	
	
}
