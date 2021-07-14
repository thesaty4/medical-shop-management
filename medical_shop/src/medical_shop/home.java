package medical_shop;
/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
public class home extends JFrame implements ActionListener{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new home().setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. and run application
	 */
	
	// globle variable decleartion
	JMenuItem list1,list2,usrl1,ex,usrl2,usrl3;
	 home() {
		 setTitle("Medical Shop Management");
		 setBounds(200,100,910,560);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setResizable(false);
		 getContentPane().setLayout(null);
		 
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon(home.class.getResource("/medical_shop/image/1.jpg")));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		 lblNewLabel.setBounds(0, 40, 910, 494);
		 getContentPane().add(lblNewLabel);
		 
		 JLabel title = new JLabel("Medical Shop Management");
		 title.setForeground(new Color(178, 34, 34));
		 title.setFont(new Font("Castellar", Font.BOLD, 20));
		 title.setHorizontalAlignment(SwingConstants.CENTER);
		 title.setBounds(0, 11, 910, 37);
		 getContentPane().add(title);
		 
		 Font f=new Font("monospaced",Font.PLAIN,16);
		 	JMenuBar mb=new JMenuBar();
			JMenu shopManage=new JMenu("Shop Management");
			list1=new JMenuItem("New Stock");
			list2=new JMenuItem("Stock Management");
			shopManage.setFont(f);
			shopManage.add(list1);
			shopManage.add(list2);
			list1.setBackground(Color.WHITE);
			list2.setBackground(Color.WHITE);
			list1.addActionListener(this);
			list2.addActionListener(this);
			
			//second column
			JMenu user=new JMenu("Customer Management");
			usrl1=new JMenuItem("Pay bill");
			usrl2=new JMenuItem("User Details");
			usrl3=new JMenuItem("Customer Details");
			usrl1.setFont(f);
			usrl1.setBackground(Color.WHITE);
			usrl2.setBackground(Color.WHITE);
			usrl3.setBackground(Color.WHITE);
			user.add(usrl1);
			user.add(usrl2);
			user.add(usrl3);
			usrl1.addActionListener(this);
			usrl2.addActionListener(this);
			usrl3.addActionListener(this);			
			
			JMenu exit=new JMenu("Exit");
			ex=new JMenuItem("Exit");
			ex.setFont(f);
			ex.setBackground(Color.WHITE);
			exit.add(ex);
			ex.addActionListener(this);
					
			mb.add(shopManage);
			mb.add(user);
			mb.add(exit);
			setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==list1) {
			//if new stock button clicked
			new NewStock().setVisible(true);
			
		}else if(e.getSource()==list2) {
			//else if stock managment clicked
			new StockManagement().setVisible(true);
			
		}else if(e.getSource()==usrl1) {
			//if user mangment clicked
			new PayBill().setVisible(true);
			
		}else if(e.getSource()==usrl2) {
//			if user details clicked
			new UserDetails().setVisible(true);
			
		}else if(e.getSource()==usrl3) {
			// customer Details
			new CustomerDetails().setVisible(true);
			
		}else if(e.getSource()==ex) {
			System.exit(0);
		}
	}
}
