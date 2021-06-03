
public class HardDrive extends Storage {
	
	@Override
	public String toString() {
		return "Storage [brand=" + getBrand() + ", model=" + getModel() + ", capacity=" + getCapacity()
				+ ", readSpeed=" + getReadSpeed() + ", writeSpeed=" + getWriteSpeed() + ", price=" + getPrice()
				+ ", spin=" + getSpin() + "]";
	}
	
	private int spin;

	public HardDrive(String brand, String model, int capacity, int readSpeed, int writeSpeed, int price, int spin) {
		super(brand, model, capacity, readSpeed, writeSpeed, price);
		this.spin = spin;
	}

	public int getSpin() {
		return spin;
	}

	public void setSpin(int spin) {
		this.spin = spin;
	}
	
}
