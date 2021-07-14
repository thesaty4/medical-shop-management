package medical_shop;
/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StockManagement extends JFrame implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockManagement window = new StockManagement();
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
	public StockManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private int i=0;
	private JTextField EntryDate;
	private JTextField DrugName;
	private JTextField Quantity;
	private JTextField TotalPrice;
	private JTextField PricePerPcs;
	private JTable table;
	private JButton btnClose,btnUpdate,btnDelete;
	private void initialize() {
		setBounds(300, 80, 900, 534);
		
		JLabel header = new JLabel("Stock Management");
		header.setForeground(new Color(139, 0, 0));
		header.setFont(new Font("Cambria Math", Font.BOLD, 20));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(header, BorderLayout.NORTH);
				
		dbConnection conn=new dbConnection();
		String sql="select * from `drugs_info`";
		try {
			ResultSet rslt=conn.stm.executeQuery(sql);	
			if(rslt.next()) {
				// If data available

				Panel panel = new Panel();
				getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				
				Panel panel_1 = new Panel();
				panel_1.setBounds(10, 11, 420, 412);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblEntryDate = new JLabel("Entry Date");
				lblEntryDate.setBounds(36, 273, 91, 14);
				panel_1.add(lblEntryDate);
				
				EntryDate = new JTextField();
				EntryDate.setText("");
				EntryDate.setColumns(10);
				EntryDate.setBounds(153, 270, 223, 20);
				panel_1.add(EntryDate);
				
				JLabel lblDrugName = new JLabel("Drug Name");
				lblDrugName.setBounds(36, 94, 91, 14);
				panel_1.add(lblDrugName);
				
				DrugName = new JTextField();
				DrugName.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						String Drug=DrugName.getText().toLowerCase().strip();
						String mySql="select * from `drugs_info` where `drug_name`='"+Drug+"'";
						try {
							ResultSet result=conn.stm.executeQuery(mySql);
							if(result.next()) {
								Quantity.setText(result.getString("quantity"));
								TotalPrice.setText(result.getString("total_price"));
								PricePerPcs.setText(result.getString("price_per_pcs"));
								EntryDate.setText(result.getString("cur_date"));
							}else {
								Quantity.setText("");
								TotalPrice.setText("");
								PricePerPcs.setText("");
								EntryDate.setText("");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				DrugName.setText("");
				DrugName.setColumns(10);
				DrugName.setBounds(153, 91, 223, 20);
				panel_1.add(DrugName);
				
				JLabel lblQuantity = new JLabel("Quantity");
				lblQuantity.setBounds(36, 141, 91, 14);
				panel_1.add(lblQuantity);
				
				Quantity = new JTextField();
				Quantity.setText("");
				Quantity.setColumns(10);
				Quantity.setBounds(153, 138, 223, 20);
				panel_1.add(Quantity);
				Quantity.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						String quantity=Quantity.getText().strip();
						Integer intQuantity=Integer.parseInt(quantity);
					
						String totalPrice=TotalPrice.getText().strip();
						float intTotalPrice=Float.parseFloat(totalPrice);
						
						float ppPcs=intTotalPrice/intQuantity;
						PricePerPcs.setText(Float.toString(ppPcs));
					}
				});
				
				JLabel lblTotalPrice = new JLabel("Total Price");
				lblTotalPrice.setBounds(36, 185, 91, 14);
				panel_1.add(lblTotalPrice);
				
				TotalPrice = new JTextField();
				TotalPrice.setText("");
				TotalPrice.setColumns(10);
				TotalPrice.setBounds(153, 182, 223, 20);
				panel_1.add(TotalPrice);
				TotalPrice.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						String quantity=Quantity.getText().strip();
						Integer intQuantity=Integer.parseInt(quantity);
					
						String totalPrice=TotalPrice.getText().strip();
						float intTotalPrice=Float.parseFloat(totalPrice);
						
						float ppPcs=intTotalPrice/intQuantity;
						PricePerPcs.setText(Float.toString(ppPcs));
					}
				});
				
				JLabel lblPriceperpcs = new JLabel("PricePerPcs");
				lblPriceperpcs.setBounds(36, 228, 91, 14);
				panel_1.add(lblPriceperpcs);
				
				PricePerPcs = new JTextField();
				PricePerPcs.setText("");
				PricePerPcs.setColumns(10);
				PricePerPcs.setBounds(153, 225, 223, 20);
				panel_1.add(PricePerPcs);
				
				btnUpdate = new JButton("Update");
				btnUpdate.setBounds(77, 332, 89, 23);
				panel_1.add(btnUpdate);
				btnUpdate.addActionListener(this);
				
				btnDelete = new JButton("Delete");
				btnDelete.setBounds(176, 332, 89, 23);
				panel_1.add(btnDelete);
				btnDelete.addActionListener(this);
				
				btnClose = new JButton("Close");
				btnClose.setBounds(275, 332, 89, 23);
				panel_1.add(btnClose);
				btnClose.addActionListener(this);
				
				Panel panel_2 = new Panel();
				panel_2.setBounds(436, 11, 423, 412);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				
				String query="select * from `drugs_info`";
				ResultSet data1=conn.stm.executeQuery(query);
				int counter=0,i=0,j=0;
				while(data1.next()) {
					counter+=1;
				}
				String x[]= {"Drug Name","Quantity","Total Price","Price/Pcs","Entry Date"};
				String y[][]=new String[counter][5];
				Resultset data=(Resultset) conn.stm.executeQuery(query);
				while(((ResultSet) data).next()) {
					y[i][j++]=((ResultSet) data).getString("drug_name");
					y[i][j++]=((ResultSet) data).getString("quantity");
					y[i][j++]=((ResultSet) data).getString("total_price");
					y[i][j++]=((ResultSet) data).getString("price_per_pcs");
					y[i][j++]=((ResultSet) data).getString("cur_date");
					i++;
					j=0;
				}
				table = new JTable(y,x);
				table.setBounds(10, 11, 403, 18);
				JScrollPane titleSP=new JScrollPane(table);
				panel_2.add(titleSP);
				titleSP.setBounds(10, 11, 403, 390);				
				
			}else {
				JLabel lblNewLabel = new JLabel("Opps ! There are no any record found...");
				lblNewLabel.setForeground(new Color(255, 0, 0));
				lblNewLabel.setBackground(new Color(255, 0, 0));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				getContentPane().add(lblNewLabel, BorderLayout.CENTER);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnClose)) {
			this.setVisible(false);
		}else {
			String drug=DrugName.getText().strip();
			String strquantity=Quantity.getText().strip();
			String strtotal_price=TotalPrice.getText().strip();
			String strpriceperpcs=PricePerPcs.getText().strip();
			
			Integer quantity=Integer.parseInt(strquantity);
			float total_price=Float.parseFloat(strtotal_price);
			float priceperpcs=Float.parseFloat(strpriceperpcs);
			
			if(drug.isEmpty() || strquantity.isEmpty() || strtotal_price.isEmpty() || strpriceperpcs.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Opps ! all field required..", "Warning", JOptionPane.WARNING_MESSAGE);
			}else {
				dbConnection conn=new dbConnection();
				if(e.getSource().equals(btnUpdate)) {
					String sql="update `drugs_info` set `quantity`='"+quantity+"', `total_price`='"+total_price+"', `price_per_pcs`='"+priceperpcs+"' where `drug_name`='"+drug+"'";
					try {
						conn.stm.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Record Updated successfull...", "Success", JOptionPane.WARNING_MESSAGE);
						this.hide();
						new StockManagement().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}else if(e.getSource().equals(btnDelete)) {
					int val=JOptionPane.showConfirmDialog(null, "After clicking you lose all record from database \n Do you want to delete this record?", "Conformation", JOptionPane.YES_NO_OPTION);					
					if(val==0) {
						// clicked on yes button
						String sql1="delete from `bill` where `drug_name`='"+drug+"'";
						String sql2="delete from `drugs_info` where `drug_name`='"+drug+"'";
						try {
							conn.stm.executeUpdate(sql1);
							conn.stm.executeUpdate(sql2);
							JOptionPane.showMessageDialog(null, "Record Deleted successfull");
							this.hide();
							new StockManagement().setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						// clicked on no button
					}					
				}
			}
		}
	}
}
