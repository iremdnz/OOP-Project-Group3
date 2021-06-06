import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class ComponentSelection extends JFrame {

	private JPanel contentPane;
	private static Computer computer;

	/**
	 * Launch the application.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		computer = new Computer();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentSelection frame = new ComponentSelection();
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
	@SuppressWarnings("unchecked")
	public ComponentSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// System.out.println(computer.getDatabase().toString());

		@SuppressWarnings("unchecked")
		JComboBox dropList1 = new JComboBox(computer.getDatabase().get("processor").toArray());
		dropList1.setBounds(134, 45, 225, 21);
		contentPane.add(dropList1);

		@SuppressWarnings("unchecked")
		JComboBox dropList2 = new JComboBox(computer.getDatabase().get("motherboard").toArray());
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

		for (Object element : computer.getDatabase().get("storage").toArray()) {

			Storage storageElement = (Storage) element;
			if (storageElement.getReadSpeed() != 150) {
				dropList4.addItem(storageElement);
			} else {
				dropList3.addItem(storageElement);
			}
		}

		@SuppressWarnings("unchecked")
		JComboBox dropList5 = new JComboBox(computer.getDatabase().get("memory").toArray());
		dropList5.setBounds(134, 245, 225, 21);
		contentPane.add(dropList5);

		@SuppressWarnings("unchecked")
		JComboBox dropList6 = new JComboBox(computer.getDatabase().get("graphics_card").toArray());
		dropList6.setBounds(134, 295, 225, 21);
		contentPane.add(dropList6);

		@SuppressWarnings("unchecked")
		JComboBox dropList7 = new JComboBox(computer.getDatabase().get("case").toArray());
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
	}
}
