package javaproject;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import javaproject.Items;

import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class update extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int id;

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
	public ArrayList<Items>getItemList(){
		ArrayList<Items>itemList=new ArrayList<Items>();
		Connection  connection=getConnection();
		String query="SELECT * FROM app_database";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("q_id"),rs.getString("question"), rs.getString("ans1"), rs.getString("ans2"),rs.getString("ans3"),rs.getString("ans4"),rs.getString("rightAns"));
				itemList.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	public void show_database() {
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Question", "Answer 1", " Answer 2", "Answer 3", "Answer 4", "Right Answer"},
			},
			new String[] {
				"ID", "Question", "Answer 1", " Answer 2", "Answer 3", "Answer 4", "Right Answer"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(28);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(176);
		table.getColumnModel().getColumn(1).setMinWidth(156);
		table.getColumnModel().getColumn(2).setMinWidth(47);
		ArrayList<Items> list= getItemList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row= new Object[7];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getQues();
			row[2]=list.get(i).getAns1();
			row[3]=list.get(i).getAns2();
			row[4]=list.get(i).getAns3();
			row[5]=list.get(i).getAns4();
			row[6]=list.get(i).getRan();
			
			model.addRow(row);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
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
	public update() {
		setMinimumSize(new Dimension(1200, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setMinimumSize(new Dimension(1200, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(new Color(255, 204, 255));
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 11, 968, 621);
		table.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				id = (int) model.getValueAt(i,0);	
			}
		});
		contentPane.add(table);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				AddNew addNew=new AddNew();
				AddNew.main(null);
				setVisible(false);
			}
		});
		btnAddNew.setBounds(1028, 126, 89, 23);
		contentPane.add(btnAddNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
					new EditPage(id).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 setVisible(false);
				 
			}
		});
		btnEdit.setBounds(1028, 194, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure? You want to delete this?","WARNING",JOptionPane.YES_NO_OPTION);

				if(dialogButton == JOptionPane.YES_OPTION) {
					String query="DELETE FROM `app_database` WHERE q_id='"+id+"'";
					Connection con= getConnection();
					Statement st;
					try {
						st=con.createStatement();
						if(st.executeUpdate(query)==1) {
							DefaultTableModel model=(DefaultTableModel) table.getModel();
							model.setRowCount(0);
							show_database();
						}else {
							JOptionPane.showMessageDialog(null, "Unexpected Error!");
							show_database();
						}
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					}
				else {
					show_database();
					}
			}
		});
		btnDelete.setBounds(1028, 279, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				OptionFrame off=new OptionFrame();
				OptionFrame.main(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(1028, 398, 89, 23);
		contentPane.add(btnBack);

		show_database();
	}
}
