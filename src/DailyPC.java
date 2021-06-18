
import java.util.ArrayList;

public class DailyPC extends Computer implements PCPreference {

	public DailyPC() {
		super();
		separateGPU();
		separateCPU();
		separateMB();
		separateCase();
	}

	public void separateGPU() {
		ArrayList<GraphicsCard> deleteGpu = new ArrayList<>();

		for (Object gpu : getDatabase().get("Graphics Card")) {
			if (((GraphicsCard) gpu).getUsage() != 'd') {
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
			if (((Processor) cpu).getUsage() != 'd') {
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
			if (((MotherBoard) mb).getUsage() != 'd') {
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
			if (((Case) casee).getUsage() != 'd') {
				deleteCase.add((Case) casee);
			}
		}

		for (Case casee : deleteCase) {
			getDatabase().get("Case").remove(casee);
		}

	}
}
