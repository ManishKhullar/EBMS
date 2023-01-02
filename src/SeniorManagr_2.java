//package updated1;

	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;
	import java.sql.*;
	import javax.swing.border.*;

	public class  SeniorManagr_2 extends JFrame implements ActionListener
	 { 
		JMenuBar menubar;
		JMenu file,consumeradmin,cashdeposit,demand,cash,csd;
		JMenuItem adduser,changepassword,cancel,delete1,logout,changetariff,walkorderassig,addcon,sportbillcollection,acdcollection,addconsumerdetails,modifycon,connectedloadchange,addeditconsumer,viewconsumerstatus;
		JMenuItem viewbilldetails,meterchange,generaleditdemand,demandwithdrawal,cdadjustment,acd,demandadjustments,advancepayment,DatEnt,DatView;
		Connection conection;
		PreparedStatement pstatement;
	  	JDesktopPane desktop;
		public SeniorManagr_2(String title)
	  	{
			super("ELECTRICITY ..BILLING.. SYSTEM: ASSISTANT ENGINEER");
			String category=title;
			desktop = new JDesktopPane();
			menubar = new JMenuBar();
			file = new JMenu("OfficeAdministration  ");
			adduser = new JMenuItem("Add adduser");
			changepassword = new JMenuItem("Change Password");
			delete1 = new JMenuItem("Deleteuser");
			logout=new JMenuItem("logout");
			cancel= new JMenuItem("Exit");
			file.add(adduser);
			file.add(changepassword);
			file.addSeparator();	    
			file.add(delete1);
			file.add(logout);
			file.add(cancel);

			consumeradmin = new JMenu("  ConsumerAdministration   ");
			addeditconsumer = new JMenuItem("Add Consumer");
		//	addcon = new JMenuItem("Add New Consumer");
		//	addeditconsumer.add(addcon);
			viewconsumerstatus = new JMenuItem("View Consumer Status");
			viewbilldetails = new JMenuItem("View Bill details");
			meterchange = new JMenuItem("MeterChange");
			changetariff = new JMenuItem("Change Tariff");
			connectedloadchange = new JMenuItem("Connected Load Change");// domestic/industrial/commercial :)
			
		//	walkorderassig = new JMenuItem("WalkOrderAssignment");
		//	DatEnt=new JMenuItem("Entering new consuer");
		//	DatView=new JMenuItem("View a consuer");
			consumeradmin.add(addeditconsumer);
			consumeradmin.add(viewconsumerstatus);
			consumeradmin.add(viewbilldetails);
			consumeradmin.add(meterchange);
			consumeradmin.add(changetariff);
			consumeradmin.add(connectedloadchange);
			//consumeradmin.add(cashdeposit);

		//	consumeradmin.add(walkorderassig);
		//	consumeradmin.add(DatEnt);
		//	consumeradmin.add(DatView);
			demand=new JMenu("   Demand   ");
		generaleditdemand = new JMenuItem("Generate/edit Demand ");
		demandwithdrawal = new JMenuItem("Demand Withdrawal");
		demandadjustments = new JMenuItem("Demand Adjustments");
		advancepayment = new JMenuItem("Advance payment");
			demand.add(generaleditdemand);
			demand.add(demandwithdrawal);
			demand.add(demandadjustments);
			demand.add(advancepayment);

		     cash=new JMenu("   CASH   ");
		     sportbillcollection = new JMenuItem("Spot Bill Collection ");
		     cash.add(sportbillcollection);
		    acdcollection=new JMenuItem("ACD Collection ");
		     cash.add(acdcollection);

		     cashdeposit = new JMenu("Cash Deposit ");
		     cash.add(cashdeposit);
				cdadjustment=new JMenuItem("C D adjustment");
				acd=new JMenuItem("A C D");
				cashdeposit.add(cdadjustment);
				cashdeposit.add(acd);
			menubar.add(file);
			menubar.add(consumeradmin);
			menubar.add(demand);
			menubar.add(cash);
			setJMenuBar(menubar);
			desktop.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(800,0,0,0,new ImageIcon("C:\\EBMS\\images\\peace.jpg")),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
			getContentPane().add(desktop,BorderLayout.CENTER);
			
			adduser.addActionListener(this);
			changepassword.addActionListener(this);
			delete1.addActionListener(this);
			logout.addActionListener(this);
			addeditconsumer.addActionListener(this);
			viewconsumerstatus.addActionListener(this);
			cancel.addActionListener(this);
			
			viewbilldetails.addActionListener(this);
			meterchange.addActionListener(this);
			changetariff.addActionListener(this);
			connectedloadchange.addActionListener(this);
			cdadjustment.addActionListener(this); 
			acd.addActionListener(this);
			
			
			
			generaleditdemand.addActionListener(this);
			demandwithdrawal.addActionListener(this);
			demandadjustments.addActionListener(this);
			advancepayment.addActionListener(this);	
			sportbillcollection.addActionListener(this);	
			acdcollection.addActionListener(this);
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e)
				{
					System.exit(1);
				}
			});

			if(category.equals(""))
			{
			}
			else if(category.equals(""))
			{
			}
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == addeditconsumer)
				{
				DatEnt de=new DatEnt("Add / Edit Consumer");
				desktop.add(de);
				de.setVisible(true);
			    de.setSize(750,500);
				}  
				
				else if(e.getSource() == adduser)
				{
				AddUser au = new AddUser("ADD adduser");
				desktop.add(au);
				au.setSize(400,250);
				//setLocation(400,400);
				au.setVisible(true);
				}
				else if (e.getSource() == delete1) {
					deluser dl = new deluser("Delete adduser");
					desktop.add(dl);
					dl.setSize(400, 250);
					// setLocation(400,400);
					dl.setVisible(true);
				}
				else if(e.getSource()==logout)
				{
					//logout l1=new logout("logout user");
					System.out.println("Inside 0");
							String s0="you are logged out successfully";
							JOptionPane.showMessageDialog(null,s0);
							Login login = new Login("User login");
							login.setSize(500, 400);
							login.setBackground(Color.cyan);
							login.setVisible(true);
							//this.setVisible(false);
								this.dispose();
				}
				else if(e.getSource() == changepassword)
				{
				Chpwd chp= new Chpwd("CHANGE PASSWORD");
				desktop.add(chp);
				chp.setSize(420,270);
				chp.setVisible(true);
				}
				else if (e.getSource() == cancel) {
					this.dispose();
				}
				else if(e.getSource() == viewconsumerstatus)
				{
				DatView dv=new DatView("View Consumer Status");
				desktop.add(dv);
				dv.setVisible(true);
			                 dv.setSize(750,500);
				}
				
				else if(e.getSource() == viewbilldetails)
				{
				Billdetails bd = new Billdetails("BILL DETAILS");
				desktop.add(bd);
				bd.setVisible(true);
				bd.setSize(900,550);
					
				}
				else if(e.getSource() == meterchange)
				{
						MeterChange mch = new MeterChange("Meter Change");
						desktop.add(mch);
						mch.setSize(550,550);
						mch.setVisible(true);
				}
				
				else if(e.getSource() == changetariff)
				{
				TariffChange w = new TariffChange("Tariff Change");
				desktop.add(w);
				w.setVisible(true);
		        		w.setSize(600,550);
				}
				
				else if(e.getSource() == connectedloadchange)
				{
				ConnectedLoadChange clch = new ConnectedLoadChange("ConnectedLoadChange");
				desktop.add(clch);
				clch.setSize(550,550);
				clch.setVisible(true);	
				}
		//-----------------------------------------------------------------------------		
				else if(e.getSource() == cdadjustment)
				{
				Cdadj cdad = new Cdadj("C D Adjustment");
				desktop.add(cdad);
				cdad.setSize(600,550);
				cdad.setVisible(true);
				}
	  			else if(e.getSource() == acd)
				{
				Acd addconsumerdetails = new Acd("Addl: C.D");
				desktop.add(addconsumerdetails);
				addconsumerdetails.setSize(400,550);
				addconsumerdetails.setVisible(true);
				}
	  			/*	else if(e.getSource()==intrestondeposit)
				{
				IntrestonDeposit intrestondeposit = new IntrestonDeposit("Intrest on Deposit");
				desktop.add(intrestondeposit);
	            intrestondeposit.setSize(550,550);
				intrestondeposit.setVisible(true);
				}	
*/	

	 //--------------------------------------------------------------------------------			
				else if(e.getSource() == generaleditdemand)
				{
			
				Demand d = new Demand("DEMAND");
				desktop.add(d);
				d.setSize(880,550);
				d.setVisible(true);
				}
				else if(e.getSource() == demandwithdrawal)
				{

						DemandWithdrawal wid = new DemandWithdrawal("Demand Withdrawal");
						desktop.add(wid);
						wid.setSize(550,550);
						wid.setVisible(true);
				}
				
				else if(e.getSource()==demandadjustments)
					{
				
				    Ccadj cadj = new Ccadj("Current Charge Adjustment");
				    desktop.add(cadj);
					cadj.setSize(600,550);
					cadj.setVisible(true);
					}
					
				else if(e.getSource()==advancepayment)
				{
					Ccadv ccad = new Ccadv("ADVANCE PAYMENT");
					desktop.add(ccad);
					ccad.setSize(400,550);
					ccad.setVisible(true);
				}
				
					else if(e.getSource()==sportbillcollection)
				{
					Collection c = new Collection("COLLECTION");
					desktop.add(c);
					c.setSize(400,550);
					c.setVisible(true);
				}

				else if (e.getSource()==acdcollection)
				{
				System.out.println("Entered ACDC");
				AcdCollection acdc = new AcdCollection(" ACD COLLECTION WINDOW");
				desktop.add(acdc);
				acdc.setSize(450,550);
				acdc.setVisible(true);
				}
				}  	
			public static void main(String arg[])
			{
				SeniorManagr_2 ss1 = new SeniorManagr_2("ASSISTANT ENGINEER");
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				ss1.setSize(1000,720);
								ss1.setBackground(Color.white);
								ss1.setVisible(true);
								
			}
			
	}