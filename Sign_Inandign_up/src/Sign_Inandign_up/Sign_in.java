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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Sign_in {

	private JFrame frame;
	private JTextField tb2;
	private JPasswordField ps2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_in window = new Sign_in();
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
	public Sign_in() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SignIn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(183, 22, 163, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsername.setBounds(26, 138, 163, 44);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(26, 231, 163, 44);
		frame.getContentPane().add(lblPassword);
		
		tb2 = new JTextField();
		tb2.setBounds(282, 138, 199, 44);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		ps2 = new JPasswordField();
		ps2.setBounds(282, 231, 199, 38);
		frame.getContentPane().add(ps2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=tb2.getText();
				String p=ps2.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","Welcome@123");
					String q="select count(*) from sign_up where username=? and password=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1, u);
					ps.setString(2, p);
					ResultSet rs=ps.executeQuery();
					rs.next();
					int c=rs.getInt(1);
					if(c==0)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Invalid");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "Login Done!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(183, 341, 124, 33);
		frame.getContentPane().add(btnNewButton);
	}

}
