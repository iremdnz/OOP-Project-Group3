
public class Memory {
	@Override
	public String toString() {
		return brand + " " + model + " " + capacity + " GB " + speed + " Mhz" + " CL" + latency;
	}

	private String brand, model, type;
	private int speed, capacity, latency, price;
	private char usage;

	public Memory(String brand, String model, int speed, int capacity, String type, int latency, int price, char usage) {
		this.brand = brand;
		this.model = model;
		this.speed = speed;
		this.capacity = capacity;
		this.type = type;
		this.latency = latency;
		this.price = price;
		this.usage = usage;
	}
	
	public Memory(String brand, String model, String speed, String capacity, String type, String latency, String price, String usage) {
		this.brand = brand;
		this.model = model;
		this.speed = Integer.parseInt(speed);
		this.capacity = Integer.parseInt(capacity);
		this.type = type;
		this.latency = Integer.parseInt(latency);
		this.price = Integer.parseInt(price);
		this.usage = usage.charAt(0);
	}

	public char getUsage() {
		return usage;
	}

	public void setUsage(char usage) {
		this.usage = usage;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
