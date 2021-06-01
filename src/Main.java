import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		HashMap<String, ArrayList<Object>> list = new HashMap<String, ArrayList<Object>>();
		Computer computerDatabase = new Computer(list);
		for (Entry<String, ArrayList<Object>> entry : list.entrySet()) {
			String key = entry.getKey();
			ArrayList<Object> value = entry.getValue();

			System.out.println(key + ":" + value.toString()+"\n");
		}

	}

}
