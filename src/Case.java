
public class Case {
	private String brand;
	private String model;
	private int psu;
	private int price;
	
	
	@Override
	public String toString() {
		return  brand + " " + model + " " + psu + " Watt";
	}

	

	public Case(String brand, String model, int psu, int price) {
		super();
		this.brand = brand;
		this.model = model;
		this.psu = psu;
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

	public int getPsu() {
		return psu;
	}

	public void setPsu(int psu) {
		this.psu = psu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
}
