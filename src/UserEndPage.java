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

	public UserEndPage() {
		setResizable(false);
		Stack<Object> components = ComponentSelection.userChoices;
		Stack<Object> tempS = ComponentSelection.tempChoices;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel total = new JLabel("Total Price:");
		total.setFont(new Font("Tahoma", Font.PLAIN, 17));
		total.setBounds(63, 346, 213, 31);
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
		list += "1. " + comp1.toString() + "\n";
		totalPrice += comp1.getPrice();
		components.push(comp1);
		
		MotherBoard comp2 = (MotherBoard) tempS.pop();
		list += "2. " + comp2.toString() + "\n";
		totalPrice += comp2.getPrice();
		components.push(comp2);
		
		HardDrive comp3 = (HardDrive) tempS.pop();
		list += "3. " + comp3.toString() + "\n";
		totalPrice += comp3.getPrice();
		components.push(comp3);
		
		SolidState comp4 = (SolidState) tempS.pop();
		list += "4. " + comp4.toString() + "\n";
		totalPrice += comp4.getPrice();
		components.push(comp4);
		
		Memory comp5 = (Memory) tempS.pop();
		list += "5. " + comp5.toString() + "\n";
		totalPrice += comp5.getPrice();
		components.push(comp5);
		
		GraphicsCard comp6 = (GraphicsCard) tempS.pop();
		list += "6. " + comp6.toString() + "\n";
		totalPrice += comp6.getPrice();
		components.push(comp6);
		
		Case comp7 = (Case) tempS.pop();
		list += "7. " + comp7.toString() + "\n";
		totalPrice += comp7.getPrice();
		components.push(comp7);
		
		total.setText("Total Price: " + totalPrice + " TL");
		selectedComp.setText(list);
		selectedComp.setBounds(63, 80, 573, 236);
		contentPane.add(selectedComp);
		
		JButton gobackButton = new JButton("Go Back");
		gobackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		gobackButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		gobackButton.setBounds(374, 352, 113, 21);
		contentPane.add(gobackButton);
		
		JButton finishButton = new JButton("Finish");
		finishButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String data = list;
				 try {
				       FileWriter output = new FileWriter(filePath);
				       output.write(data);     
				       output.close();
				     }
				     catch (Exception e1) {
				       e1.getStackTrace();
				     }
				 JOptionPane.showMessageDialog(contentPane, "The selected components has been written in a .txt file on your desktop.\nThanks for using our program!", "Finish Info", JOptionPane.INFORMATION_MESSAGE);
				 System.exit(NORMAL);
			}
		});
		finishButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		finishButton.setBounds(523, 352, 113, 21);
		contentPane.add(finishButton);
		
		JLabel finishLabel = new JLabel("");
		finishLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		finishLabel.setBounds(63, 19, 573, 49);
		finishLabel.setText("Here're components you've chosen, " + User.getUserName());
		contentPane.add(finishLabel);
		
	}
}
