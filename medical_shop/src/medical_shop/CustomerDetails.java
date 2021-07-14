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

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CustomerDetails extends JFrame implements ActionListener{
	private JTextField customerID;
	private JTextField Name;
	private JTextField Gender;
	private JTextField Mobile;
	private JTextField Address;
	private JTextField TotalPay;
	private JTextField PurcheaseDate;
	private JButton Update,btnDelete,btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetails window = new CustomerDetails();
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
	public CustomerDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 887, 442);
		getContentPane().setLayout(null);
		
		JLabel customerDetails = new JLabel("Customer Details & Modification");
		customerDetails.setBounds(0, 11, 871, 24);
		customerDetails.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		customerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(customerDetails);
		
		Panel panel = new Panel();
		panel.setBounds(25, 56, 315, 299);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblusrName = new JLabel("Customer ID");
		lblusrName.setBounds(42, 47, 74, 14);
		panel.add(lblusrName);
		
		customerID = new JTextField();
		customerID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ev) {
				dbConnection conn=new dbConnection();
				Integer cid=Integer.parseInt(customerID.getText());
				String sql="select * from `customer_info` where `customer_id`="+cid;
				try {
					ResultSet cData=conn.stm.executeQuery(sql);
					if(cData.next()) {
						Name.setText(cData.getString("name"));
						Gender.setText(cData.getString("gender"));
						Mobile.setText(cData.getString("mobile"));
						Address.setText(cData.getString("address"));
						TotalPay.setText(cData.getString("total_pay"));
						PurcheaseDate.setText(cData.getString("purchase_date"));
					}else {
						Name.setText("");
						Gender.setText("");
						Mobile.setText("");
						Address.setText("");
						TotalPay.setText("");
						PurcheaseDate.setText("");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		customerID.setBounds(142, 44, 139, 20);
		panel.add(customerID);
		customerID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(42, 75, 74, 14);
		panel.add(lblName);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(142, 72, 139, 20);
		panel.add(Name);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(42, 103, 74, 14);
		panel.add(lblGender);
		
		Gender = new JTextField();
		Gender.setColumns(10);
		Gender.setBounds(142, 100, 139, 20);
		panel.add(Gender);
		
		Mobile = new JTextField();
		Mobile.setColumns(10);
		Mobile.setBounds(142, 156, 139, 20);
		panel.add(Mobile);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(42, 159, 74, 14);
		panel.add(lblMobile);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(42, 131, 74, 14);
		panel.add(lblAddress);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(142, 128, 139, 20);
		panel.add(Address);
		
		JLabel lblTotalPay = new JLabel("Total Pay");
		lblTotalPay.setBounds(42, 187, 114, 14);
		panel.add(lblTotalPay);
		
		TotalPay = new JTextField();
		TotalPay.setColumns(10);
		TotalPay.setBounds(142, 184, 139, 20);
		panel.add(TotalPay);
		
		Update = new JButton("Update");
		Update.setBounds(23, 265, 89, 23);
		panel.add(Update);
		Update.addActionListener(this);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(124, 265, 80, 23);
		panel.add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(214, 265, 89, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(this);
		
		PurcheaseDate = new JTextField();
		PurcheaseDate.setColumns(10);
		PurcheaseDate.setBounds(142, 212, 139, 20);
		panel.add(PurcheaseDate);
		
		JLabel label = new JLabel("Purchease Date");
		label.setBounds(42, 215, 114, 14);
		panel.add(label);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(350, 56, 498, 299);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		dbConnection conn=new dbConnection();
		try {
			int counter=0;
			String sql="select * from `customer_info`";
			ResultSet logData=conn.stm.executeQuery(sql);
			while(logData.next()) {
				counter+=1;
			}
			int i=0,j=0;
			String x[]= {"Customer ID","Name","Gender","Mobile","Address","Purchase Date"};
			String y[][]=new String[counter][6];
			ResultSet logData2=conn.stm.executeQuery(sql);
			while(logData2.next()) {
				y[i][j++]=logData2.getString("customer_id");
				y[i][j++]=logData2.getString("name");
				y[i][j++]=logData2.getString("gender");
				y[i][j++]=logData2.getString("mobile");
				y[i][j++]=logData2.getString("address");
				y[i][j++]=logData2.getString("purchase_date");
				i++;
				j=0;
			}
			JTable table=new JTable(y,x);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 11, 478, 277);
			panel_1.add(scrollPane);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		String custId=customerID.getText().strip().toLowerCase();
		String name=Name.getText().strip().toLowerCase();
		String gender=Gender.getText().strip().toLowerCase();
		String mobile=Mobile.getText().strip();
		String address=Address.getText().strip().toLowerCase();
		String totalPay=TotalPay.getText().strip().toLowerCase();
		dbConnection conn=new dbConnection();
				
		if(e.getSource()==btnCancel) {
			this.hide();
		}else if(name.isEmpty()||gender.isEmpty()||mobile.isEmpty()||address.isEmpty()||totalPay.isEmpty()||custId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "All field Required","warning",JOptionPane.WARNING_MESSAGE);
		}else {
			Integer cId=Integer.parseInt(custId);
			float TotPay=Float.parseFloat(totalPay);
			if(e.getSource()==btnDelete) {
				int del=JOptionPane.showConfirmDialog(null, "Do you want to delete this account?", "Account Deletion", JOptionPane.YES_NO_OPTION);
				if(del==0) {
					String sql="delete from `customer_info` where `customer_id`="+cId;
					try {
						conn.stm.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Record deleted successfully....");
						this.hide();
						new CustomerDetails().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}else if(e.getSource()==Update) {
				int del=JOptionPane.showConfirmDialog(null, "Do you want to delete this account?", "Account Deletion", JOptionPane.YES_NO_OPTION);
				if(del==0) {
					String sql1="update `customer_info` set `name`='"+name+"' where `customer_id`="+cId;
					String sql2="update `customer_info` set `gender`='"+gender+"' where `customer_id`="+cId;
					String sql3="update `customer_info` set `mobile`='"+mobile+"' where `customer_id`="+cId;
					String sql4="update `customer_info` set `address`='"+address+"' where `customer_id`="+cId;
					String sql5="update `customer_info` set `total_pay`="+TotPay+" where `customer_id`="+cId;
					try {
						conn.stm.executeUpdate(sql1);
						conn.stm.executeUpdate(sql2);
						conn.stm.executeUpdate(sql3);
						conn.stm.executeUpdate(sql4);
						conn.stm.executeUpdate(sql5);
						JOptionPane.showMessageDialog(null, "Record Updated successfully....");
						this.hide();
						new CustomerDetails().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
