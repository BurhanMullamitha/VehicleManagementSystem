

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LinkedListInterface extends Remote {
	public void insert(int id, String make, String model, String engine, int year, int doors, int seats, float weight,
			int price, int fuelCapacity, float fuelAverage) throws RemoteException;

	public void print() throws RemoteException;

	public int getMaxVehicleID() throws RemoteException;

	public LinkNode searchByID(int vehicleID) throws RemoteException;
	
	public List<LinkNode> searchByMake(String make) throws RemoteException;

	public List<LinkNode> searchByPrice(int min_price, int max_price) throws RemoteException;

	public List<LinkNode> getAllIDs() throws RemoteException;

	public LinkNode getVehicleInfo(int vehicleID) throws RemoteException;

	public LinkNode updateVehicle(LinkNode node) throws RemoteException;

	public List<LinkNode> allVehicleData() throws RemoteException;

	public void deleteVehicle(int vehicleID) throws RemoteException;
}
