
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetImplementation extends UnicastRemoteObject implements TreeSetInterface {

	Set<TreeNode> VehicleSet = new TreeSet<TreeNode>();

	public TreeSetImplementation() throws RemoteException {
		super();
	}

	@Override
	public void insert(int id, String make, String model, String engine, int year, int doors, int seats, float weight,
			int price, int fuelCapacity, float fuelAverage) throws RemoteException {
		TreeNode newVehicle = new TreeNode(id, make, model, engine, year, doors, seats, weight, price, fuelCapacity,
				fuelAverage);
		VehicleSet.add(newVehicle);

	}

	@Override
	public void print() throws RemoteException {
		for (TreeNode b : VehicleSet) {
			System.out.println(b.id + " " + b.make + " " + b.model + " " + b.engine);
		}
	}

	@Override
	public int getMaxVehicleID() throws RemoteException {
		try {
			TreeNode last = ((TreeSet<TreeNode>) VehicleSet).last();
			int lastID = last.getId();
			return lastID;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public TreeNode searchByID(int id) throws RemoteException {
		Iterator<TreeNode> iterator = VehicleSet.iterator();
		while (iterator.hasNext()) {
			TreeNode temp = (TreeNode) iterator.next();
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public Set<TreeNode> searchByMake(String make) throws RemoteException {
		Set<TreeNode> makeList = new TreeSet<TreeNode>();
		Iterator<TreeNode> iterator = VehicleSet.iterator();
		while (iterator.hasNext()) {
			TreeNode temp = (TreeNode) iterator.next();
			if (temp.getMake().equals(make)) {
				makeList.add(temp);
			}
		}
		return makeList;
	}

	@Override
	public Set<TreeNode> searchByPrice(int min_price, int max_price) throws RemoteException {
		Set<TreeNode> priceList = new TreeSet<TreeNode>();
		Iterator<TreeNode> iterator = VehicleSet.iterator();
		while (iterator.hasNext()) {
			TreeNode temp = (TreeNode) iterator.next();
			if (temp.getPrice() >= min_price && temp.getPrice() <= max_price) {
				priceList.add(temp);
			}
		}
		return priceList;
	}

	@Override
	public Set<TreeNode> getAllIDs() throws RemoteException {
		Set<TreeNode> idList = new TreeSet<TreeNode>();
		Iterator<TreeNode> iterator = VehicleSet.iterator();
		while (iterator.hasNext()) {
			TreeNode temp = (TreeNode) iterator.next();
			idList.add(temp);
		}
		return idList;
	}

	@Override
	public TreeNode getVehicleInfo(int vehicleID) throws RemoteException {
		Iterator<TreeNode> iterator = VehicleSet.iterator();
		while (iterator.hasNext()) {
			TreeNode temp = (TreeNode) iterator.next();
			if (temp.getId() == vehicleID) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public TreeNode updateVehicle(TreeNode node) throws RemoteException {
		Iterator<TreeNode> iterator = VehicleSet.iterator();
		while (iterator.hasNext()) {
			TreeNode temp = (TreeNode) iterator.next();
			if (temp.getId() == node.getId()) {
				temp.setMake(node.getMake());
				temp.setModel(node.getModel());
				temp.setEngine(node.getEngine());
				temp.setYear(node.getYear());
				temp.setDoors(node.getDoors());
				temp.setSeats(node.getSeats());
				temp.setWeight(node.getWeight());
				temp.setPrice(node.getPrice());
				temp.setFuelAverage(node.getFuelAverage());
				temp.setFuelCapacity(node.getFuelCapacity());
			}
		}
		return null;
	}

	@Override
	public Set<TreeNode> allVehicleData() throws RemoteException {

		return VehicleSet;
	}

	@Override
	public void deleteVehicle(int vehicleID) throws RemoteException {
		Iterator<TreeNode> iterator = VehicleSet.iterator();
		while (iterator.hasNext()) {
			TreeNode temp = (TreeNode) iterator.next();
			if (temp.getId() == vehicleID) {
				VehicleSet.remove(temp);
			}
		}

	}

}
