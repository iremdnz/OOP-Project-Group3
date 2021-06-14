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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel compTypeLabel = new JLabel("Component Type: ");
		compTypeLabel.setBounds(19, 14, 183, 49);
		compTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(compTypeLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(200, 27, 239, 29);
		contentPane.add(comboBox);
		
		for (String entry : AdminPanel.computerDB.getDatabase().keySet()) {
			comboBox.addItem(entry);
		}
		
		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "isUnlocked",
				"Price", "Usage", "Remove"};
		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "formFactor", "M.2 Support", "PCIE", "Price",
		"Usage", "Remove"};
		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage", "Remove"};
		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "Price", "Usage", "Remove"};
		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage", "Remove"};
		String[] storageTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage", "Remove"};
		
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
		DefaultTableModel memoryModel = new DefaultTableModel(memoryData, memoryTag){
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
		DefaultTableModel gpuModel = new DefaultTableModel(gpuData, gpuTag){
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
		DefaultTableModel caseModel = new DefaultTableModel(caseData, caseTag){
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
		DefaultTableModel storageModel = new DefaultTableModel(storageData, storageTag){
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
		
		mainTable = new JTable();
		mainTable.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		mainTable.setDefaultEditor(Object.class, null);
		JScrollPane js = new JScrollPane(mainTable);
		js.setBounds(6, 94, 689, 329);
		contentPane.add(js);
		
		JButton removeButton = new JButton("Remove Selected");
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedCount = 0;
				
				for (int i = 0; i < mainTable.getRowCount(); i++) {
					if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("graphics_card") && (Boolean) mainTable.getValueAt(i,6)) {
						selectedCount++;
					}
					else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("memory") && (Boolean) mainTable.getValueAt(i,8)) {
						selectedCount++;
					}
					else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("processor") && (Boolean) mainTable.getValueAt(i,10)) {
						selectedCount++;
					}
					else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("storage") && (Boolean) mainTable.getValueAt(i,6)) {
						selectedCount++;
					}
					else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("case") && (Boolean) mainTable.getValueAt(i,5)) {
						selectedCount++;
					}
					else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("motherboard") && (Boolean) mainTable.getValueAt(i,9)) {
						selectedCount++;
					}
				}
				
				if (selectedCount == 0) {
					JOptionPane.showMessageDialog(contentPane, "No components were selected to remove." , "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int selResult = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete selected components?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (selResult == JOptionPane.YES_OPTION) {
						
						if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("graphics_card")) {

							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i,6)) {
									
									for (Object val : AdminPanel.computerDB.getDatabase().get("graphics_card")) {
										GraphicsCard gpu = (GraphicsCard) val;

										if (gpu.getModel().toString().equalsIgnoreCase(mainTable.getValueAt(i, 1).toString())) {
											
											System.out.println(gpu.toString());
											AdminPanel.computerDB.getDatabase().get("graphics_card").remove(gpu);
											break;
										}
									}
									
									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						}
						else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("memory")) {
							
							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i,8)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("memory")) {
										Memory memory = (Memory) val;

										if (memory.getBrand()
												.equals(mainTable.getValueAt(i, 0).toString())
												&& memory.getModel().equals(
														mainTable.getValueAt(i, 1).toString())
												&& memory.getType().equals(
														mainTable.getValueAt(i, 2).toString())
												&& memory.getSpeed() == Integer.parseInt(
														mainTable.getValueAt(i, 3).toString())
												&& memory.getCapacity() == Integer.parseInt(
														mainTable.getValueAt(i, 4).toString())
												&& memory.getLatency() == Integer.parseInt(
														mainTable.getValueAt(i, 5).toString())) {

											AdminPanel.computerDB.getDatabase().get("memory").remove(memory);
											break;
										}
									}
									
									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						}
						else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("processor")) {
							
							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i,10)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("processor")) {
										Processor cpu = (Processor) val;

										if (cpu.getModel().toString().equalsIgnoreCase(mainTable.getValueAt(i, 1).toString())) {
											AdminPanel.computerDB.getDatabase().get("processor").remove(cpu);
											break;
										}
									}
									
									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						}
						else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("storage")) {
							
							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i,6)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("storage")) {
										Storage storage = (Storage) val;

										if (storage.getModel().equals(mainTable.getValueAt(i, 1).toString())
												&& storage.getReadSpeed() == Integer.parseInt(mainTable.getValueAt(i, 2).toString())
												&& storage.getWriteSpeed() == Integer.parseInt(mainTable.getValueAt(i, 3).toString())) {

											AdminPanel.computerDB.getDatabase().get("storage").remove(storage);
											break;
										}
									}
									
									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						}
						else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("case")) {
							
							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i,5)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("case")) {
										Case caseEntry = (Case) val;

										if (caseEntry.getModel().toString().equalsIgnoreCase(mainTable.getValueAt(i, 1).toString())) {
											AdminPanel.computerDB.getDatabase().get("case").remove(caseEntry);
											break;
										}
									}
									
									((DefaultTableModel) mainTable.getModel()).removeRow(i);
									i--;
								}
							}
						}
						else if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("motherboard")) {
							
							for (int i = 0; i < mainTable.getRowCount(); i++) {
								if ((Boolean) mainTable.getValueAt(i,9)) {
									for (Object val : AdminPanel.computerDB.getDatabase().get("motherboard")) {
										MotherBoard mobo = (MotherBoard) val;

										if (mobo.getModel().equals(mainTable.getValueAt(i, 1).toString())
												&& mobo.getChipset().equals(mainTable.getValueAt(i, 2).toString())
												&& mobo.getPrice() == Integer.parseInt(mainTable.getValueAt(i, 7).toString())) {

											AdminPanel.computerDB.getDatabase().get("case").remove(mobo);
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
		removeButton.setBounds(493, 27, 138, 29);
		contentPane.add(removeButton);
		
		
	}
	
	public static Object[][] getData(Computer computerDB, int comp) {
		Object data[][] = null;
		int size;

		switch (comp) {
		case 1:
			size = computerDB.getDatabase().get("graphics_card").size();
			data = new Object[size][7];
			for (int i = 0; i < size; i++) {
				GraphicsCard gpu = (GraphicsCard) computerDB.getDatabase().get("graphics_card").get(i);

				data[i][0] = gpu.getBrand();
				data[i][1] = gpu.getModel();
				data[i][2] = gpu.getVendor();
				data[i][3] = "" + gpu.getCapacity();
				data[i][4] = "" + gpu.getPrice();
				data[i][5] = "" + gpu.getUsage();
				data[i][6] = false;
			}
			break;
		case 2:
			size = computerDB.getDatabase().get("memory").size();
			data = new Object[size][9];
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
				data[i][8] = false;
			}
			break;
		case 3:
			size = computerDB.getDatabase().get("processor").size();
			data = new Object[size][11];
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
				data[i][10] = false;
			}
			break;
		case 4:
			size = computerDB.getDatabase().get("storage").size();
			data = new Object[size][7];
			for (int i = 0; i < size; i++) {
				Storage storage = (Storage) computerDB.getDatabase().get("storage").get(i);

				data[i][0] = storage.getBrand();
				data[i][1] = storage.getModel();
				data[i][2] = "" + storage.getReadSpeed();
				data[i][3] = "" + storage.getWriteSpeed();
				data[i][4] = "" + storage.getPrice();
				data[i][5] = "" + storage.getUsage();
				data[i][6] = false;
			}
			break;
		case 5:
			size = computerDB.getDatabase().get("case").size();
			data = new Object[size][6];
			for (int i = 0; i < size; i++) {
				Case caseObject = (Case) computerDB.getDatabase().get("case").get(i);

				data[i][0] = caseObject.getBrand();
				data[i][1] = caseObject.getModel();
				data[i][2] = "" + caseObject.getPsu();
				data[i][3] = "" + caseObject.getPrice();
				data[i][4] = "" + caseObject.getUsage();
				data[i][5] = false;
			}
			break;
		case 6:
			size = computerDB.getDatabase().get("motherboard").size();
			data = new Object[size][10];
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
				data[i][9] = false;
			}
			break;
		}

		return data;
	}
}
