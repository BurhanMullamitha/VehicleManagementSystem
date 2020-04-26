

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListImplementation extends UnicastRemoteObject implements LinkedListInterface {

	List<LinkNode> VehicleList = new LinkedList<LinkNode>();

	protected LinkedListImplementation() throws RemoteException {
		super();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/VehicleInfo(LinkedList).dat"));
			VehicleList = (List<LinkNode>) in.readObject();
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(int id, String make, String model, String engine, int year, int doors, int seats, float weight,
			int price, int fuelCapacity, float fuelAverage) throws RemoteException {

		LinkNode newVehicle = new LinkNode(id, make, model, engine, year, doors, seats, weight, price, fuelCapacity,
				fuelAverage);
		VehicleList.add(newVehicle);

	}

	@Override
	public void print() throws RemoteException {
		for (LinkNode b : VehicleList) {
			System.out.println(b.id + " " + b.make + " " + b.model + " " + b.engine);
		}
	}

	@Override
	public int getMaxVehicleID() throws RemoteException {
		try {
			LinkNode lastVehicle = ((LinkedList<LinkNode>) VehicleList).peekLast();
			int lastVehicleID = lastVehicle.getId();
			return lastVehicleID;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public LinkNode searchByID(int id) throws RemoteException {
		ListIterator<LinkNode> iterator = VehicleList.listIterator();
		while (iterator.hasNext()) {
			LinkNode temp = (LinkNode) iterator.next();
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public List<LinkNode> searchByMake(String make) throws RemoteException {
		List<LinkNode> makeList = new LinkedList<LinkNode>();
		ListIterator<LinkNode> iterator = VehicleList.listIterator();
		while (iterator.hasNext()) {
			LinkNode temp = (LinkNode) iterator.next();
			if (temp.getMake().equals(make)) {
				makeList.add(temp);
			}
		}
		return makeList;
	}

	@Override
	public List<LinkNode> searchByPrice(int min_price, int max_price) throws RemoteException {
		List<LinkNode> priceList = new LinkedList<LinkNode>();
		ListIterator<LinkNode> iterator = VehicleList.listIterator();
		while (iterator.hasNext()) {
			LinkNode temp = (LinkNode) iterator.next();
			if (temp.getPrice() >= min_price && temp.getPrice() <= max_price) {
				priceList.add(temp);
			}
		}
		return priceList;
	}

	@Override
	public List<LinkNode> getAllIDs() throws RemoteException {
		List<LinkNode> idList = new LinkedList<LinkNode>();
		ListIterator<LinkNode> iterator = VehicleList.listIterator();
		while (iterator.hasNext()) {
			LinkNode temp = (LinkNode) iterator.next();
			idList.add(temp);
		}
		return idList;
	}

	@Override
	public LinkNode getVehicleInfo(int vehicleID) throws RemoteException {
		ListIterator<LinkNode> iterator = VehicleList.listIterator();
		while (iterator.hasNext()) {
			LinkNode temp = (LinkNode) iterator.next();
			if (temp.getId() == vehicleID) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public LinkNode updateVehicle(LinkNode node) throws RemoteException {
		ListIterator<LinkNode> iterator = VehicleList.listIterator();
		while (iterator.hasNext()) {
			LinkNode temp = (LinkNode) iterator.next();
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
	public List<LinkNode> allVehicleData() throws RemoteException {
		return VehicleList;
	}

	@Override
	public void deleteVehicle(int vehicleID) throws RemoteException {

		ListIterator<LinkNode> iterator = VehicleList.listIterator();
		while (iterator.hasNext()) {
			LinkNode temp = (LinkNode) iterator.next();
			if (temp.getId() == vehicleID) {
				VehicleList.remove(temp);
				return;
			}
		}

	}

}
