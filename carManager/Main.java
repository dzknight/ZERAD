package carManager;
import org.json.simple.*;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new CarManager();
		Optional<String> name=Optional.empty();
		if(name.isPresent()) {
			System.out.println(name.get());
		} else {
			
		}
	}

}
