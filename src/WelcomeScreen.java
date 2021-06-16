import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
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
	public WelcomeScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeMsg1 = new JLabel("Welcome to PC Builder");
		welcomeMsg1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		welcomeMsg1.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMsg1.setBounds(181, 33, 317, 50);
		contentPane.add(welcomeMsg1);
		
		JRadioButton userRadioButton = new JRadioButton("USER");

		userRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userRadioButton.setBounds(181, 142, 109, 23);
		contentPane.add(userRadioButton);
		
		JRadioButton adminRadioButton = new JRadioButton("ADMIN");

		adminRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		adminRadioButton.setBounds(389, 142, 109, 23);
		contentPane.add(adminRadioButton);
		
		ButtonGroup userSelGroup = new ButtonGroup();
		userSelGroup.add(userRadioButton);
		userSelGroup.add(adminRadioButton);

		JLabel userNameLabel = new JLabel("Username:");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userNameLabel.setBounds(181, 200, 81, 32);
		contentPane.add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(272, 209, 226, 20);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLabel.setBounds(181, 267, 81, 14);
		contentPane.add(passwordLabel);
		passwordLabel.setVisible(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(272, 267, 226, 20);
		contentPane.add(passwordField);
		passwordField.setVisible(false);
		
		JLabel userNameWarning = new JLabel("Please make sure to enter a username!");
		userNameWarning.setForeground(Color.RED);
		userNameWarning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userNameWarning.setBounds(272, 240, 226, 14);
		userNameWarning.setVisible(false);
		contentPane.add(userNameWarning);
		
		JLabel passwordWarning = new JLabel("Please make sure to enter a password!");
		passwordWarning.setForeground(Color.RED);
		passwordWarning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordWarning.setBounds(272, 298, 226, 14);
		passwordWarning.setVisible(false);
		contentPane.add(passwordWarning);
		
		userRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (userRadioButton.isSelected()) {
					passwordLabel.setVisible(false);
					passwordField.setVisible(false);
					passwordField.setText(null);
					passwordWarning.setVisible(false);
				}
			}
		});
		
		adminRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (adminRadioButton.isSelected()) {
					passwordLabel.setVisible(true);
					passwordField.setVisible(true);
				}
			}
		});
		
		JButton startButton = new JButton("LOGIN");
		startButton.setBounds(280, 342, 109, 39);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = userNameTextField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				if (userName.equals("")) {
					userNameWarning.setVisible(true);
				}
				else {
					userNameWarning.setVisible(false);
				}
				
				if (adminRadioButton.isSelected()) {
					if (password.equals("")) {
						passwordWarning.setVisible(true);
					}
					else {
						passwordWarning.setVisible(false);
					}
				}
				
				if (!userName.equals("") && userRadioButton.isSelected()) {
					User mainUser = new User(userName);
					String message = "Login successfull! Let's start, " + mainUser.getUserName() + ".";
					JOptionPane.showMessageDialog(contentPane, message, "Login Info", JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					ComputerConfSelect configure = new ComputerConfSelect();
					configure.setVisible(true);
				}
				
				if (!userName.equals("") && !password.equals("") && adminRadioButton.isSelected()) {
					if(!userName.equals(User.adminName) || !password.equals(User.adminPassword)) {
						JOptionPane.showMessageDialog(contentPane, "Please enter your inputs correctly" , "Warning", JOptionPane.WARNING_MESSAGE);
					}
					else {
						User.userType = "admin";
						//String message = "Username: " + userName + "\nPassword: " + password;
						JOptionPane.showMessageDialog(contentPane, "Authorized! Switching to Admin Panel", "Login Info", JOptionPane.INFORMATION_MESSAGE);
					
						dispose();
						AdminPanel adminPanel = new AdminPanel();
						adminPanel.setVisible(true);
					}
					
				}
				if(!userRadioButton.isSelected() && !adminRadioButton.isSelected()) {
					JOptionPane.showMessageDialog(contentPane, "Please select your user type!" , "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		contentPane.add(startButton);
		

	}
}
