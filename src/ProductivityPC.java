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
	
	public void separateGPU() {
		ArrayList<GraphicsCard> deleteGpu = new ArrayList<>();

		for (Object gpu : getDatabase().get("Graphics Card")) {
			if (((GraphicsCard) gpu).getUsage() != 'p') {
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
			if (((Processor) cpu).getUsage() != 'p') {
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
			if (((MotherBoard) mb).getUsage() != 'p') {
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
			if (((Case) casee).getUsage() != 'p') {
				deleteCase.add((Case) casee);
			}
		}

		for (Case casee : deleteCase) {
			getDatabase().get("Case").remove(casee);
		}
	
	}
}
