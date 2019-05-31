//package updated1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Ccadj extends JInternalFrame implements ActionListener
 { 
	JLabel consumer_number,areacode,daycode,mtrcode,officename,demandtobeadjust,demand_id;
	JComboBox con_no_combobox,area_code,day_code,mtr_code_combobox,office_name_combobox;
	JTextField demandtoadjusted,demandid;
	
	JButton ok,edit,cancel;
	
	public Ccadj (String title)
  	{


		super("Demand Adjustment");
		setLayout(null);
		consumer_number=new JLabel("Consumer Number");
		con_no_combobox=new JComboBox();
		con_no_combobox.setPreferredSize(new Dimension(100,20));
		demand_id=new JLabel("Demand ID");
demand_id.setForeground(new Color(150,100,150)); 
		demandid=new JTextField(10);
		mtrcode=new JLabel("Meter Reader Code");
		String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code_combobox=new JComboBox(mtrcd);
		officename=new JLabel("Name of the Office");
		
		String office[]={"Shahtri nager ,yerwada","Pune,pune"};
		office_name_combobox=new JComboBox(office);
		demandtobeadjust=new JLabel("Demand to be adjusted");
		demandtoadjusted=new JTextField(10); //read from the database
		
		ok=new JButton("Adjust");
		cancel=new JButton("Cancel");
		edit=new JButton("Edit");
		
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p6;

		p1=new JPanel();

		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1. add(consumer_number);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(con_no_combobox);		
		p1.add(Box.createRigidArea(new Dimension(30,0)));
		p1.add(demand_id);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(demandid);
		p3=new JPanel();
		p3.setLayout(new GridLayout(2,2,10,10));
		p3.add(officename);
		p3.add(office_name_combobox);     
		p3.add(demandtobeadjust);
		p3.add(demandtoadjusted);        
		
		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
			setLocation(120,70);

		p1.setBounds(80,100,450,30);
		add(p1);
		//p2.setBounds(320,138,212,30);
		//add(p2);
		p3.setBounds(80,180,450,60);
		add(p3);
		p4.setBounds(100,270,380,30);
		add(p4);
		
		
		JLabel c=new JLabel("DEMAND ADJUSTMENT");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(200,0,20)); 
		
		
		p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(100,30,350,50);
     			p6.add(c);
     			add(p6);  
		
		cancel.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
		}
	public static void main(String arg[])
		{
		/*	Ccadj cadj = new Ccadj("Current Charge Adjustment");
			cadj.setSize(600,550);
			cadj.setVisible(true);*/
	}
}