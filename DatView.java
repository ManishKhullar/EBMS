//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
public class DatView extends JInternalFrame implements ActionListener
{
	JLabel meterreadercode,consumernumber,addres,meternumber,intialreading,cr,noofdigit,tariff,phase,postnumber,connectedload,dateofconnection,dd1,mm1,yy1;
	JTextArea address;
	JTextField ta_riff,cphase,area_code1,area_code2,area_code3,meter_code1,meter_code2,meter_code3, consumer_name,post_number,connected_load,meter_number,intial_reading,c_r,no_of_digit,date_of_connection;
	JTextField m1,y1,d2,m2,y2,d3,m3,y3,d4,m4,y4,d5,m5,y5,d6,m6,y6,instalment_end_date,m77;
	JButton qry,cancel,list, listall;
	JComboBox con_no1_combobox, con_no2_combobox,con_no3_combobox,con_no4_combobox;
	 JTextField ac_d,receipt_no_1,cash_deposit,receipt_no_2,total_no_of_installment,oyec_amt,installment_amount,paid_installment,balance_installment,ending_month;
JTextField lemgamt,scmgamt,lramt,ilemg,iscmg,ilr,noofinst_lemg,noofinst_semg,noofinst_lr,pnoofinst_lemg,pnoofinst_semg,pnoofinst_lr;

	String dw[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"Month","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String ac[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
	String mc[]={"1","2","3","4","5","6","7","8"};
	String yw[]={"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	String t[]={"IA","IB","IC","II","III","IV","VA","VB","VC","VI","VII","VIII"};
	String p[]={"Single","Three"};
	
	
	JTabbedPane tb;
	
	public DatView(String title)
	{
		super("Data View");
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		
		JLabel cd=new JLabel("CONSUMER DETAILS");
			
		cd.setFont(new Font("Times New Roman",Font.BOLD,20));
		cd.setForeground(new Color(50,150,20));
		
			JPanel p65=new JPanel();
			p65.setLayout(new FlowLayout());
     			p65.setBounds(150,0,350,30);
     			p65.add(cd);
     			
     			panel1.add(p65);
			
//************************************NEW CONSUMER .1********************************
        		JLabel conno=new JLabel("Consumer Number");
		try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		con_no1_combobox=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		JLabel areacode=new JLabel("Area Code");
		area_code1=new JTextField(10);
		meterreadercode=new JLabel("Meter Reader Code");
		meter_code1=new JTextField(10);
		tariff=new JLabel("tariff");
		ta_riff=new JTextField(10);
		phase=new JLabel("phase");
		cphase=new JTextField(10);	
		postnumber=new JLabel("Postnumber");
		post_number=new JTextField(20);	
		connectedload=new JLabel("Connected Load");
		connected_load=new JTextField(20);
		
		dateofconnection=new JLabel("Date of connection");
		date_of_connection=new JTextField(15);
		//m1=new JTextField(5);
		//y1=new JTextField(5);
		
		JPanel p1= new JPanel();
		
		
		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1.setLayout(new GridLayout(8,2,0,0));
	
		p1.add(conno);
		p1.add(con_no1_combobox);
		p1.add(areacode);
    		p1.add(area_code1);
    		area_code1.setEditable(false);
    		p1.add(meterreadercode);
    		p1.add(meter_code1);
    		meter_code1.setEditable(false);
		p1.add(tariff);
		p1.add(ta_riff);
	ta_riff.setEditable(false);
		p1.add(phase);
		p1.add(cphase);
		cphase.setEditable(false);
		p1.add(postnumber);
		p1.add(post_number);
		post_number.setEditable(false);
		p1.add(connectedload);
		p1.add(connected_load);
		connected_load.setEditable(false);
		
	

        		consumernumber=new JLabel("Consumer name");
       		 consumer_name=new JTextField(60);
    		addres = new JLabel("Address");
		address= new JTextArea(5,5);
		JScrollPane scroll = new JScrollPane(address);
		JPanel p2 = new JPanel();
		
		p2.setLayout(new GridLayout(1,1,0,0));
		p2.add(consumernumber);
		JPanel p3 = new JPanel();
		
		p3.setLayout(new GridLayout(1,1,0,0));
		p3.add(consumer_name);
		consumer_name.setEditable(false);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1,1,0,0));
		p4.add(addres);
		
		
		JPanel p5 = new JPanel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.X_AXIS));
		p5.setLayout(new GridLayout(1,1,0,0));
		p5.add(Box.createRigidArea(new Dimension(80,0)));
		p5.add(scroll);
		address.setEditable(false);

		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(1,1,0,0));
		p6.add(dateofconnection);
	
		
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(1,1,0,0));
		p7.add(date_of_connection);
		//p7.add(m1);
		//p7.add(y1);
		date_of_connection.setEditable(false);
		
		qry=new JButton("view all");
     		
		JPanel p8=new JPanel();
		p8.setLayout(new FlowLayout());
     		p8.setBounds(270,230,200,40);
     		//p8.add(qry);
     			
		p1.setBounds(20,30,230,200);
		p2.setBounds(300,30,100,20);
		p3.setBounds(402,30,225,20);
		p4.setBounds(300,90,75,20);
     		p5.setBounds(168,60,462,100);
		p6.setBounds(300,190,120,20);
		p7.setBounds(425,190,200,20);
		
		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		panel1.add(p5);
		panel1.add(p6);		
		panel1.add(p7);		
	
		panel1.add(p8);
	
	//************************METER DETAILS .2********************************

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		JLabel md=new JLabel("METER DETAILS");
			
		md.setFont(new Font("Times New Roman",Font.BOLD,25));
		md.setForeground(new Color(180,0,230));
	
		JPanel p55=new JPanel();
		p55.setLayout(new FlowLayout());
     		p55.setBounds(200,30,350,30);
     		p55.add(md);
         		panel2.add(p55);	
		JPanel p9 = new JPanel();
		p9.setLayout(new GridLayout(4,2,10,10));
		JLabel conno1=new JLabel("Consumer Number");
		Vector v2=null;
		try{
		QueryData qd = new QueryData();
		v2= qd.getConsumer(); 
		con_no2_combobox=new JComboBox(v2);
		}catch(Exception ex)
		{//System.out.println("Error in DataEnt " + ex);
			ex.printStackTrace();
		}
		
		System.out.println("Elements in V2 " + v2);
		
		meternumber=new JLabel("Metre Number");
		meter_number=new JTextField(10);
		meter_number.setEditable(false);
		noofdigit=new JLabel("No of Digits");
		no_of_digit=new JTextField(10);
		no_of_digit.setEditable(false);
		intialreading=new JLabel("Initial Reading");
		intial_reading=new JTextField(20);
		intial_reading.setEditable(false);
		qry=new JButton("view all");
		p9.add(conno1);
		p9.add(con_no2_combobox);
		p9.add(meternumber);
		p9.add(meter_number);
		p9.add(noofdigit);
		p9.add(no_of_digit);
		p9.add(intial_reading);
		p9.setBounds(50,100,300,150);
		JPanel p10 = new JPanel();
		p10.setLayout(new GridLayout(1,2,10,10));
		//p10.add(qry);
		p10.setBounds(250,305,170,30);
		panel2.add(p9);
		panel2.add(p10);
		
			
