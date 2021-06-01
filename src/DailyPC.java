import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DailyPC extends Computer implements PCPreference {

	private ArrayList<Object> dailyMB, dailyCPU, dailyGPU, dailyCase;
	
	public DailyPC() throws FileNotFoundException {
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
