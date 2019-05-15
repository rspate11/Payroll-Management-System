package manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Manager extends Frame 
{

	private static final int DA_Rs = 0;
	//public static void main(String args[]) {
	//	Manager f=new Manager(); 
	//	JFrame t= new JFrame("Payroll System");  
	//	f.addComponents();
	//	f.addEvents();
	//}

	//private static double HRA_Rs;

	//private static  double WA_Rs ;

	//private static double GPF_Rs ;

	//private static double IT_Rs;

	//private static  double GIS_Rs ;

	//private static  double PF_Rs ;

	//private static  double LIC_Rs;

JTabbedPane j;
String s;
//JTextArea ta;
List l;
String[] data=new String[15];
//Panel p1,p2,p3;
Label id,name,days;
JLabel J_dt;
final TextField t1,t2,t3; 
JButton lout,exit,add,Generate;
Choice dd=new Choice();
Choice m=new Choice();
Choice y=new Choice();
String User_id="";

		public Manager(){  
		this.setVisible(true);
		this.setSize(500,400);
		this.setLayout(null);
		this.setBackground(Color.yellow);
		this.setLocation(400, 200);
		
		//j=new JTabbedPane();
		//ta=new JTextArea(400,200);
	//	ta.setBackground(Color.yellow);
	//	p1=new Panel();
	//	p2=new Panel();
		//p3=new Panel();
		
		l=new List();
		id=new Label("User_id");
		name=new Label("Ename");
		days=new Label("Leave taken:");
		J_dt=new JLabel("S_date:");
		
		t1=new TextField();
		t2=new TextField();
		t3=new TextField();
		
		add=new JButton("Add");
		lout=new JButton("Log out");
		exit=new JButton("Exit");
		Generate=new JButton("Generate");
		
	    
	    dd.add("date");
		m.add("month");
		y.add("year");
		for(int i=1;i<=31;i++){
			String z=Integer.toString(i);
			dd.add(z);
			
			}
			
			for(int i=1;i<=12;i++){
				String z=Integer.toString(i);
				m.add(z);
			
			}
			
			for(int i=1999;i<=2018;i++){
				String z=Integer.toString(i);
				y.add(z);
				}
			  J_dt.setBounds(50,250,80,30);

		    dd.setBounds(150,250,50,30);
		    m.setBounds(200,250, 100, 30);
		    y.setBounds(300,250, 70, 30);
		    
		    
		
	//	p1.setLayout(null);
	//	p1.setBackground(Color.yellow);
	//	p2.setBackground(Color.yellow);
		//p2.setLayout(null);
		
	
		//setBounds:
		//j.setBounds(50,80,500,400);
		l.setBounds(550, 100,400, 320);
		id.setBounds(50,100,80,30);
		name.setBounds(50,150,80, 30);
		days.setBounds(50,200,80, 30);
		t1.setBounds(150, 100, 300, 30);
		t2.setBounds(150, 150, 300, 30);
		t3.setBounds(150,200,300,30);
	    add.setBounds(150,300 , 80, 30);
	    Generate .setBounds(240,300,100,30);
		lout.setBounds(360, 300, 100, 30);
//	    lout.setBackground(Color.GREEN);
	//    exit.setBackground(Color.RED);
	    lout.setBackground(Color.RED);
	    
		this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent windowEvent){
		      dispose();}
		    });
	}
	
	public void addComponents(){
		
	//	add(j);
        add(add);
		add(id);	
		add(name);
		add(days);
		 add(J_dt);
		    add(dd);
		    add(m);
		    add(y);
		add(t1);
		add(t2);
		add(t3);
        add(Generate);
        add(lout);
      //  p1.add(exit);
//		add(p3);
	//	p3.add(ta);
	//	p3.add(lout);
	//	p3.add(exit);
	
		
		//j.add("Generate Payslip",p1);
		//j.add("Update employee details",p2);
		
	}
