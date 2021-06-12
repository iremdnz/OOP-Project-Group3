import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCompFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;
	private static String[] chosenTag;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCompFrame frame = new AddCompFrame();
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
	public AddCompFrame() {
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Component Type: ");
		lblNewLabel.setBounds(24, 19, 150, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
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
		
		JLabel[] labels = {label1,label2,label3,label4,label5,label6,label7,label8,label9,label10}; 
		JTextField[] texts = {text1,text2,text3,text4,text5,text6,text7,text8,text9,text10};

		Computer computerDB = new Computer();
		
		for (String entry : computerDB.getDatabase().keySet()) {
			String key = entry;
			if(key.equals("storage")) {
				comboBox.addItem("solid_state");
				comboBox.addItem("hard_disk");
			}
			else {
				comboBox.addItem(key);
			}
		}
		
		String[] gpuTag = { "Brand", "Model", "Vendor", "Capacity", "Price", "Usage" };
		String[] memoryTag = { "Brand", "Model", "Type", "Speed", "Capacity", "Latency", "Price", "Usage" };
		String[] motherboardTag = { "Brand", "Model", "Chipset", "Socket", "Form Factor", "M.2", "PCIE", "Price", "Usage" };
		String[] solidTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage", "Type", "Cooling S." };
		String[] hardTag = { "Brand", "Model", "Read Speed", "Write Speed", "Price", "Usage", "Spin" };
		String[] processorTag = { "Brand", "Model", "Core", "Thread", "Socket", "Clockspeed", "TDP", "Unlocked", "Price", "Usage" };
		String[] caseTag = { "Brand", "Model", "PSU", "Price", "Usage" };
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				for(int i = 0; i < 10; i++) {
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
				} else if (selectedComp.equalsIgnoreCase("solid_state")) {
					chosenTag = solidTag;
				} else if (selectedComp.equalsIgnoreCase("hard_disk")) {
					chosenTag = hardTag;
				} else if (selectedComp.equalsIgnoreCase("case")) {
					chosenTag = caseTag;
				} else if (selectedComp.equalsIgnoreCase("motherboard")) {
					chosenTag = motherboardTag;
				}
				
				for(int i = 0; i < chosenTag.length; i++) {
					labels[i].setText(chosenTag[i]);
					labels[i].setVisible(true);
					texts[i].setVisible(true);
				}
				
			}
		});
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean isValid = true;
				
				for(int i = 0; i < 10; i++) {
					if(labels[i].isVisible() == true && texts[i].getText().equals("")) {
						JOptionPane.showMessageDialog(contentPane, "All specifiations must be filled" , "Warning", JOptionPane.WARNING_MESSAGE);
						break;
					}
					if(labels[i].getText().equals("Capacity") || labels[i].getText().equals("Price") || labels[i].getText().equals("Speed") ||
					labels[i].getText().equals("Latency") || labels[i].getText().equals("Read Speed") || labels[i].getText().equals("Write Speed") ||
					labels[i].getText().equals("Core") || labels[i].getText().equals("Thread") || labels[i].getText().equals("TDP") || labels[i].getText().equals("PSU")) {
						try {
							Integer.parseInt(texts[i].getText());
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type" , "Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
					}
					else if(labels[i].getText().equals("M.2") || labels[i].getText().equals("Unlocked")) {
						if(!(texts[i].getText().equalsIgnoreCase("true") || texts[i].getText().equalsIgnoreCase("false"))) {
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type" , "Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
	
					}
					else if(labels[i].getText().equals("PCIE") || labels[i].getText().equals("Clockspeed")) {
						try {
							Double.parseDouble(texts[i].getText());
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type" , "Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
					}
					else { //sadece string direkt int yapýlamamalý
						try {
							Integer.parseInt(texts[i].getText());
							JOptionPane.showMessageDialog(contentPane, "Please enter specifiations in correct type" , "Warning", JOptionPane.WARNING_MESSAGE);
							isValid = false;
							break;
						}
						catch(Exception e1) {
							//do nothing
						}
					}
				}
				
				String selectedComp = String.valueOf(comboBox.getSelectedItem());
				
				if(isValid == true) {
					if (selectedComp.equalsIgnoreCase("graphics_card")) {
						GraphicsCard gpu = new GraphicsCard(texts[0].getText(),texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText(),texts[5].getText());
						computerDB.getDatabase().get("graphics_card").add(gpu);
					} else if (selectedComp.equalsIgnoreCase("memory")) {
						Memory memory = new Memory(texts[0].getText(),texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText(),texts[5].getText(),texts[6].getText(),texts[7].getText());
						computerDB.getDatabase().get("memory").add(memory);
					} else if (selectedComp.equalsIgnoreCase("processor")) {
						Processor processor = new Processor(texts[0].getText(),texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText(),texts[5].getText(),
						texts[6].getText(),texts[7].getText(),texts[8].getText(),texts[9].getText());
						computerDB.getDatabase().get("processor").add(processor);
					} else if (selectedComp.equalsIgnoreCase("solid_state")) {
						SolidState solidState = new SolidState(texts[0].getText(),texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText(),texts[5].getText(),texts[6].getText(),texts[7].getText(),texts[8].getText());
						computerDB.getDatabase().get("storage").add(solidState);
					} else if (selectedComp.equalsIgnoreCase("hard_disk")) {
						HardDrive hardDrive = new HardDrive(texts[0].getText(),texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText(),texts[5].getText(),texts[6].getText(),texts[7].getText());
						computerDB.getDatabase().get("storage").add(hardDrive);
					} else if (selectedComp.equalsIgnoreCase("case")) {
						Case casee = new Case(texts[0].getText(),texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText());
						computerDB.getDatabase().get("case").add(casee);
					} else if (selectedComp.equalsIgnoreCase("motherboard")) {
						MotherBoard motherboard = new MotherBoard(texts[0].getText(),texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText(),texts[5].getText(),texts[6].getText(),texts[7].getText(),texts[8].getText());
						computerDB.getDatabase().get("motherboard").add(motherboard);
					}
				}
			}
		});
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(535, 359, 89, 26);
		contentPane.add(btnNewButton);
		text10.setVisible(false);
		
	}
}
