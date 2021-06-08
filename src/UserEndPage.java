import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

public class UserEndPage extends JFrame {

	private JPanel contentPane;
	private int totalPrice;
	String list = "";
	String filePath = System.getProperty("user.home") + "/Desktop/choices.txt";;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserEndPage frame = new UserEndPage();
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
	public UserEndPage() {
		Stack<Object> components = ComponentSelection.userChoices;
		Stack<Object> tempS = ComponentSelection.tempChoices;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel total = new JLabel("Total Price:");
		total.setFont(new Font("Tahoma", Font.PLAIN, 17));
		total.setBounds(22, 346, 213, 31);
		totalPrice = 1000;
		contentPane.add(total);
		
		Color customColor = new Color(238,238,238);
		JTextArea selectedComp = new JTextArea();
		selectedComp.setBackground(customColor);
		selectedComp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		selectedComp.setEditable(false);
		
		
		while(!components.isEmpty()) {
			tempS.push(components.pop());
		}
		
		Processor comp1 = (Processor) tempS.pop();
		list += comp1.toString() + "\n";
		totalPrice += comp1.getPrice();
		components.push(comp1);
		
		MotherBoard comp2 = (MotherBoard) tempS.pop();
		list += comp2.toString() + "\n";
		totalPrice += comp2.getPrice();
		components.push(comp2);
		
		HardDrive comp3 = (HardDrive) tempS.pop();
		list += comp3.toString() + "\n";
		totalPrice += comp3.getPrice();
		components.push(comp3);
		
		SolidState comp4 = (SolidState) tempS.pop();
		list += comp4.toString() + "\n";
		totalPrice += comp4.getPrice();
		components.push(comp4);
		
		Memory comp5 = (Memory) tempS.pop();
		list += comp5.toString() + "\n";
		totalPrice += comp5.getPrice();
		components.push(comp5);
		
		GraphicsCard comp6 = (GraphicsCard) tempS.pop();
		list += comp6.toString() + "\n";
		totalPrice += comp6.getPrice();
		components.push(comp6);
		
		Case comp7 = (Case) tempS.pop();
		list += comp7.toString() + "\n";
		totalPrice += comp7.getPrice();
		components.push(comp7);
		
		total.setText("Total Price: " + totalPrice + " tl");
		selectedComp.setText(list);
		selectedComp.setBounds(51, 28, 573, 236);
		contentPane.add(selectedComp);
		
		JButton gobackButton = new JButton("Go Back");
		gobackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		gobackButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		gobackButton.setBounds(369, 351, 113, 21);
		contentPane.add(gobackButton);
		
		JButton finishButton = new JButton("Finish");
		finishButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String data = list;
				 try {
				       // Creates a Writer using FileWriter
				       FileWriter output = new FileWriter(filePath);

				       // Writes string to the file
				       output.write(data);
				       System.out.println("Data is written to the file.");

				       // Closes the writer
				       output.close();
				     }
				     catch (Exception e1) {
				       e1.getStackTrace();
				     }
				 JOptionPane.showMessageDialog(contentPane, "Data is written to the file.", "Finish Info", JOptionPane.INFORMATION_MESSAGE);
				 System.exit(NORMAL);
			}
		});
		finishButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		finishButton.setBounds(511, 351, 113, 21);
		contentPane.add(finishButton);
		
	}
}
