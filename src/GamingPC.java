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

	public void separateGPU() {
		ArrayList<GraphicsCard> deleteGpu = new ArrayList<>();

		for (Object gpu : getDatabase().get("Graphics Card")) {
			if (((GraphicsCard) gpu).getUsage() != 'g') {
				deleteGpu.add((GraphicsCard) gpu);
			}
		}

		for (GraphicsCard gpu : deleteGpu) {
			getDatabase().get("Graphics Card").remove(gpu);
		}

	}

	public void separateCPU() {
		ArrayList<Processor> deleteCpu = new ArrayList<>();

		for (Object cpu : getDatabase().get("Processor")) {
			if (((Processor) cpu).getUsage() != 'g') {
				deleteCpu.add((Processor) cpu);
			}
		}

		for (Processor cpu : deleteCpu) {
			getDatabase().get("Processor").remove(cpu);
		}

	}

	public void separateMB() {
		ArrayList<MotherBoard> deleteMB = new ArrayList<>();

		for (Object mb : getDatabase().get("Motherboard")) {
			if (((MotherBoard) mb).getUsage() != 'g') {
				deleteMB.add((MotherBoard) mb);
			}
		}

		for (MotherBoard mb : deleteMB) {
			getDatabase().get("Motherboard").remove(mb);
		}

	}

	public void separateCase() {
		ArrayList<Case> deleteCase = new ArrayList<>();

		for (Object casee : getDatabase().get("Case")) {
			if (((Case) casee).getUsage() != 'g') {
				deleteCase.add((Case) casee);
			}
		}

		for (Case casee : deleteCase) {
			getDatabase().get("Case").remove(casee);
		}

	}
}
