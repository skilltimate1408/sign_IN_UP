package Sign_Inandign_up;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField ps1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SignUP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(207, 35, 171, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSetUsername = new JLabel("Set Username");
		lblSetUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSetUsername.setBounds(30, 129, 233, 53);
		frame.getContentPane().add(lblSetUsername);
		
		JLabel lblSetPassword = new JLabel("Set Password");
		lblSetPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSetPassword.setBounds(30, 257, 233, 53);
		frame.getContentPane().add(lblSetPassword);
		
		tb1 = new JTextField();
		tb1.setBounds(325, 129, 215, 44);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		ps1 = new JPasswordField();
		ps1.setBounds(334, 257, 205, 53);
		frame.getContentPane().add(ps1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un=tb1.getText();
				String ps=ps1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","Welcome@123");
					String q="insert into sign_up values('"+un+"','"+ps+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Done!");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(219, 389, 123, 44);
		frame.getContentPane().add(btnNewButton);
	}
}
