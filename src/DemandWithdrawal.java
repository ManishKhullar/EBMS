//package updated1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class DemandWithdrawal extends JInternalFrame implements ActionListener
 { 
	JLabel consumernumber,totaldemand,withdrawal_amount,demand_id,daycode;
	JComboBox con_no_combobox,area_code,day_code_combobox;
	JTextField total_demand,total_demand_units,withdrawals_amount,withdrawalsu_units,demandid;
	 JTextArea note;
	JButton ok,edit,cancel;
	
	public DemandWithdrawal(String title)
  	{


		super("Demand withdrawal");
		setLayout(null);
		consumernumber=new JLabel("CONSUMER NUMBER");

			try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		con_no_combobox=new JComboBox(v);
			}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		//con_no_combobox=new JComboBox();
		con_no_combobox.setPreferredSize(new Dimension(100,20));
		demand_id=new JLabel("Demand ID");
		demand_id.setForeground(new Color(170,30,120)); 
		//String area[] = {"A01","A02","A03","A04","A05","B01","B02","B03","B04","B05"};
		demandid=new JTextField(10);
		daycode=new JLabel("DAYCODE");
		day_code_combobox=new JComboBox();
		JLabel totaldemandu=new JLabel("TOTAL UNITS");
		 total_demand_units=new JTextField(10);
		totaldemand=new JLabel("TOTAL DEMAND");
		total_demand=new JTextField(10);
		JLabel withdrawalu=new JLabel("WITHDRAWAL UNITS");
		withdrawalsu_units=new JTextField(10);
		
		withdrawal_amount=new JLabel("WITHDRAWAL AMOUNT");
		withdrawals_amount=new JTextField(10);
		note=new JTextArea(10,5);
		ok=new JButton("UPDATE");
		edit=new JButton("EDIT");
		cancel=new JButton("CANCEL");
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p5,p6;

		p1=new JPanel();
	
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();


		p1.setLayout(new GridLayout(2,2,10,10));
		p2.setLayout(new GridLayout(4,2,10,10));
		p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		p4.setLayout(new GridLayout(1,3,10,10));
		p5.setLayout(layout);
	//	p6.setLayout(new GridLayout(3,1));

		p1. add(consumernumber);
		p1.add(con_no_combobox);
		p1.add(demand_id);
		p1.add(demandid);
		//p1.add(new JLabel("Choose an Area Code and Consumer Number"));
		p1.setPreferredSize(new Dimension(280,50));
		p2.add(totaldemandu);
		p2.add(total_demand_units);
		p2.add(totaldemand);
		p2.add(total_demand);
		p2.add(withdrawalu);
		p2.add(withdrawalsu_units);

		p2.add(withdrawal_amount);
		p2.add(withdrawals_amount);

		p3.add(new JLabel("Note  :"));
		p3.add(note);

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
		p5.add(p1);
		p5.add(p2);

		p5.setBounds(80,100,400,190);
		//p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(20,20,20,20)));
		p5.setBorder(BorderFactory.createEtchedBorder());
		p3.setBounds(80,300,400,75);
		p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));
		p4.setBounds(140,400,300,30);

		add(p5);
		add(p3);
		add(p4);
		
		setSize(550,550);
		setLocation(150,80);
		setVisible(true);
		
		
		
		JLabel c=new JLabel("DEMAND WITHDRAWAL");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(200,0,20)); 
		
		
		p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(100,30,370,100);
     			p6.add(c);
     			add(p6);  
		
		cancel.addActionListener(this);
		con_no_combobox.addActionListener(this);
		
		}
	
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
		
	
	
	
	       if(e.getSource()==con_no_combobox)
			{
					System.out.println("Entered   CON_NO");
			try{
				QueryData qd = new QueryData();
				System.out.println((String)con_no_combobox.getSelectedItem());
				String id=(String)con_no_combobox.getSelectedItem();
	
				  //Vector v8 = qd.getDepositDetails(id.trim()); 
				Vector v8 = qd.getDmdwithdraw(id);
				
				Enumeration em = v8.elements();
				System.out.println("ELements in V8 : " + v8);
				demandid.setText((String)em.nextElement());
				total_demand_units.setText((String)em.nextElement());
				total_demand.setText((String)em.nextElement());
				
			/*	mr_code3.setText((String)em5.nextElement()); 
				Vector v4 = qd.getMgDetails(id.trim());  
				System.out.println("ELements in V4 : " + v4);
				Enumeration em4=v4.elements();
				lemgamt.setText((String)em4.nextElement());
				scmgamt.setText((String)em4.nextElement());
				lramt.setText((String)em4.nextElement());
				ilemg.setText((String)em4.nextElement());
				iscmg.setText((String)em4.nextElement());
				ilr.setText((String)em4.nextElement());
				m77.setText((String)em4.nextElement());
				System.out.println("Date     : " + m77.getText());
				//System.out.println("Ending month" + em4.nextElement());*/
				}catch(Exception ex){System.out.println("Error in DW " + ex);}		
		}
	}

	
		
		
	
	/*	else if(e.getSource()==ok)
				{
				try{
					QueryData qd = new QueryData();
					PreparedStatement pst2 = qd.getConnect().prepareStatement("insert into demand values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst2.setString(1,(String)area_code.getSelectedItem());
					pst2.setString(2,(String)mtr_code.getSelectedItem());
					pst2.setString(3,(String)con_no_combobox.getSelectedItem());
					pst2.setString(4,(String)pre_reading.getText());
					//pst2.setString(5,(String)present_reading.getText());
					//pst2.setString(6,(String)unit_con.getText());
					
					
					
					
					//pst2.setInt(4,Integer.parseInt(pre_reading.getText()));
					pst2.setInt(5,Integer.parseInt(present_reading.getText()));
					pst2.setInt(6,Integer.parseInt(unit_con.getText()));
					pst2.setString(7,(String)demandid.getText());
					pst2.setString(8,(String)f_c.getText());
					pst2.setString(9,(String)e_c.getText());
					pst2.setString(10,(String)dty.getText());
					pst2.setString(11,(String)m_r.getText());
					pst2.setString(12,(String)dem.getText());
					pst2.setString(13,(String)sub.getText());
					pst2.setString(14,(String)adv.getText());
					pst2.setString(15,(String)arrear.getText());
					pst2.setString(16,(String)tot.getText());
					pst2.setString(17,(String)cdint.getText());
					pst2.setString(18,(String)net_amt.getText());
					
					String ds,ys,ms,dates;
					ds=(String)d1.getSelectedItem();
					ms=(String)m1.getSelectedItem();
					ys=(String)y1.getSelectedItem();
					dates=ds+"/"+ms+"/"+ys;
					pst2.setString(19,dates);
					
					String da,ya,ma,dates1;
					da=(String)d2.getSelectedItem();
					ma=(String)m2.getSelectedItem();
					ya=(String)y2.getSelectedItem();
					dates1=da+"/"+ma+"/"+ya;
					pst2.setString(20,dates1);
					
					
					String db,yb,mb,dates2;
					db=(String)d3.getSelectedItem();
					mb=(String)m3.getSelectedItem();
					yb=(String)y3.getSelectedItem();
					dates2=db+"/"+mb+"/"+yb;
					pst2.setString(21,dates2);
					
					
				
					int i=pst2.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"Demand Generated","NEW DEMAND ",1);
					}
					

					}catch(Exception ex){System.out.println("Inside Save   :" +ex);}
				

				}
		}*/
		
		public static void main(String arg[])
		{
			/*DemandWithdrawal w = new DemandWithdrawal("Demand Withdrawal");
			w.setSize(550,550);
	
			w.setVisible(true);*/
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
//public class DemandWithdrawal {}