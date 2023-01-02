//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class AcdCollection extends JInternalFrame implements ActionListener
 { 
	JLabel consumerno,areacode,mtrcode,a_cd ;
	
	JTextField acdtobevoll,acdcollect,m_r,oyec,tariff,ints,unit_con,area_code,day_code,mtr_code,acd;
	JComboBox combobox;
	JButton qry,ofset,recipt,exit;
	
	public AcdCollection(String title)
  	{


		super("ACD COLLECTION WINDOW");
		setLayout(null);
		consumerno=new JLabel("Consumer Number");


			try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		combobox=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		//combobox=new JComboBox();
		combobox.setPreferredSize(new Dimension(100,20));

		//qry=new JButton("Quierry");
		
		FlowLayout layout=new FlowLayout();
		ofset=new JButton("Offset");
		recipt=new JButton("Receipt");
		exit=new JButton("exit");

		JPanel p1,p2,p3,p4,p5,p6,p7;
		setLocation(200,150);
	
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,2,0,5));
		p1.add(consumerno);
		p1.add(combobox);
	
		p1.setBounds(30,100,265,30);
		add(p1);

		//p2=new JPanel();
		//p2.setLayout(new FlowLayout());
		//p2.add(qry);
		//p2.setBounds(270,95,90,40);
		//add(p2);
		
		JLabel c=new JLabel("ACD COLLECTION");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(150,0,200));      
		
		        p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(60,50,250,30);
     			p6.add(c);
     			add(p6);
     			
		
		p5=new JPanel();
		p5.setLayout(new GridLayout(1,3,10,10));
		p5.add(ofset);
		p5.add(recipt);
		p5.add(exit);
		p5.setBounds(30,400,300,30);
		add(p5);
	
		JLabel amtc=new JLabel("ACD to be collected");
		acdtobevoll=new JTextField(10);
		JLabel amtcd=new JLabel("ACD  collected");
		acdcollect=new JTextField(10);
;
		p7=new JPanel();
		p7.setLayout(new GridLayout(3,2,0,5));
		p7.add(amtc);
		p7.add(acdtobevoll);
		p7.add(amtcd);
		p7.add(acdcollect);

		p7.setBounds(40,220,265,80);
		add(p7);
		
		
			setLocation(200,70);
		
		exit.addActionListener(this);
		combobox.addActionListener(this);
		}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==exit)
	{
	this.dispose();
	}
			if(e.getSource()==combobox)
			{
			System.out.println("Entered   CON_NO");
			try{

				QueryData qd = new QueryData();
				System.out.println((String)combobox.getSelectedItem());
				String id=(String)combobox.getSelectedItem();
			
				String v = qd.getCdDetails(id.trim()); 
			
				System.out.println("ACD  : " + v);
				if(v!=null)			
					acdtobevoll.setText(v);
				
				}catch(Exception ex){System.out.println("Error in ACD cllection " + ex);}

			}

}

		public static void main(String arg[])
		{
			AcdCollection c = new AcdCollection("COLLECTION WINDOW");
			c.setSize(380,550);
			c.setVisible(true);
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package electricity;

/**
 *
 * @author ASUS
 */
//public class AcdCollection {}