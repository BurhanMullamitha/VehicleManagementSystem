
import java.io.Serializable;

public class LinkNode implements Serializable{

	int id, price;
	String make, model, engine;
	int year, doors, seats, fuelCapacity;
	float fuelAverage, weight;

	public LinkNode(int id, String make, String model, String engine, int year, int doors, int seats, float weight,
			int price, int fuelCapacity, float fuelAverage) {
		this.id = id;
		this.make = new String(make);
		this.model = new String(model);
		this.engine = new String(engine);
		this.year = year;
		this.doors = doors;
		this.seats = seats;
		this.weight = weight;
		this.price = price;
		this.fuelCapacity = fuelCapacity;
		this.fuelAverage = fuelAverage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public float getFuelAverage() {
		return fuelAverage;
	}

	public void setFuelAverage(float fuelAverage) {
		this.fuelAverage = fuelAverage;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
