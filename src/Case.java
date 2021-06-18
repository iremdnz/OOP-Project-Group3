
public class Case {
	private String brand;
	private String model;
	private int psu;
	private int price;
	private char usage;
	
	@Override
	public String toString() {
		return  brand + " " + model + " " + psu + " Watt";
	}

	public Case(String brand, String model, int psu, int price, char usage) {
		this.brand = brand;
	 	this.model = model;
		this.psu = psu;
		this.price = price;
		this.usage = usage;
	}
	
	public Case(String brand, String model, String psu, String price, String usage) {
		this.brand = brand;
		this.model = model;
		this.psu = Integer.parseInt(psu);
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
