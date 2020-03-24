

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

public interface TreeSetInterface extends Remote {
	public void insert(int id, String make, String model, String engine, int year, int doors, int seats, float weight,
			int price, int fuelCapacity, float fuelAverage) throws RemoteException;

	public void print() throws RemoteException;

	public int getMaxVehicleID() throws RemoteException;

	public TreeNode searchByID(int id) throws RemoteException;

	public Set<TreeNode> searchByMake(String make) throws RemoteException;

	public Set<TreeNode> searchByPrice(int min_price, int max_price) throws RemoteException;

	public Set<TreeNode> getAllIDs() throws RemoteException;

	public TreeNode getVehicleInfo(int id) throws RemoteException;

	public TreeNode updateVehicle(TreeNode node) throws RemoteException;

	public Set<TreeNode> allVehicleData() throws RemoteException;

	public void deleteVehicle(int vehicleID) throws RemoteException;
}
