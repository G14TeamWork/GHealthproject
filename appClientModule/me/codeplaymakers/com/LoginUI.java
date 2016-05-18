package me.codeplaymakers.com;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JRadioButton;
import java.awt.Canvas;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterUserName;
	private JPasswordField passwordField;
	private JLabel label;
	private JButton btnForgotPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\galme\\workspace\\G14_Prototype_Client\\logogray.png"));
		setFont(new Font("FrankRuehl", Font.BOLD | Font.ITALIC, 17));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterUserName = new JTextField();
		txtEnterUserName.setBounds(214, 128, 160, 22);
		txtEnterUserName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(txtEnterUserName);
		txtEnterUserName.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnSubmit.setBounds(156, 198, 160, 40);
		contentPane.add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 163, 160, 22);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(passwordField);
		
		JLabel lblEnterUserName = new JLabel(" Enter user name:");
		lblEnterUserName.setBounds(99, 131, 123, 16);
		lblEnterUserName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEnterUserName);
		
		JLabel lblEnterPassword = new JLabel("Enter password:");
		lblEnterPassword.setBounds(109, 166, 113, 19);
		lblEnterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEnterPassword);
		
		label = new JLabel("");
		label.setBounds(156, 0, 123, 134);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("C:\\Users\\galme\\workspace\\G14_Prototype_Client\\logologin.png"));
		contentPane.add(label);
		
		btnForgotPassword = new JButton("Forgot password?");
		btnForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnForgotPassword.setBounds(166, 250, 135, 25);
		contentPane.add(btnForgotPassword);
	}
}
