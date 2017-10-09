package Petrol;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Supplier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier frame = new Supplier();
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
	public Supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaiPetrolium = new JLabel("Sai Petrolium");
		lblSaiPetrolium.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 22));
		lblSaiPetrolium.setBounds(157, 0, 138, 42);
		contentPane.add(lblSaiPetrolium);
		
		JLabel lblSupplier = new JLabel("Supplier : ");
		lblSupplier.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblSupplier.setBounds(10, 42, 87, 26);
		contentPane.add(lblSupplier);
		
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
		
		JLabel lblOutlet = new JLabel("Inlet");
		lblOutlet.setBounds(210, 110, 65, 26);
		contentPane.add(lblOutlet);
		
		JLabel lblRemaining = new JLabel("New Value ");
		lblRemaining.setBounds(305, 110, 65, 26);
		contentPane.add(lblRemaining);
		
		/*JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 14));
		btnLogout.setBounds(335, 44, 89, 23);
		contentPane.add(btnLogout);*/
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new CloseListner() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 14));
		btnLogout.setBounds(332, 40, 89, 23);
		contentPane.add(btnLogout);
		
		JLabel lblAdd = new JLabel("Add : ");
		lblAdd.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblAdd.setBounds(10, 159, 72, 17);
		contentPane.add(lblAdd);
		
		textField = new JTextField();
		textField.setBounds(183, 157, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblL = new JLabel("30 L");
		lblL.setBounds(120, 160, 46, 14);
		contentPane.add(lblL);
		
		txtL = new JTextField();
		//txtL.setText("30 L");
		txtL.setBounds(284, 157, 86, 20);
		contentPane.add(txtL);
		txtL.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		btnSubmit.setBounds(171, 210, 89, 23);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					
					int x=30;
					String y=textField.getText();
					//int z=txtL.getText();
					String z=txtL.getText();
					//txtL.setText(y);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/p?useSSL=false","root","shan123");
					Statement stmt = con.createStatement();
					
					String sql = ("INSERT INTO supp (capacity,inlet,new_value) VALUES ('"+x+"','"+y+"','"+z+"')");
					stmt.executeUpdate(sql);
					con.close();
				}catch(Exception e1){
					System.out.println(e1);
				}
				
			}
		});
	}
}
