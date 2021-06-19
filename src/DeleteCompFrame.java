import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteCompFrame extends JFrame {

	private JPanel contentPane;
	public static JTable mainTable;

	public DeleteCompFrame() {
		setTitle(WelcomeScreen.title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel compTypeLabel = new JLabel("Component Type: ");
		compTypeLabel.setBounds(19, 14, 183, 49);
		compTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(compTypeLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(200, 26, 239, 29);
		contentPane.add(comboBox);

		for (String entry : AdminPanel.computerDB.getDatabase().keySet()) {
			comboBox.addItem(entry);
		}

		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "isUnlocked",
				"Price", "Usage", "Remove" };
		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "formFactor", "M.2 Support", "PCIE", "Price",
				"Usage", "Remove" };
		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage", "Remove" };
		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "TDP", "Price", "Usage", "Remove" };
		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage", "Remove" };
		String[] storageTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage", "Remove" };

		Object[][] processorData = getData(AdminPanel.computerDB, 3);
		Object[][] motherboardData = getData(AdminPanel.computerDB, 6);
		Object[][] memoryData = getData(AdminPanel.computerDB, 2);
		Object[][] gpuData = getData(AdminPanel.computerDB, 1);
		Object[][] caseData = getData(AdminPanel.computerDB, 5);
		Object[][] storageData = getData(AdminPanel.computerDB, 4);

		DefaultTableModel cpuModel = new DefaultTableModel(processorData, processorTag) {
			@SuppressWarnings("unchecked")
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 10:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		DefaultTableModel mbModel = new DefaultTableModel(motherboardData, motherboardTag) {
			@SuppressWarnings("unchecked")
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 9:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		DefaultTableModel memoryModel = new DefaultTableModel(memoryData, memoryTag) {
			@SuppressWarnings("unchecked")
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 8:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		DefaultTableModel gpuModel = new DefaultTableModel(gpuData, gpuTag) {
			@SuppressWarnings("unchecked")
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 7:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		DefaultTableModel caseModel = new DefaultTableModel(caseData, caseTag) {
			@SuppressWarnings("unchecked")
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 5:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		DefaultTableModel storageModel = new DefaultTableModel(storageData, storageTag) {
			@SuppressWarnings("unchecked")
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 6:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedComp = String.valueOf(comboBox.getSelectedItem());

				if (selectedComp.equalsIgnoreCase("Graphics Card")) {
					Object[][] newGpuData = getData(AdminPanel.computerDB, 1);
					DefaultTableModel newGpuModel = new DefaultTableModel(newGpuData, gpuTag) {
						@SuppressWarnings("unchecked")
						@Override
						public Class getColumnClass(int column) {
							switch (column) {
							case 7:
								return Boolean.class;
							default:
								return String.class;
							}
						}
					};
					mainTable.setModel(newGpuModel);
				} else if (selectedComp.equalsIgnoreCase("Memory")) {
					Object[][] newMemoryData = getData(AdminPanel.computerDB, 2);
					DefaultTableModel newMemoryModel = new DefaultTableModel(newMemoryData, memoryTag) {
						@SuppressWarnings("unchecked")
						@Override
						public Class getColumnClass(int column) {
							switch (column) {
							case 8:
								return Boolean.class;
							default:
								return String.class;
							}
						}
					};
					mainTable.setModel(newMemoryModel);
				} else if (selectedComp.equalsIgnoreCase("Processor")) {
					Object[][] newProcessorData = getData(AdminPanel.computerDB, 3);
					DefaultTableModel newCpuModel = new DefaultTableModel(newProcessorData, processorTag) {
						@SuppressWarnings("unchecked")
						@Override
						public Class getColumnClass(int column) {
							switch (column) {
							case 10:
								return Boolean.class;
							default:
								return String.class;
							}
						}
					};

					mainTable.setModel(newCpuModel);
				} else if (selectedComp.equalsIgnoreCase("Storage")) {
					Object[][] newStorageData = getData(AdminPanel.computerDB, 4);
					DefaultTableModel newStorageModel = new DefaultTableModel(newStorageData, storageTag) {
						@SuppressWarnings("unchecked")
						@Override
						public Class getColumnClass(int column) {
							switch (column) {
							case 6:
								return Boolean.class;
							default:
								return String.class;
							}
						}
					};
					mainTable.setModel(newStorageModel);
				} else if (selectedComp.equalsIgnoreCase("Case")) {
					Object[][] newCaseData = getData(AdminPanel.computerDB, 5);
					DefaultTableModel newCaseModel = new DefaultTableModel(newCaseData, caseTag) {
						@SuppressWarnings("unchecked")
						@Override
						public Class getColumnClass(int column) {
							switch (column) {
							case 5:
								return Boolean.class;
							default:
								return String.class;
							}
						}
					};
					mainTable.setModel(newCaseModel);
				} else if (selectedComp.equalsIgnoreCase("Motherboard")) {
					Object[][] newMotherboardData = getData(AdminPanel.computerDB, 6);
					DefaultTableModel newMbModel = new DefaultTableModel(newMotherboardData, motherboardTag) {
						@SuppressWarnings("unchecked")
						@Override
						public Class getColumnClass(int column) {
							switch (column) {
							case 9:
								return Boolean.class;
							default:
								return String.class;
							}
						}
					};
					mainTable.setModel(newMbModel);
				}
			}
		});

		mainTable = new JTable();
		mainTable.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		mainTable.setDefaultEditor(Object.class, null);
		JScrollPane js = new JScrollPane(mainTable);
		js.setBounds(6, 94, 689, 329);
		contentPane.add(js);

		JButton removeButton = new JButton("Remove Selected");
		removeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int selectedCount = 0;

				for (int i = 0; i < mainTable.getRowCount(); i++) {
					if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Graphics Card")
							&& (Boolean) mainTable.getValueAt(i, 7)) {
						selectedCount++;
					} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Memory")
							&& (Boolean) mainTable.getValueAt(i, 8)) {
						selectedCount++;
					} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Processor")
							&& (Boolean) mainTable.getValueAt(i, 10)) {
						selectedCount++;
					} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Storage")
							&& (Boolean) mainTable.getValueAt(i, 6)) {
						selectedCount++;
					} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Case")
							&& (Boolean) mainTable.getValueAt(i, 5)) {
						selectedCount++;
					} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Motherboard")
							&& (Boolean) mainTable.getValueAt(i, 9)) {
						selectedCount++;
					}
				}

				if (selectedCount == 0) {
					JOptionPane.showMessageDialog(contentPane, "No components were selected to remove.", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					int selResult = JOptionPane.showConfirmDialog(contentPane,
							"Are you sure you want to delete selected components?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (selResult == JOptionPane.YES_OPTION) {

						if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Graphics Card")) {

							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i, 7)) {

									for (Object val : AdminPanel.computerDB.getDatabase().get("Graphics Card")) {
										GraphicsCard gpu = (GraphicsCard) val;

										if (gpu.getModel().toString()
												.equalsIgnoreCase(mainTable.getValueAt(i, 1).toString())) {

											System.out.println(gpu.toString());
											AdminPanel.computerDB.getDatabase().get("Graphics Card").remove(gpu);
											break;
										}
									}

									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Memory")) {

							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i, 8)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("Memory")) {
										Memory memory = (Memory) val;

										if (memory.getBrand().equals(mainTable.getValueAt(i, 0).toString())
												&& memory.getModel().equals(mainTable.getValueAt(i, 1).toString())
												&& memory.getType().equals(mainTable.getValueAt(i, 2).toString())
												&& memory.getSpeed() == Integer
														.parseInt(mainTable.getValueAt(i, 3).toString())
												&& memory.getCapacity() == Integer
														.parseInt(mainTable.getValueAt(i, 4).toString())
												&& memory.getLatency() == Integer
														.parseInt(mainTable.getValueAt(i, 5).toString())) {

											AdminPanel.computerDB.getDatabase().get("Memory").remove(memory);
											break;
										}
									}

									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Processor")) {

							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i, 10)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("Processor")) {
										Processor cpu = (Processor) val;

										if (cpu.getModel().toString()
												.equalsIgnoreCase(mainTable.getValueAt(i, 1).toString())) {
											AdminPanel.computerDB.getDatabase().get("Processor").remove(cpu);
											break;
										}
									}

									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Storage")) {

							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i, 6)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("Storage")) {
										Storage storage = (Storage) val;

										if (storage.getModel().equals(mainTable.getValueAt(i, 1).toString())
												&& storage.getReadSpeed() == Integer
														.parseInt(mainTable.getValueAt(i, 2).toString())
												&& storage.getWriteSpeed() == Integer
														.parseInt(mainTable.getValueAt(i, 3).toString())) {

											AdminPanel.computerDB.getDatabase().get("Storage").remove(storage);
											break;
										}
									}

									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Case")) {

							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i, 5)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("Case")) {
										Case caseEntry = (Case) val;

										if (caseEntry.getModel().toString()
												.equalsIgnoreCase(mainTable.getValueAt(i, 1).toString())) {
											AdminPanel.computerDB.getDatabase().get("Case").remove(caseEntry);
											break;
										}
									}

									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						} else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("Motherboard")) {

							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i, 9)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("Motherboard")) {
										MotherBoard mobo = (MotherBoard) val;

										if (mobo.getModel().equals(mainTable.getValueAt(i, 1).toString())
												&& mobo.getChipset().equals(mainTable.getValueAt(i, 2).toString())
												&& mobo.getPrice() == Integer
														.parseInt(mainTable.getValueAt(i, 7).toString())) {

											AdminPanel.computerDB.getDatabase().get("Motherboard").remove(mobo);
											break;
										}
									}

									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						}
					}
				}
			}
		});
		removeButton.setBounds(491, 23, 161, 35);
		contentPane.add(removeButton);

	}

	public static Object[][] getData(Computer computerDB, int comp) {
		Object data[][] = null;
		int size;

		switch (comp) {
		case 1:
			size = computerDB.getDatabase().get("Graphics Card").size();
			data = new Object[size][8];
			for (int i = 0; i < size; i++) {
				GraphicsCard gpu = (GraphicsCard) computerDB.getDatabase().get("Graphics Card").get(i);

				data[i][0] = gpu.getBrand();
				data[i][1] = gpu.getModel();
				data[i][2] = gpu.getVendor();
				data[i][3] = "" + gpu.getCapacity();
				data[i][4] = "" + gpu.getTdp();
				data[i][5] = "" + gpu.getPrice();
				data[i][6] = "" + gpu.getUsage();
				data[i][7] = false;
			}
			break;
		case 2:
			size = computerDB.getDatabase().get("Memory").size();
			data = new Object[size][9];
			for (int i = 0; i < size; i++) {
				Memory memory = (Memory) computerDB.getDatabase().get("Memory").get(i);

				data[i][0] = memory.getBrand();
				data[i][1] = memory.getModel();
				data[i][2] = memory.getType();
				data[i][3] = "" + memory.getSpeed();
				data[i][4] = "" + memory.getCapacity();
				data[i][5] = "" + memory.getLatency();
				data[i][6] = "" + memory.getPrice();
				data[i][7] = "" + memory.getUsage();
				data[i][8] = false;
			}
			break;
		case 3:
			size = computerDB.getDatabase().get("Processor").size();
			data = new Object[size][11];
			for (int i = 0; i < size; i++) {
				Processor cpu = (Processor) computerDB.getDatabase().get("Processor").get(i);

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
				data[i][10] = false;
			}
			break;
		case 4:
			size = computerDB.getDatabase().get("Storage").size();
			data = new Object[size][8];
			for (int i = 0; i < size; i++) {
				Storage storage = (Storage) computerDB.getDatabase().get("Storage").get(i);

				data[i][0] = storage.getBrand();
				data[i][1] = storage.getModel();
				data[i][2] = storage.getCapacity();
				data[i][3] = "" + storage.getReadSpeed();
				data[i][4] = "" + storage.getWriteSpeed();
				data[i][5] = "" + storage.getPrice();
				data[i][6] = "" + storage.getUsage();
				data[i][7] = false;
			}
			break;
		case 5:
			size = computerDB.getDatabase().get("Case").size();
			data = new Object[size][6];
			for (int i = 0; i < size; i++) {
				Case caseObject = (Case) computerDB.getDatabase().get("Case").get(i);

				data[i][0] = caseObject.getBrand();
				data[i][1] = caseObject.getModel();
				data[i][2] = "" + caseObject.getPsu();
				data[i][3] = "" + caseObject.getPrice();
				data[i][4] = "" + caseObject.getUsage();
				data[i][5] = false;
			}
			break;
		case 6:
			size = computerDB.getDatabase().get("Motherboard").size();
			data = new Object[size][10];
			for (int i = 0; i < size; i++) {
				MotherBoard mobo = (MotherBoard) computerDB.getDatabase().get("Motherboard").get(i);

				data[i][0] = mobo.getBrand();
				data[i][1] = mobo.getModel();
				data[i][2] = "" + mobo.getChipset();
				data[i][3] = "" + mobo.getSocket();
				data[i][4] = "" + mobo.getFormFactor();
				data[i][5] = "" + mobo.isM2Support();
				data[i][6] = "" + mobo.getPcieVersion();
				data[i][7] = "" + mobo.getPrice();
				data[i][8] = "" + mobo.getUsage();
				data[i][9] = false;
			}
			break;
		}

		return data;
	}
}
