import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Computer {
	private HashMap<String, ArrayList<Object>> database;
	private String usrPreference;
	private ArrayList<Object> currentlyAdded;
	private File caseFile, graphics_card, processor, memory, motherboard, storage;

	public Computer() throws FileNotFoundException {
		caseFile = new File("case.txt");
		graphics_card = new File("graphics_card.txt");
		processor = new File("processor.txt");
		memory = new File("memory.txt");
		motherboard = new File("motherboard.txt");
		storage = new File("storage.txt");
		
		database = new HashMap<>();
		database.put("case", readData(caseFile));
		database.put("graphics_card", readData(graphics_card));
		database.put("processor", readData(processor));
		database.put("memory", readData(memory));
		database.put("motherboard", readData(motherboard));
		// database.put("storage", readData(storage));

	}

	public HashMap<String, ArrayList<Object>> getDatabase() {
		return database;
	}
	
	private ArrayList<Object> readData(File file) throws FileNotFoundException {
		ArrayList<Object> list = new ArrayList<Object>();
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			String word = scan.nextLine();
			String[] splitWord = word.split(",");
			if (file.getName().equalsIgnoreCase("case.txt")) {
				String brand = splitWord[0];
				String model = splitWord[1];
				int psu = Integer.valueOf(splitWord[2]);
				int price = Integer.valueOf(splitWord[3]);

				Case caseUnit = new Case(brand, model, psu, price);
				list.add(caseUnit);
			} else if (file.getName().equalsIgnoreCase("graphics_card.txt")) {

				String brand = splitWord[0];
				String model = splitWord[1];
				String vendor = splitWord[2];
				int capacity = Integer.valueOf(splitWord[3]);
				int price = Integer.valueOf(splitWord[4]);
				GraphicsCard gpuUnit = new GraphicsCard(brand, model, vendor, capacity, price);
				list.add(gpuUnit);
			} else if (file.getName().equalsIgnoreCase("memory.txt")) {
				String brand = splitWord[0];
				String model = splitWord[1];
				int speed = Integer.valueOf(splitWord[2]);
				int capacity = Integer.valueOf(splitWord[3]);
				String type = splitWord[4];
				int latency = Integer.valueOf(splitWord[5]);
				int price = Integer.valueOf(splitWord[6]);

				Memory memoryUnit = new Memory(brand, model, speed, capacity, type, latency, price);
				list.add(memoryUnit);
			} else if (file.getName().equalsIgnoreCase("motherboard.txt")) {
				String brand = splitWord[0];
				String model = splitWord[1];
				String chipset = splitWord[2];
				String socket = splitWord[3];
				String formFactor = splitWord[4];
				boolean m2Support = false;
				if (splitWord[5].equalsIgnoreCase("true"))
					m2Support = true;

				double pcieVersion = Double.valueOf(splitWord[6]);
				double price = Double.valueOf(splitWord[7]);
				MotherBoard moboUnit = new MotherBoard(brand, model, chipset, socket, formFactor, m2Support,
						pcieVersion, price);
				list.add(moboUnit);

			} else if (file.getName().equalsIgnoreCase("processor.txt")) {
				String brand = splitWord[0];
				String model = splitWord[1];
				int core = Integer.valueOf(splitWord[2]);
				int thread = Integer.valueOf(splitWord[3]);
				String socket = splitWord[4];
				double clockSpeed = Double.valueOf(splitWord[5]);
				int tdp = Integer.valueOf(splitWord[6]);
				boolean isUnlocked = false;
				if (splitWord[7].equalsIgnoreCase("true"))
					isUnlocked = true;

				int price = Integer.valueOf(splitWord[8]);

				Processor processorUnit = new Processor(brand, model, core, thread, socket, clockSpeed, tdp, isUnlocked,
						price);
				list.add(processorUnit);
			} else if (file.getName().equalsIgnoreCase("storage.txt")) {

				String type = splitWord[0];
				String brand = splitWord[1];
				String model = splitWord[2];
				int capacity = Integer.valueOf(splitWord[3]);

				int readSpeed = 0;
				int writeSpeed = 0;
				if (type.equalsIgnoreCase("ssd")) {
					String[] splitted = splitWord[4].split("-");
					readSpeed = Integer.valueOf(splitted[0]);
					writeSpeed = Integer.valueOf(splitted[1]);
					int price = Integer.valueOf(splitWord[7]);
					Storage storageUnit = new Storage(type, brand, model, capacity, readSpeed, writeSpeed, price);
					list.add(storageUnit);

				} else {
					readSpeed = Integer.valueOf(splitWord[4]);
					writeSpeed = Integer.valueOf(splitWord[4]);
					int price = Integer.valueOf(splitWord[5]);
					Storage storageUnit = new Storage(type, brand, model, capacity, readSpeed, writeSpeed, price);
					list.add(storageUnit);
				}

			}

		}
		return list;
	}

	public String userPref() {
		return null;
	}

	public void listComponents() {

	}

	public boolean isCompatible(String comp1, String comp2) {
		return true;
	}

	public boolean checkPower() {
		return true;
	}

	public void displayChosen() {

	}
}
