import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Help extends JFrame {

	private JPanel contentPane;
	public static String userMessage, keyMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	public Help() {
		setTitle("HELP");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 773, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setModel(new SpinnerNumberModel(0, 0, 26, 1));
		spinner.setBounds(233, 240, 40, 25);
		contentPane.add(spinner);


		JTextField textField = new JTextField();
		textField.setBounds(233, 126, 422, 20);
		contentPane.add(textField);
		textField.setColumns(10);


		JTextField textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(232, 182, 422, 20);
		contentPane.add(textField_1);


		JTextField textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(233, 292, 421, 20);
		contentPane.add(textField_2);


		JTextField textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(232, 336, 422, 20);
		contentPane.add(textField_3);


		JLabel lblTheLengthOf = new JLabel("");
		lblTheLengthOf.setForeground(Color.RED);
		lblTheLengthOf.setEnabled(true);
		lblTheLengthOf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTheLengthOf.setBounds(232, 205, 354, 14);
		contentPane.add(lblTheLengthOf);

		JLabel label = new JLabel("ENTER YOUR MESSAGE HERE. PRESS ENTER TO CONTINUE.");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setEnabled(true);
		label.setBounds(233, 150, 354, 14);
		contentPane.add(label);

		JButton btnEncodeMessage = new JButton("ENCODE MESSAGE");
		btnEncodeMessage.setEnabled(false);
		btnEncodeMessage.setBounds(163, 404, 168, 42);
		contentPane.add(btnEncodeMessage);


		JButton btnDecodeMessage = new JButton("DECODE MESSAGE");
		btnDecodeMessage.setEnabled(false);
		btnDecodeMessage.setBounds(442, 405, 168, 40);
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


		JButton btnBack = new JButton("Close");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(338, 470, 89, 23);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel.setBounds(233, 267, 422, 14);
		contentPane.add(lblNewLabel);

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					userMessage = textField.getText().toString();

					if(userMessage.length() == 0) {
						label.setText("ENTER YOUR MESSAGE HERE. PRESS ENTER TO CONTINUE.");
						textField_1.setEnabled(false);
					} else {
						label.setText("");
						textField_1.setEnabled(true);
						textField_1.setEditable(true);
						lblTheLengthOf.setText("ENTER THE KEY MESSAGE HERE. PRESS ENTER TO CONTINUE.");
					}
				}
			}
		});

		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					keyMessage = textField_1.getText().toString();

					if(keyMessage.length() < userMessage.length() || keyMessage.length() == 0) {
						lblTheLengthOf.setText("Length of key message must be more than the above message!");
					} else {
						lblTheLengthOf.setText("");
						lblNewLabel.setText("CHOOSE A NUMBER THEN PRESS EITHER THE ENCODE OR DECODE BUTTON");
						spinner.setEnabled(true);
					}
				}
			}
		});


		/*Desktop d = Desktop.getDesktop();
		try {
			d.browse(new URI("http://bing.com"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}*/
	}
}