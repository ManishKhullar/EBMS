//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class Billdetails extends JInternalFrame implements ActionListener
 { 
	JLabel consumer_number,areacode,prereading,presentreading,metercode,unitsconsume;
	
	JTextField advancepaid,demandid,area_code,mtr_code,billldate,duedate,disconnectdate,m1,m2,m3,y1,y2,y3,dutytogovt,cashpaid,bcash,net_amt_payab,interestondeposit,tota,previousarrea,demandfor,subsidy,fixedcharge,energycharge,meterrent,pre_reading,present_reading,ints,unitconsumed,day_code,reconfee,surcharge;
	JComboBox combo_box;
	JButton query,showdemanddetail,meterreadingdetail,exit;
		String dw[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"Month","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};

	String yw[]={"Year","2019","2020","2021","2022","2023","2024","2025"};
	String ac[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
String mc[]={"1","2","3","4","5","6","7","8"};
	Connection con ;
	public 	Billdetails(String title)
  	{


		super("BILL DETAILS");
		setLayout(null);
		consumer_number=new JLabel("Consumer Number");
                                       try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		combo_box=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		combo_box.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		area_code=new JTextField();
	
		metercode=new JLabel("Meter Reader Code");
		//String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code=new  JTextField();
		prereading=new JLabel("Previous Reading");
		pre_reading=new JTextField(10); //read from the database
		presentreading=new JLabel("Present Reading");
		present_reading=new JTextField(10);
		unitsconsume=new JLabel("Units consumed");
		unitconsumed=new JTextField(10);
		JLabel demid= new JLabel("Demand ID");
		demandid=new JTextField(10);
		
		//query=new JButton("Quierry");
		//ok=new JButton("Update");
		//cancel=new JButton("Cancel");
		//edit=new JButton("edit");
		FlowLayout layout=new FlowLayout();
		showdemanddetail=new JButton("Show Demand details");
		
		meterreadingdetail=new JButton("Meter Reading details");

		exit=new JButton("exit");


		JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;

		p1=new JPanel();
		p1.setLayout(new GridLayout(9,2,0,5));

		p1.add(consumer_number);
		p1.add(combo_box);
		p1.add(areacode);
		p1.add(area_code);		
		p1.add(metercode);
		p1.add(mtr_code);
		
		p1.add(prereading);
		p1.add(pre_reading); 
		p1.add(presentreading);
		p1.add(present_reading);
		p1.add(unitsconsume);
		p1.add(unitconsumed);
		p1.add(demid);
		p1.add(demandid);
		p1.setBounds(10,100,250,196);
		add(p1);
		combo_box.setEditable(false);
	   	 area_code.setEditable(false);
	   	 mtr_code.setEditable(false);
	   	 pre_reading.setEditable(false);
	   	 present_reading.setEditable(false);
	   	 unitconsumed.setEditable(false);
	   	 demandid.setEditable(false);


		/*p2=new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(query);
		p2.setBounds(262,163,90,40);
		add(p2);*/
		
		JLabel c=new JLabel("BILL DETAILS");
		c.setFont(new Font("Times New Roman",Font.BOLD,30));
		c.setForeground(new Color(200,0,20));      
		
		        p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(250,30,350,50);
     			p6.add(c);
     			add(p6);
     			//panel1.add(p65);
			
		
		p5=new JPanel();
		p5.setLayout(new GridLayout(1,1,10,10));
	//	p5.add(showdemanddetail);
	//	p5.add(meterreadingdetail);
		p5.add(exit);
		
		
		
		p5.setBounds(400,425,80,30);
		add(p5);
	
		JLabel fc=new JLabel("Fixed Charge");
		fixedcharge=new JTextField(10);
		JLabel ec=new JLabel("Energy Charge");
		energycharge=new JTextField(10);
		JLabel mr=new JLabel("Meter Rent");
		meterrent=new JTextField(10);
		
		JLabel duty=new JLabel("DUTY TO GOVT:");
		dutytogovt=new JTextField(10);
		
		JLabel rf=new JLabel("Re con: fee");
		reconfee=new JTextField(10);
		JLabel sc=new JLabel("Surcharge");
		surcharge=new JTextField(10);
		JLabel demd=new JLabel("Demand for  ..... ");
		demandfor=new JTextField(10);
		
		JLabel subsi=new JLabel("Subsidy");
		subsidy=new JTextField(10);
		
		JLabel adv=new JLabel("Advance Paid");
		advancepaid=new JTextField(10);
		
		JLabel prebal=new JLabel("Previous arrears");
		previousarrea=new JTextField(10);
		
		JLabel total=new JLabel("Total");
		tota=new JTextField(10);	
		JLabel intcd=new JLabel("Intrest on CD");
		interestondeposit=new JTextField(10);
		JLabel netamt=new JLabel("NET AMOUNT PAYABLE");
		net_amt_payab=new JTextField(10);	
		
		p7=new JPanel();
		p7.setLayout(new GridLayout(12,2,0,7));
		p7.add(fc);
		p7.add(fixedcharge);
		p7.add(ec);
		p7.add(energycharge);
		
		fixedcharge.setEditable(false);
	   	 energycharge.setEditable(false);
	   	 dutytogovt.setEditable(false);

		
		p7.add(duty);
		p7.add(dutytogovt);
		
		
		p7.add(mr);
		p7.add(meterrent);
		p7.add(rf);
		p7.add(reconfee);
		
		p7.add(demd);
		p7.add(demandfor);
		p7.add(subsi);
		p7.add(subsidy);
		
		
		meterrent.setEditable(false);
	   	 reconfee.setEditable(false);
	   	 demandfor.setEditable(false);
	   	 subsidy.setEditable(false);


		//p7.add(demd);
		//p7.add(demandfor);
		
		p7.add(adv);
		p7.add(advancepaid);
		
		
		p7.add(prebal);
		p7.add(previousarrea);
		
		p7.add(total);
		p7.add(tota);
		p7.add(intcd);
		p7.add(interestondeposit);
		p7.add(netamt);
		p7.add(net_amt_payab);
		 advancepaid.setEditable(false);
	   	 previousarrea.setEditable(false);
		 tota.setEditable(false);
	   	 interestondeposit.setEditable(false);
	   	 demandfor.setEditable(false);
	   	 net_amt_payab.setEditable(false);

		
		p7.setBounds(352,100,270,260);
		add(p7);
		
		JLabel bdate=new JLabel("Bill Date");
		billldate=new JTextField(10);
		//m1=new JTextField(5);
		//y1=new JTextField(5);
		JLabel ddate=new JLabel("Due Date");
		duedate=new JTextField(10);
		//m2=new JTextField(5);
		//y2=new JTextField(5);
		JLabel disdate=new JLabel("Disconnnection date");
		disconnectdate=new JTextField(10);
		//m3=new JTextField(5);
		//y3=new JTextField(5);
		
		p8=new JPanel();
		p8.setLayout(new GridLayout(1,1,10,10));
		p8.add(bdate);
		p8.setBounds(650,100,120,20);
		add(p8);
		
		p9=new JPanel();
		p9.setLayout(new GridLayout(1,1,0,10));
		p9.add(billldate);
		//p9.add(m1);
	    //p9.add(y1);
		p9.setBounds(650,120,150,20);
		add(p9);
	
		
		p10=new JPanel();
		p10.setLayout(new GridLayout(1,1,10,10));
		p10.add(ddate);
		p10.setBounds(650,140,120,20);
		add(p10);
		
		p11=new JPanel();
		p11.setLayout(new GridLayout(1,1,0,10));
		p11.add(duedate);
		//p11.add(m2);
	    //p11.add(y2);
		p11.setBounds(650,160,150,20);
		add(p11);
		
		p12=new JPanel();
		p12.setLayout(new GridLayout(1,1,10,10));
		p12.add(disdate);
		p12.setBounds(650,180,120,20);
		add(p12);
		
		p13=new JPanel();
		p13.setLayout(new GridLayout(1,1,0,10));
		p13.add(disconnectdate);
		//p13.add(m3);
	   // p13.add(y3);
		p13.setBounds(650,200,150,20);
		add(p13);
	
		 billldate.setEditable(false);
	   	 duedate.setEditable(false);
	   	 disconnectdate.setEditable(false);

	setLocation(50,70);
	
JLabel amtpaid=new JLabel("cashpaid paid");
cashpaid=new JTextField(10);
JLabel balamt=new JLabel("Balance adjustable ");
bcash=new JTextField(10);
//JLabel duty=new JLabel("DUTY TO GOVT:");
//dutytogovt=new JTextField(10);
p14=new JPanel();
p14.setLayout(new GridLayout(6,1,0,5));
//p14.add(duty);
//p14.add(dutytogovt);
p14.add(amtpaid);
p14.add(cashpaid);
p14.add(balamt);
p14.add(bcash);

		 cashpaid.setEditable(false);
	   	 bcash.setEditable(false);

p14.setBounds(650,225,120,130);
		add(p14);
exit.addActionListener(this);
combo_box.addActionListener(this);			
					}
		
                               public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==exit)
			{
				this.dispose();
			}if(e.getSource()==combo_box)
			{
				//System.out.println("Selecte d ocnsumer NO");
				try{

					
					QueryData qd = new QueryData();

					String id=(String)combo_box.getSelectedItem();
					/*Vector v = qd.getBillDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					System.out.println(id + "Bill Details " + v );
					Enumeration em=v.elements();
					area_code.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
					mtr_code.setText((String)em.nextElement());
					
				
					String cl=qd.getInitialReading(id);
					if(cl!=null)
						pre_reading.setText(cl);*/
					
					Vector v11 = qd.getDmdwiew(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					System.out.println(id + "Bill  " + v11 );
					Enumeration em=v11.elements();
					
					area_code.setText((String)em.nextElement());
					mtr_code.setText((String)em.nextElement());
					pre_reading.setText((String)em.nextElement());
					present_reading.setText((String)em.nextElement());
					unitconsumed.setText((String)em.nextElement());
					demandid.setText((String)em.nextElement());
					fixedcharge.setText((String)em.nextElement());
					energycharge.setText((String)em.nextElement());
					dutytogovt.setText((String)em.nextElement());
					meterrent.setText((String)em.nextElement());
					reconfee.setText((String)em.nextElement());
					demandfor.setText((String)em.nextElement());
					subsidy.setText((String)em.nextElement());
					advancepaid.setText((String)em.nextElement());
					previousarrea.setText((String)em.nextElement());
					tota.setText((String)em.nextElement());
					interestondeposit.setText((String)em.nextElement());
					net_amt_payab.setText((String)em.nextElement());
					billldate.setText((String)em.nextElement());
					duedate.setText((String)em.nextElement());
					disconnectdate.setText((String)em.nextElement());			
					}catch(Exception ex){System.out.println("Error in Bill Details " + ex);}
			}	
	
	}
        public static void main(String arg[])
		{
		/*	Billdetails bd = new Billdetails("BILL DETAILS");
			bd.setSize(900,550);
			bd.setVisible(true);*/
	}

}