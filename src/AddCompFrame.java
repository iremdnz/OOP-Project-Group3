import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCompFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;
	private static String[] chosenTag;

	public AddCompFrame() {
		setResizable(false);
		setTitle(WelcomeScreen.title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Component Type: ");
		lblNewLabel.setBounds(24, 19, 150, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(184, 33, 321, 26);
		contentPane.add(comboBox);

		JLabel label1 = new JLabel();
		label1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label1.setBounds(43, 105, 97, 26);
		contentPane.add(label1);
		label1.setVisible(false);

		JLabel label2 = new JLabel();
		label2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label2.setBounds(43, 153, 97, 26);
		contentPane.add(label2);
		label2.setVisible(false);

		JLabel label3 = new JLabel();
		label3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label3.setBounds(43, 201, 97, 26);
		contentPane.add(label3);
		label3.setVisible(false);

		JLabel label4 = new JLabel();
		label4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label4.setBounds(43, 249, 97, 26);
		contentPane.add(label4);
		label4.setVisible(false);

		JLabel label5 = new JLabel();
		label5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label5.setBounds(43, 297, 97, 26);
		contentPane.add(label5);
		label5.setVisible(false);

		JLabel label6 = new JLabel();
		label6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label6.setBounds(376, 105, 89, 26);
		contentPane.add(label6);
		label6.setVisible(false);

		JLabel label7 = new JLabel();
		label7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label7.setBounds(376, 153, 89, 26);
		contentPane.add(label7);
		label7.setVisible(false);

		JLabel label8 = new JLabel();
		label8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label8.setBounds(376, 201, 89, 26);
		contentPane.add(label8);
		label8.setVisible(false);

		JLabel label9 = new JLabel();
		label9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label9.setBounds(376, 249, 89, 26);
		contentPane.add(label9);
		label9.setVisible(false);

		JLabel label10 = new JLabel();
		label10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label10.setBounds(376, 297, 89, 26);
		contentPane.add(label10);
		label10.setVisible(false);

		text1 = new JTextField();
		text1.setBounds(139, 105, 156, 26);
		contentPane.add(text1);
		text1.setColumns(10);
		text1.setVisible(false);

		text2 = new JTextField();
		text2.setBounds(139, 153, 156, 26);
		contentPane.add(text2);
		text2.setColumns(10);
		text2.setVisible(false);

		text3 = new JTextField();
		text3.setBounds(139, 201, 156, 26);
		contentPane.add(text3);
		text3.setColumns(10);
		text3.setVisible(false);

		text4 = new JTextField();
		text4.setBounds(139, 249, 156, 26);
		contentPane.add(text4);
		text4.setColumns(10);
		text4.setVisible(false);

		text5 = new JTextField();
		text5.setBounds(139, 297, 156, 26);
		contentPane.add(text5);
		text5.setColumns(10);
		text5.setVisible(false);

		text6 = new JTextField();
		text6.setBounds(468, 105, 156, 26);
		contentPane.add(text6);
		text6.setColumns(10);
		text6.setVisible(false);

		text7 = new JTextField();
		text7.setBounds(468, 153, 156, 26);
		contentPane.add(text7);
		text7.setColumns(10);
		text7.setVisible(false);

		text8 = new JTextField();
		text8.setBounds(468, 201, 156, 26);
		contentPane.add(text8);
		text8.setColumns(10);
		text8.setVisible(false);

		text9 = new JTextField();
		text9.setBounds(468, 249, 156, 26);
		contentPane.add(text9);
		text9.setColumns(10);
		text9.setVisible(false);

		text10 = new JTextField();
		text10.setBounds(468, 297, 156, 26);
		contentPane.add(text10);
		text10.setColumns(10);
		text10.setVisible(false);

		JLabel[] labels = { label1, label2, label3, label4, label5, label6, label7, label8, label9, label10 };
		JTextField[] texts = { text1, text2, text3, text4, text5, text6, text7, text8, text9, text10 };

		for (String entry : AdminPanel.computerDB.getDatabase().keySet()) {
			String key = entry;
			if (key.equals("Storage")) {
				comboBox.addItem("Solid State");
				comboBox.addItem("Hard Disk");
			} else {
				comboBox.addItem(key);
			}
		}

		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "TDP", "Price", "Usage" };
		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage" };
		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "Form Factor", "M.2", "PCIE", "Price",
				"Usage" };
		String[] solidTag = { "Brand", "Model", "Capacity", "Read Speed", "Write Speed", "Price", "Usage", "Type",
				"Cooling S." };
		String[] hardTag = { "Brand", "Model", "Capacity", "Read Speed", "Write Speed", "Price", "Usage", "Spin" };
		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "Unlocked",
				"Price", "Usage" };
		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage" };

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				boolean isValid = true;

				for (int i = 0; i < 10; i++) {
					if (labels[i].isVisible() == true && texts[i].getText().equals("")) {
						JOptionPane.showMessageDialog(contentPane, "All specifiations must be filled", "Warning",
								JOptionPane.WARNING_MESSAGE);
						isValid = false;
						break;
					}
					if (labels[i].isVisible() == true && (labels[i].getText().equals("Capacity")
							|| labels[i].getText().equals("Price") || labels[i].getText().equals("Speed")
							|| labels[i].getText().equals("Latency") || labels[i].getText().equals("Read Speed")
							|| labels[i].getText().equals("Write Speed") || labels[i].getText().equals("Core")
							|| labels[i].getText().equals("Thread") || labels[i].getText().equals("TDP")
							|| labels[i].getText().equals("PSU") || labels[i].getText().equals("Spin"))) {
						try {
							Integer.parseInt(texts[i].getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
					} else if (labels[i].isVisible() == true
							&& (labels[i].getText().equals("M.2") || labels[i].getText().equals("Unlocked"))) {
						if (!(texts[i].getText().equalsIgnoreCase("true")
								|| texts[i].getText().equalsIgnoreCase("false"))) {
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}

					} else if (labels[i].isVisible() == true
							&& (labels[i].getText().equals("PCIE") || labels[i].getText().equals("Clockspeed"))) {
						try {
							Double.parseDouble(texts[i].getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
					} else if (labels[i].isVisible() == true && (labels[i].getText().equals("Usage"))) {

						if (!(texts[i].getText().equals("d") || texts[i].getText().equals("g")
								|| texts[i].getText().equals("p"))) {
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}

					} else if (labels[i].isVisible() == true) { // sadece string direkt int olmamali
						try {
							Integer.parseInt(texts[i].getText());
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type",
									"Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						} catch (Exception e1) {
							// do nothing
						}
					}
				}

				String selectedComp = String.valueOf(comboBox.getSelectedItem());

				if (isValid == true) {
					if (selectedComp.equalsIgnoreCase("Graphics Card")) {
						GraphicsCard gpu = new GraphicsCard(texts[0].getText(), texts[1].getText(), texts[2].getText(),
								texts[3].getText(), texts[4].getText(), texts[5].getText(), texts[6].getText());
						AdminPanel.computerDB.getDatabase().get("Graphics Card").add(gpu);
					} else if (selectedComp.equalsIgnoreCase("Memory")) {
						Memory memory = new Memory(texts[0].getText(), texts[1].getText(), texts[3].getText(),
								texts[4].getText(), texts[2].getText(), texts[5].getText(), texts[6].getText(),
								texts[7].getText());
						AdminPanel.computerDB.getDatabase().get("Memory").add(memory);
					} else if (selectedComp.equalsIgnoreCase("Processor")) {
						Processor processor = new Processor(texts[0].getText(), texts[1].getText(), texts[2].getText(),
								texts[3].getText(), texts[4].getText(), texts[5].getText(), texts[6].getText(),
								texts[7].getText(), texts[8].getText(), texts[9].getText());
						AdminPanel.computerDB.getDatabase().get("Processor").add(processor);
					} else if (selectedComp.equalsIgnoreCase("Solid State")) {
						SolidState solidState = new SolidState(texts[0].getText(), texts[1].getText(),
								texts[2].getText(), texts[3].getText(), texts[4].getText(), texts[5].getText(),
								texts[6].getText(), texts[7].getText(), texts[8].getText());
						AdminPanel.computerDB.getDatabase().get("Storage").add(solidState);
					} else if (selectedComp.equalsIgnoreCase("Hard Disk")) {
						HardDrive hardDrive = new HardDrive(texts[0].getText(), texts[1].getText(), texts[2].getText(),
								texts[3].getText(), texts[4].getText(), texts[5].getText(), texts[6].getText(),
								texts[7].getText());
						AdminPanel.computerDB.getDatabase().get("Storage").add(hardDrive);
					} else if (selectedComp.equalsIgnoreCase("Case")) {
						Case casee = new Case(texts[0].getText(), texts[1].getText(), texts[2].getText(),
								texts[3].getText(), texts[4].getText());
						AdminPanel.computerDB.getDatabase().get("Case").add(casee);
					} else if (selectedComp.equalsIgnoreCase("Motherboard")) {
						MotherBoard motherboard = new MotherBoard(texts[0].getText(), texts[1].getText(),
								texts[2].getText(), texts[3].getText(), texts[4].getText(), texts[5].getText(),
								texts[6].getText(), texts[7].getText(), texts[8].getText());
						AdminPanel.computerDB.getDatabase().get("Motherboard").add(motherboard);
					}

					JOptionPane.showMessageDialog(contentPane, "Component added successfully!", "Add Info",
							JOptionPane.INFORMATION_MESSAGE);

					ListCompFrame listFrame = new ListCompFrame();
					listFrame.setVisible(true);

					if (selectedComp.equalsIgnoreCase("Graphics Card")) {
						ListCompFrame.mainTable.setModel(ListCompFrame.gpuModel);
						ListCompFrame.comboBox.setSelectedItem("Graphics Card");
					} else if (selectedComp.equalsIgnoreCase("Memory")) {
						ListCompFrame.mainTable.setModel(ListCompFrame.memoryModel);
						ListCompFrame.comboBox.setSelectedItem("Memory");
					} else if (selectedComp.equalsIgnoreCase("Processor")) {
						ListCompFrame.mainTable.setModel(ListCompFrame.cpuModel);
						ListCompFrame.comboBox.setSelectedItem("Processor");
					} else if (selectedComp.equalsIgnoreCase("Solid State")) {
						ListCompFrame.mainTable.setModel(ListCompFrame.storageModel);
						ListCompFrame.comboBox.setSelectedItem("Solid State");
					} else if (selectedComp.equalsIgnoreCase("Hard Disk")) {
						ListCompFrame.mainTable.setModel(ListCompFrame.storageModel);
						ListCompFrame.comboBox.setSelectedItem("Hard Disk");
					} else if (selectedComp.equalsIgnoreCase("Case")) {
						ListCompFrame.mainTable.setModel(ListCompFrame.caseModel);
						ListCompFrame.comboBox.setSelectedItem("Case");
					} else if (selectedComp.equalsIgnoreCase("Motherboard")) {
						ListCompFrame.mainTable.setModel(ListCompFrame.mbModel);
						ListCompFrame.comboBox.setSelectedItem("Motherboard");
					}
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(535, 359, 89, 26);
		btnNewButton.setVisible(false);
		contentPane.add(btnNewButton);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				for (int i = 0; i < 10; i++) {
					texts[i].setText("");
					labels[i].setVisible(false);
					texts[i].setVisible(false);
				}

				String selectedComp = String.valueOf(comboBox.getSelectedItem());

				if (selectedComp.equalsIgnoreCase("Graphics Card")) {
					chosenTag = gpuTag;
				} else if (selectedComp.equalsIgnoreCase("Memory")) {
					chosenTag = memoryTag;
				} else if (selectedComp.equalsIgnoreCase("Processor")) {
					chosenTag = processorTag;
				} else if (selectedComp.equalsIgnoreCase("Solid State")) {
					chosenTag = solidTag;
				} else if (selectedComp.equalsIgnoreCase("Hard Disk")) {
					chosenTag = hardTag;
				} else if (selectedComp.equalsIgnoreCase("Case")) {
					chosenTag = caseTag;
				} else if (selectedComp.equalsIgnoreCase("Motherboard")) {
					chosenTag = motherboardTag;
				}

				for (int i = 0; i < chosenTag.length; i++) {
					labels[i].setText(chosenTag[i]);
					labels[i].setVisible(true);
					texts[i].setVisible(true);
				}

				btnNewButton.setVisible(true);
			}
		});
	}
}
