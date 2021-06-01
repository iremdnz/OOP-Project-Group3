import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductivityPC extends Computer implements PCPreference {

	private ArrayList<Object> productvitiyMB, productvitiyCPU, productvitiyGPU, productvitiyCase;
	
	public ProductivityPC() throws FileNotFoundException {
		super();
	}
	
	public ArrayList<Object> separateGPU() {
		return null;
	}
	
	public ArrayList<Object> separateCPU() {
		return null;
	}
	
	public ArrayList<Object> separateMB() {
		return null;
	}
	
	public ArrayList<Object> separateCase() {
		return null;
	}
}
