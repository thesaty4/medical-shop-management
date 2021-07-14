package medical_shop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

/**
 * @Author Satya Narayan Mishra
 */

public class login extends JFrame implements ActionListener{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new login().setVisible(true);
	}

	/**
	 * Create the application. and run application from here
	 */
	private JTextField userFeild;
	private JButton login,btnCancel;
	private JPasswordField passwordField;
	public login() {
		setBounds(500,200,500,300);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		
		//title setting
		JLabel title = new JLabel("Medical Shop Login");
		title.setBounds(0, 22, 484, 24);
		title.setForeground(new Color(128, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		getContentPane().add(title);
		
//		labels setting
		JLabel usrIdLabel = new JLabel("User Name :");
		usrIdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		usrIdLabel.setBounds(72, 91, 97, 24);
		getContentPane().add(usrIdLabel);
		
		JLabel passwdLabel = new JLabel("Password :");
		passwdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwdLabel.setBounds(72, 135, 82, 24);
		getContentPane().add(passwdLabel);
		
		//text field setting
		userFeild = new JTextField();
		userFeild.setBounds(189, 95, 203, 20);
		getContentPane().add(userFeild);
		userFeild.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 139, 203, 20);
		getContentPane().add(passwordField);
		
		login = new JButton("Login");
		login.setForeground(Color.BLUE);
		login.setFont(new Font("Tahoma", Font.BOLD, 12));
		login.setBounds(92, 206, 129, 24);
		getContentPane().add(login);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(282, 206, 129, 24);
		getContentPane().add(btnCancel);
		
		login.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			String usrname=userFeild.getText();
			String passwd=passwordField.getText();
			if(usrname.isEmpty() || passwd.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Opps ! all field required....");
			}else {
				dbConnection conn=new dbConnection();
				String sql="select * from `login_info` where `usr_name`='"+usrname+"' and `passwd`='"+passwd+"'";
				try {
					ResultSet data=conn.stm.executeQuery(sql);
					if(data.next()) {
						this.setVisible(false);
						new home().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Opps ! invalid login", "Wrong User or Password", JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}else if(e.getSource().equals(btnCancel)) {
			this.setVisible(false);
			new MainPage().setVisible(true);
		}
	}
}
