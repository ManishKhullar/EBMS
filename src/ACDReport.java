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
public class ACDReport extends JInternalFrame implements ActionListener
{
	DefaultTableModel tablemodel;
	JTable tab;
	JScrollPane scrollpane;
	JButton print;
	DefaultTableCellRenderer defaulttableceren;
	public ACDReport()
	{
		/*try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception ex)
		{
			System.out.println("Exception in LookAnd Feel");
		}*/
		//this.setOpaque(true);
		setBackground(Color.white);
		defaulttableceren= new DefaultTableCellRenderer();
		print = new JButton("   Print   ");
		tablemodel = new DefaultTableModel();
		Font f = new Font("TimesNewRoman",Font.BOLD,30);
		JLabel l1 = new JLabel("ACD Collection");
		l1.setFont(f);
		//tablemodel.addColumn(l1.getText().toString()); 
		JPanel p = new JPanel();
		p.add(l1);
		p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createEmptyBorder(20,20,20,20)));
		tablemodel.addColumn("Consumer Number");
		tablemodel.addColumn("Net Amount");
		tablemodel.addColumn("ACD Collected");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/electricity","root","");
			PreparedStatement pst = con.prepareStatement("select consumer.conno,demand.netamt,acdcollection.acdcollected from consumer,demand,acdcollection where consumer.conno=demand.conno and consumer.conno=acdcollection.conno");
			ResultSet rs=pst.executeQuery();
			Vector v;
			while(rs.next())
			{
				v=new Vector();
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				tablemodel.addRow(v);
			}
			tab=new JTable(tablemodel);
			tab.setPreferredScrollableViewportSize(new Dimension(600,200));

			tab.setRowHeight(25);
			tab.setGridColor(Color.red);
			print.addActionListener(this);
			scrollpane = new JScrollPane(tab);
			scrollpane.setOpaque(true);
			scrollpane.setBackground(Color.white);
		 }
		catch(Exception ex){System.out.println(ex);}
		getContentPane().add(p,BorderLayout.NORTH);
		getContentPane().add(scrollpane,BorderLayout.CENTER);
		JPanel p1 = new JPanel();
		//p1.setLayout(null);
		//print.setBounds(200,20,50,30);
		p1.add(print,BorderLayout.WEST);
		p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createEmptyBorder(10,10,10,10)));
		getContentPane().add(p1,BorderLayout.SOUTH);
		pack();
	}
	public void actionPerformed(ActionEvent e)
	{	try
	{
		tab.print();
		}catch(PrinterException ex)
		{
			
                    JOptionPane.showMessageDialog(this,"No Printer Connected");
                    JOptionPane.showMessageDialog(this,"PLEASE CONNECT PRINTER TO PRINT");
		}
	}
	public static void main(String arg[])throws Exception
	{
		ACDReport acd = new ACDReport();
		acd.setVisible(true);
	}
}