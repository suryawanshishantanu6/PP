package Petrol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					//Dimensions d = new Dimensions();
					//d.setSize(1024,768);
					//frame.setSize(1376, 760);
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setContentPane(new JLabel(new ImageIcon("admin.png")));
		
		JLabel lblSaiPetrolium = new JLabel("Sai Petrolium");
		lblSaiPetrolium.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 22));
		lblSaiPetrolium.setBounds(157, 0, 138, 42);
		contentPane.add(lblSaiPetrolium);
		
		String[] nozzles = { "Nozzle 1", "Nozzle 2", "Nozzle 3", "Nozzle 4"};
		JComboBox comboBox = new JComboBox(nozzles);
		comboBox.setBounds(10, 110, 72, 26);
		contentPane.add(comboBox);
		//comboBox.addActionListener(this);
		
		/*public void actionPerformed(ActionEvent e) {
			JComboBox comboBox = (JComboBox)e.getSource()
		}*/
		
		JLabel lblSelectNozzle = new JLabel("Select Nozzle : ");
		lblSelectNozzle.setFont(new Font("Adobe Caslon Pro Bold", Font.ITALIC, 16));
		lblSelectNozzle.setBounds(10, 74, 100, 25);
		contentPane.add(lblSelectNozzle);
		
		JLabel lblNozzle = new JLabel("Nozzle 1");
		lblNozzle.setFont(new Font("Adobe Caslon Pro Bold", Font.ITALIC, 14));
		lblNozzle.setBounds(120, 77, 65, 20);
		contentPane.add(lblNozzle);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(120, 110, 65, 26);
		contentPane.add(lblCapacity);
		
		JLabel lblOutlet = new JLabel("Outlet");
		lblOutlet.setBounds(204, 110, 65, 26);
		contentPane.add(lblOutlet);
		
		JLabel lblRemaining = new JLabel("Remaining");
		lblRemaining.setBounds(283, 110, 65, 26);
		contentPane.add(lblRemaining);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblAdminPanel.setBounds(10, 43, 109, 20);
		contentPane.add(lblAdminPanel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new CloseListner() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 14));
		btnLogout.setBounds(335, 42, 89, 23);
		contentPane.add(btnLogout);
		
		textField = new JTextField();
		textField.setBounds(99, 147, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 147, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(268, 147, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(180, 198, 89, 23);
		contentPane.add(btnSubmit);
	}
}
