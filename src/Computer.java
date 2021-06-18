import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Computer {
	private HashMap<String, ArrayList<Object>> database;

	private File caseFile, graphics_card, processor, memory, motherboard, storage;

	public Computer() {
		caseFile = new File("case.txt");
		graphics_card = new File("graphics_card.txt");
		processor = new File("processor.txt");
		memory = new File("memory.txt");
		motherboard = new File("motherboard.txt");
		storage = new File("storage.txt");

		database = new HashMap<>();
		database.put("Case", readData(caseFile));
		database.put("Graphics Card", readData(graphics_card));
		database.put("Processor", readData(processor));
		database.put("Memory", readData(memory));
		database.put("Motherboard", readData(motherboard));
		database.put("Storage", readData(storage));

	}

	public HashMap<String, ArrayList<Object>> getDatabase() {
		return database;
	}

	private ArrayList<Object> readData(File file) {
		ArrayList<Object> list = new ArrayList<Object>();

		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String word = scan.nextLine();
				String[] splitWord = word.split(",");
				if (file.getName().equalsIgnoreCase("case.txt")) {
					String brand = splitWord[0];
					String model = splitWord[1];
					int psu = Integer.valueOf(splitWord[2]);
					int price = Integer.valueOf(splitWord[3]);
					char usage = splitWord[4].charAt(0);

					Case caseUnit = new Case(brand, model, psu, price, usage);
					list.add(caseUnit);
				} else if (file.getName().equalsIgnoreCase("graphics_card.txt")) {

					String brand = splitWord[0];
					String model = splitWord[1];
					String vendor = splitWord[2];
					int capacity = Integer.valueOf(splitWord[3]);
					int price = Integer.valueOf(splitWord[5]);
					char usage = splitWord[6].charAt(0);
					int tdp = Integer.valueOf(splitWord[4]);
					GraphicsCard gpuUnit = new GraphicsCard(brand, model, vendor, capacity, tdp, price, usage);
					list.add(gpuUnit);
				} else if (file.getName().equalsIgnoreCase("memory.txt")) {
					String brand = splitWord[0];
					String model = splitWord[1];
					int speed = Integer.valueOf(splitWord[2]);
					int capacity = Integer.valueOf(splitWord[3]);
					String type = splitWord[4];
					int latency = Integer.valueOf(splitWord[5]);
					int price = Integer.valueOf(splitWord[6]);
					char usage = splitWord[7].charAt(0);

					Memory memoryUnit = new Memory(brand, model, speed, capacity, type, latency, price, usage);
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
					int price = Integer.valueOf(splitWord[7]);
					char usage = splitWord[8].charAt(0);
					MotherBoard moboUnit = new MotherBoard(brand, model, chipset, socket, formFactor, m2Support,
							pcieVersion, price, usage);
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
					char usage = splitWord[9].charAt(0);

					Processor processorUnit = new Processor(brand, model, core, thread, socket, clockSpeed, tdp,
							isUnlocked, price, usage);
					list.add(processorUnit);
				} else if (file.getName().equalsIgnoreCase("storage.txt")) {

					String brand = splitWord[0];
					String model = splitWord[1];
					int capacity = Integer.valueOf(splitWord[2]);

					int readSpeed = 0;
					int writeSpeed = 0;

					String type;
					boolean hasCooling;

					if (splitWord.length == 8) {
						String[] splitted = splitWord[3].split("-");
						readSpeed = Integer.valueOf(splitted[0]);
						writeSpeed = Integer.valueOf(splitted[1]);
						type = splitWord[4];
						hasCooling = Boolean.parseBoolean(splitWord[5]);
						int price = Integer.valueOf(splitWord[6]);
						char usage = splitWord[7].charAt(0);
						SolidState storageUnit = new SolidState(brand, model, capacity, readSpeed, writeSpeed, price,
								usage, type, hasCooling);
						list.add(storageUnit);

					} else {
						readSpeed = 150;
						writeSpeed = 150;
						int spin = Integer.valueOf(splitWord[3]);
						int price = Integer.valueOf(splitWord[4]);
						char usage = splitWord[5].charAt(0);
						HardDrive storageUnit = new HardDrive(brand, model, capacity, readSpeed, writeSpeed, price,
								usage, spin);
						list.add(storageUnit);
					}

				}

			}
		} catch (Exception e) {
			System.err.println("Error! Given file was not found to be opened.");
			e.printStackTrace();
		}
		return list;
	}


	
}
