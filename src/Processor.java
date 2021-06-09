
public class Processor {
	@Override
	public String toString() {
		return brand + " " + model + " " + clockSpeed + " GHz";
	}

	private String brand;
	private String model;
	private int core;
	private int thread;
	private String socket;
	private double clockSpeed;
	private int tdp;
	private boolean isUnlocked;
	private int price;
	private char usage;

	public Processor(String brand, String model, int core, int thread, String socket, double clockSpeed, int tdp,
			boolean isUnlocked, int price, char usage) {
		this.brand = brand;
		this.model = model;
		this.core = core;
		this.thread = thread;
		this.socket = socket;
		this.clockSpeed = clockSpeed;
		this.tdp = tdp;
		this.isUnlocked = isUnlocked;
		this.price = price;
		this.usage = usage;
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

	public int getCore() {
		return core;
	}

	public void setCore(int core) {
		this.core = core;
	}

	public int getThread() {
		return thread;
	}

	public void setThread(int thread) {
		this.thread = thread;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public double getClockSpeed() {
		return clockSpeed;
	}

	public void setClockSpeed(double clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	public int getTdp() {
		return tdp;
	}

	public void setTdp(int tdp) {
		this.tdp = tdp;
	}

	public boolean isUnlocked() {
		return isUnlocked;
	}

	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