//**************************************************************************************
//DEPOSIT DETAILS .3
	JLabel acd,rtno1,cashdeposit,rtno2,totnoinst,oyecamt;
			JPanel panel3 = new JPanel();
			panel3.setLayout(null);
			JLabel dd=new JLabel("DEPOSIT DETAILS");
			
			dd.setFont(new Font("Times New Roman",Font.BOLD,25));
			dd.setForeground(new Color(180,60,30));
		
			JPanel p45=new JPanel();
			p45.setLayout(new FlowLayout());
     			p45.setBounds(200,30,350,30);
     			p45.add(dd);
     			
     			panel3.add(p45);
				
			conno=new JLabel("Consumer No:");
			Vector v3=null;
			try{
				QueryData qd = new QueryData();
				v3= qd.getConsumer(); 
				con_no3_combobox=new JComboBox(v3);
			}catch(Exception ex)
			{//System.out.println("Error in DataEnt " + ex);
				ex.printStackTrace();
			}
			areacode=new JLabel("Area Code");                   
			area_code2=new JTextField(10);
			area_code2.setEditable(false);
			meterreadercode=new JLabel("Meter Reader Code");
			meter_code2=new JTextField(10);
			meter_code2.setEditable(false);
			
			JPanel p11=new JPanel();
			p11.setLayout(new GridLayout(1,1,0,0));
		
			p11.add(conno);
			p11.setBounds(10,10,80,20);
		
			
			JPanel p101=new JPanel();
	     		p101.setLayout(new GridLayout(1,1,0,0));
			p101.add(con_no3_combobox);
			p101.setBounds(95,10,100,20);
		
	
			JPanel p112=new JPanel();
			p112.setLayout(new FlowLayout());
			p112.setBounds(0,75,400,40);
			p112.add(p11);
			p112.add(p101);
	    		panel3.add(p112);
			JPanel p12=new JPanel();
			p12.setLayout(new GridLayout(4,2,0,10));                    
			cashdeposit=new JLabel("Cash deposit");
			cash_deposit=new JTextField(10);
			cash_deposit.setEditable(false);
			acd=new JLabel("A C D");
			ac_d=new JTextField(10);
			ac_d.setEditable(false);
			oyecamt=new JLabel("OYEC Amount");
			oyec_amt=new JTextField(10);
			oyec_amt.setEditable(false);
			totnoinst=new JLabel("Total no of instalments");
			total_no_of_installment=new JTextField(10);
		total_no_of_installment.setEditable(false);
		p12.add(cashdeposit);	
		p12.add(cash_deposit);
		p12.add(acd);	
		p12.add(ac_d);
		p12.add(oyecamt);	
		p12.add(oyec_amt);
		p12.add(totnoinst);
		p12.add(total_no_of_installment);
		p12.setBounds(5,140,300,105);
		panel3.add(p12);

		rtno1=new JLabel("Receipt no");
		receipt_no_1=new JTextField(10);
		receipt_no_1.setEditable(false);
		rtno2=new JLabel("Receipt no");
		receipt_no_2=new JTextField(10);
		receipt_no_2.setEditable(false);
		d4=new JTextField(12);
		d4.setEditable(false);
		
		d5=new JTextField(12);
		d5.setEditable(false);
		
		JPanel p13,p14;
		p13=new JPanel(new FlowLayout());
		p13.add(rtno1);
		p13.add(receipt_no_1);
		p13.add(d4);
		
		p14 = new JPanel(new FlowLayout());
		p14.add(rtno2);
		p14.add(receipt_no_2);
		p14.add(d5);
		
		p13.setBounds(300,120,430,30);
		p14.setBounds(300,150,430,30);
		panel3.add(p13);
		panel3.add(p14);

		JLabel totinst,instamt,paidinst,balinst,endingmonth;
		JPanel p15=new JPanel();
		p15.setLayout(new GridLayout(3,2,0,10));
		instamt=new JLabel("Instalment Amt: ");
		installment_amount=new JTextField(10);
		installment_amount.setEditable(false);
		paidinst=new JLabel("Paid Instalments ");
		paid_installment=new JTextField(10);
			paid_installment.setEditable(false);			
		balinst=new JLabel("Balance Instalments ");
		balance_installment=new JTextField(10);
		balance_installment.setEditable(false);
		p15.add(instamt);
		p15.add(installment_amount);
		p15.add(paidinst);
		p15.add(paid_installment);
		p15.add(balinst);
		p15.add(balance_installment);
		p15.setBounds(390,190,250,100);
		panel3.add(p15);
		
		endingmonth=new JLabel("OYEC Instalment ends on the month");
	
		 instalment_end_date=new JTextField(12);
		instalment_end_date.setEditable(false);
		JPanel p16=new JPanel();
		p16.setLayout(new FlowLayout());
		p16.add(endingmonth);
		p16.add(instalment_end_date);
		
		p16.setBounds(0,255,360,30);
		panel3.add(p16);
		
		qry=new JButton("QUIERY");
		JPanel p38=new JPanel();
		p38.setLayout(new FlowLayout());
     		p38.setBounds(270,330,200,40);
     		//p38.add(qry);
     		panel3.add(p38);
		
		
		
