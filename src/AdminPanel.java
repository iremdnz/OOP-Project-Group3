import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	public static Computer computerDB;

	public AdminPanel() {
		setResizable(false);
		computerDB = new Computer();
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMINISTRATOR OPERATIONS MANAGER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(31, 27, 637, 68);
		contentPane.add(lblNewLabel);

		JButton addComponentButton = new JButton("Add Component");
		addComponentButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addComponentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCompFrame addComp = new AddCompFrame();
				addComp.setVisible(true);
			}
		});
		addComponentButton.setBounds(185, 158, 330, 35);
		contentPane.add(addComponentButton);

		JButton removeComponentButton = new JButton("Remove Component");
		removeComponentButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		removeComponentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteCompFrame deleteComp = new DeleteCompFrame();
				deleteComp.setVisible(true);
			}
		});
		removeComponentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		removeComponentButton.setBounds(185, 208, 330, 35);
		contentPane.add(removeComponentButton);

		JButton editComponentButton = new JButton("Edit Component");
		editComponentButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		editComponentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditCompFrame editComp = new EditCompFrame();
				editComp.setVisible(true);
			}
		});

		editComponentButton.setBounds(185, 258, 330, 35);
		contentPane.add(editComponentButton);

		JButton listComponentButton = new JButton("List Components");
		listComponentButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		listComponentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListCompFrame listFrame = new ListCompFrame();
				listFrame.setVisible(true);
			}
		});
		listComponentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		listComponentButton.setBounds(185, 308, 330, 35);
		contentPane.add(listComponentButton);
	}
}
