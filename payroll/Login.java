
//package login; 
import java.awt.Button;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import admin.Admin;
import emp.Employee;
import history.History;
import manager.Manager;
import multi.MultiCount;


public class Login extends Frame{

	public static void main(String args[]) {
		Login l=new Login();
	    l.addComponents();
	    l.addEvents();
	}
Label title,log,pass,typ;
final TextField t1,t2;
Panel p1;
Choice type;
Button enter,exit;
Manager newframe1;
Admin newframe2;
Employee newframe3;
History newframe4;
F ob=new F();
static boolean bflag=false;
	public Login(){
	this.setSize(500, 400);
	setLayout(null);
	setBackground(Color.yellow);
	setLocation(700, 300);
	
	p1=new Panel();
	
	//p1.setBackground(Color.BLACK);
	//p1.setBounds(5, 5, 40, 400);
	

	typ=new Label("Type");
	log=new Label("Login");
	pass=new Label("Password");
	title=new Label("PAYROLL SYSTEM");
	Font f=new Font("Serif",Font.BOLD,30);
	title.setFont(f);
	title.setForeground(Color.BLACK);
	type=new Choice();
	type.add("ADMIN");
	type.add("MANAGER");
	type.add("EMPLOYEE");
	
	t1=new TextField();
	t2=new TextField();
	t2.setEchoChar('*');
	
	enter=new Button("Enter");
	exit=new Button("Exit");
	
	//setBounds
	title.setBounds(134,90,300,30);
	log.setBounds(150, 170, 100, 20);
	pass.setBounds(150, 200, 100, 20);
	t1.setBounds(260, 170, 100, 20);
	t2.setBounds(260, 200, 100, 20);
	typ.setBounds(150,140,100,20);
	type.setBounds(260,140,100,20);
	enter.setBounds(170, 240, 70, 30);
	exit.setBounds(260, 240, 70, 30);
	
	 this.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent windowEvent){
	      System.exit(0);}
	    });
	}
	
	public void addComponents(){
	
	add(title);	
	add(log);
	add(pass);
	add(t1);
	add(t2);
	add(type);
	add(typ);
	add(enter);
	add(exit);
	
	this.setVisible(true);
	p1.setVisible(true);
	}

	public void addEvents(){
		exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		          System.exit(0);
		        }
		    });	
		
		        
	          enter.addActionListener(new ActionListener() {
	    		    public void actionPerformed(ActionEvent e){
	    		    int flag=0;	
	    		    String n=t1.getText();
	    		    String p=t2.getText();
	    		    String t=type.getSelectedItem();
	    		    	try {
	    					 String database = 
	    				              "jdbc:ucanaccess://F://Data2.mdb;";
	    					 Connection conn = DriverManager.getConnection(database, "", "");
	    			            Statement s = conn.createStatement();
	    			            String selTable = "SELECT User_id,Pass FROM Pass";
	    			            s.execute(selTable);
	    			            ResultSet rs = s.getResultSet();     
	    		    	
	    		        
	    		    	 while((rs!=null) && (rs.next()))
	    		            {
	    		    		 
	    		    		 if(n.equalsIgnoreCase(rs.getString(1)) && p.equalsIgnoreCase(rs.getString(2))){
	    		            	
	    		    			 
	    		            	  flag =1; 
	    		                 break;
	    		              }
	    		            	
	    		            }
	    		    	 
	    		            s.close();
	    		            conn.close();
	    		          
	    		    	} catch (Exception ex) {
	    				
	    				System.out.println("error");
	    				//ex.printStackTrace();
	    			}
	    		    	
	    		    		    if(flag==1 && t.equalsIgnoreCase("MANAGER")){
	    	    		    		if(n.startsWith("m") || n.startsWith("M")) {
	    	    		    			
	    	    		    			new ManagerMulti(n,ob);
	    	    		    			t1.setText("");
	    	    		    	    	t2.setText("");
	    	    		    		
	    	    	        		    	 
	    	    	        	
	    	    		    		//}
	    	    		    			}
	    	    		    	    
	    	          				else
	    	          				{JFrame f=new JFrame();
	    	          				JOptionPane.showMessageDialog(f, "Type Is Selected For Manager", "Error", 

	    JOptionPane.ERROR_MESSAGE);
	    	          				}
	    		    		    
	          
	    		    		    }		
	    	          				 if(flag==1 && t.equalsIgnoreCase("ADMIN")){
		    	    		    		if(n.startsWith("a") || n.startsWith("A")) {
		    	    		    			//F ob ;
		    	    		    			new AdminMulti(n,ob);
		    	    		    			bflag=true;
		    	    	    		    	
		    	    	    		    	t1.setText("");
		    	    	    		    	t2.setText("");}
		    	    	    		    	    
		    	    	          				else
		    	    	          				{JFrame f=new JFrame();
		    	    	          				JOptionPane.showMessageDialog(f, "Type Is Selected For Admin", "Error", 

		    	    JOptionPane.ERROR_MESSAGE);
	    	    		    			}
	    	    		    	}
	    		    		    
	    	          				else if(flag==1 && t.equalsIgnoreCase("EMPLOYEE")){
		    	    		    		if(n.startsWith("e") || n.startsWith("E")) {
		    	    	    		    	newframe3= new Employee(t1.getText());	
		    	    	    		    	newframe3.setVisible(true);
		    	    	    		    	newframe3.addComponents();
		    	    	    		    	newframe3.addEvents(); 
		    	    	    		    	t1.setText("");
		    	    	    		    	t2.setText("");

		    	    	    		    	newframe4 = new History (t1.getText());
		    	    	    		    	newframe4.setVisible(false);}
		    	    	    		    	    
		    	    	          				else
		    	    	          				{JFrame f=new JFrame();
		    	    	          				JOptionPane.showMessageDialog(f, "Type Is Selected For Employee", "Error", 

		    	    JOptionPane.ERROR_MESSAGE);
	    	    		    			}
	    	    		    	}

	    	    		    	
	    	    		    if(flag==0){
	    	    		    		JFrame f=new JFrame();
	    	    			    	JOptionPane.showMessageDialog(f, "The Login Or Password Is Incorrect", "Error", 

	    JOptionPane.ERROR_MESSAGE);
	    	    		    			    		    		
	    	    		    	        };}
	    		    });
	           
		} //addevents
	class AdminMulti implements Runnable{
		Thread t;
		F ob;
		String id;
			AdminMulti(String id,F ob){
				this.id=id;
				this.ob=ob;
				t=new Thread(this);
				t.start();
			}
			
			public void run(){
				ob.adm(id);
			}
		}

		class ManagerMulti implements Runnable{
		Thread t;
		F ob;
		String id;
			ManagerMulti(String id,F ob){
				this.id=id;
				this.ob=ob;
				t=new Thread(this);
				t.start();
			}

			public void run(){
				ob.man(id);
			}
		}

		class F{
			boolean flag=true;
          //  F ob=new F();
			MultiCount mc=new MultiCount();
			Manager newframe1;
			Admin newframe2;
			
			synchronized void adm(String n){
				
				if(!flag){
					JFrame jf=new JFrame();
					jf.setVisible(true);
					jf.setSize(100, 100);
					jf.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							jf.dispose();
						}
					});
				}
				while(!flag){
					try{
						wait();
					}catch(InterruptedException e){
						System.out.println("Interrupted Exception caught");
					}finally{
						
					}
					}
				
				
				System.out.println("Admin entering");
			    MultiCount.incCount();
				newframe2= new Admin();	
		    	newframe2.setVisible(true);
		    	newframe2.addComponents();
		    	newframe2.addEvents(); 
		   	while(newframe2.mflag()){
		    		System.out.print("");
		    	}
		  	
		    	
		    //	flag=false;
		    	Login.bflag=false;
		    	System.out.println(Login.bflag);
		    	
			}
			
			synchronized void man(String n){
				flag=false;
				
				if(MultiCount.getCount()!=0){
					JFrame f=new JFrame();
			    	JOptionPane.showMessageDialog(f,MultiCount.getCount()+ " Admin is currently working. You will be logged in automatically.", "WAIT", JOptionPane.INFORMATION_MESSAGE);
				}
				while(MultiCount.getCount()!=0){
					if(Login.bflag){
						display();
						Login.bflag=false;
					}
					System.out.print("");
				}
				
				System.out.println("Manager entering");
				try{
	    			String database="jdbc:ucanaccess://F://Data2.mdb;";
			    	 Connection conn=DriverManager.getConnection(database,"","");
			    	 Statement stmt=conn.createStatement();
			    	    String temp = "SELECT Deprt FROM EMPLOYEE WHERE User_id=\""+n+"\"";
    				    //System.out.println(temp);							
			    	    stmt.execute(temp);	
		    	    	ResultSet local2=stmt.getResultSet();
		    	    	 local2.next();
		    	    	String r1=local2.getString(1);
		    	    	newframe1= new Manager();	
				    	newframe1.setVisible(true);
				    	newframe1.addComponents();
				    	newframe1.addEvents(r1);
				    	while(newframe1.mflag()){
				    		if(Login.bflag){
								display();
								Login.bflag=false;
							}
				    	System.out.print("");
				    	}
				    	System.out.println("in here");
				    	flag=true;
				    	notifyAll();
		    	    			
    	stmt.close();
    	conn.close();
    	

    	
    	
     	    	    	    	
        		    	 }
				catch(Exception ex)
	        	{
	        		JFrame f=new JFrame();
	            	JOptionPane.showMessageDialog(f, "Invalid.", "Error", JOptionPane.ERROR_MESSAGE);
	        	}
        		    	 
				
			}
			void display(){
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Manager is currently working. You will be logged in automatically.", "WAIT", JOptionPane.INFORMATION_MESSAGE);
		}
		}
		
}