//************************MINIMUM  GAURENTEE .4****************************


JTextField y7;

           JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		JLabel mg=new JLabel("MINIMUM GAURENTEE");	
		mg.setFont(new Font("Times New Roman",Font.BOLD,25));
		mg.setForeground(new Color(80,0,230));
		JLabel lemg=new JLabel("           LEMG         ");
		JLabel scmg=new JLabel("                       SCMG         ");
		JLabel lr=new JLabel("               Line Rent");		
		JLabel amt=new JLabel("Amount");
		lemgamt=new JTextField(10);		
		scmgamt=new JTextField(10);
		lramt=new JTextField(10);
		JLabel iamt=new JLabel("Instalment Amt");
		ilemg=new JTextField(10);		
		iscmg=new JTextField(10);
		ilr=new JTextField(10);
	   	 conno=new JLabel("Consumer No:");
	   	 lemgamt.setEditable(false);
	   	 scmgamt.setEditable(false);
	   	 lemgamt.setEditable(false);
	   	 lramt.setEditable(false);
	   	 ilemg.setEditable(false);
	   	 ilr.setEditable(false);
	   	 iscmg.setEditable(false);

			Vector v4=null;
			try{
				QueryData qd = new QueryData();
				v4= qd.getConsumer(); 
				con_no4_combobox=new JComboBox(v4);
				con_no4_combobox.setEditable(false);

				area_code3=new JTextField(10);
				area_code3.setEditable(false);
				meter_code3=new JTextField(10);
				meter_code3.setEditable(false);
		
			}catch(Exception ex)
			{//System.out.println("Error in DataEnt " + ex);
			ex.printStackTrace();
			}
	
    		//con_no4_combobox=new JComboBox();
		//area_code3=new JTextField(10);
		//meter_code3=new JTextField(10);
		
		JPanel p17=new JPanel();
		p17.setLayout(new GridLayout(1,1,0,10));
		p17.setBounds(50,70,85,20);
		p17.add(conno);

		JPanel p18=new JPanel();
		p18.setLayout(new GridLayout(1,1,0,10));
		p18.setBounds(135,70,100,20);
     		p18.add(con_no4_combobox);
		
		JPanel p19=new JPanel();
		p19.setLayout(new GridLayout(1,1,0,10));
		p19.setBounds(240,70,65,20);	
		p19.add(areacode);
			
		JPanel p20=new JPanel();
		p20.setLayout(new GridLayout(1,1,0,10));
		p20.setBounds(308,70,80,20);
		p20.add(area_code3);
		
		JPanel p21=new JPanel();
		p21.setLayout(new GridLayout(1,1,0,10));
		p21.setBounds(400,70,120,20);
		p21.add(meterreadercode);
		
		JPanel p22=new JPanel();
		p22.setLayout(new GridLayout(1,1,0,10));
		p22.setBounds(520,70,90,20);
		p22.add(meter_code3);
		

    		JLabel p23=new JLabel("No of Instalments");			
		noofinst_lemg=new JTextField(10);				
		noofinst_semg=new JTextField(10);	
		noofinst_lr=new JTextField(10);	
		noofinst_lemg.setEditable(false);
	   	 
	   	 noofinst_lr.setEditable(false);
	   	
		
		JPanel p24=new JPanel();
		p24.setLayout(new GridLayout(2,4,0,10));
		p24.add(amt);
		p24.add(lemgamt);
		p24.add(scmgamt);
		p24.add(lramt);
		p24.add(iamt);
		p24.add(ilemg);
		p24.add(iscmg);
		p24.add(ilr);
		p24.setBounds(50,150,500,60);
		
		
		JPanel p25=new JPanel();
		p25.setLayout(new FlowLayout());
     		p25.setBounds(200,30,350,30);
     		p25.add(mg);
     	
   		JPanel p26=new JPanel();
		p26.setLayout(new FlowLayout());
     		p26.setBounds(170,130,350,30);
     		p26.add(lemg);
     		p26.add(scmg);
   		p26.add(lr);
   		
   		JLabel lim=new JLabel("MG ends as on");//ending month of minimum gaurentee
   		JLabel mm7=new JLabel("Month & Year");
	
		m77=new JTextField(10);
		m77.setEditable(false);
		//y7=new JTextField(5);
		
		
		JPanel p27=new JPanel();
		p27.setLayout(new GridLayout(1,2,0,10));
     		p27.setBounds(50,230,200,30);
     		p27.add(lim);
     		p27.add(m77);
     		//p27.add(y7);
     	
     		qry=new JButton("QUERY");
   		JPanel p28=new JPanel();
		p28.setLayout(new FlowLayout());
     		p28.setBounds(270,230,200,40);
     		//p28.add(qry);
     		//p28.add(edit);
     	
		
		panel4.add(p17);
		panel4.add(p18);
		panel4.add(p19);
		panel4.add(p20);
		panel4.add(p21);
		panel4.add(p22);
		panel4.add(p23);
		panel4.add(p24);
		panel4.add(p25);
		panel4.add(p26);
		panel4.add(p27);
		panel4.add(p28);
		
			tb = new JTabbedPane();
			
			panel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
			panel2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
	    		panel3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
			panel4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
	
	
			tb.addTab("ConsumerDetails",panel1);
	        		tb.addTab("MeterDetails",panel2);
		   	 tb.addTab("DepositDetails",panel3);
            			tb.addTab("Minimum gaurentee",panel4);
		
			cancel = new JButton("Cancel");

			JPanel pp = new JPanel();
			pp.setLayout(new FlowLayout());
			pp.add(cancel);
			getContentPane().add(tb,BorderLayout.CENTER);
			getContentPane().add(pp,BorderLayout.SOUTH);
			setLocation(120,70);		
			cancel.addActionListener(this);
			con_no1_combobox.addActionListener(this);
			con_no2_combobox.addActionListener(this);
			con_no3_combobox.addActionListener(this);
			con_no4_combobox.addActionListener(this);
				
					}

			 public void actionPerformed(ActionEvent e)
			{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}if(e.getSource()==con_no1_combobox)
			{
				//System.out.println("Selecte d ocnsumer NO");
				try{
					QueryData qd = new QueryData();

					String id=(String)con_no1_combobox.getSelectedItem();
					Vector v = qd.getConsumerDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					Enumeration em=v.elements();
					area_code1.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
					meter_code1.setText((String)em.nextElement());
					ta_riff.setText((String)em.nextElement());
					cphase.setText((String)em.nextElement());
					post_number.setText((String)em.nextElement());
					connected_load.setText((String)em.nextElement());
					consumer_name.setText((String)em.nextElement());
					address.setText((String)em.nextElement());
					date_of_connection.setText((String)em.nextElement());			
					}catch(Exception ex)
				{
						//System.out.println("Error in DataEnt " + ex);
						ex.printStackTrace();
						
			}
 			if(e.getSource()==con_no2_combobox)
			{
					System.out.println("Entered   CON_NO2");
			try{

				QueryData qd = new QueryData();

				String id=(String)con_no2_combobox.getSelectedItem();
				Vector v2 = qd.getMeterDetails(id.trim()); 
				System.out.println("ELements in V2 : " + v2);
				Enumeration em2=v2.elements();
				meter_number.setText((String)em2.nextElement());
				no_of_digit.setText((String)em2.nextElement());
				intial_reading.setText((String)em2.nextElement());
				//no_of_digit.setText((String)em.nextElement());
				}catch(Exception ex)
			{
					//System.out.println("Error in DataEnt " + ex);
					ex.printStackTrace();
			}

			}

		if(e.getSource()==con_no3_combobox)
			{
					System.out.println("Entered   CON_NO3");
			try{

				QueryData qd = new QueryData();
				System.out.println((String)con_no3_combobox.getSelectedItem());
				String id=(String)con_no3_combobox.getSelectedItem();
			//=============================================
				Vector v3 = qd.getDepositDetails(id.trim()); 
			//=============================================
				System.out.println("ELements in V3 : " + v3);
				Enumeration em3=v3.elements();
				cash_deposit.setText((String)em3.nextElement());
				ac_d.setText((String)em3.nextElement());
				oyec_amt.setText((String)em3.nextElement());
				total_no_of_installment.setText((String)em3.nextElement());
				//System.out.println("Ending month" + em3.nextElement());
				
				instalment_end_date.setText((String)em3.nextElement());
				System.out.println("Date     : " + instalment_end_date.getText());
				receipt_no_1.setText((String)em3.nextElement());
				d4.setText((String)em3.nextElement());
				receipt_no_2.setText((String)em3.nextElement());
				
				d5.setText((String)em3.nextElement());
				installment_amount.setText((String)em3.nextElement());
				paid_installment.setText((String)em3.nextElement());
				balance_installment.setText((String)em3.nextElement());
				
				}catch(Exception ex)
			{
					//System.out.println("Error in DataView " + ex);
					ex.printStackTrace();
			}
			

			}
		

		if(e.getSource()==con_no4_combobox)
			{
					System.out.println("Entered   CON_NO4");
			try{

				QueryData qd = new QueryData();
				System.out.println((String)con_no4_combobox.getSelectedItem());
				String id=(String)con_no4_combobox.getSelectedItem();
				 
				Vector v5 = qd.getAreaCode(id);
				Enumeration em5 = v5.elements();
				area_code3.setText((String)em5.nextElement());
				meter_code3.setText((String)em5.nextElement()); 
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
				//System.out.println("Ending month" + em4.nextElement());
				}catch(Exception ex)
			{
					//System.out.println("Error in DataView " + ex);
					ex.printStackTrace();
			}		
		}
	}
}

		public static void main(String arg[])
		{
		DatView dv=new DatView("Data View");
		dv.setVisible(true);
		dv.setSize(750,500);
		dv.pack();
		}
}
