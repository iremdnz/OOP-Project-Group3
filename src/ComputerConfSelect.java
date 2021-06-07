import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComputerConfSelect extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application. (DELETE LATER ON)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComputerConfSelect frame = new ComputerConfSelect();
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
	public ComputerConfSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pcConfMessage = new JLabel("How is this PC mainly going to be used?");
		pcConfMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		pcConfMessage.setHorizontalAlignment(SwingConstants.CENTER);
		pcConfMessage.setBounds(6, 41, 688, 77);
		contentPane.add(pcConfMessage);
		
		JButton dailyPCButton = new JButton("Daily");
		dailyPCButton.setToolTipText("A daily PC is more suitable for watching videos, browsing web, listening to music etc.");
		dailyPCButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		dailyPCButton.setBounds(48, 214, 155, 50);
		contentPane.add(dailyPCButton);
		
		JButton gamingPCButton = new JButton("Gaming");
		gamingPCButton.setToolTipText("A powerful equipment is always the key for the best gaming experience");
		gamingPCButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		gamingPCButton.setBounds(269, 214, 155, 50);
		contentPane.add(gamingPCButton);
		
		JButton productivityPCButton = new JButton("Productivity");
		productivityPCButton.setToolTipText("Use this option if PC is going to be used by a developer, content creator, video editor and in more professional areas");
		productivityPCButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		productivityPCButton.setBounds(487, 214, 155, 50);
		contentPane.add(productivityPCButton);
		
		JButton btnNewButton = new JButton("Custom");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ComponentSelection compSel = new ComponentSelection();
				compSel.setVisible(true);
			}
		});
		btnNewButton.setToolTipText("Use this selection to configure your PC freely, with all available parts.");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton.setBounds(269, 324, 155, 50);
		contentPane.add(btnNewButton);
	}
}
