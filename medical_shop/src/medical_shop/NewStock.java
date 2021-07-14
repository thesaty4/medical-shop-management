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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewStock extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField drugsName;
	private JTextField quantity;
	private JTextField totalPrice;
	private JTextField pricePerPcs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStock window = new NewStock();
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
	public NewStock() {
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnNewButton,btnCancel;
	private void initialize() {
		setBounds(300, 80, 900, 534);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("______________________________________________________________________________________________________________________________________________________________________________");
		label.setBounds(0, 44, 940, 23);
		getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New Stocks");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 884, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("______________________________________________________________________________________________________________________________________________________________________________");
		label_1.setBounds(0, 36, 940, 14);
		getContentPane().add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(482, 89, 392, 322);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel drugsLabel = new JLabel("Drugs Name ");
		drugsLabel.setBounds(10, 75, 91, 14);
		panel_1.add(drugsLabel);
		
		drugsName = new JTextField();
		drugsName.setBounds(97, 72, 244, 20);
		panel_1.add(drugsName);
		drugsName.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity ");
		lblQuantity.setBounds(10, 118, 91, 14);
		panel_1.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String qntty=quantity.getText().strip();
				Integer intQuantity=Integer.parseInt(qntty);
			
				String tPrice=totalPrice.getText().strip();
				float intTotalPrice=Float.parseFloat(tPrice);
				
				float ppPcs=intTotalPrice/intQuantity;
				pricePerPcs.setText(Float.toString(ppPcs));
			}
		});
		quantity.setColumns(10);
		quantity.setBounds(97, 115, 244, 20);
		panel_1.add(quantity);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(10, 164, 91, 14);
		panel_1.add(lblTotalPrice);
		
		totalPrice = new JTextField();
		totalPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String qntty=quantity.getText().strip();
				Integer intQuantity=Integer.parseInt(qntty);
			
				String tPrice=totalPrice.getText().strip();
				float intTotalPrice=Float.parseFloat(tPrice);
				
				float ppPcs=intTotalPrice/intQuantity;
				pricePerPcs.setText(Float.toString(ppPcs));
			}
		});
		totalPrice.setColumns(10);
		totalPrice.setBounds(97, 161, 244, 20);
		panel_1.add(totalPrice);
		
		JLabel lblPricePerPcs = new JLabel("Price Per Pcs");
		lblPricePerPcs.setBounds(10, 208, 91, 14);
		panel_1.add(lblPricePerPcs);
		
		pricePerPcs = new JTextField();
		pricePerPcs.setColumns(10);
		pricePerPcs.setBounds(97, 205, 244, 20);
		panel_1.add(pricePerPcs);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(46, 275, 111, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBounds(211, 275, 111, 23);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(40, 89, 481, 322);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewStock.class.getResource("/medical_shop/image/drugs2.jpg")));
		lblNewLabel.setBounds(10, 11, 425, 307);
		panel.add(lblNewLabel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCancel)) {
			this.setVisible(false);
		}else {
			String drug=drugsName.getText().strip();
			String qnty=new String(quantity.getText().strip());
			String tPrice=new String(totalPrice.getText().strip());
			String ppPcs=new String(pricePerPcs.getText().strip());
			
			if(drug.isEmpty() || qnty.isEmpty() || tPrice.isEmpty() || ppPcs.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Opps ! all field required..", "Warning", JOptionPane.WARNING_MESSAGE);
			}else {
				Integer intQnty=Integer.parseInt(qnty);
				float fltTprice=Float.parseFloat(tPrice);
				float fltppPcs=Float.parseFloat(ppPcs);
				dbConnection conn=new dbConnection();
				try {
					String sql="insert into `drugs_info` (`drug_name`,`quantity`,`total_price`,`price_per_pcs`) values ('"+drug+"',"+intQnty+","+fltTprice+","+fltppPcs+")";
					conn.stm.executeUpdate(sql);
					drugsName.setText("");
					quantity.setText("");
					totalPrice.setText("");
					pricePerPcs.setText("");
					
					JOptionPane.showMessageDialog(null, "New Stock Added successfully....");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
