package medical_shop;
/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserDetails extends JFrame implements ActionListener{
	private JTextField userName;
	private JTextField Name;
	private JTextField Gender;
	private JTextField Mobile;
	private JTextField Address;
	private JTextField Email;
	private JPasswordField password;
	private JButton Update,btnDelete,btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetails window = new UserDetails();
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
	public UserDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 791, 442);
		getContentPane().setLayout(null);
		
		JLabel userDetails = new JLabel("Users Details & Modification");
		userDetails.setBounds(0, 11, 775, 24);
		userDetails.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		userDetails.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(userDetails);
		
		Panel panel = new Panel();
		panel.setBounds(25, 56, 315, 299);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblusrName = new JLabel("User Name");
		lblusrName.setBounds(23, 47, 74, 14);
		panel.add(lblusrName);
		
		dbConnection conn=new dbConnection();
		userName = new JTextField();
		userName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int flag=0;
				String uName=userName.getText().strip();
				String Passwd=password.getText().strip();
				String sql="select * from `login_info` where `usr_name`='"+uName+"' and `passwd`='"+Passwd+"'";
				try {
					ResultSet logData=conn.stm.executeQuery(sql);
					while(logData.next()) {
						Name.setText(logData.getString("name"));
						Gender.setText(logData.getString("gender"));
						Email.setText(logData.getString("email"));
						Mobile.setText(logData.getString("mobile"));
						Address.setText(logData.getString("address"));
						flag+=1;
					}
					if(flag==0) {
						Name.setText("");
						Gender.setText("");
						Email.setText("");
						Mobile.setText("");
						Address.setText("");
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		userName.setBounds(123, 44, 139, 20);
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 105, 74, 14);
		panel.add(lblName);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(123, 102, 139, 20);
		panel.add(Name);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(23, 133, 74, 14);
		panel.add(lblGender);
		
		Gender = new JTextField();
		Gender.setColumns(10);
		Gender.setBounds(123, 130, 139, 20);
		panel.add(Gender);
		
		Mobile = new JTextField();
		Mobile.setColumns(10);
		Mobile.setBounds(123, 217, 139, 20);
		panel.add(Mobile);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(23, 220, 74, 14);
		panel.add(lblMobile);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(23, 192, 74, 14);
		panel.add(lblAddress);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(123, 189, 139, 20);
		panel.add(Address);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(123, 158, 139, 20);
		panel.add(Email);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(23, 161, 74, 14);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(23, 75, 74, 14);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int flag=0;
				String uName=userName.getText().strip();
				String Passwd=password.getText().strip();
				String sql="select * from `login_info` where `usr_name`='"+uName+"' and `passwd`='"+Passwd+"'";
				try {
					ResultSet logData=conn.stm.executeQuery(sql);
					while(logData.next()) {
						Name.setText(logData.getString("name"));
						Gender.setText(logData.getString("gender"));
						Email.setText(logData.getString("email"));
						Mobile.setText(logData.getString("mobile"));
						Address.setText(logData.getString("address"));
						flag+=1;
					}
					if(flag==0) {
						Name.setText("");
						Gender.setText("");
						Email.setText("");
						Mobile.setText("");
						Address.setText("");
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		password.setColumns(10);
		password.setBounds(123, 72, 139, 20);
		panel.add(password);
		
		Update = new JButton("Update");
		Update.setBounds(0, 265, 89, 23);
		panel.add(Update);
		Update.addActionListener(this);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(115, 265, 89, 23);
		panel.add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(226, 265, 89, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(this);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(350, 56, 415, 299);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		try {
			int counter=0;
			String sql="select * from `login_info`";
			ResultSet logData=conn.stm.executeQuery(sql);
			while(logData.next()) {
				counter+=1;
			}
			int i=0,j=0;
			String x[]= {"User Name","Name","Mobile","Email","Address"};
			String y[][]=new String[counter][6];
			ResultSet logData2=conn.stm.executeQuery(sql);
			while(logData2.next()) {
				y[i][j++]=logData2.getString("usr_name");
				y[i][j++]=logData2.getString("name");
				y[i][j++]=logData2.getString("mobile");
				y[i][j++]=logData2.getString("email");
				y[i][j++]=logData2.getString("address");
				i++;
				j=0;
			}
			JTable table=new JTable(y,x);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 11, 395, 277);
			panel_1.add(scrollPane);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dbConnection conn=new dbConnection();
		String Uname=userName.getText().strip();
		String Upass=password.getText().strip();
		String name=Name.getText().strip().toLowerCase();
		String gender=Gender.getText().strip().toLowerCase();
		String mobile=Mobile.getText().strip().toLowerCase();
		String address=Address.getText().strip().toLowerCase();
		String email=Email.getText().strip();
		if(Uname.isEmpty()||Upass.isEmpty()||name.isEmpty()||gender.isEmpty()||mobile.isEmpty()||address.isEmpty()||email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "All field required","warning",JOptionPane.ERROR_MESSAGE);
		}else {		
			if(e.getSource() == btnCancel) {
				this.hide();
			}else if(e.getSource() == btnDelete) {
				int del=JOptionPane.showConfirmDialog(null, "Do you want to delete this account?", "Account Deletion", JOptionPane.YES_NO_OPTION);
				if(del==0) {
					String sql6="delete from `login_info` where `usr_name`='"+Uname+"'";
					
					try {
						conn.stm.executeUpdate(sql6);
						JOptionPane.showMessageDialog(null, "record update successfull..");
						this.hide();
						new UserDetails().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}else if(e.getSource() == Update) {
				int upd=JOptionPane.showConfirmDialog(null, "Do you want update account details?", "Account Deletion", JOptionPane.YES_NO_OPTION);
				if(upd==0) {
					String sql1="update `login_info` set `name`='"+name+"' where `usr_name`='"+Uname+"'";
					String sql2="update `login_info` set `gender`='"+gender+"' where `usr_name`='"+Uname+"'";
					String sql3="update `login_info` set `mobile`='"+mobile+"' where `usr_name`='"+Uname+"'";
					String sql4="update `login_info` set `address`='"+address+"' where `usr_name`='"+Uname+"'";
					String sql5="update `login_info` set `email`='"+email+"' where `usr_name`='"+Uname+"'";
					try {
						conn.stm.executeUpdate(sql1);
						conn.stm.executeUpdate(sql2);
						conn.stm.executeUpdate(sql3);
						conn.stm.executeUpdate(sql4);
						conn.stm.executeUpdate(sql5);
						JOptionPane.showMessageDialog(null, "record update successfull..");
						this.hide();
						new UserDetails().setVisible(true);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
}
