package medical_shop;
/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayBill extends JFrame implements ActionListener{
	private JTextField Name;
	private JTextField Mobile;
	private JTextField Address;
	private JTextField DrugName;
	private JTextField PricePcs;
	private JTextField Quantity;
	private JTextField TPay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayBill window = new PayBill();
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
	public PayBill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton Update,btnCancel,btnClear;
	JRadioButton rdbtnMale,rdbtnFemale;
	private void initialize() {
		setBounds(100, 100, 887, 442);
		getContentPane().setLayout(null);
		
		JLabel customerDetails = new JLabel("Pay Bill & Customer Record");
		customerDetails.setBounds(0, 11, 871, 24);
		customerDetails.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		customerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(customerDetails);
		
		Panel panel = new Panel();
		panel.setBounds(25, 56, 315, 299);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(42, 24, 74, 14);
		panel.add(lblName);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(142, 21, 139, 20);
		panel.add(Name);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(42, 49, 74, 14);
		panel.add(lblGender);
		
		Mobile = new JTextField();
		Mobile.setColumns(10);
		Mobile.setBounds(142, 74, 139, 20);
		panel.add(Mobile);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(42, 77, 74, 14);
		panel.add(lblMobile);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(42, 108, 74, 14);
		panel.add(lblAddress);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(142, 105, 139, 20);
		panel.add(Address);
		
		JLabel lblDrugsName = new JLabel("Drugs Name");
		lblDrugsName.setBounds(42, 136, 101, 14);
		panel.add(lblDrugsName);
		
		DrugName = new JTextField();		
		DrugName.setColumns(10);
		DrugName.setBounds(142, 133, 139, 20);
		panel.add(DrugName);
		
		Update = new JButton("Pay");
		Update.addActionListener(this);
		Update.setBounds(23, 265, 89, 23);
		panel.add(Update);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnClear.setBounds(124, 265, 80, 23);
		panel.add(btnClear);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(214, 265, 89, 23);
		panel.add(btnCancel);
		
		PricePcs = new JTextField();
		PricePcs.setColumns(10);
		PricePcs.setBounds(142, 189, 139, 20);
		panel.add(PricePcs);
		
		JLabel lblPricepcs = new JLabel("Price/Pcs");
		lblPricepcs.setBounds(42, 192, 101, 14);
		panel.add(lblPricepcs);
		
		ButtonGroup bg=new ButtonGroup();
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(138, 48, 53, 23);
		panel.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(203, 48, 78, 23);
		panel.add(rdbtnFemale);
		bg.add(rdbtnMale);bg.add(rdbtnFemale);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(42, 164, 101, 14);
		panel.add(lblQuantity);
		
		Quantity = new JTextField();
		Quantity.setColumns(10);
		Quantity.setBounds(142, 161, 139, 20);
		panel.add(Quantity);
		
		TPay = new JTextField();
		TPay.setColumns(10);
		TPay.setBounds(142, 220, 139, 20);
		panel.add(TPay);
		
//Key Listener------------------------------------------
		Quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String qntty=Quantity.getText().strip();
				Integer intQuantity=Integer.parseInt(qntty);
				
				String pps=PricePcs.getText().strip();
				float intPppcs=Float.parseFloat(pps);
						
				float TAmount=intQuantity*intPppcs;
				TPay.setText(Float.toString(TAmount));
			}
		});
		

		TPay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Quantity.setText("");
				PricePcs.setText("");
			}
		});
		

		PricePcs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String qntty=Quantity.getText().strip();
				Integer intQuantity=Integer.parseInt(qntty);
				
				String pps=PricePcs.getText().strip();
				float intPppcs=Float.parseFloat(pps);
						
				float TAmount=intQuantity*intPppcs;
				TPay.setText(Float.toString(TAmount));
			}
		});
		
//Key Listener--------------------------------------------
		
		
		JLabel lblTotalPay_1 = new JLabel("Total Pay");
		lblTotalPay_1.setBounds(42, 223, 101, 14);
		panel.add(lblTotalPay_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(350, 56, 498, 299);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		dbConnection conn=new dbConnection();
		String sql="select * from `customer_info`";
		int counter=0;
		int i=0,j=0;
		try {
			ResultSet result=conn.stm.executeQuery(sql);
			while(result.next()) {
				counter+=1;
			}
			ResultSet result2=conn.stm.executeQuery(sql);
			String x[]= {"User ID","Name","Gender","Mobile","Address","Purchease Date"};
			String y[][]=new String[counter][7];
			while(result2.next()) {
				y[i][j++]=result2.getString("customer_id");
				y[i][j++]=result2.getString("name");
				y[i][j++]=result2.getString("gender");
				y[i][j++]=result2.getString("mobile");
				y[i][j++]=result2.getString("address");
				y[i][j++]=result2.getString("purchase_date");
				i++;
				j=0;
			}
			JTable table=new JTable(y,x);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 11, 478, 277);
			panel_1.add(scrollPane);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Update)) {
			String name=Name.getText().strip().toLowerCase();
			String mobile=Mobile.getText().strip().toLowerCase();
			String add=Address.getText().strip().toLowerCase();
			String drug=DrugName.getText().strip();
			String Qtty=Quantity.getText().strip();
			String ppPcs=PricePcs.getText().strip();
			String TotalPay=TPay.getText().strip();
			String gender="";
			if(rdbtnMale.isSelected()) {
				gender="male";
			}else if(rdbtnFemale.isSelected()){
				gender="female";
			}
			
			if(name.isEmpty() || mobile.isEmpty() || add.isEmpty() || drug.isEmpty() || Qtty.isEmpty() || ppPcs.isEmpty() || TotalPay.isEmpty() || gender.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Opps ! all field required..", "Warning", JOptionPane.WARNING_MESSAGE);
			}else {
				Integer intQnty=Integer.parseInt(Qtty);
				float fltTprice=Float.parseFloat(TotalPay);
				float fltppPcs=Float.parseFloat(ppPcs);
				dbConnection conn=new dbConnection();
				try {
					String sql4="select `drug_name` from `drugs_info` where `drug_name`='"+drug+"'";
					ResultSet dName=conn.stm.executeQuery(sql4);
					if(dName.next()) {
						String sql="insert into `customer_info` (`name`,`gender`,`mobile`,`address`,`total_pay`) values ('"+name+"','"+
								gender+"','"+mobile+"','"+add+"',"+fltTprice+")";
						conn.stm.executeUpdate(sql);
						
						String sql2="select `customer_id` from `customer_info`";
						String cstmr_id=new String();
						ResultSet rslt=conn.stm.executeQuery(sql2);
						while(rslt.next()) {
							cstmr_id=rslt.getString("customer_id");
						}
						Integer intCID=Integer.parseInt(cstmr_id);
						
						String sql3="insert into `bill` (`customer_id`,`drug_name`,`quantity`) values ("+intCID+","+drug+","+intQnty+")";
						conn.stm.executeUpdate(sql);					
						JOptionPane.showMessageDialog(null, "New Stock Added successfully....");
						this.hide();
						new PayBill().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Drug name isn't availabe in the database....");
						DrugName.setText("");
					}					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
		}else if(e.getSource().equals(btnCancel)) {
			this.setVisible(false);
		}else if(e.getSource().equals(btnClear)) {
			Name.setText("");Mobile.setText("");Address.setText("");DrugName.setText("");Quantity.setText("");
			PricePcs.setText("");TPay.setText("");
		}
	}
}
