import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Computer computerDatabase = new Computer();
		for (Entry<String, ArrayList<Object>> entry : computerDatabase.getDatabase().entrySet()) {
			String key = entry.getKey();
			ArrayList<Object> value = entry.getValue();

			System.out.println(key + ":" + value.toString()+"\n");
		}

	}

}
