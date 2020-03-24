import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static LinkedListImplementation linkedlistImpl;
	
	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("RMI REGISTRY CREATED");

		} catch (Exception e) {
			
		}
		try {
			linkedlistImpl = new LinkedListImplementation();
			Naming.rebind("list", linkedlistImpl);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
