//package updated1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;

public class Demand extends JInternalFrame implements ActionListener,FocusListener
 { 
	JLabel consumernumber,areacode,previous_reading,presentreading,meter_reader_code,units_consumed ;
	
	JTextField  cld,ph,r_f,ta_riff,dty,net_amt,cdint,tot,arrear,dem,sub,dm_id,f_c,e_c,m_r,pre_reading,present_reading,ints,unit_con,adv;
	JComboBox d1,d2,d3,m1,m2,m3,y1,y2,y3,area_code,day_code,meter_code,combobox;
	JButton query,show_bill_details,meter_reading_details,exit,edit,ok;
	String dw[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"Month","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
String yw[]={"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	String ac[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
String mc[]={"1","2","3","4","5","6","7","8"};
	Vector v2=new Vector();
	
	public 	Demand(String title)
  	{

		super("DEMAND GENERATION WINDOW");
		setLayout(null);
		consumernumber=new JLabel("Consumer Number");

	


		//combobox=new JComboBox();
		
		areacode=new JLabel("Area code");
		area_code=new JComboBox(ac);
		meter_reader_code=new JLabel("Meter Reader Code");
		meter_code=new JComboBox(mc);
		area_code.addActionListener(this);
		meter_code.addActionListener(this);
		
		combobox=new JComboBox(v2);
		JLabel Tariff=new JLabel("Tariff");
		ta_riff=new JTextField(10);
JLabel phase=new JLabel("Phase");
ph=new JTextField(10);

JLabel clds=new JLabel("CLD");
cld=new JTextField(10);
	                   combobox.setPreferredSize(new Dimension(100,20));
		//System.out.println("Elements in V2 " + v2);
		previous_reading=new JLabel("Previous Reading");
		pre_reading=new JTextField(10); //read from the database
		presentreading=new JLabel("Present Reading");
		present_reading=new JTextField(10);
		units_consumed=new JLabel("Units consumed");
		unit_con=new JTextField(10);
		unit_con.addFocusListener(this);

		JLabel dmid=new JLabel("Demand ID");
		dmid.setForeground(new Color(200,0,20)); 
		dm_id=new JTextField(10);
		
		query=new JButton("Querry");
		
		FlowLayout layout=new FlowLayout();
		show_bill_details=new JButton("Show Bill details");
		
		meter_reading_details=new JButton("Meter Reading details");

		exit=new JButton("exit");
		ok=new JButton("Save");
		//cancel=new JButton("Cancel");
		edit=new JButton("Edit");

		JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;

	
		p1=new JPanel();
		p1.setLayout(new GridLayout(11,2,0,5));
		
		p1.add(areacode);
		p1.add(area_code);		
		p1.add(meter_reader_code);
		p1.add(meter_code);

		p1.add(consumernumber);
		p1.add(combobox);
		
		p1.add(Tariff);
		p1.add(ta_riff);

		p1.add(phase);
		p1.add(ph);
		
		p1.add(clds);
		p1.add(cld);
		
		p1.add(previous_reading);
		p1.add(pre_reading); 
		p1.add(presentreading);
		p1.add(present_reading);
		p1.add(units_consumed);
		p1.add(unit_con);

		p1.add(dmid);
		p1.add(dm_id);
		p1.setBounds(10,100,250,260);
		add(p1);

		p2=new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(query);
		p2.setBounds(680,350,90,40);
		add(p2);
		
		JLabel c=new JLabel("GENERATE / EDIT DEMAND");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(50,0,200));      
		
		        p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(280,30,350,50);
     			p6.add(c);
     			add(p6);
     			//panel1.add(p65);
			
		
		p5=new JPanel();
		p5.setLayout(new GridLayout(1,3,10,10));
		p5.add(show_bill_details);
		p5.add(meter_reading_details);
		p5.add(exit);
		p5.add(ok);
		p5.add(edit);
		
		p5.setBounds(10,470,850,30);
		add(p5);
	
		JLabel fc=new JLabel("Fixed Charge");
		f_c=new JTextField(10);
		JLabel ec=new JLabel("Energy Charge");
		e_c=new JTextField(10);
		
		JLabel duty=new JLabel("DUTY TO GOVT:");
		dty=new JTextField(10);
		
		JLabel mr=new JLabel("Meter Rent");
		m_r=new JTextField(10);
		
		JLabel rf=new JLabel("Re con:  fee");
		r_f=new JTextField(10);
		
		JLabel demd=new JLabel("Demand for  ..... ");
		dem=new JTextField(10);
		
		JLabel subsi=new JLabel("Subsidy");
		sub=new JTextField(10);
		JLabel prebal=new JLabel("Previous arrears");
		arrear=new JTextField(10);


		JLabel ad=new JLabel("Advance paid");
		adv=new JTextField(10);
		

		
		JLabel total=new JLabel("Total");
		tot=new JTextField(10);	
		JLabel intcd=new JLabel("Intrest on CD");
		cdint=new JTextField(10);
		JLabel netamt=new JLabel("NET AMOUNT PAYABLE");
		net_amt=new JTextField(10);	
		
		p7=new JPanel();
		p7.setLayout(new GridLayout(12,2,0,10));
		p7.add(fc);
		p7.add(f_c);
		f_c.setEditable(false);
		p7.add(ec);
		p7.add(e_c);
				e_c.setEditable(false);
		p7.add(duty);
		p7.add(dty);
		dty.setEditable(false);
		p7.add(mr);
		p7.add(m_r);
		m_r.setEditable(false);
		
		p7.add(rf);
		p7.add(r_f);
		p7.add(demd);
		p7.add(dem);
		p7.add(subsi);
		p7.add(sub);

		p7.add(ad);
		p7.add(adv);

		p7.add(prebal);
		p7.add(arrear);

		p7.add(total);
		p7.add(tot);
		p7.add(intcd);
		p7.add(cdint);
		p7.add(netamt);
		p7.add(net_amt);
		p7.setBounds(352,100,270,350);
		add(p7);
		
		JLabel bdate=new JLabel("Bill Date");
		d1=new JComboBox(dw);
		m1=new JComboBox(mw);
		y1=new JComboBox(yw);
		JLabel ddate=new JLabel("Due Date");
		d2=new JComboBox(dw);
		m2=new JComboBox(mw);
		y2=new JComboBox(yw);
		JLabel disdate=new JLabel("Disconnnection date");
		d3=new JComboBox(dw);
		m3=new JComboBox(mw);
		y3=new JComboBox(yw);
		
		p8=new JPanel();
		p8.setLayout(new GridLayout(1,1,10,10));
		p8.add(bdate);
		p8.setBounds(650,100,120,20);
		add(p8);
		
		p9=new JPanel();
		p9.setLayout(new GridLayout(1,1,0,10));
		p9.add(d1);
		p9.add(m1);
	 	 p9.add(y1);
		p9.setBounds(650,120,180,20);
		add(p9);
	
		
		p10=new JPanel();
		p10.setLayout(new GridLayout(1,1,10,10));
		p10.add(ddate);
		p10.setBounds(650,140,180,20);
		add(p10);
		
		p11=new JPanel();
		p11.setLayout(new GridLayout(1,1,0,10));
		p11.add(d2);
		p11.add(m2);
	   	p11.add(y2);
		p11.setBounds(650,160,180,20);
		add(p11);
		
		p12=new JPanel();
		p12.setLayout(new GridLayout(1,1,10,10));
		p12.add(disdate);
		p12.setBounds(650,180,180,20);
		add(p12);
		
		p13=new JPanel();
		p13.setLayout(new GridLayout(1,1,0,10));
		p13.add(d3);
		p13.add(m3);
	    	p13.add(y3);
		p13.setBounds(650,200,180,20);
		add(p13);
		
		
			setLocation(80,70);
			
		exit.addActionListener(this);
		combobox.addActionListener(this);
		ok.addActionListener(this);
		f_c.addFocusListener(this);
		e_c.addFocusListener(this);
		dty.addFocusListener(this);
		m_r.addFocusListener(this);
		r_f.addFocusListener(this);
		dem.addFocusListener(this);
		sub.addFocusListener(this);
		tot.addFocusListener(this);
		net_amt.addFocusListener(this);
		}
		public void focusGained(FocusEvent e)
		{
			if(e.getSource()==unit_con)
			{
				long pre=Integer.parseInt(present_reading.getText().trim());
				long prev=Integer.parseInt(pre_reading.getText().trim());
				long v=pre-prev;
				unit_con.setText(""+v);
			
			}
			
			else if(e.getSource()==f_c)
			{
				System.out.println("Lost Focused from Tarif");
				if((ta_riff.getText()).trim().equals("IA"))
				{
					long f=0;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				if((ta_riff.getText()).trim().equals("II"))
				{
					long f=1990;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
				
				if((ta_riff.getText()).trim().equals("III"))
				{
					long c=Integer.parseInt(cld.getText().trim());
					long f=c*1350/100000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
					if((ta_riff.getText()).trim().equals("V"))
				{
					long c=Integer.parseInt(cld.getText().trim());
					long f=c*600/100000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
				
					if((ta_riff.getText()).trim().equals("VIA"))
				{
					long c=Integer.parseInt(cld.getText().trim());
					long f=c*4000/100000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
				
					if((ta_riff.getText()).trim().equals("VIB"))
				{
					long c=Integer.parseInt(cld.getText().trim());
					long f=c*5500/100000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
				
					if((ta_riff.getText()).trim().equals("VIC"))
				{
					long c=Integer.parseInt(cld.getText().trim());
					long f=c*17000/100000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
				
					if((ta_riff.getText()).trim().equals("VID"))
				{
					//long c=Integer.parseInt(cld.getText().trim());
					long f=0;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
				
					if((ta_riff.getText()).trim().equals("VIIA")&&(ph.getText()).trim().equals("Single"))
				{
					long c=Integer.parseInt(cld.getText().trim());
						if ((c>0)&&(c<=1000))
						{
					long f=1*50000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>1001)&&(c<=2000))
						{
					long f=2*50000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>2001)&&(c<=3000))
						{
					long f=3*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>3001)&&(c<=4000))
						{
					long f=4*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>4001)&&(c<=5000))
						{
					long f=5*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>5001)&&(c<=6000))
						{
					long f=6*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>6001)&&(c<=7000))
						{
					long f=7*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
				}

				
				if((ta_riff.getText()).trim().equals("VIIA")&&(ph.getText()).trim().equals("Three"))
				{
					long c=Integer.parseInt(cld.getText().trim());
					
					if ((c>0)&&(c<=1000))
						{
					long f=1*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>1001)&&(c<=2000))
						{
					long f=2*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>2001)&&(c<=3000))
						{
					long f=3*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>3001)&&(c<=4000))
						{
					long f=4*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>4001)&&(c<=5000))
						{
					long f=5*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
					if ((c>5001)&&(c<=6000))
						{
					long f=6*100000/1000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
						}
				
					}
				if((ta_riff.getText()).trim().equals("VIIB"))//&&(ph.getText()).trim().equals("Single"))
				{
					long c=Integer.parseInt(cld.getText().trim());
					long f=c*3000/100000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				
				if((ta_riff.getText()).trim().equals("VIIC"))//&&(ph.getText()).trim().equals("Single"))
				{
					int c=Integer.parseInt(cld.getText().trim());
					int f=c*8000/1000000;
					f_c.setText(""+f);
					System.out.println(f_c.getText());
					
				}
				  }
				  
		//==============================================		  
				  
				  	else if(e.getSource()==m_r)
					{
				System.out.println("Lost Focused from Duty");
				if((ph.getText()).trim().equals("Single"))
				{
					long f=20;
					m_r.setText(""+f);
					System.out.println(m_r.getText());
					
				}
				
				if((ph.getText()).trim().equals("Three"))
				{
					long f=60;
					m_r.setText(""+f);
					System.out.println(m_r.getText());
					
				}
				
				     
				 }   
				     
				     
				else if(e.getSource()==dem)    
				     
					{
				System.out.println("Lost Focused from MRent");
				long fc = Long.parseLong((f_c.getText()).trim());
				long ec = Long.parseLong((e_c.getText()).trim());
				long dy = Long.parseLong((dty.getText()).trim());
				long r = Long.parseLong((m_r.getText()).trim());
				long rf=Long.parseLong((r_f.getText()).trim());
				//long d=fc+ec+dy+r;
				long dm=fc+ec+dy+r+rf;
				dem.setText(""+dm);
					}
					else if(e.getSource()==sub)    
				     
					{
				System.out.println("Lost Focused from Demand");
				//long d = Long.parseLong((dem.getText()).trim());
				long fc = Long.parseLong((f_c.getText()).trim());
				long ec = Long.parseLong((e_c.getText()).trim());
				long dy = Long.parseLong((dty.getText()).trim());
				long r = Long.parseLong((m_r.getText()).trim());
				//long rf=Long.parseLong((r_f.getText()).trim());
				//long d=fc+ec+dy+r;
			
				long s=(fc+ec+dy+r)/10;
				sub.setText(""+s);
					}
			
			
			else if(e.getSource()==tot)    
				     
					{
				System.out.println("Lost Focused from TOT");
				//long d = Long.parseLong((dem.getText()).trim());
				long fc = Long.parseLong((f_c.getText()).trim());
				long ec = Long.parseLong((e_c.getText()).trim());
				long dy = Long.parseLong((dty.getText()).trim());
				long r = Long.parseLong((m_r.getText()).trim());
				long rf = Long.parseLong((r_f.getText()).trim());
				long su=Long.parseLong((sub.getText()).trim());
				long ad=Long.parseLong((adv.getText()).trim());
				long arr=Long.parseLong((arrear.getText()).trim());
				/*long cdi=Long.parseLong((cdint.getText()).trim());
				//long na=Long.parseLong((net_amt.getText()).trim());
				//long d=fc+ec+dy+r;*/
			
				long t=fc+ec+dy+r+rf-su-ad+arr;
				tot.setText(""+t);
					}
					
						else if(e.getSource()==net_amt)    
				     
					{
				System.out.println("Lost Focused from TOT");
				//long d = Long.parseLong((dem.getText()).trim());
				long fc = Long.parseLong((f_c.getText()).trim());
				long ec = Long.parseLong((e_c.getText()).trim());
				long dy = Long.parseLong((dty.getText()).trim());
				long r = Long.parseLong((m_r.getText()).trim());
				long rf = Long.parseLong((r_f.getText()).trim());
				long su=Long.parseLong((sub.getText()).trim());
				long ad=Long.parseLong((adv.getText()).trim());
				long arr=Long.parseLong((arrear.getText()).trim());
				long cdi=Long.parseLong((cdint.getText()).trim());
				//long na=Long.parseLong((net_amt.getText()).trim());
				//long d=fc+ec+dy+r;
			
				long t=fc+ec+dy+r+rf-su-ad+arr-cdi;
				net_amt.setText(""+t);
					}
					
		//==================================================		  
			     else if(e.getSource()==e_c)
				
			     {
				System.out.println("Gained focus on E C");
				long uc = Long.parseLong((unit_con.getText()).trim());
					if ((uc>0)&&(uc<=40))
					{
					long c=uc*115/100;
					e_c.setText(""+c);
					}
					else if ((uc>=41)&&(uc<=80))
					{
					long c=uc*190/100;
					e_c.setText(""+c);
					}
					else if ((uc>=81)&&(uc<=120))
					{
					long c=uc*240/100;
					e_c.setText(""+c);
					}
					else if ((uc>=121)&&(uc<=150))
					{
					long c=uc*300/100;
					e_c.setText(""+c);
					}
					else if ((uc>=151)&&(uc<=200))
					{
					long c=uc*365/100;
					e_c.setText(""+c);
					}
					else if ((uc>=201)&&(uc<=300))
					{
					long c=uc*430/100;
					e_c.setText(""+c);
					}
					else if ((uc>=301)&&(uc<=500))
					{
					long c=uc*530/100;
					e_c.setText(""+c);
					}
					else if (uc>=501)
					{
					long c=uc*545/100;
					e_c.setText(""+c);
					}
				
			     }
			     
			   
		else if(e.getSource()==dty)
				{
				System.out.println("Lost Focused from duty");
				long d = Long.parseLong((e_c.getText()).trim());				
					long dy=d*175/10000;
					dty.setText(""+dy);
					System.out.println(f_c.getText());
					
				}
				
			}	
 //----------------------------------------------------}
 
                                                          
		/* else if (e.getSource()==m_r)
				{
					System.out.println("lost focus form mtr_rent");
					if(ph="Single")
					{
						long r=20;
						m_r.setText(""+r);
					}
					
					
				}
			
		
			}*/
				
	//______________________________________________________________________________		
		//}
		public void focusLost(FocusEvent e)
		{
			/*if(e.getSource()==ta_riff)
			{
				System.out.println("Lost Focused from Tarif");
				if(ta_riff.getText().equals("IA"))
				{
				//long f=Integer.parseInt(f_c.getText().trim());
				long f=0;
				f_c.setText(""+f);
				
				System.out.println(f_c.getText());
				}
			}*/
		}
	//___________________________________________________________________________
		public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==exit)
		{
			this.dispose();
		}
		if((e.getSource()==area_code)||(e.getSource()==meter_code))
		{
			System.out.println("Selected area code");
				
			 try{
			QueryData qd = new QueryData();
			v2.clear();
			v2.addAll(qd.getCons((String)area_code.getSelectedItem(),(String)meter_code.getSelectedItem()));
		
			System.out.println("Elements in V2  " + v2);
			
					
					
		   }catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		}
		
	if((e.getSource()==area_code)||(e.getSource()==meter_code)||(e.getSource()==combobox))
		{
			System.out.println("Selected combobox,area_code,meter_code");
				
			 try{
			QueryData qd = new QueryData();
		
						String id=(String)combobox.getSelectedItem();//||(String)meter_code.getSelectedItem()||(String)combobox.getSelectedItem());
			
						String cl=qd.getInitialReading(id);
						String c2=qd.getPhase(id);
						String c3=qd.getCl(id);
						String cl2=qd.getTariff(id);
	//====================================================					
						pre_reading.setText(cl);
					    ph.setText(c2);
						
						cld.setText(c3);
						
						ta_riff.setText(cl2);
			
		   }catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
			
		}
		else if(e.getSource()==ok)
				{
				try{
					QueryData qd = new QueryData();
					PreparedStatement pst2 = qd.getConnect().prepareStatement("insert into demand values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst2.setString(1,(String)area_code.getSelectedItem());
					pst2.setString(2,(String)meter_code.getSelectedItem());
					pst2.setString(3,(String)combobox.getSelectedItem());
					pst2.setString(4,(String)pre_reading.getText());
					//pst2.setString(5,(String)present_reading.getText());
					//pst2.setString(6,(String)unit_con.getText());
					
					
					
					
					//pst2.setInt(4,Integer.parseInt(pre_reading.getText()));
					pst2.setInt(5,Integer.parseInt(present_reading.getText()));
					pst2.setInt(6,Integer.parseInt(unit_con.getText()));
					pst2.setString(7,(String)dm_id.getText());
					//pst2.setInt(6,Integer.parseInt(f_c.getText()));

					pst2.setString(8,(String)f_c.getText());
					pst2.setString(9,(String)e_c.getText());
					pst2.setString(10,(String)dty.getText());
					pst2.setString(11,(String)m_r.getText());
					pst2.setString(12,(String)r_f.getText());
					pst2.setString(13,(String)dem.getText());
					pst2.setString(14,(String)sub.getText());
					pst2.setString(15,(String)adv.getText());
					pst2.setString(16,(String)arrear.getText());
					pst2.setString(17,(String)tot.getText());
					pst2.setString(18,(String)cdint.getText());
					pst2.setString(19,(String)net_amt.getText());
					
					String ds,ys,ms,dates;
					ds=(String)d1.getSelectedItem();
					ms=(String)m1.getSelectedItem();
					ys=(String)y1.getSelectedItem();
					dates=ds+"/"+ms+"/"+ys;
					pst2.setString(20,dates);
					
					String da,ya,ma,dates1;
					da=(String)d2.getSelectedItem();
					ma=(String)m2.getSelectedItem();
					ya=(String)y2.getSelectedItem();
					dates1=da+"/"+ma+"/"+ya;
					pst2.setString(21,dates1);
					
					
					String db,yb,mb,dates2;
					db=(String)d3.getSelectedItem();
					mb=(String)m3.getSelectedItem();
					yb=(String)y3.getSelectedItem();
					dates2=db+"/"+mb+"/"+yb;
					pst2.setString(22,dates2);
					
					
				
					int i=pst2.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"Demand Generated","NEW DEMAND ",1);
					}
					

					}catch(Exception ex){System.out.println("Inside Save   :" +ex);}
				

				}
	
		}
	

		public static void main(String arg[])
		{
			/*Demand d = new Demand("DEMAND");
			d.setSize(1000,550);
			d.setVisible(true);*/	}

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
//public class Demand {}