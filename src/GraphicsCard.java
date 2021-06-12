
public class GraphicsCard {
	@Override
	public String toString() {
		return "" + brand + " " + model + " " + vendor + " " + capacity + " GB";
	}

	private String brand, model, vendor;
	private int capacity, price;
	private char usage;

	public GraphicsCard(String brand, String model, String vendor, int capacity, int price, char usage) {
		this.brand = brand;
		this.model = model;
		this.vendor = vendor;
		this.capacity = capacity;
		this.price = price;
		this.usage = usage;
	}
	
	public GraphicsCard(String brand, String model, String vendor, String capacity, String price, String usage) {
		this.brand = brand;
		this.model = model;
		this.vendor = vendor;
		this.capacity = Integer.parseInt(capacity);
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
