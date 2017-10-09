package Petrol;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.sql.*;
import com.mysql.*;

public class Emp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emp frame = new Emp();
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
	public Emp() {
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
		
		JLabel lblEmploye = new JLabel("Employe : ");
		lblEmploye.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblEmploye.setBounds(10, 46, 86, 17);
		contentPane.add(lblEmploye);
		
		JLabel label = new JLabel("1");
		label.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(83, 47, 46, 14);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblName.setBounds(20, 74, 55, 14);
		contentPane.add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblType.setBounds(123, 74, 46, 14);
		contentPane.add(lblType);
		
		JLabel lblNetAmount = new JLabel("Net Litres");
		lblNetAmount.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblNetAmount.setBounds(213, 74, 92, 14);
		contentPane.add(lblNetAmount);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblPrice.setBounds(332, 74, 55, 14);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(113, 99, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 99, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 99, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(317, 99, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		Scanner scn = new Scanner(System.in);
		String type = textField.getText();
		String name = textField_1.getText();
		String netl = textField_2.getText();
		String Price = textField_3.getText();
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(name);
				try{
					String x=textField_1.getText();
					String y=textField.getText();
					String z=textField_2.getText();
					String z1=textField_3.getText();
					String z2=textField_4.getText();
					//String fin=((z2)*60);
					//String fz=textField_3.setText(fin);
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/p?useSSL=false","root","shan123");
					Statement stmt = con.createStatement();
					
					String sql = ("INSERT INTO emp (name,type,netlitres,rate,price) VALUES ('"+x+"','"+y+"','"+z+"','"+z2+"','"+z1+"')");
					stmt.executeUpdate(sql);
					con.close();
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(98, 157, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(213, 157, 89, 23);
		contentPane.add(btnPrint);
		btnPrint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String z2=textField_4.getText();
				//String fin=((z2)*60);
				//String fz=textField_3.setText(fin);
				
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new CloseListner() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 14));
		btnLogout.setBounds(332, 40, 89, 23);
		contentPane.add(btnLogout);
		
		JLabel lblTodaysRate = new JLabel("Todays Rate : ");
		lblTodaysRate.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 16));
		lblTodaysRate.setBounds(213, 233, 92, 17);
		contentPane.add(lblTodaysRate);
		
		textField_4 = new JTextField();
		textField_4.setBounds(317, 231, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
