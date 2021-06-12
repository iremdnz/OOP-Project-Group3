
public class MotherBoard {
	@Override
	public String toString() {
		return brand + " " + model + " " + chipset + " " + socket;
	}

	private String brand, model, chipset, socket, formFactor;
	private boolean m2Support;
	private double pcieVersion;
	private int price;
	private char usage;

	public MotherBoard(String brand, String model, String chipset, String socket, String formFactor, boolean m2Support,
		double pcieVersion, int price, char usage) {
		this.brand = brand;
		this.model = model;
		this.chipset = chipset;
		this.socket = socket;
		this.formFactor = formFactor;
		this.m2Support = m2Support;
		this.pcieVersion = pcieVersion;
		this.price = price;
		this.usage = usage;
	}
	
	public MotherBoard(String brand, String model, String chipset, String socket, String formFactor, String m2Support,
		String pcieVersion, String price, String usage) {
		this.brand = brand;
		this.model = model;
		this.chipset = chipset;
		this.socket = socket;
		this.formFactor = formFactor;
		if(m2Support.charAt(0) == 't' || m2Support.charAt(0) == 'T') {
			this.m2Support = true;
		}
		else {
			this.m2Support = false;
		}
		this.pcieVersion = Double.parseDouble(pcieVersion);
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

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public boolean isM2Support() {
		return m2Support;
	}

	public void setM2Support(boolean m2Support) {
		this.m2Support = m2Support;
	}

	public double getPcieVersion() {
		return pcieVersion;
	}

	public void setPcieVersion(double pcieVersion) {
		this.pcieVersion = pcieVersion;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