public void addEvents(String r1){
		
		add.addActionListener(new ActionListener() {

    		    public void actionPerformed(ActionEvent e){
    		    	String id=t1.getText();
    		    	String name=t2.getText();
    		    	String days=t3.getText();
    		    	
    		    	
    		    	if( id.startsWith("E") )
    		    	
    		    	{
    		    	 try{   
    		    		 
    		    			String database="jdbc:ucanaccess://F://Data2.mdb;";
   				    	 Connection conn=DriverManager.getConnection(database,"","");
   				    	 Statement stmt=conn.createStatement();
   				    	    String temp1 = "SELECT Deprt FROM EMPLOYEE WHERE User_id=\""+id+"\"";
   	    				    //System.out.println(temp);							
   	    	stmt.execute(temp1);
   	    		
	    	ResultSet local5=stmt.getResultSet();
	    	 local5.next();
	    	String r2=local5.getString(1);
	    	
   	    	stmt.close();
   	    	conn.close();
    		    		 
 	    		    			 
	   	    		    		 
	   	    		    	if (r2.equalsIgnoreCase(r1)){
	   	    		    			 
	   	    		    			String database1="jdbc:ucanaccess://F://Data2.mdb;";
	       				    	 Connection conn1=DriverManager.getConnection(database1,"","");
	       				    	 Statement stmt1=conn1.createStatement();	   	    		    		 
    				    	 
  String temp2= "UPDATE  EMPLOYEE SET L="+days+" WHERE User_id=\""+id+"\""; 
  System.out.println(temp2);
							
    	stmt1.execute(temp2);										


    	stmt1.close();
    	conn1.close();
    	}
    		    	 }
    		    	 
    		    	 
    		    
    	catch(Exception ex)
    	{
    	System.out.println(ex);
    	}
    		    	 
    	    		    }
    		    	else{
   		    		 JOptionPane.showMessageDialog(null, "Invalid Entry",
   		    		    	 "WARNING!!",JOptionPane.WARNING_MESSAGE);
    		    	}
    		    }

    	});

		

		Generate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    
		    	System.out.println("Calculating");		   
		   cal();
		   try{
		    	 String id=t1.getText();

		   
		   String database6="jdbc:ucanaccess://F://Data2.mdb;";
		    	 Connection conn6=DriverManager.getConnection(database6,"","");
		    	 Statement stmt6=conn6.createStatement();
		    	 
		    	 String database7="jdbc:ucanaccess://F://Data2.mdb;";
		    	 Connection conn7=DriverManager.getConnection(database7,"","");
		    	 Statement stmt7=conn7.createStatement();
		    	String temp2 = "SELECT  Salary FROM EMPLOYEE  WHERE User_id=\""+id+"\""; 
		    	  System.out.println(temp2);
				    	  
				    								
				    	    	stmt7.execute(temp2);										
				    	    		
				    	    	 ResultSet local=stmt7.getResultSet();
				    	    	 local.next();
				    	    	 double n1=Double.parseDouble(local.getString(1));

				    	    	
		    	 
		    	 String temp3= "INSERT INTO HISTORY(User_id,S_dt,salary) VALUES (\""+id+"\",#"+m.getSelectedItem()+"/"+dd.getSelectedItem()+"/"+y.getSelectedItem()+"#,"+n1+")";
		    	  System.out.println(temp3);
		    								
		    	    	stmt6.execute(temp3);										


		    	    	stmt6.close();
		    	    	conn6.close();
		    	    	stmt7.close();
		    	    	conn7.close();
		   }
		   catch(Exception ea)
		   {
			   System.out.println(ea);
		   }
		    	
		    }  
		});
		
	
		
		
		
		exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	  JFrame f=new JFrame();
		    	  int a;
		          a = JOptionPane.showConfirmDialog(f,"Do You Want To Exit The System?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		      
		          if(a==JOptionPane.YES_OPTION)
		        	  {
		        	  dispose();
		        	  }
		          }
		    });
		
		lout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	  JFrame f=new JFrame();
		    	  int a;
		          a = JOptionPane.showConfirmDialog(f,"Do You Want To Logout?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		      
		          
		          if(a==JOptionPane.YES_OPTION)
	        	  {
	        	 dispose();
	        	  }
		          }
		    });	
	}

	


		
		
		public  void cal()
		
		{ double DA_Rs;
		  double HRA_Rs;
		  double WA_Rs;
		  
		  double GPF_Rs;
		  double IT_Rs;
		  double GIS_Rs;
		  double PF_Rs;
		  double LIC_Rs;
			String id=t1.getText();
			try{
				String database1="jdbc:ucanaccess://F://Data2.mdb;";
			    	 Connection conn1=DriverManager.getConnection(database1,"","");
			    	 Statement stmt3=conn1.createStatement();	   	    		    		 

				
			    	  String q = "SELECT  L FROM EMPLOYEE  WHERE User_id=\""+id+"\""; 
			    	  System.out.println(q);
			    								
			    	    	stmt3.execute(q);	
			    	    	 ResultSet local=stmt3.getResultSet();
			    	    	 local.next();
			    	    	 double n=Double.parseDouble(local.getString(1));
			    			 
			    	    	 
			    	    	 String database2="jdbc:ucanaccess://F://Data2.mdb;";
					    	 Connection conn2=DriverManager.getConnection(database2,"","");
					    	 Statement stmt1=conn2.createStatement();	   	    	 
		 
					    	 String r = "SELECT  Designation FROM EMPLOYEE  WHERE User_id=\""+id+"\"";
					    	 System.out.println(r);
								
				    	    	stmt1.execute(r);	
				    	    	ResultSet local2=stmt1.getResultSet();
				    	    	 local2.next();
				    	    	String r1=local2.getString(1);
				    	    	
				    	    	 String database4="jdbc:ucanaccess://F://Data1.mdb;";
						    	 Connection conn4=DriverManager.getConnection(database4,"","");
						    	 Statement stmt5=conn4.createStatement();	   	  
					  String q1 = "SELECT Basic_Pay, DA,HRA,WA,GPF,IT,GIS,PF,LIC,DA_Value,HRA_Value,WA_Value,GPF_Value,IT_Value,GIS_Value,PF_Value,LIC_Value,sal  FROM CALCULATION  WHERE Designation=\""+r1+"\""; 
					    	  System.out.println(q1);
					    	  stmt5.execute(q1);	
					    	  
					    	  ResultSet rs=stmt5.getResultSet();
				    	    	while( rs.next())
				    	    	
				    	        
				                
				                {
				                	
				            double Basic_Pay = rs.getInt(1);              	                    
				             String DA = rs.getString(2);
				    		 String	HRA = rs.getString(3);
				    		 String	WA = rs.getString(4);
				    		String   GPF = rs.getString(5);
				    		String 	IT = rs.getString(6);
				    		String 	GIS = rs.getString(7);
				    		String 	PF = rs.getString(8);
				    		String	LIC = rs.getString(9);
				    		int DA_Value = rs.getInt(10);
				    		int 	HRA_Value = rs.getInt(11);
				    		 int	WA_Value = rs.getInt(12);
				    		 int  GPF_Value = rs.getInt(13);
				    		 int	IT_Value = rs.getInt(14);
				    		 int	GIS_Value = rs.getInt(15);
				    		 int	PF_Value = rs.getInt(16);
				    		int	LIC_Value = rs.getInt(17);
				    		  double sal=rs.getInt(18);
				    			//leave=rs.getInt(11);
				    		    
				    			if (DA.equals("true") )
				    			{
				    				DA_Rs =  (Basic_Pay*DA_Value)/100;
				    		
				    			}
				    			else
				    			{
				    			 	DA_Rs =DA_Value ;
				    			
				    			}
				    			
				    			if (HRA.equals("true"))
				    			{
				    			    HRA_Rs = (Basic_Pay *HRA_Value ) / 100;	
				    			}
				    			else
				    			{
				    				HRA_Rs = HRA_Value;
				    			}
				    			
				    			if (WA.equals("true"))
				    			{
				    			    WA_Rs = (Basic_Pay * WA_Value) / 100;	
				    			}
				    			else
				    			{
				    			 	WA_Rs = WA_Value;
				    			}
				    			
				    			if (GPF.equals("true"))
				    			{
				    			   GPF_Rs = (Basic_Pay * GPF_Value) / 100;	
				    			}
				    			else
				    			{
				    				GPF_Rs = GPF_Value;
				    			}
				    			
				    			if (IT.equals("true"))
				    			{
				    				IT_Rs = (Basic_Pay * IT_Value) / 100;	
				    			}
				    			else
				    			{
				    				IT_Rs = IT_Value;
				    			}
				    			
				    			if (GIS.equals("true"))
				    			{
				    				GIS_Rs = (Basic_Pay * GIS_Value) / 100;	
				    			}
				    			else
				    			{
				    				GIS_Rs = GIS_Value;
				    			}
				    			
				    				if (PF.equals("true"))
				    			{
				    				PF_Rs = (Basic_Pay * PF_Value) / 100;	
				    			}
				    			else
				    			{
				    				PF_Rs = PF_Value;
				    			}
				    			
				    			
				    				if (LIC.equals("true"))
				    			{
				    				LIC_Rs = (Basic_Pay * LIC_Value) / 100;	
				    			}
				    			else
				    			{
				    				LIC_Rs = LIC_Value;
				    			}
				    			
				    		
				    			 double net=n*sal;
				    			
								double Allow = DA_Rs+ HRA_Rs + WA_Rs;
				    		
							double	Dedu = GPF_Rs + IT_Rs + GIS_Rs + PF_Rs + LIC_Rs;
				    		double	sal1= (Basic_Pay + Allow) - Dedu - net ;
				    		
				                	    	 
				  
				  String database3="jdbc:ucanaccess://F://Data2.mdb;";
			    	 Connection conn3=DriverManager.getConnection(database3,"","");
			    	 Statement stmt2=conn3.createStatement();	   	    	 

				  String q2="UPDATE EMPLOYEE SET SALARY="+sal1+" WHERE User_id=\""+id+"\"";  
				  System.out.println(q2);
		    	 stmt2.execute(q2);	
		    	  
		    	  stmt3.close();
		    		conn1.close();
		    		
		    	 	stmt1.close();
		    		conn2.close();
		    		 stmt5.close();
			    		conn4.close();
		    		stmt2.close();
		    		conn3.close();
		    	  
				                }	  
					    	  
	}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
}


	

