import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ComponentSelection extends JFrame {

	private JPanel contentPane;
	// private static Computer computer;
	public static Stack<Object> userChoices, tempChoices;
	private int totalTdp = 0, gpuTdp = 0, cpuTdp = 0, caseTdp = 0;
	private boolean gpuFlag = false, cpuFlag = false, caseFlag = false;
	private MotherBoard mBoard = null;
	
	
	@SuppressWarnings("unchecked")
	public ComponentSelection() {
		setResizable(false);
		userChoices = new Stack<>();
		tempChoices = new Stack<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// System.out.println(computer.getDatabase().toString());

		@SuppressWarnings("unchecked")
		JComboBox dropList1 = new JComboBox(ComputerConfSelect.computer.getDatabase().get("Processor").toArray());

		dropList1.setSelectedIndex(-1);
		dropList1.setBounds(134, 45, 225, 21);
		contentPane.add(dropList1);

		@SuppressWarnings("unchecked")
		JComboBox dropList2 = new JComboBox(ComputerConfSelect.computer.getDatabase().get("Motherboard").toArray());
		dropList2.setSelectedIndex(-1);
		dropList2.setBounds(134, 95, 225, 21);
		contentPane.add(dropList2);

		@SuppressWarnings("unchecked")
		JComboBox dropList3 = new JComboBox();
		dropList3.setBounds(134, 145, 225, 21);

		contentPane.add(dropList3);

		@SuppressWarnings("unchecked")
		JComboBox dropList4 = new JComboBox();
		dropList4.setBounds(134, 195, 225, 21);
		contentPane.add(dropList4);

		for (Object element : ComputerConfSelect.computer.getDatabase().get("Storage").toArray()) {

			Storage storageElement = (Storage) element;
			if (storageElement.getReadSpeed() != 150) {
				dropList4.addItem(storageElement);
			} else {
				dropList3.addItem(storageElement);
			}
		}

		dropList3.setSelectedIndex(-1);
		dropList4.setSelectedIndex(-1);

		@SuppressWarnings("unchecked")
		JComboBox dropList5 = new JComboBox(ComputerConfSelect.computer.getDatabase().get("Memory").toArray());
		dropList5.setSelectedIndex(-1);
		dropList5.setBounds(134, 245, 225, 21);
		contentPane.add(dropList5);

		@SuppressWarnings("unchecked")
		JComboBox dropList6 = new JComboBox(ComputerConfSelect.computer.getDatabase().get("Graphics Card").toArray());
		dropList6.setSelectedIndex(-1);
		dropList6.setBounds(134, 295, 225, 21);
		contentPane.add(dropList6);

		@SuppressWarnings("unchecked")
		JComboBox dropList7 = new JComboBox(ComputerConfSelect.computer.getDatabase().get("Case").toArray());
		dropList7.setSelectedIndex(-1);
		dropList7.setBounds(134, 345, 225, 21);
		contentPane.add(dropList7);

		JLabel procLabel = new JLabel("Processor");
		procLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		procLabel.setBounds(20, 45, 93, 21);
		contentPane.add(procLabel);

		JLabel motherLabel = new JLabel("Motherboard");
		motherLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		motherLabel.setBounds(20, 95, 104, 21);
		contentPane.add(motherLabel);

		JLabel hardDLabel = new JLabel("Hard Drive");
		hardDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hardDLabel.setBounds(20, 145, 93, 21);
		contentPane.add(hardDLabel);

		JLabel solidSLabel = new JLabel("Solid State");
		solidSLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		solidSLabel.setBounds(20, 195, 93, 21);
		contentPane.add(solidSLabel);

		JLabel memoryLabel = new JLabel("Memory");
		memoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memoryLabel.setBounds(20, 245, 93, 21);
		contentPane.add(memoryLabel);

		JLabel gpuLabel = new JLabel("GPU");
		gpuLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gpuLabel.setBounds(20, 295, 93, 21);
		contentPane.add(gpuLabel);

		JLabel caseLabel = new JLabel("Case");
		caseLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		caseLabel.setBounds(20, 345, 93, 21);
		contentPane.add(caseLabel);

		JLabel compIcon = new JLabel("COMPONENT ICON");
		compIcon.setHorizontalAlignment(SwingConstants.CENTER);
		compIcon.setBounds(442, 24, 135, 135);
		contentPane.add(compIcon);

		Color customColor = new Color(238, 238, 238);
		JTextArea compInformation = new JTextArea();
		compInformation.setBackground(customColor);
		compInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		compInformation.setEditable(false);
		compInformation.setVisible(false);
		compInformation.setBounds(381, 174, 304, 170);
		contentPane.add(compInformation);

		dropList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				compInformation.setVisible(true);

				Processor cpu = (Processor) dropList1.getSelectedItem();

				while (!userChoices.isEmpty()) {
					tempChoices.push(userChoices.pop());
				}

				if (!tempChoices.isEmpty()) {
					Object tempElement = tempChoices.pop();
					try {
						Processor tempCpu = (Processor) tempElement;
						tempCpu = null;
					} catch (Exception e) {
						tempChoices.push(tempElement);
					}
				}
				
				if((mBoard != null && mBoard.getSocket().equals(cpu.getSocket())) || mBoard == null) {
					userChoices.push(cpu);
					if (cpuFlag == true) {
						totalTdp -= cpuTdp;
					}
					cpuFlag = true;
					cpuTdp = cpu.getTdp();
					totalTdp += cpuTdp;
				
					if (caseTdp < totalTdp && gpuFlag == true && cpuFlag == true && caseFlag == true) {
						totalTdp -= cpuTdp;
						userChoices.pop();
						while (!tempChoices.isEmpty()) {
							userChoices.push(tempChoices.pop());
						}
			
						cpuFlag = false;
						JOptionPane.showMessageDialog(contentPane, "Case's PSU is not enough!", "Warning",
								JOptionPane.WARNING_MESSAGE);
						dropList1.setSelectedIndex(-1);
						compInformation.setVisible(false);
					} else {
						while (!tempChoices.isEmpty()) {
							userChoices.push(tempChoices.pop());
						}

					

						String isUnlocked = cpu.isUnlocked() ? "Yes" : "No";
						String socket = cpu.getBrand().equals("AMD") ? cpu.getSocket() : "LGA" + cpu.getSocket();
						String information = "Brand: " + cpu.getBrand() + "\nModel: " + cpu.getModel() + "\nCores/Threads: "
								+ cpu.getCore() + "/" + cpu.getThread() + "\nSocket Type: " + socket + "\nClock Speed: "
								+ cpu.getClockSpeed() + " GHz" + "\nTDP: " + cpu.getTdp() + " Watt" + "\nUnlocked: "
								+ isUnlocked + "\nPrice (Avg.): " + cpu.getPrice() + " TL";
						compInformation.setText(information);

					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane,
							"Selected processor is incompatible with motherboard!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					dropList1.setSelectedIndex(-1);
					compInformation.setVisible(false);
				}
			}
		});

		dropList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				compInformation.setVisible(true);

				MotherBoard mb = (MotherBoard) dropList2.getSelectedItem();

				if (userChoices.size() < 1) {
					JOptionPane.showMessageDialog(contentPane, "Please select previous components first!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					dropList2.setSelectedIndex(-1);
					compInformation.setVisible(false);
				}

				else {
					while (userChoices.size() != 1) {
						tempChoices.push(userChoices.pop());
					}

					if (!tempChoices.isEmpty()) {
						Object tempElement = tempChoices.pop();
						try {
							MotherBoard tempMb = (MotherBoard) tempElement;
							tempMb = null;
						} catch (Exception e) {
							tempChoices.push(tempElement);
						}
					}

					if (mb.getSocket().equals(((Processor) userChoices.peek()).getSocket())) {
						userChoices.push(mb);
						mBoard = mb;
					} else {
						mBoard = null;
						JOptionPane.showMessageDialog(contentPane,
								"Selected motherboard is incompatible with processor!", "Warning",
								JOptionPane.WARNING_MESSAGE);
						dropList2.setSelectedIndex(-1);
						compInformation.setVisible(false);
					}
					
					while (!tempChoices.isEmpty()) {
						userChoices.push(tempChoices.pop());
					}

					String m2Support = mb.isM2Support() ? "Supported" : "Not Supported";
					String information = "Brand: " + mb.getBrand() + "\nModel: " + mb.getModel() + "\nChipset: "
							+ mb.getChipset() + "\nSocket: " + mb.getSocket() + "\nForm Factor: " + mb.getFormFactor()
							+ "\nM.2 SSD Support: " + m2Support + "\nPCIe Standart: " + mb.getPcieVersion()
							+ "\nPrice (Avg.): " + mb.getPrice() + " TL";
					compInformation.setText(information);

				}
			}
		});

		dropList3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				compInformation.setVisible(true);

				HardDrive disk = (HardDrive) dropList3.getSelectedItem();

				if (userChoices.size() < 2) {
					JOptionPane.showMessageDialog(contentPane, "Please select previous components first!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					dropList3.setSelectedIndex(-1);
					compInformation.setVisible(false);
				}

				else {
					while (userChoices.size() != 2) {
						tempChoices.push(userChoices.pop());
					}

					if (!tempChoices.isEmpty()) {
						tempChoices.pop();
					}

					userChoices.push(disk);

					while (!tempChoices.isEmpty()) {
						userChoices.push(tempChoices.pop());
					}

					String capacity = disk.getCapacity() >= 1000 ? (disk.getCapacity() / 1000) + " TB"
							: disk.getCapacity() + " GB";
					String information = "Brand: " + disk.getBrand() + "\nModel: " + disk.getModel() + "\nCapacity: "
							+ capacity + "\nR/W Speeds: " + disk.getReadSpeed() + "/" + disk.getWriteSpeed() + " MB/s"
							+ "\nSpin: " + disk.getSpin() + "\nPrice (Avg.): " + disk.getPrice() + " TL";

					compInformation.setText(information);
				}
			}
		});

		dropList4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				compInformation.setVisible(true);

				SolidState disk = (SolidState) dropList4.getSelectedItem();

				if (userChoices.size() < 3) {
					JOptionPane.showMessageDialog(contentPane, "Please select previous components first!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					dropList4.setSelectedIndex(-1);
					compInformation.setVisible(false);
				}

				else {
					while (userChoices.size() != 3) {
						tempChoices.push(userChoices.pop());
					}

					if (!tempChoices.isEmpty()) {
						tempChoices.pop();
					}

					userChoices.push(disk);

					while (!tempChoices.isEmpty()) {
						userChoices.push(tempChoices.pop());
					}

					String coolingSys = disk.isHasCoolingSys() ? "Included" : "Not Included";
					String capacity = disk.getCapacity() >= 1000 ? (disk.getCapacity() / 1000) + " TB"
							: disk.getCapacity() + " GB";
					String information = "Brand: " + disk.getBrand() + "\nModel: " + disk.getModel() + "\nCapacity: "
							+ capacity + "\nR/W Speeds: " + disk.getReadSpeed() + "/" + disk.getWriteSpeed() + " MB/s"
							+ "\nType: " + disk.getType() + "\nCooling System: " + coolingSys + "\nPrice (Avg.): "
							+ disk.getPrice() + "TL";

					compInformation.setText(information);
				}
			}
		});

		dropList5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				compInformation.setVisible(true);

				Memory memory = (Memory) dropList5.getSelectedItem();

				if (userChoices.size() < 4) {
					JOptionPane.showMessageDialog(contentPane, "Please select previous components first!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					dropList5.setSelectedIndex(-1);
					compInformation.setVisible(false);
				} else {
					while (userChoices.size() != 4) {
						tempChoices.push(userChoices.pop());
					}

					if (!tempChoices.isEmpty()) {
						tempChoices.pop();
					}

					userChoices.push(memory);

					while (!tempChoices.isEmpty()) {
						userChoices.push(tempChoices.pop());
					}

					String capacity = memory.getType().contains("DualKit") ? (memory.getCapacity() / 2) + "x2 GB"
							: memory.getType().contains("QuadKit") ? (memory.getCapacity() / 4) + "x4 GB"
									: memory.getCapacity() + " GB";
					String information = "Brand: " + memory.getBrand() + "\nModel: " + memory.getModel() + "\nSpeed: "
							+ memory.getSpeed() + " MHz" + "\nCapacity: " + capacity + "\nType: " + memory.getType()
							+ "\nLatency: CL" + memory.getLatency() + "\nPrice (Avg.): " + memory.getPrice() + " TL";
					compInformation.setText(information);
				}
			}
		});

		dropList6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				compInformation.setVisible(true);

				GraphicsCard gpu = (GraphicsCard) dropList6.getSelectedItem();

				if (userChoices.size() < 5) {
					JOptionPane.showMessageDialog(contentPane, "Please select previous components first!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					dropList6.setSelectedIndex(-1);
					compInformation.setVisible(false);
				}

				else {
					while (userChoices.size() != 5) {
						tempChoices.push(userChoices.pop());
					}

					if (!tempChoices.isEmpty()) {
						Object tempElement = tempChoices.pop();
						try {
							GraphicsCard tempGpu = (GraphicsCard) tempElement;
							tempGpu = null;
						} catch (Exception e) {
							tempChoices.push(tempElement);
						}
					}
					userChoices.push(gpu);

					if (gpuFlag == true) {
						totalTdp -= gpuTdp;
					}
					gpuFlag = true;
					gpuTdp = gpu.getTdp();
					totalTdp += gpuTdp;
					
					if (caseTdp < totalTdp && gpuFlag == true && cpuFlag == true && caseFlag == true) {
						totalTdp -= gpuTdp;
						userChoices.pop();
						while (!tempChoices.isEmpty()) {
							userChoices.push(tempChoices.pop());
						}
						
						gpuFlag = false;
						JOptionPane.showMessageDialog(contentPane, "Case's PSU is not enough!", "Warning",
								JOptionPane.WARNING_MESSAGE);
						dropList6.setSelectedIndex(-1);
						compInformation.setVisible(false);
					} else {

						while (!tempChoices.isEmpty()) {
							userChoices.push(tempChoices.pop());
						}

						String information = "Brand: " + gpu.getBrand() + "\nVendor: " + gpu.getVendor() + "\nModel: "
								+ gpu.getModel() + "\nVRAM Capacity: " + gpu.getCapacity() + " GB" + "\nTDP: "
								+ gpu.getTdp() + " Watt" + "\nPrice (Avg.): " + gpu.getPrice() + " TL";
						compInformation.setText(information);
					}

				}
			}
		});

		dropList7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				compInformation.setVisible(true);

				Case compCase = (Case) dropList7.getSelectedItem();

				if (userChoices.size() < 6) {
					JOptionPane.showMessageDialog(contentPane, "Please select previous components first!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					dropList7.setSelectedIndex(-1);
					compInformation.setVisible(false);
				}

				else {
					while (userChoices.size() != 6) {
						tempChoices.push(userChoices.pop());
					}

					if (!tempChoices.isEmpty()) {
						tempChoices.pop();
					}

					userChoices.push(compCase);
					caseFlag = true;
					caseTdp = compCase.getPsu();
					if (caseTdp < totalTdp) {
						userChoices.pop();
						caseFlag = false;
						while (!tempChoices.isEmpty()) {
							userChoices.push(tempChoices.pop());
						}
						System.out.println("Wrong case: " + userChoices.toString());
						JOptionPane.showMessageDialog(contentPane, "Case's PSU is not enough!", "Warning",
								JOptionPane.WARNING_MESSAGE);
						dropList7.setSelectedIndex(-1);
						compInformation.setVisible(false);
					} else {
						while (!tempChoices.isEmpty()) {
							userChoices.push(tempChoices.pop());
						}

						String information = "Brand: " + compCase.getBrand() + "\nModel: " + compCase.getModel()
								+ "\nPSU Unit: " + compCase.getPsu() + " Watt" + "\nPrice (Avg.): "
								+ compCase.getPrice() + " TL";
						compInformation.setText(information);
					}

				}
			}
		});

		JButton nextButton = new JButton("Next");
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (userChoices.size() != 7) {
					JOptionPane.showMessageDialog(contentPane, "Please select previous components first!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					UserEndPage end = new UserEndPage();
					end.setVisible(true);
				}
			}
		});
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nextButton.setBounds(490, 367, 85, 21);
		contentPane.add(nextButton);

	}
}
