import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GamingPC extends Computer implements PCPreference {

	private ArrayList<Object> gamingMB, gamingCPU, gamingGPU, gamingCase;

	public GamingPC() {
		super();
		separateGPU();
		separateCPU();
		separateMB();
		separateCase();
	}

	public ArrayList<Object> separateGPU() {
		ArrayList<GraphicsCard> deleteGpu = new ArrayList<>();

		for (Object gpu : getDatabase().get("graphics_card")) {
			if (((GraphicsCard) gpu).getUsage() != 'g') {
				deleteGpu.add((GraphicsCard) gpu);
			}
		}

		for (GraphicsCard gpu : deleteGpu) {
			getDatabase().get("graphics_card").remove(gpu);
		}
		return null;
	}

	public ArrayList<Object> separateCPU() {
		ArrayList<Processor> deleteCpu = new ArrayList<>();

		for (Object cpu : getDatabase().get("processor")) {
			if (((Processor) cpu).getUsage() != 'g') {
				deleteCpu.add((Processor) cpu);
			}
		}

		for (Processor cpu : deleteCpu) {
			getDatabase().get("processor").remove(cpu);
		}
		return null;
	}

	public ArrayList<Object> separateMB() {
		ArrayList<MotherBoard> deleteMB = new ArrayList<>();

		for (Object mb : getDatabase().get("motherboard")) {
			if (((MotherBoard) mb).getUsage() != 'g') {
				deleteMB.add((MotherBoard) mb);
			}
		}

		for (MotherBoard mb : deleteMB) {
			getDatabase().get("motherboard").remove(mb);
		}
		return null;
	}

	public ArrayList<Object> separateCase() {
		ArrayList<Case> deleteCase = new ArrayList<>();

		for (Object casee : getDatabase().get("case")) {
			if (((Case) casee).getUsage() != 'g') {
				deleteCase.add((Case) casee);
			}
		}

		for (Case casee : deleteCase) {
			getDatabase().get("case").remove(casee);
		}
		return null;
	}
}
