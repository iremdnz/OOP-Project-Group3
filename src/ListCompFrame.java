import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class ListCompFrame extends JFrame {

	private JPanel contentPane;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCompFrame frame = new ListCompFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ListCompFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Component Type: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 28, 174, 47);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(234, 44, 328, 21);
		contentPane.add(comboBox);

		Computer computerDB = new Computer();

		for (String entry : computerDB.getDatabase().keySet()) {
			String key = entry;
			comboBox.addItem(key);
		}

		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "isUnlocked",
				"Price", "Usage" };
		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "formFactor", "M.2 Support", "PCIE", "Price",
				"Usage" };
		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage" };
		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "Price", "Usage" };
		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage" };
		String[] storageTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage" };

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String selectedComp = String.valueOf(comboBox.getSelectedItem());
				String[][] printList = null;
				String[] nameTag = null;
				if (selectedComp.equalsIgnoreCase("graphics_card")) {
					int size = computerDB.getDatabase().get("graphics_card").size();
					printList = new String[size][gpuTag.length];
					for (int i = 0; i < size; i++) {
						GraphicsCard gpu = (GraphicsCard) computerDB.getDatabase().get("graphics_card").get(i);

						printList[i][0] = gpu.getBrand();
						printList[i][1] = gpu.getModel();
						printList[i][2] = gpu.getVendor();
						printList[i][3] = "" + gpu.getCapacity();
						printList[i][4] = "" + gpu.getPrice();
						printList[i][5] = "" + gpu.getUsage();
						nameTag = gpuTag;
					}
				} else if (selectedComp.equalsIgnoreCase("memory")) {

					int size = computerDB.getDatabase().get("memory").size();
					printList = new String[size][memoryTag.length];
					for (int i = 0; i < size; i++) {
						Memory memory = (Memory) computerDB.getDatabase().get("memory").get(i);

						printList[i][0] = memory.getBrand();
						printList[i][1] = memory.getModel();
						printList[i][2] = memory.getType();
						printList[i][3] = "" + memory.getSpeed();
						printList[i][4] = "" + memory.getCapacity();
						printList[i][5] = "" + memory.getLatency();
						printList[i][6] = "" + memory.getPrice();
						printList[i][7] = "" + memory.getUsage();
						nameTag = memoryTag;

					}

				} else if (selectedComp.equalsIgnoreCase("processor")) {

					int size = computerDB.getDatabase().get("processor").size();
					printList = new String[size][processorTag.length];
					for (int i = 0; i < size; i++) {
						Processor cpu = (Processor) computerDB.getDatabase().get("processor").get(i);

						printList[i][0] = cpu.getBrand();
						printList[i][1] = cpu.getModel();
						printList[i][2] = "" + cpu.getCore();
						printList[i][3] = "" + cpu.getThread();
						printList[i][4] = "" + cpu.getSocket();
						printList[i][5] = "" + cpu.getClockSpeed();
						printList[i][6] = "" + cpu.getTdp();
						printList[i][7] = "" + cpu.isUnlocked();
						printList[i][8] = "" + cpu.getPrice();
						printList[i][9] = "" + cpu.getUsage();
						nameTag = processorTag;
					}

				} else if (selectedComp.equalsIgnoreCase("storage")) {

					int size = computerDB.getDatabase().get("storage").size();
					printList = new String[size][storageTag.length];
					for (int i = 0; i < size; i++) {
						Storage storage = (Storage) computerDB.getDatabase().get("storage").get(i);

						printList[i][0] = storage.getBrand();
						printList[i][1] = storage.getModel();
						printList[i][2] = "" + storage.getReadSpeed();
						printList[i][3] = "" + storage.getWriteSpeed();
						printList[i][4] = "" + storage.getPrice();
						printList[i][5] = "" + storage.getUsage();
						nameTag = storageTag;

					}

				} else if (selectedComp.equalsIgnoreCase("case")) {

					int size = computerDB.getDatabase().get("case").size();
					printList = new String[size][caseTag.length];
					for (int i = 0; i < size; i++) {
						Case caseObject = (Case) computerDB.getDatabase().get("case").get(i);

						printList[i][0] = caseObject.getBrand();
						printList[i][1] = caseObject.getModel();
						printList[i][2] = "" + caseObject.getPsu();
						printList[i][3] = "" + caseObject.getPrice();
						printList[i][4] = "" + caseObject.getUsage();
						nameTag = caseTag;

					}
				} else if (selectedComp.equalsIgnoreCase("motherboard")) {

					int size = computerDB.getDatabase().get("motherboard").size();
					printList = new String[size][motherboardTag.length];
					for (int i = 0; i < size; i++) {
						MotherBoard mobo = (MotherBoard) computerDB.getDatabase().get("motherboard").get(i);

						printList[i][0] = mobo.getBrand();
						printList[i][1] = mobo.getModel();
						printList[i][2] = "" + mobo.getChipset();
						printList[i][3] = "" + mobo.getSocket();
						printList[i][4] = "" + mobo.getFormFactor();
						printList[i][5] = "" + mobo.isM2Support();
						printList[i][6] = "" + mobo.getPcieVersion();
						printList[i][7] = "" + mobo.getPrice();
						printList[i][8] = "" + mobo.getUsage();
						nameTag = motherboardTag;
					}

				}

				table = new JTable(printList, nameTag);
				table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

				table.setSurrendersFocusOnKeystroke(true);
				table.setFillsViewportHeight(true);
				table.setCellSelectionEnabled(true);
				table.setColumnSelectionAllowed(true);
				table.setBackground(SystemColor.window);
				table.setBorder(new CompoundBorder());
				table.setBounds(35, 85, 602, 321);
				table.setVisible(true);
				contentPane.add(table);

				JFrame f = new JFrame();
				// adding it to JScrollPane
				JScrollPane sp = new JScrollPane(table);
				f.add(sp);
				// Frame Size
				f.setSize(540, 480);
				// Frame Visible = true
				f.setVisible(true);

			}

		});

	}

}
