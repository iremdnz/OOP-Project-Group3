import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DailyPC extends Computer implements PCPreference {

	private ArrayList<Object> dailyMB, dailyCPU, dailyGPU, dailyCase;
	
	public DailyPC() {
		super();
		separateGPU();
		separateCPU();
		separateMB();
		separateCase();
	}
	
	public ArrayList<Object> separateGPU() {
		ArrayList<GraphicsCard> deleteGpu = new ArrayList<>();
		
		for(Object gpu: getDatabase().get("graphics_card")) {
			if(((GraphicsCard)gpu).getUsage() != 'd') {
				deleteGpu.add((GraphicsCard)gpu);
			}
		}
		
		for(GraphicsCard gpu: deleteGpu) {
			getDatabase().get("graphics_card").remove(gpu);
		}
		
		return null;
	}
	
	public ArrayList<Object> separateCPU() {
        ArrayList<Processor> deleteCpu = new ArrayList<>();
		
		for(Object cpu: getDatabase().get("processor")) {
			if(((Processor)cpu).getUsage() != 'd') {
				deleteCpu.add((Processor)cpu);
			}
		}
		
		for(Processor cpu: deleteCpu) {
			getDatabase().get("processor").remove(cpu);
		}
		return null;
	}
	
	public ArrayList<Object> separateMB() {
		ArrayList<MotherBoard> deleteMB = new ArrayList<>();
		
		for(Object mb: getDatabase().get("motherboard")) {
			if(((MotherBoard)mb).getUsage() != 'd') {
				deleteMB.add((MotherBoard)mb);
			}
		}
		
		for(MotherBoard mb: deleteMB) {
			getDatabase().get("motherboard").remove(mb);
		}
		return null;
	}
	
	public ArrayList<Object> separateCase() {
		ArrayList<Case> deleteCase = new ArrayList<>();
		
		for(Object casee: getDatabase().get("case")) {
			if(((Case)casee).getUsage() != 'd') {
				deleteCase.add((Case)casee);
			}
		}
		
		for(Case casee: deleteCase) {
			getDatabase().get("case").remove(casee);
		}
		return null;
	}
}
