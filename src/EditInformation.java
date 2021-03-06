import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EditInformation extends JFrame {

	private JPanel editContentPane;
	private JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;

	public EditInformation() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		editContentPane = new JPanel();
		editContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		editContentPane.setLayout(null);
		setContentPane(editContentPane);

		label1 = new JLabel();
		label1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label1.setBounds(43, 105, 97, 26);
		editContentPane.add(label1);
		label1.setVisible(false);

		label2 = new JLabel();
		label2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label2.setBounds(43, 153, 97, 26);
		editContentPane.add(label2);
		label2.setVisible(false);

		label3 = new JLabel();
		label3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label3.setBounds(43, 201, 97, 26);
		editContentPane.add(label3);
		label3.setVisible(false);

		label4 = new JLabel();
		label4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label4.setBounds(43, 249, 97, 26);
		editContentPane.add(label4);
		label4.setVisible(false);

		label5 = new JLabel();
		label5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label5.setBounds(43, 297, 97, 26);
		editContentPane.add(label5);
		label5.setVisible(false);

		label6 = new JLabel();
		label6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label6.setBounds(376, 105, 89, 26);
		editContentPane.add(label6);
		label6.setVisible(false);

		label7 = new JLabel();
		label7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label7.setBounds(376, 153, 89, 26);
		editContentPane.add(label7);
		label7.setVisible(false);

		label8 = new JLabel();
		label8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label8.setBounds(376, 201, 89, 26);
		editContentPane.add(label8);
		label8.setVisible(false);

		label9 = new JLabel();
		label9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label9.setBounds(376, 249, 89, 26);
		editContentPane.add(label9);
		label9.setVisible(false);

		label10 = new JLabel();
		label10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label10.setBounds(376, 297, 89, 26);
		editContentPane.add(label10);
		label10.setVisible(false);

		text1 = new JTextField();
		text1.setBounds(139, 105, 156, 26);
		editContentPane.add(text1);
		text1.setColumns(10);
		text1.setVisible(false);

		text2 = new JTextField();
		text2.setBounds(139, 153, 156, 26);
		editContentPane.add(text2);
		text2.setColumns(10);
		text2.setVisible(false);

		text3 = new JTextField();
		text3.setBounds(139, 201, 156, 26);
		editContentPane.add(text3);
		text3.setColumns(10);
		text3.setVisible(false);

		text4 = new JTextField();
		text4.setBounds(139, 249, 156, 26);
		editContentPane.add(text4);
		text4.setColumns(10);
		text4.setVisible(false);

		text5 = new JTextField();
		text5.setBounds(139, 297, 156, 26);
		editContentPane.add(text5);
		text5.setColumns(10);
		text5.setVisible(false);

		text6 = new JTextField();
		text6.setBounds(468, 105, 156, 26);
		editContentPane.add(text6);
		text6.setColumns(10);
		text6.setVisible(false);

		text7 = new JTextField();
		text7.setBounds(468, 153, 156, 26);
		editContentPane.add(text7);
		text7.setColumns(10);
		text7.setVisible(false);

		text8 = new JTextField();
		text8.setBounds(468, 201, 156, 26);
		editContentPane.add(text8);
		text8.setColumns(10);
		text8.setVisible(false);

		text9 = new JTextField();
		text9.setBounds(468, 249, 156, 26);
		editContentPane.add(text9);
		text9.setColumns(10);
		text9.setVisible(false);

		text10 = new JTextField();
		text10.setBounds(468, 297, 156, 26);
		editContentPane.add(text10);
		text10.setColumns(10);

		JLabel[] labels = { label1, label2, label3, label4, label5, label6, label7, label8, label9, label10 };
		JTextField[] texts = { text1, text2, text3, text4, text5, text6, text7, text8, text9, text10 };

		// computerDB.getDatabase()
		for (int i = 0; i < EditCompFrame.column; i++) {
			texts[i].setText(EditCompFrame.mainTable.getModel().getValueAt(EditCompFrame.row, i).toString());
		}

		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "TDP", "Price", "Usage" };
		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage" };
		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "Form Factor", "M.2", "PCIE", "Price",
				"Usage" };
		String[] storageTag = { "Brand", "Model", "Capacity", "Read Speed", "Write Speed", "Price", "Usage" };
		String[] solidTag = { "Brand", "Model", "Capacity", "Read Speed", "Write Speed", "Price", "Usage", "Type", "Cooling S." };
		String[] hardTag = { "Brand", "Model", "Capacity", "Read Speed", "Write Speed", "Price", "Usage", "Spin" };
		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "Unlocked",
				"Price", "Usage" };
		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage" };

		for (int i = 0; i < 10; i++) {
			labels[i].setVisible(false);
			texts[i].setVisible(false);
		}

		String selectedComp = String.valueOf(EditCompFrame.selectedItem);
		Storage storageObject = null;

		if (selectedComp.equalsIgnoreCase("Graphics Card")) {
			EditCompFrame.chosenTag = gpuTag;

		} else if (selectedComp.equalsIgnoreCase("Memory")) {
			EditCompFrame.chosenTag = memoryTag;
		} else if (selectedComp.equalsIgnoreCase("Processor")) {
			EditCompFrame.chosenTag = processorTag;
		} else if (selectedComp.equalsIgnoreCase("Storage")) {
			
			for (Object val : AdminPanel.computerDB.getDatabase().get("Storage")) {
				Storage storage = (Storage) val;

				if (storage.getModel()
						.equals(EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 1).toString())
						&& storage.getReadSpeed() == Integer.parseInt(
								EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 3).toString())
						&& storage.getWriteSpeed() == Integer.parseInt(
								EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 4).toString())) {

					storageObject = storage;
					break;
				}
			}
			
			if (storageObject.getReadSpeed() == 150) {
				EditCompFrame.chosenTag = hardTag;
			} else {
				EditCompFrame.chosenTag = solidTag;
			}
		} else if (selectedComp.equalsIgnoreCase("Case")) {
			EditCompFrame.chosenTag = caseTag;
		} else if (selectedComp.equalsIgnoreCase("Motherboard")) {
			EditCompFrame.chosenTag = motherboardTag;
		}

		for (int i = 0; i < EditCompFrame.chosenTag.length; i++) {
			labels[i].setText(EditCompFrame.chosenTag[i]);
			labels[i].setVisible(true);
			texts[i].setVisible(true);
		}
		
		if (EditCompFrame.selectedItem.equalsIgnoreCase("Storage")) {
			if (storageObject.getReadSpeed() == 150) {
				texts[7].setText("" + ((HardDrive)storageObject).getSpin());
			}
			else {
				texts[7].setText(((SolidState)storageObject).getType());
				texts[8].setText(""+((SolidState)storageObject).isHasCoolingSys());
			}
		}

		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				boolean isValid = true;

				for (int i = 0; i < 10; i++) {
					if (labels[i].isVisible() == true && texts[i].getText().equals("")) {
						JOptionPane.showMessageDialog(editContentPane, "All specifiations must be filled", "Warning",
								JOptionPane.WARNING_MESSAGE);
						isValid = false;
						break;
					}
					if (labels[i].getText().equals("Capacity") || labels[i].getText().equals("Price")
							|| labels[i].getText().equals("Speed") || labels[i].getText().equals("Latency")
							|| labels[i].getText().equals("Read Speed") || labels[i].getText().equals("Write Speed")
							|| labels[i].getText().equals("Core") || labels[i].getText().equals("Thread")
							|| labels[i].getText().equals("TDP") || labels[i].getText().equals("PSU")
							|| labels[i].getText().equals("Spin")) {
						try {
							Integer.parseInt(texts[i].getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(editContentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
					} else if (labels[i].getText().equals("M.2") || labels[i].getText().equals("Unlocked")) {
						if (!(texts[i].getText().equalsIgnoreCase("true")
								|| texts[i].getText().equalsIgnoreCase("false"))) {
							JOptionPane.showMessageDialog(editContentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}

					} else if (labels[i].getText().equals("PCIE") || labels[i].getText().equals("Clockspeed")) {
						try {
							Double.parseDouble(texts[i].getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(editContentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
					} else { // sadece string direkt int yap???lamamal???
						try {
							Integer.parseInt(texts[i].getText());
							JOptionPane.showMessageDialog(editContentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						} catch (Exception e1) {
							// do nothing
						}
					}
				}

				if (isValid == true) {
					Object EditObject = null;

					for (int i = 0; i < EditCompFrame.column; i++) {

						if (EditCompFrame.selectedItem.equals("Graphics Card") && i == 1) {

							for (Object val : AdminPanel.computerDB.getDatabase().get("Graphics Card")) {
								GraphicsCard gpu = (GraphicsCard) val;

								if (gpu.getModel().toString().equalsIgnoreCase(
										EditCompFrame.mainTable.getValueAt(EditCompFrame.row, i).toString())) {
									EditObject = gpu;

									break;
								}
							}

							if (EditObject != null) {
								break;
							}

						} else if (EditCompFrame.selectedItem.equals("Processor") && i == 1) {
							for (Object val : AdminPanel.computerDB.getDatabase().get("Processor")) {
								Processor cpu = (Processor) val;

								if (cpu.getModel().toString().equalsIgnoreCase(
										EditCompFrame.mainTable.getValueAt(EditCompFrame.row, i).toString())) {
									EditObject = cpu;
									break;
								}
							}

							if (EditObject != null) {
								break;
							}

						} else if (EditCompFrame.selectedItem.equals("Memory")) {

							for (Object val : AdminPanel.computerDB.getDatabase().get("Memory")) {
								Memory memory = (Memory) val;

								if (memory.getBrand()
										.equals(EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 0).toString())
										&& memory.getModel().equals(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 1).toString())
										&& memory.getType().equals(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 2).toString())
										&& memory.getSpeed() == Integer.parseInt(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 3).toString())
										&& memory.getCapacity() == Integer.parseInt(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 4).toString())
										&& memory.getLatency() == Integer.parseInt(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 5).toString())) {

									EditObject = memory;
									System.out.println("hg");
									break;
								}
							}

							if (EditObject != null) {
								break;
							}

						} else if (EditCompFrame.selectedItem.equals("Case") && i == 1) {
							for (Object val : AdminPanel.computerDB.getDatabase().get("Case")) {
								Case caseEntry = (Case) val;

								if (caseEntry.getModel().toString().equalsIgnoreCase(
										EditCompFrame.mainTable.getValueAt(EditCompFrame.row, i).toString())) {
									EditObject = caseEntry;

									break;
								}
							}

							if (EditObject != null) {
								break;
							}

						} else if (EditCompFrame.selectedItem.equals("Motherboard")) {

							for (Object val : AdminPanel.computerDB.getDatabase().get("Motherboard")) {
								MotherBoard mobo = (MotherBoard) val;

								if (mobo.getModel()
										.equals(EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 1).toString())
										&& mobo.getChipset().equals(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 2).toString())
										&& mobo.getPrice() == Integer.parseInt(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 7).toString())) {

									EditObject = mobo;
									break;
								}
							}

							if (EditObject != null) {
								break;
							}

						} else if (EditCompFrame.selectedItem.equals("Storage")) {

							for (Object val : AdminPanel.computerDB.getDatabase().get("Storage")) {
								Storage storage = (Storage) val;

								if (storage.getModel()
										.equals(EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 1).toString())
										&& storage.getReadSpeed() == Integer.parseInt(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 3).toString())
										&& storage.getWriteSpeed() == Integer.parseInt(
												EditCompFrame.mainTable.getValueAt(EditCompFrame.row, 4).toString())) {

									EditObject = storage;
									break;
								}
							}

							if (EditObject != null) {
								break;
							}
						}
					}
					
					// System.out.println(computerDB.getDatabase().get(selectedItem).toString());
					if (EditCompFrame.selectedItem.equals("Graphics Card")) {
						GraphicsCard gpu = (GraphicsCard) EditObject;
						gpu.setBrand(texts[0].getText());
						gpu.setModel(texts[1].getText());
						gpu.setVendor(texts[2].getText());
						gpu.setCapacity(Integer.valueOf(texts[3].getText()));
						gpu.setTdp(Integer.valueOf(texts[4].getText()));
						gpu.setPrice(Integer.valueOf(texts[5].getText()));
						gpu.setUsage(texts[6].getText().charAt(0));
						int index = AdminPanel.computerDB.getDatabase().get("Graphics Card").indexOf(gpu);
						AdminPanel.computerDB.getDatabase().get("Graphics Card").remove(gpu);
						AdminPanel.computerDB.getDatabase().get("Graphics Card").add(index, gpu);
						
						String[][] data = EditCompFrame.getData(AdminPanel.computerDB, 1);
						EditCompFrame.model = new DefaultTableModel(data, gpuTag);

					} else if (EditCompFrame.selectedItem.equals("Memory")) {

						Memory memory = (Memory) EditObject;

						memory.setBrand(texts[0].getText());
						memory.setModel(texts[1].getText());
						memory.setType(texts[2].getText());
						memory.setSpeed(Integer.valueOf(texts[3].getText()));
						memory.setCapacity(Integer.valueOf(texts[4].getText()));
						memory.setLatency(Integer.valueOf(texts[5].getText()));
						memory.setPrice(Integer.valueOf(texts[6].getText()));
						memory.setUsage(texts[7].getText().charAt(0));
						int index = AdminPanel.computerDB.getDatabase().get("Memory").indexOf(memory);
						AdminPanel.computerDB.getDatabase().get("Memory").remove(memory);
						AdminPanel.computerDB.getDatabase().get("Memory").add(index, memory);
						
						String[][] data = EditCompFrame.getData(AdminPanel.computerDB, 2);
						EditCompFrame.model = new DefaultTableModel(data, memoryTag);

					}

					else if (EditCompFrame.selectedItem.equals("Motherboard")) {

						MotherBoard mobo = (MotherBoard) EditObject;
						mobo.setBrand(texts[0].getText());
						mobo.setModel(texts[1].getText());
						mobo.setChipset(texts[2].getText());
						mobo.setSocket(texts[3].getText());
						mobo.setFormFactor(texts[4].getText());
						mobo.setM2Support(Boolean.parseBoolean(texts[5].getText()));
						mobo.setPcieVersion(Double.parseDouble(texts[6].getText()));
						mobo.setPrice(Integer.valueOf(texts[7].getText()));
						mobo.setUsage(texts[8].getText().charAt(0));
						int index = AdminPanel.computerDB.getDatabase().get("Motherboard").indexOf(mobo);
						AdminPanel.computerDB.getDatabase().get("Motherboard").remove(mobo);
						AdminPanel.computerDB.getDatabase().get("Motherboard").add(index, mobo);
						
						String[][] data = EditCompFrame.getData(AdminPanel.computerDB, 6);
						EditCompFrame.model = new DefaultTableModel(data, motherboardTag);

					}

					else if (EditCompFrame.selectedItem.equals("Storage")) {

						Storage storage = (Storage) EditObject;
						
						if (storage.getReadSpeed() == 150) {
							HardDrive hdd = (HardDrive) storage;
							
							hdd.setBrand(texts[0].getText());
							hdd.setModel(texts[1].getText());
							hdd.setCapacity(Integer.parseInt(texts[2].getText()));
							hdd.setReadSpeed(Integer.parseInt(texts[3].getText()));
							hdd.setWriteSpeed(Integer.parseInt(texts[4].getText()));
							hdd.setPrice(Integer.parseInt(texts[5].getText()));
							hdd.setUsage(texts[6].getText().charAt(0));
							hdd.setSpin(Integer.parseInt(texts[7].getText()));
							storage = hdd;
						}
						
						else {
							SolidState ssd = (SolidState) storage;
							
							ssd.setBrand(texts[0].getText());
							ssd.setModel(texts[1].getText());
							ssd.setCapacity(Integer.parseInt(texts[2].getText()));
							ssd.setReadSpeed(Integer.parseInt(texts[3].getText()));
							ssd.setWriteSpeed(Integer.parseInt(texts[4].getText()));
							ssd.setPrice(Integer.parseInt(texts[5].getText()));
							ssd.setUsage(texts[6].getText().charAt(0));
							ssd.setType(texts[7].getText());
							ssd.setHasCoolingSys(Boolean.parseBoolean(texts[8].getText()));
							storage = ssd;
						}
						int index = AdminPanel.computerDB.getDatabase().get("Storage").indexOf(storage);
						AdminPanel.computerDB.getDatabase().get("Storage").remove(storage);
						AdminPanel.computerDB.getDatabase().get("Storage").add(index, storage);
						
						String[][] data = EditCompFrame.getData(AdminPanel.computerDB, 4);
						EditCompFrame.model = new DefaultTableModel(data, storageTag);
						
					}

					else if (EditCompFrame.selectedItem.equals("Processor")) {

						Processor cpu = (Processor) EditObject;
						cpu.setBrand(texts[0].getText());
						cpu.setModel(texts[1].getText());
						cpu.setCore(Integer.valueOf(texts[2].getText()));
						cpu.setThread(Integer.valueOf(texts[3].getText()));
						cpu.setSocket(texts[4].getText());
						cpu.setClockSpeed(Double.parseDouble(texts[5].getText()));
						cpu.setTdp(Integer.valueOf(texts[6].getText()));
						cpu.setUnlocked(Boolean.parseBoolean(texts[7].getText()));
						cpu.setPrice(Integer.valueOf(texts[8].getText()));
						cpu.setUsage(texts[9].getText().charAt(0));
						int index = AdminPanel.computerDB.getDatabase().get("Processor").indexOf(cpu);
						AdminPanel.computerDB.getDatabase().get("Processor").remove(cpu);
						AdminPanel.computerDB.getDatabase().get("Processor").add(index, cpu);
						
						String[][] data = EditCompFrame.getData(AdminPanel.computerDB, 3);
						EditCompFrame.model = new DefaultTableModel(data, processorTag);
					}

					else if (EditCompFrame.selectedItem.equals("Case")) {
						Case cse = (Case) EditObject;
						cse.setBrand(texts[0].getText());
						cse.setModel(texts[1].getText());
						cse.setPsu(Integer.valueOf(texts[2].getText()));
						cse.setUsage(texts[3].getText().charAt(0));
						int index = AdminPanel.computerDB.getDatabase().get("Case").indexOf(cse);
						AdminPanel.computerDB.getDatabase().get("Case").remove(cse);
						AdminPanel.computerDB.getDatabase().get("Case").add(index, cse);
						
						String[][] data = EditCompFrame.getData(AdminPanel.computerDB, 5);
						EditCompFrame.model = new DefaultTableModel(data, caseTag);
					}

					EditCompFrame.mainTable.setModel(EditCompFrame.model);

				}
				dispose();
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(535, 359, 89, 26);
		editContentPane.add(btnNewButton);
	}
}
