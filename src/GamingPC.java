import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GamingPC extends Computer implements PCPreference {

	private ArrayList<Object> gamingMB, gamingCPU, gamingGPU, gamingCase;
	
	public GamingPC() throws FileNotFoundException {
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
