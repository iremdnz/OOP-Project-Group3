import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductivityPC extends Computer implements PCPreference {

	private ArrayList<Object> productvitiyMB, productvitiyCPU, productvitiyGPU, productvitiyCase;
	
	public ProductivityPC() {
		super();
		separateGPU();
		separateCPU();
		separateMB();
		separateCase();
	}
	
	public ArrayList<Object> separateGPU() {
		ArrayList<GraphicsCard> deleteGpu = new ArrayList<>();

		for (Object gpu : getDatabase().get("graphics_card")) {
			if (((GraphicsCard) gpu).getUsage() != 'p') {
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
			if (((Processor) cpu).getUsage() != 'p') {
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
			if (((MotherBoard) mb).getUsage() != 'p') {
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
			if (((Case) casee).getUsage() != 'p') {
				deleteCase.add((Case) casee);
			}
		}

		for (Case casee : deleteCase) {
			getDatabase().get("case").remove(casee);
		}
		return null;
	}
}
