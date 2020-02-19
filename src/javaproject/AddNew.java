package javaproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddNew extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gre_math?autoReconnect=true&useSSL=false", "root", "sarwar");
			return con;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
			}
		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNew frame = new AddNew();
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
	public AddNew() {
		setMinimumSize(new Dimension(1200, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.setMinimumSize(new Dimension(1200, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNew = new JLabel("Add New");
		lblAddNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNew.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblAddNew.setBounds(253, 43, 378, 41);
		contentPane.add(lblAddNew);
		
		JLabel lblQuestion = new JLabel("Question : ");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(91, 148, 178, 42);
		contentPane.add(lblQuestion);
		
		JLabel lblOption = new JLabel("Option 1:");
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOption.setBounds(133, 338, 111, 30);
		contentPane.add(lblOption);
		
		JLabel lblOption_1 = new JLabel("Option 2: ");
		lblOption_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOption_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption_1.setBounds(145, 379, 93, 30);
		contentPane.add(lblOption_1);
		
		JLabel lblOption_2 = new JLabel("Option 3: ");
		lblOption_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOption_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption_2.setBounds(145, 420, 93, 30);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("Option 4: ");
		lblOption_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOption_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption_3.setBounds(145, 464, 93, 31);
		contentPane.add(lblOption_3);
		
		JLabel lblRightAnswer = new JLabel("Right Answer:");
		lblRightAnswer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRightAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblRightAnswer.setBounds(76, 506, 200, 41);
		contentPane.add(lblRightAnswer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(279, 160, 692, 84);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		textField = new JTextField();
		textField.setBounds(279, 345, 390, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(279, 386, 390, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(279, 430, 390, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(279, 471, 390, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(279, 519, 390, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="INSERT INTO `app_database` (`q_id`, `question`, `ans1`, `ans2`, `ans3`, `ans4`, `rightAns`) VALUES (NULL,'"+textArea.getText()+"', '"+textField.getText()+"',"
						+ "'"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"');";
				Connection con= getConnection();
				Statement st;
				try {
					st=con.createStatement();
					if(st.executeUpdate(query)==1) {
						
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
					}else {
						JOptionPane.showMessageDialog(null, "Data Not Inserted");
					}
					
					update up= new update();
					update.main(null);
					setVisible(false);
					} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(416, 610, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				update up=new update();
				update.main(null);
				setVisible(false);
			}
		});
		btnCancel.setBounds(580, 610, 89, 23);
		contentPane.add(btnCancel);
	}

}
