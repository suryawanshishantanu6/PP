package Petrol;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.sql.*;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private String myString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					//frame.getRootPane().setDefaultButton(btnSubmit);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public Login() {
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
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblUsername.setBounds(71, 77, 77, 17);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(71, 119, 77, 17);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 117, 86, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		myString = textField.getText();
		textField.setBounds(175, 75, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		//textField.setText(set.getString("Username"));
		//String s = textField.getText();
		//System.out.println(myString);
		//String s = myString.toString();
		
		//connectivity

		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		btnSubmit.setBounds(172, 172, 89, 23);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new CloseListner() {
			public void actionPerformed(ActionEvent e) {
				String getvalue = textField.getText();
				String getpass = passwordField.getText();
				String ser = "Supp";
				try{
					String x=textField.getText();
					String y=passwordField.getText();
					String z=textField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/p?useSSL=false","root","shan123");
					Statement stmt = con.createStatement();
					
					String sql = ("INSERT INTO login (username,password) VALUES ('"+x+"','"+y+"')");
					stmt.executeUpdate(sql);
					con.close();
				}catch(Exception e1){
					System.out.println(e1);
				}
				
				
				if(new String("Admin").equals(getvalue) && new String("Admin123").equals(getpass)){
				Admin ad = new Admin();
				ad.setVisible(true);
				dispose();
				System.out.println(getvalue);
				System.out.println(getpass);
				}
				
				else if(new String("Emp").equals(getvalue) && new String("Emp123").equals(getpass)) 
				{
					Emp ad = new Emp();
					ad.setVisible(true);
					dispose();
					System.out.println(getvalue);
					System.out.println(getpass);
				}
				
				else if((ser).equals(getvalue) && new String("Supp123").equals(getpass)) 
				{
					Supplier ad = new Supplier();
					ad.setVisible(true);
					dispose();
					System.out.println(getvalue);
					System.out.println(getpass);
					
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Enter Correct Credentilals...");
					
				}
			}
			
		});
	}
}
