package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class OptionFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtChooseToEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionFrame frame = new OptionFrame();
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
	public OptionFrame() {
		setMinimumSize(new Dimension(1250, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 255));
		contentPane.setMinimumSize(new Dimension(1250, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtChooseToEnter = new JTextField();
		txtChooseToEnter.setBackground(new Color(0, 51, 255));
		txtChooseToEnter.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtChooseToEnter.setHorizontalAlignment(SwingConstants.CENTER);
		txtChooseToEnter.setText("Choose to Enter");
		txtChooseToEnter.setEditable(false);
		txtChooseToEnter.setBounds(479, 46, 396, 54);
		contentPane.add(txtChooseToEnter);
		txtChooseToEnter.setColumns(10);
		
		JButton btnPlayQuiz = new JButton("Play Quiz");
		btnPlayQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayQuiz pq=new PlayQuiz();
				PlayQuiz.main(null);
				setVisible(false);
				
			}
		});
		btnPlayQuiz.setBounds(604, 163, 119, 42);
		contentPane.add(btnPlayQuiz);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNew an=new AddNew();
				AddNew.main(null);
				setVisible(false);
			}
		});
		btnAddNew.setBounds(604, 236, 133, 46);
		contentPane.add(btnAddNew);
		
		JButton btnUpdateOrDelete = new JButton("Update or Delete");
		btnUpdateOrDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update up=new update();
				update.main(null);
				setVisible(false);
			}
			
		});
		btnUpdateOrDelete.setBounds(599, 312, 149, 48);
		contentPane.add(btnUpdateOrDelete);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setBounds(601, 394, 119, 42);
		contentPane.add(btnAbout);
	}
}
