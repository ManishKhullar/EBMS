//package updated1;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.io.*;
import java.awt.event.*;
import java.awt.print.*;
public class SBcollection extends JInternalFrame implements ActionListener
{
	DefaultTableModel default_table_model;
	JTable tabs;
	JScrollPane scroll_pane;
	JButton print;
	DefaultTableCellRenderer default_cell_render;
	public SBcollection()
	{
		setBackground(Color.white);
		default_cell_render= new DefaultTableCellRenderer();
		print = new JButton("   Print   ");
		default_table_model = new DefaultTableModel();
		Font f = new Font("TimesNewRoman",Font.BOLD,30);
		JLabel l1 = new JLabel("Spot Bill Collection");
		l1.setFont(f);
		//default_table_model.addColumn(l1.getText().toString()); 
		JPanel p = new JPanel();
		p.add(l1);
		p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createEmptyBorder(20,20,20,20)));
		default_table_model.addColumn("Consumer Number");
		default_table_model.addColumn("Dmand");
		default_table_model.addColumn("Collection");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/electricity","root","");
			PreparedStatement pst = con.prepareStatement("select demand.conno,demand.netamt,sbcollection.amtcollected from consumer,demand,sbcollection where consumer.conno=sbcollection.conno and demand.conno=sbcollection.conno ");//and consumer.conno=sbcollection.conno
			ResultSet rs=pst.executeQuery();
			Vector v;
			while(rs.next())
			{
				v=new Vector();
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				default_table_model.addRow(v);
			}
			tabs=new JTable(default_table_model);
			tabs.setPreferredScrollableViewportSize(new Dimension(600,200));

			tabs.setRowHeight(25);
			tabs.setGridColor(Color.green);
			print.addActionListener(this);
			scroll_pane = new JScrollPane(tabs);
			scroll_pane.setOpaque(true);
			scroll_pane.setBackground(Color.white);
		 }
		catch(Exception ex){System.out.println(ex);}
		getContentPane().add(p,BorderLayout.NORTH);
		getContentPane().add(scroll_pane,BorderLayout.CENTER);
		JPanel p1 = new JPanel();
		//p1.setLayout(null);
		//print.setBounds(200,20,50,30);
		p1.add(print,BorderLayout.WEST);
		p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createEmptyBorder(10,10,10,10)));
		getContentPane().add(p1,BorderLayout.SOUTH);
		pack();
	}
	public void actionPerformed(ActionEvent e)
	{	try{
		tabs.print();
		}catch(PrinterException ex)
		{
			JOptionPane.showMessageDialog(this,"No Printer Connected");
		}
	}
	/*public static void main(String arg[])throws Exception
	{
		SBcollection sb = new SBcollection();
		sb.setVisible(true);
	}*/
}