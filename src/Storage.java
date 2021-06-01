
public class Storage {
	@Override
	public String toString() {
		return "Storage [type=" + type + ", brand=" + brand + ", model=" + model + ", capacity=" + capacity
				+ ", readSpeed=" + readSpeed + ", writeSpeed=" + writeSpeed + ", price=" + price + "]";
	}

	private String type, brand, model;
	private int capacity, readSpeed, writeSpeed, price;

	public Storage(String type, String brand, String model, int capacity, int readSpeed, int writeSpeed, int price) {
		super();
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.capacity = capacity;
		this.readSpeed = readSpeed;
		this.writeSpeed = writeSpeed;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getReadSpeed() {
		return readSpeed;
	}

	public void setReadSpeed(int readSpeed) {
		this.readSpeed = readSpeed;
	}

	public int getWriteSpeed() {
		return writeSpeed;
	}

	public void setWriteSpeed(int writeSpeed) {
		this.writeSpeed = writeSpeed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
