import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EditCompFrame extends JFrame {

	private JPanel contentPane;
	private JTable mainTable;
	private static DefaultTableModel caseModel;
	private static String[][] caseData;
	private Object EditObject = null;
	private static DefaultTableModel model;

	private JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;
	private static String[] chosenTag;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCompFrame frame = new EditCompFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditCompFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Component Type: ");
		lblNewLabel.setBounds(6, 19, 183, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(214, 27, 239, 29);
		contentPane.add(comboBox);

		Computer computerDB = new Computer();

		for (String entry : computerDB.getDatabase().keySet()) {
			String key = entry;

			comboBox.addItem(key);

		}

		JPanel editContentPane = new JPanel();
		JFrame editFrame = new JFrame();

		mainTable = new JTable();
		mainTable.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		mainTable.setDefaultEditor(Object.class, null);
		JScrollPane js = new JScrollPane(mainTable);
		js.setBounds(6, 94, 689, 329);
		contentPane.add(js);

		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "isUnlocked",
				"Price", "Usage" };
		String[][] processorData = getData(computerDB, 3);
		DefaultTableModel cpuModel = new DefaultTableModel(processorData, processorTag);

		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "formFactor", "M.2 Support", "PCIE", "Price",
				"Usage" };
		String[][] motherboardData = getData(computerDB, 6);
		DefaultTableModel mbModel = new DefaultTableModel(motherboardData, motherboardTag);

		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage" };
		String[][] memoryData = getData(computerDB, 2);
		DefaultTableModel memoryModel = new DefaultTableModel(memoryData, memoryTag);

		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "Price", "Usage" };
		String[][] gpuData = getData(computerDB, 1);
		DefaultTableModel gpuModel = new DefaultTableModel(gpuData, gpuTag);

		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage" };
		caseData = getData(computerDB, 5);
		caseModel = new DefaultTableModel(caseData, caseTag);

		String[] storageTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage" };
		String[][] storageData = getData(computerDB, 4);
		DefaultTableModel storageModel = new DefaultTableModel(storageData, storageTag);

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
		mainTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedVal = null;
				if (e.getClickCount() == 2) {

					int row = mainTable.getSelectedRow();
					int column = mainTable.getModel().getColumnCount();

					editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					editFrame.setBounds(100, 100, 700, 450);

					editContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(editContentPane);
					editContentPane.setLayout(null);
					editFrame.setContentPane(editContentPane);
					editFrame.setVisible(true);
					editContentPane.setVisible(true);

					JLabel label1 = new JLabel();
					label1.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label1.setBounds(43, 105, 97, 26);
					editContentPane.add(label1);
					label1.setVisible(false);

					JLabel label2 = new JLabel();
					label2.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label2.setBounds(43, 153, 97, 26);
					editContentPane.add(label2);
					label2.setVisible(false);

					JLabel label3 = new JLabel();
					label3.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label3.setBounds(43, 201, 97, 26);
					editContentPane.add(label3);
					label3.setVisible(false);

					JLabel label4 = new JLabel();
					label4.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label4.setBounds(43, 249, 97, 26);
					editContentPane.add(label4);
					label4.setVisible(false);

					JLabel label5 = new JLabel();
					label5.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label5.setBounds(43, 297, 97, 26);
					editContentPane.add(label5);
					label5.setVisible(false);

					JLabel label6 = new JLabel();
					label6.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label6.setBounds(376, 105, 89, 26);
					editContentPane.add(label6);
					label6.setVisible(false);

					JLabel label7 = new JLabel();
					label7.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label7.setBounds(376, 153, 89, 26);
					editContentPane.add(label7);
					label7.setVisible(false);

					JLabel label8 = new JLabel();
					label8.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label8.setBounds(376, 201, 89, 26);
					editContentPane.add(label8);
					label8.setVisible(false);

					JLabel label9 = new JLabel();
					label9.setFont(new Font("Tahoma", Font.PLAIN, 17));
					label9.setBounds(376, 249, 89, 26);
					editContentPane.add(label9);
					label9.setVisible(false);

					JLabel label10 = new JLabel();
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

					JLabel[] labels = { label1, label2, label3, label4, label5, label6, label7, label8, label9,
							label10 };
					JTextField[] texts = { text1, text2, text3, text4, text5, text6, text7, text8, text9, text10 };

					String selectedItem = comboBox.getSelectedItem().toString();
					// computerDB.getDatabase()
					for (int i = 0; i < column; i++) {
						selectedVal = mainTable.getModel().getValueAt(row, i).toString();

						texts[i].setText(selectedVal);

					}

					String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "Price", "Usage" };
					String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage" };
					String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "Form Factor", "M.2", "PCIE",
							"Price", "Usage" };
					String[] solidTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage", "Type",
							"Cooling S." };
					String[] hardTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage", "Spin" };
					String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP",
							"Unlocked", "Price", "Usage" };
					String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage" };

					for (int i = 0; i < 10; i++) {
						labels[i].setVisible(false);
						texts[i].setVisible(false);
					}

					String selectedComp = String.valueOf(comboBox.getSelectedItem());

					if (selectedComp.equalsIgnoreCase("graphics_card")) {
						chosenTag = gpuTag;

					} else if (selectedComp.equalsIgnoreCase("memory")) {
						chosenTag = memoryTag;
					} else if (selectedComp.equalsIgnoreCase("processor")) {
						chosenTag = processorTag;
					} else if (selectedComp.equalsIgnoreCase("storage")) {
						if (mainTable.getModel().getValueAt(row, 2).toString().equalsIgnoreCase("150")) {
							chosenTag = hardTag;
						} else {
							chosenTag = solidTag;
						}
					} else if (selectedComp.equalsIgnoreCase("case")) {
						chosenTag = caseTag;
					} else if (selectedComp.equalsIgnoreCase("motherboard")) {
						chosenTag = motherboardTag;
					}

					for (int i = 0; i < chosenTag.length; i++) {
						labels[i].setText(chosenTag[i]);
						labels[i].setVisible(true);
						texts[i].setVisible(true);
					}

					JButton btnNewButton = new JButton("Edit");
					btnNewButton.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseClicked(MouseEvent e) {

							boolean isValid = true;

							for (int i = 0; i < 10; i++) {
								if (labels[i].isVisible() == true && texts[i].getText().equals("")) {
									JOptionPane.showMessageDialog(editContentPane, "All specifiations must be filled",
											"Warning", JOptionPane.WARNING_MESSAGE);
									isValid = false;
									break;
								}
								if (labels[i].getText().equals("Capacity") || labels[i].getText().equals("Price")
										|| labels[i].getText().equals("Speed") || labels[i].getText().equals("Latency")
										|| labels[i].getText().equals("Read Speed")
										|| labels[i].getText().equals("Write Speed")
										|| labels[i].getText().equals("Core") || labels[i].getText().equals("Thread")
										|| labels[i].getText().equals("TDP") || labels[i].getText().equals("PSU")) {
									try {
										Integer.parseInt(texts[i].getText());
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(editContentPane,
												"Please enter specifiations in correct type", "Warning",
												JOptionPane.WARNING_MESSAGE);
										isValid = false;
										break;
									}
								} else if (labels[i].getText().equals("M.2")
										|| labels[i].getText().equals("Unlocked")) {
									if (!(texts[i].getText().equalsIgnoreCase("true")
											|| texts[i].getText().equalsIgnoreCase("false"))) {
										JOptionPane.showMessageDialog(editContentPane,
												"Please enter specifiations in correct type", "Warning",
												JOptionPane.WARNING_MESSAGE);
										isValid = false;
										break;
									}

								} else if (labels[i].getText().equals("PCIE")
										|| labels[i].getText().equals("Clockspeed")) {
									try {
										Double.parseDouble(texts[i].getText());
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(editContentPane,
												"Please enter specifiations in correct type", "Warning",
												JOptionPane.WARNING_MESSAGE);
										isValid = false;
										break;
									}
								} else { // sadece string direkt int yap�lamamal�
									try {
										Integer.parseInt(texts[i].getText());
										JOptionPane.showMessageDialog(editContentPane,
												"Please enter specifiations in correct type", "Warning",
												JOptionPane.WARNING_MESSAGE);
										isValid = false;
										break;
									} catch (Exception e1) {
										// do nothing
									}
								}
							}

							String selectedComp = String.valueOf(comboBox.getSelectedItem());

							if (isValid == true) {
								for (int i = 0; i < column; i++) {

									if (selectedItem.equals("graphics_card") && i == 1) {

										for (Object val : computerDB.getDatabase().get("graphics_card")) {
											GraphicsCard gpu = (GraphicsCard) val;

											if (gpu.getModel().toString().equalsIgnoreCase(texts[i].getText())) {
												EditObject = gpu;

												break;
											}
										}

									} else if (selectedItem.equals("processor") && i == 1) {
										for (Object val : computerDB.getDatabase().get("processor")) {
											Processor cpu = (Processor) val;

											if (cpu.getModel().toString().equalsIgnoreCase(texts[i].getText())) {
												EditObject = cpu;
												System.out.println("yey");
												break;
											}
										}

									} else if (selectedItem.equals("memory")) {

										for (Object val : computerDB.getDatabase().get("memory")) {
											Memory memory = (Memory) val;

											if (memory.getBrand().equals(texts[0].getText())
													&& memory.getModel().equals(texts[1].getText())
													&& memory.getType().equals(texts[2].getText())
													&& memory.getSpeed() == Integer.parseInt(texts[3].getText())
													&& memory.getCapacity() == Integer.parseInt(texts[4].getText())
													&& memory.getLatency() == Integer.parseInt(texts[5].getText())) {

												EditObject = memory;

												break;
											}

										}

									} else if (selectedItem.equals("case") && i == 1) {
										for (Object val : computerDB.getDatabase().get("case")) {
											Case caseEntry = (Case) val;

											if (caseEntry.getModel().toString().equalsIgnoreCase(texts[i].getText())) {
												EditObject = caseEntry;

												break;
											}
										}

									} else if (selectedItem.equals("motherboard")) {

										for (Object val : computerDB.getDatabase().get("motherboard")) {
											MotherBoard mobo = (MotherBoard) val;

											if (mobo.getModel().equals(texts[1].getText())
													&& mobo.getChipset().equals(texts[2].getText())
													&& mobo.getPrice() == Integer.parseInt(texts[7].getText())

											) {

												EditObject = mobo;

												break;
											}

										}

									} else if (selectedItem.equals("storage")) {

										for (Object val : computerDB.getDatabase().get("storage")) {
											Storage storage = (Storage) val;

											if (storage.getModel().equals(texts[1].getText())
													&& storage.getReadSpeed() == Integer.parseInt(texts[2].getText())
													&& storage.getWriteSpeed() == Integer.parseInt(texts[3].getText())

											) {

												EditObject = storage;

												break;
											}

										}

									}

								}

								int editObjectIndex = computerDB.getDatabase().get(selectedItem).indexOf(EditObject);

								// System.out.println(computerDB.getDatabase().get(selectedItem).toString());
								if (selectedItem.equals("graphics_card")) {
									GraphicsCard gpu = (GraphicsCard) EditObject;
									gpu.setBrand(texts[0].getText());
									gpu.setModel(texts[1].getText());
									gpu.setVendor(texts[2].getText());
									gpu.setCapacity(Integer.valueOf(texts[3].getText()));
									gpu.setPrice(Integer.valueOf(texts[4].getText()));
									gpu.setUsage(texts[5].getText().charAt(0));
									computerDB.getDatabase().get(selectedItem).add(editObjectIndex, gpu);
									String[][] data = getData(computerDB, 1);
									model = new DefaultTableModel(data, gpuTag);

								} else if (selectedItem.equals("memory")) {

									Memory memory = (Memory) EditObject;

									memory.setBrand(texts[0].getText());
									memory.setModel(texts[1].getText());
									memory.setType(texts[2].getText());
									memory.setSpeed(Integer.valueOf(texts[3].getText()));
									memory.setCapacity(Integer.valueOf(texts[4].getText()));
									memory.setLatency(Integer.valueOf(texts[5].getText()));
									memory.setPrice(Integer.valueOf(texts[6].getText()));
									memory.setUsage(texts[7].getText().charAt(0));
									computerDB.getDatabase().get(selectedItem).add(editObjectIndex, memory);
									String[][] data = getData(computerDB, 2);
									model = new DefaultTableModel(data, memoryTag);

								}

								else if (selectedItem.equals("motherboard")) {

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
									computerDB.getDatabase().get(selectedItem).add(editObjectIndex, mobo);
									String[][] data = getData(computerDB, 6);
									model = new DefaultTableModel(data, motherboardTag);

								}

								else if (selectedItem.equals("storage")) {

									Storage storage = (Storage) EditObject;
									String[][] data = getData(computerDB, 4);
									model = new DefaultTableModel(data, storageTag);
								}

								else if (selectedItem.equals("processor")) {

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
									computerDB.getDatabase().get(selectedItem).add(editObjectIndex, cpu);
									String[][] data = getData(computerDB, 3);
									model = new DefaultTableModel(data, processorTag);
								}

								else if (selectedItem.equals("case")) {
									Case cse = (Case) EditObject;
									cse.setBrand(texts[0].getText());
									cse.setModel(texts[1].getText());
									cse.setPsu(Integer.valueOf(texts[2].getText()));
									cse.setUsage(texts[3].getText().charAt(0));
									computerDB.getDatabase().get(selectedItem).add(editObjectIndex, cse);
									String[][] data = getData(computerDB, 5);
									model = new DefaultTableModel(data, caseTag);
								}

								mainTable.setModel(model);

							}

						}
					});

					btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
					btnNewButton.setBounds(535, 359, 89, 26);
					editContentPane.add(btnNewButton);

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
			data = new String[size][6];
			for (int i = 0; i < size; i++) {
				GraphicsCard gpu = (GraphicsCard) computerDB.getDatabase().get("graphics_card").get(i);

				data[i][0] = gpu.getBrand();
				data[i][1] = gpu.getModel();
				data[i][2] = gpu.getVendor();
				data[i][3] = "" + gpu.getCapacity();
				data[i][4] = "" + gpu.getPrice();
				data[i][5] = "" + gpu.getUsage();
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
			data = new String[size][6];
			for (int i = 0; i < size; i++) {
				Storage storage = (Storage) computerDB.getDatabase().get("storage").get(i);

				data[i][0] = storage.getBrand();
				data[i][1] = storage.getModel();
				data[i][2] = "" + storage.getReadSpeed();
				data[i][3] = "" + storage.getWriteSpeed();
				data[i][4] = "" + storage.getPrice();
				data[i][5] = "" + storage.getUsage();
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
