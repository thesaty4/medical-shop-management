package medical_shop;

/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Registration extends JFrame implements ActionListener{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}
	private JTextField userNameField,nameField,emailField,passField,confirmPassField;
	private JButton button;
	private JTextField mobileField;
	private JTextField addressField;
	private JRadioButton male,female;
	private JButton cancel;
	private void initialize() {
		setTitle("Registration Form");
		setBounds(100, 100, 450, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel usrNameLabel = new JLabel("User Name ");
		JLabel nameLabel = new JLabel("Name ");
		JLabel emailLabel = new JLabel("Email ");
		JLabel addressLabel = new JLabel("Address");
		JLabel lblMobileNo = new JLabel("Mobile No. ");
		JLabel passLabel = new JLabel("Password ");
		JLabel confirmPassLabel = new JLabel("Re-type Password ");
		
		userNameField = new JTextField();
		nameField = new JTextField();
		emailField = new JTextField();
		passField = new JTextField();
		confirmPassField = new JTextField();
		
		
		usrNameLabel.setBounds(63, 40, 72, 20);
		userNameField.setBounds(184, 40, 233, 20);
		
		nameLabel.setBounds(63, 80, 77, 20);
		nameField.setBounds(183, 80, 234, 20);
		
		emailLabel.setBounds(63, 159, 64, 20);
		emailField.setBounds(184, 159, 235, 20);
		
		passLabel.setBounds(62, 290, 66, 20);
		passField.setBounds(184, 290, 233, 20);
		
		confirmPassLabel.setBounds(63, 330, 108, 20);
		confirmPassField.setBounds(184, 330, 236, 20);
		
		
		lblMobileNo.setBounds(63, 248, 65, 20);
		getContentPane().add(lblMobileNo);
		mobileField = new JTextField();
		mobileField.setBounds(184, 248, 233, 20);
		getContentPane().add(mobileField);
		
		
		addressLabel.setBounds(63, 203, 65, 20);
		getContentPane().add(addressLabel);
		setBounds(450, 150, 500, 450);
		addressField = new JTextField();
		addressField.setBounds(184, 203, 233, 20);
		getContentPane().add(addressField);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setBounds(63, 121, 72, 20);
		getContentPane().add(genderLabel);
		
		ButtonGroup bg=new ButtonGroup();
		male = new JRadioButton("Male");
		male.setBounds(184, 120, 109, 23);
		getContentPane().add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(295, 120, 109, 23);
		getContentPane().add(female);
		bg.add(male);bg.add(female);
		
		button = new JButton("Ragister");
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(118, 376, 127 , 23);
		button.addActionListener(this);
		
		getContentPane().add(usrNameLabel);getContentPane().add(userNameField);
		getContentPane().add(nameLabel);getContentPane().add(nameField);		
		getContentPane().add(emailLabel);getContentPane().add(emailField);
		getContentPane().add(passLabel);getContentPane().add(passField);		
		getContentPane().add(confirmPassLabel);getContentPane().add(confirmPassField);
		
		getContentPane().add(button);
		getContentPane().setLayout(null);
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.RED);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancel.setBounds(256, 376, 127, 23);
		getContentPane().add(cancel);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button)) {
			String usrName = userNameField.getText();
			String name = nameField.getText();
			String email = emailField.getText();
			String address   = addressField.getText();
			String mobile= mobileField.getText();
			String pass = passField.getText();
			String confirmPass = confirmPassField.getText();
			String gender="";
			if(usrName.isEmpty() || name.isEmpty() || email.isEmpty() || address.isEmpty() || mobile.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "All Field required", "Warrning ", JOptionPane.WARNING_MESSAGE);
			}else{
				if(male.isSelected() || female.isSelected()) {
					if(!pass.equals(confirmPass)) {
						JOptionPane.showMessageDialog(null, "password should be same", "Warrning ", JOptionPane.WARNING_MESSAGE);
					}else {
						dbConnection conn=new dbConnection();
						String sql="select `usr_name` from `login_info` where `usr_name`='"+usrName+"'";
						try {
							ResultSet data=conn.stm.executeQuery(sql);
							if(data.next()) {						
								JOptionPane.showMessageDialog(null,"Opps ! this username already exits", "Warrning ", JOptionPane.WARNING_MESSAGE);
							}else {
								if(male.isSelected()) {
									gender="male";
								}else {
									gender="female";
								}
								String sql2="insert into `login_info` values ('"+usrName+"','"+name+"','"+gender+"','"+email+"','"+address+"','"+mobile+"','"+pass+"')";
								conn.stm.executeUpdate(sql2);
								JOptionPane.showMessageDialog(null, "Congrats ! you are register successfull..", "Registerd", JOptionPane.PLAIN_MESSAGE);
								this.setVisible(false);
								new MainPage().setVisible(true);
							}
							
						}catch(Exception ex) {
							ex.printStackTrace();
						}	
					}
				}else {
					JOptionPane.showMessageDialog(null, "please Select your gender", "Warrning ", JOptionPane.WARNING_MESSAGE);
				}
			}
		}else if(e.getSource().equals(cancel)) {
			this.setVisible(false);
			new MainPage().setVisible(true);
		}
	}
}
