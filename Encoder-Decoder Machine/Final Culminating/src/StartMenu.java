import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartMenu extends JFrame {

	private JPanel contentPane;
	public static Help frame1 = new Help();
	public static About frame2 = new About();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu frame = new StartMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Ikd8eXRbOL_Eg4ugI04NG7V2Qlx34NQf0n0YG-EwSP3UkvsjAObHxW6gb8_aXUo3HYU=w300.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(162, 52, 256, 212);
		contentPane.add(lblNewLabel);
		
		JButton Start = new JButton("Start Game");
		Start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Start) {
					DataEntry frame = new DataEntry();
					frame.setVisible(true);
					frame1.dispose();
					frame2.dispose();
					dispose();
				}
			}
		});
		Start.setBounds(234, 284, 123, 32);
		contentPane.add(Start);
		
		JButton About = new JButton("About");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == About) {
					frame2.setVisible(true);
				}
			}
		});
		About.setBounds(61, 284, 123, 32);
		contentPane.add(About);
		
		JButton Help = new JButton("Tutorial");
		Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Help) {
					frame1.setVisible(true);
				}
			}
		});
		Help.setBounds(403, 284, 123, 32);
		contentPane.add(Help);
		
		JLabel lblWelcomeToThe = new JLabel("WELCOME TO THE CC ENCODER-DECODER MACHINE");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcomeToThe.setBounds(51, 11, 487, 37);
		contentPane.add(lblWelcomeToThe);
		
	}
}
