import java.net.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class About extends JFrame {

	private JPanel contentPane;
	public static int count = 0;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setTitle("OVERVIEW");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1191, 706);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtpnWhatDoes = new JTextPane();
		txtpnWhatDoes.setEditable(false);
		txtpnWhatDoes.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnWhatDoes.setText("\u00D8 What does this program do\r\n\tThe encoder decoder machine starts off by asking the user whether they would like to encode or decode a message or go through a tutorial. The user inputs their option and then the computer asks the user what their text message is and goes through a series of instructions for the user perform before the computer begins to encode or decode the message. After that, depending on whichever task the user wishes to perform, the computer outputs the modified message to the console.\r\n\r\n\tThis program is more likely to be used for those sending secret messages to one another so like in the military or just between friends if they\u2019re sending encrypted code. It\u2019s a program that can technically be used by high school students and older people, but they should have a good understanding of how a Caesar cipher algorithm works. Although the way we built the program, it can teach even beginners who don\u2019t have any background knowledge in any types of algorithms how to run through the program. In other words, we added a tutorial section that teaches them how to use the application. This type of program uses a Caesar Cipher algorithm to encrypt or decrypt the message.\r\n\r\n\r\n\u00D8 How it works\r\n\tFor the encoder-decoder machine, we must first get the user to enter their choice of action, to encode or decode. Next, the user will be prompted to enter a key number between 1 and 26. Using this key, we will create a 2D array that uses the Caesar cipher algorithm which will shift each letter of the alphabet a key number of spaces, to create a pre-set coordinate grid that will later be used to encrypt the word/phrase the user wishes to encode. The user will be prompted to input the word/phrase they wish to encrypt and then input a word/phrase of equal or greater length to the first one they entered. Those 2 inputted words/phrases will be used to encrypt or decrypt whatever the user wishes to encode or decode.\r\n \r\n\tIf the user wishes to encrypt a word or phrase, they will enter the key number between 1-26, the desired phrase or word, and finally, the key word. The key number will shift each letter of the alphabet down that number of spaces inside of a 2D array. The 2D array will be 26 by 26 for each letter of the alphabet. On each row, the starting letter of the alphabet will increase by 1. Using the first word, the first letter will be taken and the index of that letter of the column it matches with, will be found. Next, the first letter of the key word will be used to find the index of the row it corresponds with. Finally, using those two indices, the new letter of the encrypted word at that position will be the letter found in the 2D array. This is repeated until all the letters of the first word/phrase has been replaced.\r\n \r\n\tIf the user wishes to decrypt a message, they will first enter the key between 1 and 26, the desired encrypted message, and the key message. Just like for encrypting a message, the program will create the 2D array necessary to decode the message. Then the program will search through the 2D array to find in which column index that letter belongs in, in the 2D array. Based on that, it will relate it to the original alphabet array and repeat until all letters of the message have been decrypted. Then the message will be returned as a string and outputted to the console for the user to read.\r\n");
		txtpnWhatDoes.setBounds(35, 28, 1110, 592);
		contentPane.add(txtpnWhatDoes);
		
		txtpnWhatDoes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}
			}
		});
		
		JButton back = new JButton("Close");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == back) {
					dispose();
				}
			}
		});
		back.setBounds(509, 631, 155, 28);
		contentPane.add(back);
	}
}
