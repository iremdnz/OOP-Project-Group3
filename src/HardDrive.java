
public class HardDrive extends Storage {

	@Override
	public String toString() {
		return "" + getBrand() + " "+ getModel() +" " +  getCapacity()  +" GB";
	}

	private int spin;

	public HardDrive(String brand, String model, int capacity, int readSpeed, int writeSpeed, int price, char usage, int spin) {
		super(brand, model, capacity, readSpeed, writeSpeed, price, usage);
		this.spin = spin;
	}
	
	public HardDrive(String brand, String model, String capacity, String readSpeed, String writeSpeed, String price, String usage, String spin) {
		super(brand, model, capacity, readSpeed, writeSpeed, price, usage);
		this.spin = Integer.parseInt(spin);
	}

	public int getSpin() {
		return spin;
	}

	public void setSpin(int spin) {
		this.spin = spin;
	}

}
