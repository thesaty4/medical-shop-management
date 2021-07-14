package medical_shop;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
/**
 * @Author Satya Narayan Mishra
 */

public class MainPage extends JFrame implements ActionListener{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainPage().setVisible(true);
	}

	/**
	 * Constructor Application run from here........
	 */
	private JButton login,btnRegistration;
	MainPage() {
		// this script for full window---------------------
//		setExtendedState(this.MAXIMIZED_BOTH); 
//		frame.setUndecorated(true);
//		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		GraphicsDevice device = env.getDefaultScreenDevice();
//		device.setFullScreenWindow(this);
		// Setting the size of frame-----------------------
		setSize(1500,1100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//image arranging
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("medical_shop/image/Group-55.jpg"));
		this.getContentPane().setLayout(null);
		JLabel j=new JLabel(icon);
		j.setBounds(220, -100, 1420, 799);
		this.getContentPane().add(j);
		
		//Welcome label
		JLabel title = new JLabel("Welcome to Medical Shop");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Cambria Math", Font.BOLD, 35));
		title.setForeground(new Color(139, 0, 0));
		title.setBounds(40, 198, 437, 56);
		this.getContentPane().add(title);
		
		// quots
		JLabel quot1 = new JLabel("\"When somebody follows you 20 blocks to the pharmacy, ");
		quot1.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		quot1.setHorizontalAlignment(SwingConstants.CENTER);
		quot1.setBounds(63, 265, 414, 14);
		this.getContentPane().add(quot1);
		
		JLabel quot2 = new JLabel("where they watch you buy toilet paper,");
		quot2.setHorizontalAlignment(SwingConstants.CENTER);
		quot2.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		quot2.setBounds(63, 290, 414, 14);
		this.getContentPane().add(quot2);
		
		JLabel quot3 = new JLabel(" you know your life has changed.\u201D");
		quot3.setHorizontalAlignment(SwingConstants.CENTER);
		quot3.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		quot3.setBounds(63, 315, 414, 14);
		this.getContentPane().add(quot3);
		
		//Login button
		login = new JButton("Login");
		login.setFont(new Font("Cambria Math", Font.BOLD, 15));
		login.setBounds(107, 407, 132, 27);
		this.getContentPane().add(login);
		
		btnRegistration = new JButton("Registration");
		btnRegistration.setFont(new Font("Cambria Math", Font.BOLD, 15));
		btnRegistration.setBounds(270, 407, 132, 27);
		getContentPane().add(btnRegistration);
		
		login.addActionListener(this);
		btnRegistration.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			this.setVisible(false);
			new login().setVisible(true);
		}else if(e.getSource().equals(btnRegistration)) {
			this.setVisible(false);
			new Registration().setVisible(true);
		}
	}
}
