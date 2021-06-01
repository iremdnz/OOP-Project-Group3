
public class GraphicsCard {
	@Override
	public String toString() {
		return "GraphicsCard [brand=" + brand + ", model=" + model + ", vendor=" + vendor + ", capacity=" + capacity
				+ ", price=" + price + "]";
	}

	private String brand, model, vendor;
	private int capacity, price;
	
	public GraphicsCard(String brand, String model, String vendor, int capacity, int price) {
		this.brand = brand;
		this.model = model;
		this.vendor = vendor;
		this.capacity = capacity;
		this.price = price;
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
