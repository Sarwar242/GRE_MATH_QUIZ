package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class PlayQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea;
	private int id=1;
	private int rowCount =0;
	private String corrAns=null;

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
	public void Questions(){
		if(rowCount>0) {
		Connection  connection=getConnection();
		String query="SELECT * FROM app_database Where q_id='"+id+"'";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				textArea.setText(rs.getString("question"));
				textField.setText(rs.getString("ans1"));
				textField_1.setText(rs.getString("ans2"));
				textField_2.setText(rs.getString("ans3"));
				textField_3.setText(rs.getString("ans4"));			
				corrAns=rs.getString("rightAns");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayQuiz frame = new PlayQuiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PlayQuiz() {
		Connection  connection=getConnection();
		String query2="SELECT * FROM app_database";
		Statement st2;
		ResultSet rs2 = null;
		try {
			st2=connection.createStatement();
			rs2=st2.executeQuery(query2);
			rowCount = rs2.last() ? rs2.getRow() : 0; 
			rs2.beforeFirst();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(rowCount);
		setMinimumSize(new Dimension(1200, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1200, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblD = new JLabel("D.");
		lblD.setSize(20, 20);
		lblD.setLocation(213, 424);
		contentPane.add(lblD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 56, 1007, 115);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBorder(new EmptyBorder(7, 10, 7, 6));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBackground(new Color(255, 204, 255));
		textArea.setSelectionColor(Color.RED);
		textArea.setForeground(Color.MAGENTA);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(393, 198, 280, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblB = new JLabel("B.");
		lblB.setBounds(213, 286, 46, 14);
		contentPane.add(lblB);
		JLabel lblC = new JLabel("C.");
		lblC.setBounds(213, 352, 46, 21);
		contentPane.add(lblC);
		
		JLabel lblA = new JLabel("A. ");
		lblA.setBounds(213, 209, 46, 14);
		contentPane.add(lblA);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setEditable(false);
		textField_1.setBounds(393, 276, 280, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setBounds(393, 345, 280, 34);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setEditable(false);
		textField_3.setBounds(393, 417, 280, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNext.setRequestFocusEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NextQues();
			}
		});
		btnNext.setBounds(420, 598, 128, 52);
		contentPane.add(btnNext);
		
		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ans=null;
				 ans=textField.getText();
				if(ans.equals(corrAns)) {
					JOptionPane.showMessageDialog(null, "Congratulations, Your answer is correct.");
					NextQues();
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, The Correct answer is: "+corrAns+".");
					NextQues();
				}
				
			}
		});
		btnA.setBounds(223, 528, 89, 23);
		contentPane.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans=null;
				ans=textField_1.getText().toString();
				if(ans.equals(corrAns)) {
					JOptionPane.showMessageDialog(null, "Congratulations, Your answer is correct.");
					NextQues();
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, The Correct answer is: "+corrAns+".");
					NextQues();
				}
			}
		});
		btnB.setBounds(342, 528, 89, 23);
		contentPane.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans=null;
				ans=textField_2.getText();
				if(ans.equals(corrAns)) {
					JOptionPane.showMessageDialog(null, "Congratulations, Your answer is correct.");
					NextQues();
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, The Correct answer is: "+corrAns+".");
					NextQues();
				}
			}
			
		});
		btnC.setBounds(459, 528, 89, 23);
		contentPane.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans=null;
				ans=textField_3.getText();
				if(ans.equals(corrAns)) {
					JOptionPane.showMessageDialog(null, "Congratulations, Your answer is correct.");
					NextQues();
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, The Correct answer is: "+corrAns+".");
					NextQues();
				}
			}
		});
		btnD.setBounds(584, 528, 89, 23);
		contentPane.add(btnD);
		
		JLabel lblQuestion = new JLabel("Question: ");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(57, 74, 81, 52);
		contentPane.add(lblQuestion);
		
		JButton btnBack = new JButton("Back");
		btnBack.setRequestFocusEnabled(false);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionFrame pf=new OptionFrame();
				OptionFrame.main(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 28, 89, 23);
		contentPane.add(btnBack);
		Questions();
		
	}
	protected void NextQues() {
		if(id>=rowCount) {
			id=1;
			Questions();
		}
		else {
			id=id+1;
			Questions();
		}
		
	}

}
