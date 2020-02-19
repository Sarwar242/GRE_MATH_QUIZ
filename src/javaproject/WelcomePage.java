package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class WelcomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public WelcomePage() {
		setBackground(new Color(255, 204, 204));
		setMinimumSize(new Dimension(1250, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setMinimumSize(new Dimension(1250, 700));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(80, 60, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField("Welcome to gre - Math Quiz Application.");
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 32));
		textField.setBorder(new EmptyBorder(10, 10, 0, 0));
		textField.setBounds(231, 115, 677, 74);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFocusable(false);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OptionFrame of=new OptionFrame();
				OptionFrame.main(null);
				setVisible(false);
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnEnter.setBounds(495, 314, 191, 56);
		contentPane.add(btnEnter);
	
	
		
	}
}
