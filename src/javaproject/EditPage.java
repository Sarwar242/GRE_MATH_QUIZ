package javaproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class EditPage extends JFrame {

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
	private JTextArea textArea;
	static int id;

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
					EditPage frame = new EditPage();
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
	public void initsComponents(){
		setMinimumSize(new Dimension(1200, 700));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
	contentPane.setMinimumSize(new Dimension(1200, 700));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblAddNew = new JLabel("Edit Question");
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
	
	textArea = new JTextArea();
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
	
	JButton btnUpdate = new JButton("Update");
	btnUpdate.addActionListener(new ActionListener() {
		private PreparedStatement pst;
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				Connection con=getConnection();
				pst = null;
				String query="UPDATE `app_database` SET `question`= ?, `ans1`= ?, `ans2`= ? ,`ans3`= ?, `ans4`= ?, `rightAns`= ? where q_id='"+id+"'";
				pst=con.prepareStatement(query);
				pst.setString(1,textArea.getText() );
				pst.setString(2, textField.getText());
				pst.setString(3, textField_1.getText());
				pst.setString(4, textField_2.getText());
				pst.setString(5, textField_3.getText());
				pst.setString(6, textField_4.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				@SuppressWarnings("unused")
				update up=new update();
				update.main(null);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnUpdate.setBounds(293, 610, 89, 23);
	contentPane.add(btnUpdate);
}
	public EditPage(int ques_id) throws SQLException {
		id=ques_id;
		initsComponents();
		updateData(id);
	}	
	private void updateData(int i) throws SQLException {
		Connection  connection=getConnection();
		//System.out.println(a);
		String query="SELECT * FROM app_database where q_id='"+i+"'";
		Statement st=null;
		ResultSet rs = null;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				textArea.setText(rs.getString("question"));
				textField.setText(rs.getString("ans1"));
				textField_1.setText(rs.getString("ans2"));
				textField_2.setText(rs.getString("ans3"));
				textField_3.setText(rs.getString("ans4"));
				textField_4.setText(rs.getString("rightAns"));
			}
			
	}catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally {
				connection.close();
				rs.close();
			}
	}
	public EditPage() {
		initsComponents();
	}	
}
