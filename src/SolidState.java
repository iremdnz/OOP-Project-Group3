
public class SolidState extends Storage {

	@Override

	public String toString() {
		return getBrand() + " " + getModel() + " " + getCapacity() + " GB";
	}

	private String type;
	private boolean hasCoolingSys;

	public SolidState(String brand, String model, int capacity, int readSpeed, int writeSpeed, int price, char usage, String type,
			boolean hasCoolingSys) {
		super(brand, model, capacity, readSpeed, writeSpeed, price, usage);
		this.type = type;
		this.hasCoolingSys = hasCoolingSys;
	}
	
	public SolidState(String brand, String model, String capacity, String readSpeed, String writeSpeed, String price, String usage, String type,
			String hasCoolingSys) {
		super(brand, model, capacity, readSpeed, writeSpeed, price, usage);
		this.type = type;
		if(hasCoolingSys.charAt(0) == 't' || hasCoolingSys.charAt(0) == 'T') {
			this.hasCoolingSys = true;
		}
		else {
			this.hasCoolingSys = false;
		}
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
