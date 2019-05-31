//package updated1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.border.*;

public class Acd extends JInternalFrame implements ActionListener//,FocusListener
  
 { 
	JLabel consumerno,areacode,daycode,mtrcode,cdavailable,cdreq,acd;
	JComboBox combobox;
	JTextField cd_available,cd_req,a_cd,area_code,day_code,mtr_code;
	JButton ok,edit,cancel;
	String p[]={"6months","12months"};
	
	public Acd (String title)
  	{
		super("A C D");
		setLayout(null);
		consumerno=new JLabel("Consumer Number");
		try
		{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		combobox=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		//combobox=new JComboBox();
		combobox.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		String area[] = {"A01","A02","A03","A04","A05","B01","B02","B03","B04","B05"};
		area_code=new JTextField(10);
		
		mtrcode=new JLabel("Meter Reader Code");
		String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code=new JTextField(10);
		
		cdreq=new JLabel("C D Required");
		cd_req=new JTextField(10);
		
		cdavailable=new JLabel("CD amount available");
		cd_available=new JTextField(10);
		acd=new JLabel("A  C  D");
		a_cd=new JTextField(10); //read from the database
		
		JLabel labe=new JLabel("Issue ACD notice");
		ok=new JButton("ok");
		cancel=new JButton("Cancel");
		edit=new JButton("Edit");
		
		FlowLayout layout=new FlowLayout();
		
		JPanel p1,p2,p3,p4,p5;
		p1=new JPanel();
		p1.setLayout(new GridLayout(6,2,6,6));

		p1.add(consumerno);
	   	p1.add(combobox);	
		p1.add(areacode);
		p1.add(area_code);
		p1.add(mtrcode);
		p1.add(mtr_code);
		
	    p1.add(cdreq);
	    p1.add(cd_req);
	    p1.add(cdavailable);
	    p1.add(cd_available);
	    p1.add(acd);
	    p1.add(a_cd);
	    
	    	
		p1.setBounds(80,100,240,180);
		add(p1);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(1,3,10,10));

		p2.add(ok);
		p2.add(edit);
		p2.add(cancel);
		
		p2.setBounds(100,400,270,30);
		add(p2);
		
		p3=new JPanel();
		
		p3.add(labe);
		p3.setLayout(new GridLayout(1,1,0,0));
        p3.setBounds(100,350,200,30);
		add(p3);
		
		
		
		JLabel c=new JLabel("A C D ");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(200,0,20)); 
		
		
		p4=new JPanel();
		p4.setLayout(new FlowLayout());
     	p4.setBounds(20,30,350,50);
     	p4.add(c);
     	add(p4);  
		setLocation(200,70);
		
		cancel.addActionListener(this);
		combobox.addActionListener(this);
		ok.addActionListener(this);
       }
		     public void actionPerformed(ActionEvent e)
     		     {
     		     	if(e.getSource()==cancel)
     		     	{
     		     		this.dispose();
     		     	}

		if(e.getSource()==combobox)
			{
					System.out.println("Entered   CON_NO");
			try{
				QueryData qd = new QueryData();
				String id=(String)combobox.getSelectedItem();
				Vector v = qd.getConsumerDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
				Enumeration em=v.elements();
				area_code.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
				mtr_code.setText((String)em.nextElement());
					}catch(Exception ex){System.out.println("Error in ACD: " + ex);}		
		}
		if(e.getSource()==cd_req)
			{
					System.out.println("Entered   cd_req");
			try{

				QueryData qd = new QueryData();	
				}catch(Exception ex){System.out.println("Error in ACD cd_req: " + ex);}		
		}


//________________________________________________________________

		if(e.getSource()==cd_available)
			{
					System.out.println("Entered   cd_available");
			try{

				QueryData qd = new QueryData();
				
				
					String id=(String)combobox.getSelectedItem();
					Vector v = qd.getCd(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					Enumeration em=v.elements();
					cd_available.setText((String)em.nextElement());
					
				}catch(Exception ex){System.out.println("Error in ACD cd_available: " + ex);}		
		}
//___________________________________________________________________________
		
else if(e.getSource()==ok)
				{
				try{
					QueryData qd = new QueryData();
					PreparedStatement pst2 = qd.getConnect().prepareStatement("insert into acd values(?,?,?,?,?,?)");
					pst2.setString(1,(String)combobox.getSelectedItem());
					pst2.setString(2,area_code.getText());
					pst2.setString(3,mtr_code.getText());
					pst2.setInt(4,Integer.parseInt(cd_req.getText()));;
					pst2.setInt(5,Integer.parseInt(cd_available.getText()));
					pst2.setInt(6,Integer.parseInt(a_cd.getText()));
					
					int i=pst2.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"ACD demand generated","ACD ",1);
					}
					

					}catch(Exception ex){System.out.println("Inside Save   :" +ex);}
				}
     		 }
		public static void main(String arg[])
		{
				Acd acd = new Acd("Addl: C.D");
			    acd.setSize(400,550);
				 acd.setVisible(true);
		}
}