import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.util.*;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DataEntry extends JFrame {

	private JPanel contentPane;
	public static Scanner in = new Scanner(System.in);
	public static char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	public static char newAlphabet[] = new char[26];
	public static char tempAlphabetArray[] = new char[26];
	public static char caesarCipher2DArray[][] = new char[26][26];
	public static int count = -1;
	public static String userChoice, tempKeyNum, userMessage, keyMessage;
	public static int keyNum, spaceCount = 0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JSpinner spinner = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataEntry frame = new DataEntry();
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
	public DataEntry() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		setTitle("GAME");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 520);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmBackToMain = new JMenuItem("Back To Main Menu");
		mntmBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mntmBackToMain) {
					StartMenu frame = new StartMenu();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		mnFile.add(mntmBackToMain);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmNew = new JMenuItem("Duplicate Window    Ctrl + d");
		mnView.add(mntmNew);
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mntmNew) {
					DataEntry frame = new DataEntry();
					frame.setVisible(true);
				}
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Clear All          Ctrl + Shift + c");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mntmNewMenuItem) {
					textField.setText("");
					textField_1.setText("");
					spinner.setValue(0);
				}
			}
		});

		JMenuItem mntmCloseWindow = new JMenuItem("Close Window           Ctrl + w");
		mntmCloseWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mntmCloseWindow) {
					dispose();
				}
			}
		});
		mnView.add(mntmCloseWindow);
		mnView.add(mntmNewMenuItem);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem Tutorial = new JMenuItem("Tutorial");
		mnHelp.add(Tutorial);

		JMenu mnEdit = new JMenu("About");
		menuBar.add(mnEdit);

		JMenuItem about = new JMenuItem("About The Game");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About frame = new About();
				frame.setVisible(true);
			}
		});
		mnEdit.add(about);
		Tutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help frame = new Help();
				frame.setVisible(true);
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		spinner.setModel(new SpinnerNumberModel(0, 0, 26, 1));
		spinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		spinner.setBounds(233, 240, 40, 25);
		contentPane.add(spinner);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		textField.setBounds(233, 126, 422, 20);
		contentPane.add(textField);
		textField.setColumns(10);


		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(232, 182, 422, 20);
		contentPane.add(textField_1);


		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(233, 292, 421, 20);
		contentPane.add(textField_2);


		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(232, 336, 422, 20);
		contentPane.add(textField_3);

		JLabel lblKeyMessageMust = new JLabel("");
		lblKeyMessageMust.setForeground(Color.RED);
		lblKeyMessageMust.setBounds(233, 202, 422, 14);
		contentPane.add(lblKeyMessageMust);

		JButton btnEncodeMessage = new JButton("ENCODE MESSAGE");
		btnEncodeMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		
		btnEncodeMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((e.getSource() == btnEncodeMessage)) {
					count = 0;
					keyNum = Integer.parseInt(spinner.getValue().toString());
					userMessage = (String) textField.getText().toString();
					keyMessage = (String) textField_1.getText().toString();

					if(userMessage.length() > keyMessage.length()) {
						lblKeyMessageMust.setText("Key message must be of longer length than the above message!");
					} else {
						lblKeyMessageMust.setText("");
						caesarCipherArray(keyNum);
						twoDimensionalArray();
						textField_2.setText(encodeMessage(userMessage, keyMessage));
						textField_3.setText("");
					}
				}
			}
		});
		btnEncodeMessage.setBounds(165, 397, 168, 42);
		contentPane.add(btnEncodeMessage);


		JButton btnDecodeMessage = new JButton("DECODE MESSAGE");
		btnDecodeMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_W) {
						dispose();
					}
				}

				if(e.isControlDown()) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						DataEntry frame = new DataEntry();
						frame.setVisible(true);
					}
				}

				if(e.isControlDown()) {
					if(e.isShiftDown()) {
						if(e.getKeyCode() == KeyEvent.VK_C) {
							textField.setText("");
							textField_1.setText("");
							spinner.setValue(0);
						}
					}
				}
			}
		});
		
		btnDecodeMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnDecodeMessage) {
					count = 0;
					keyNum = Integer.parseInt(spinner.getValue().toString());
					userMessage = (String) textField.getText().toString();
					keyMessage = (String) textField_1.getText().toString();

					if(userMessage.length() > keyMessage.length()) {
						lblKeyMessageMust.setText("Key message must be of longer length than the above message!");
					} else {
						lblKeyMessageMust.setText("");
						caesarCipherArray(keyNum);
						twoDimensionalArray();
						textField_2.setText("");
						textField_3.setText(decodeMessage(userMessage, keyMessage));
					}
				}
			}
		});
		btnDecodeMessage.setBounds(406, 398, 168, 40);
		contentPane.add(btnDecodeMessage);

		JLabel lblEnterMessageHere = new JLabel("ENTER MESSAGE HERE:");
		lblEnterMessageHere.setBounds(77, 124, 145, 25);
		contentPane.add(lblEnterMessageHere);

		JLabel lblEnterKeyWord = new JLabel("ENTER KEY MESSGAE:");
		lblEnterKeyWord.setBounds(82, 182, 138, 20);
		contentPane.add(lblEnterKeyWord);

		JLabel lblChooseKeyNumber = new JLabel("CHOOSE KEY NUMBER:");
		lblChooseKeyNumber.setBounds(75, 242, 147, 20);
		contentPane.add(lblChooseKeyNumber);

		JLabel lblEncryptedText = new JLabel("ENCRYPTED TEXT:");
		lblEncryptedText.setBounds(97, 292, 126, 20);
		contentPane.add(lblEncryptedText);

		JLabel lblDecryptedText = new JLabel("DECRYPTED TEXT:");
		lblDecryptedText.setBounds(96, 336, 126, 20);
		contentPane.add(lblDecryptedText);

		JLabel lblCcEncoderDecoder = new JLabel("CC ENCODER-DECODER MACHINE");
		lblCcEncoderDecoder.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCcEncoderDecoder.setBounds(165, 26, 422, 42);
		contentPane.add(lblCcEncoderDecoder);
	}


	public static String encodeMessage(String userMessage, String keyMessage) {
		/* ENCODE EACH LETTER OF THE USER'S MESSAGE AND RETURN THE ENCODED MESSAGE AS A STRING TYPE */

		String encodedMessage = "";
		int indexOfFirstLetter = 0;
		int indexOfSecondLetter = 0;

		// Encode each letter of the message
		for(int k = 0; k < ((CharSequence) userMessage).length(); k++) {

			/* If there is a space in the user's message, add a space to the encoded message,
			 * else, if there is no space nor letter, add that character to the encoded message,
			 * else, encode the letter.
			 */
			if(Character.isSpaceChar(((CharSequence) userMessage).charAt(k))) {
				encodedMessage += " ";
			} else if(Character.isLetter(((CharSequence) userMessage).charAt(k)) == false) {
				encodedMessage += ((CharSequence) userMessage).charAt(k);
			} else {
				// Find in which column the letter in the first row matches the letter in the user's message
				for(int i = 0; i < caesarCipher2DArray.length; i++) {
					if(caesarCipher2DArray[0][i] == Character.toLowerCase(((CharSequence) userMessage).charAt(k))) {
						indexOfFirstLetter = i;
					}
				}

				/* If the key message has a space or a different character, the index of the row for the 2D array is 0, else,
				 * search for when the character in the column found above of the 2D array matches the character in the key message.
				 */
				if(Character.isSpaceChar(((CharSequence) keyMessage).charAt(k)) || Character.isLetter(((CharSequence) keyMessage).charAt(k)) == false) {
					indexOfSecondLetter = 0;
				} else {
					for(int i = 0; i < caesarCipher2DArray.length; i++) {
						if(caesarCipher2DArray[i][0] == Character.toLowerCase(((CharSequence) keyMessage).charAt(k))) {
							indexOfSecondLetter = i;
						}
					}
				}

				// If the letter in the user's message is lower case, the new letter is lower case, else upper case
				if(Character.isLowerCase(((CharSequence) userMessage).charAt(k))) {
					encodedMessage += caesarCipher2DArray[indexOfFirstLetter][indexOfSecondLetter];
				} else {
					encodedMessage += Character.toUpperCase(caesarCipher2DArray[indexOfFirstLetter][indexOfSecondLetter]);
				}
			}
		}

		// Return encoded message to the main method
		return encodedMessage;
	}



	public static String decodeMessage(String userMessage, String keyMessage) {
		/* DECODE MESSAGE AND RETURN IT TO THE MAIN METHOD */

		String decodedMessage = "";
		int indexOfFirstLetter = 0;
		int indexOfSecondLetter = 0;

		// Decodes each letter of the user's message and adds it to the string type variable decodedMessage
		for(int k = 0; k < ((CharSequence) userMessage).length(); k++) {


			/* Checks if the character at that index is a space. If so, it adds a space to the decoded message,
			 * if it isn'ta space nor a letter, it adds that character to the decoded message, else, it decodes that
			 * letter using the 2D array.
			 */

			if(Character.isSpaceChar(((CharSequence) userMessage).charAt(k))) {
				decodedMessage += " ";
			} else if(Character.isLetter(((CharSequence) userMessage).charAt(k)) == false) {
				decodedMessage += ((CharSequence) userMessage).charAt(k);
			} else {

				/* If the key message is a space or a character, the index of the row for the 2D array is 0, else,
				 * the program searches for when the letter of the first column matches the letter of the first
				 * character of the key message.
				 */
				if(Character.isSpaceChar(((CharSequence) keyMessage).charAt(k)) || Character.isLetter(((CharSequence) keyMessage).charAt(k)) == false) {
					indexOfSecondLetter = 0;
				} else {
					for(int i = 0; i < caesarCipher2DArray.length; i++) {
						if(caesarCipher2DArray[i][0] == Character.toLowerCase(((CharSequence) keyMessage).charAt(k))) {
							indexOfSecondLetter = i;
						}
					}
				}

				// Searches for when the character in the row found above matches the user's message character
				for(int i = 0; i < caesarCipher2DArray.length; i++) {
					if(caesarCipher2DArray[indexOfSecondLetter][i] == Character.toLowerCase(((CharSequence) userMessage).charAt(k))) {
						indexOfFirstLetter = i;
					}
				}

				// If the letter in user's message is lower case, the decoded letter is also lower case, else, upper case
				if(Character.isLowerCase(((CharSequence) userMessage).charAt(k))) {
					decodedMessage += caesarCipher2DArray[0][indexOfFirstLetter];
				} else {
					decodedMessage += Character.toUpperCase(caesarCipher2DArray[0][indexOfFirstLetter]);
				}
			}
		}

		// Returns the decoded message to the main method
		return decodedMessage;
	}


	public static void twoDimensionalArray() {
		/* CREATE THE 2D ARRAY USING THE NEW ALPHABET */

		for(int i = 0; i < caesarCipher2DArray.length; i++) {
			// Go to the method and run it before carrying out the rest of the program
			constantlyChangingCaesarCipherArray();

			for(int j = 0; j < caesarCipher2DArray.length; j++) {
				caesarCipher2DArray[i][j] = tempAlphabetArray[j];
			}
		}
	}

	public static void caesarCipherArray(int keyNum) {
		/* METHOD CREATES THE NEW ALPHABET USING THE CAESAR CIPHER ALGORITHM */

		for(int i = 0; i < newAlphabet.length; i++) {
			if(i + keyNum <= 25) {
				newAlphabet[i] = alphabet[i + keyNum];
			} else {
				newAlphabet[i] = alphabet[i + keyNum - 26];
			}
		}	
	}


	public static void constantlyChangingCaesarCipherArray() {
		/* METHOD CREATES THE NEW ALPHABET FOR EACH ROW OF THE 2D ARRAY BY STARTING AT THE NEXT LETTER IN THE ALPHABET FOR EACH ROW */

		// Add one to the counter of the new starting letter of each row
		count += 1;

		// Create new temporary array starting with the new letter
		for(int i = 0; i < newAlphabet.length; i++) {
			if(i + count <= 25) {
				tempAlphabetArray[i] = newAlphabet[i + count];
			} else {
				tempAlphabetArray[i] = newAlphabet[i + count - 26];
			}
		}
	}
}
