import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListCompFrame extends JFrame {

	private JPanel contentPane;
	public static JTable mainTable;
	public static DefaultTableModel caseModel, cpuModel, mbModel, memoryModel, gpuModel, storageModel;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ListCompFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel compTypeLabel = new JLabel("Component Type: ");
		compTypeLabel.setBounds(6, 19, 155, 49);
		compTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(compTypeLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(214, 27, 239, 29);
		contentPane.add(comboBox);

		mainTable = new JTable();
		mainTable.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		mainTable.setDefaultEditor(Object.class, null);
		JScrollPane js = new JScrollPane(mainTable);
		js.setBounds(6, 94, 689, 329);
		contentPane.add(js);

		for (String entry : AdminPanel.computerDB.getDatabase().keySet()) {
			String key = entry;
			comboBox.addItem(key);
		}

		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "isUnlocked",
				"Price", "Usage" };
		String[][] processorData = getData(AdminPanel.computerDB, 3);
		cpuModel = new DefaultTableModel(processorData, processorTag);

		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "formFactor", "M.2 Support", "PCIE", "Price",
				"Usage" };
		String[][] motherboardData = getData(AdminPanel.computerDB, 6);
		mbModel = new DefaultTableModel(motherboardData, motherboardTag);

		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage" };
		String[][] memoryData = getData(AdminPanel.computerDB, 2);
		memoryModel = new DefaultTableModel(memoryData, memoryTag);

		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "TDP", "Price", "Usage" };
		String[][] gpuData = getData(AdminPanel.computerDB, 1);
		gpuModel = new DefaultTableModel(gpuData, gpuTag);

		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage" };
		String[][] caseData = getData(AdminPanel.computerDB, 5);
		caseModel = new DefaultTableModel(caseData, caseTag);

		String[] storageTag = { "Brand", "Model", "Capacity","Read Speed", "Write Speed", "Price", "Usage" };
		String[][] storageData = getData(AdminPanel.computerDB, 4);
		storageModel = new DefaultTableModel(storageData, storageTag);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				String selectedComp = String.valueOf(comboBox.getSelectedItem());

				if (selectedComp.equalsIgnoreCase("graphics_card")) {
					mainTable.setModel(gpuModel);
				} else if (selectedComp.equalsIgnoreCase("memory")) {
					mainTable.setModel(memoryModel);
				} else if (selectedComp.equalsIgnoreCase("processor")) {
					mainTable.setModel(cpuModel);
				} else if (selectedComp.equalsIgnoreCase("storage")) {
					mainTable.setModel(storageModel);
				} else if (selectedComp.equalsIgnoreCase("case")) {
					mainTable.setModel(caseModel);
				} else if (selectedComp.equalsIgnoreCase("motherboard")) {
					mainTable.setModel(mbModel);
				}

			}
		});
	}

	public String[][] getData(Computer computerDB, int comp) {
		String data[][] = null;
		int size;

		switch (comp) {
		case 1:
			size = computerDB.getDatabase().get("graphics_card").size();
			data = new String[size][7];
			for (int i = 0; i < size; i++) {
				GraphicsCard gpu = (GraphicsCard) computerDB.getDatabase().get("graphics_card").get(i);

				data[i][0] = gpu.getBrand();
				data[i][1] = gpu.getModel();
				data[i][2] = gpu.getVendor();
				data[i][3] = "" + gpu.getCapacity();
				data[i][4] = "" + gpu.getTdp();
				data[i][5] = "" + gpu.getPrice();
				data[i][6] = "" + gpu.getUsage();
			}
			break;
		case 2:
			size = computerDB.getDatabase().get("memory").size();
			data = new String[size][8];
			for (int i = 0; i < size; i++) {
				Memory memory = (Memory) computerDB.getDatabase().get("memory").get(i);

				data[i][0] = memory.getBrand();
				data[i][1] = memory.getModel();
				data[i][2] = memory.getType();
				data[i][3] = "" + memory.getSpeed();
				data[i][4] = "" + memory.getCapacity();
				data[i][5] = "" + memory.getLatency();
				data[i][6] = "" + memory.getPrice();
				data[i][7] = "" + memory.getUsage();
			}
			break;
		case 3:
			size = computerDB.getDatabase().get("processor").size();
			data = new String[size][10];
			for (int i = 0; i < size; i++) {
				Processor cpu = (Processor) computerDB.getDatabase().get("processor").get(i);

				data[i][0] = cpu.getBrand();
				data[i][1] = cpu.getModel();
				data[i][2] = "" + cpu.getCore();
				data[i][3] = "" + cpu.getThread();
				data[i][4] = "" + cpu.getSocket();
				data[i][5] = "" + cpu.getClockSpeed();
				data[i][6] = "" + cpu.getTdp();
				data[i][7] = "" + cpu.isUnlocked();
				data[i][8] = "" + cpu.getPrice();
				data[i][9] = "" + cpu.getUsage();
			}
			break;
		case 4:
			size = computerDB.getDatabase().get("storage").size();
			data = new String[size][7];
			for (int i = 0; i < size; i++) {
				Storage storage = (Storage) computerDB.getDatabase().get("storage").get(i);

				data[i][0] = storage.getBrand();
				data[i][1] = storage.getModel();
				data[i][2] = "" + storage.getCapacity();
				data[i][3] = "" + storage.getReadSpeed();
				data[i][4] = "" + storage.getWriteSpeed();
				data[i][5] = "" + storage.getPrice();
				data[i][6] = "" + storage.getUsage();
			}
			break;
		case 5:
			size = computerDB.getDatabase().get("case").size();
			data = new String[size][5];
			for (int i = 0; i < size; i++) {
				Case caseObject = (Case) computerDB.getDatabase().get("case").get(i);

				data[i][0] = caseObject.getBrand();
				data[i][1] = caseObject.getModel();
				data[i][2] = "" + caseObject.getPsu();
				data[i][3] = "" + caseObject.getPrice();
				data[i][4] = "" + caseObject.getUsage();
			}
			break;
		case 6:
			size = computerDB.getDatabase().get("motherboard").size();
			data = new String[size][9];
			for (int i = 0; i < size; i++) {
				MotherBoard mobo = (MotherBoard) computerDB.getDatabase().get("motherboard").get(i);

				data[i][0] = mobo.getBrand();
				data[i][1] = mobo.getModel();
				data[i][2] = "" + mobo.getChipset();
				data[i][3] = "" + mobo.getSocket();
				data[i][4] = "" + mobo.getFormFactor();
				data[i][5] = "" + mobo.isM2Support();
				data[i][6] = "" + mobo.getPcieVersion();
				data[i][7] = "" + mobo.getPrice();
				data[i][8] = "" + mobo.getUsage();
			}
			break;
		}

		return data;
	}
}
