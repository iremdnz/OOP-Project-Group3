
public class SolidState extends Storage {
	
	@Override
	public String toString() {
		return "Storage [brand=" + getBrand() + ", model=" + getModel() + ", capacity=" + getCapacity()
				+ ", readSpeed=" + getReadSpeed() + ", writeSpeed=" + getWriteSpeed() + ", price=" + getPrice()
				+ ", type=" + getType() + ", hasCooling=" + isHasCoolingSys() + "]";
	}
	
	private String type;
	private boolean hasCoolingSys;
	
	public SolidState(String brand, String model, int capacity, int readSpeed, int writeSpeed, int price, String type, boolean hasCoolingSys) {
		super(brand, model, capacity, readSpeed, writeSpeed, price);
		this.type = type;
		this.hasCoolingSys = hasCoolingSys;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isHasCoolingSys() {
		return hasCoolingSys;
	}

	public void setHasCoolingSys(boolean hasCoolingSys) {
		this.hasCoolingSys = hasCoolingSys;
	}
	
}
