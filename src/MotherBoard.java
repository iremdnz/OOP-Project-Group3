
public class MotherBoard {
	@Override
	public String toString() {
		return brand + " " + model + " " + chipset + " " + socket;
	}

	private String brand, model, chipset, socket, formFactor;
	private boolean m2Support;
	private double pcieVersion, price;

	public MotherBoard(String brand, String model, String chipset, String socket, String formFactor, boolean m2Support,
			double pcieVersion, double price) {
		this.brand = brand;
		this.model = model;
		this.chipset = chipset;
		this.socket = socket;
		this.formFactor = formFactor;
		this.m2Support = m2Support;
		this.pcieVersion = pcieVersion;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
