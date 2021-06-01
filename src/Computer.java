import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Computer {
	private HashMap<String, ArrayList<Object>> database;
	private String usrPreference;
	private ArrayList<Object> currentlyAdded;

	public Computer(HashMap<String, ArrayList<Object>> database, String usrPreference,
			ArrayList<Object> currentlyAdded) {
		this.database = database;
		this.usrPreference = usrPreference;
		this.currentlyAdded = currentlyAdded;
	}

	File caseFile = new File("/src/case.txt");
	File graphics_card = new File("/src/graphics_card.txt");
	File processor = new File("/src/processor.txt");
	File memory = new File("/src/memory.txt");
	File motherboard = new File("/src/motherboard.txt");
	File storage = new File("/src/storage.txt");
	
	
	
	
	
	
	
	
	private ArrayList<Object> readData(File file) throws FileNotFoundException {
		ArrayList<Object> list = new ArrayList<Object>();
		Scanner scan = new Scanner(file);
		while(scan.hasNext())
		{
			
		}
		return null;
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
