import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("RMI REGISTRY CREATED");

		} catch (Exception e) {

		}
	}

}
