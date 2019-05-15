package emp;


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
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import history.History;



public class Employee extends Frame{

	//public static void main(String args[]) {
	//	Employee u=new Employee();
	//    u.addComponents();
	//    u.addEvents();
	//}
	
History h1;	
Label title;
Button lout,exit,history;
Panel p1;


	public Employee(String v){
		super(v);
		String r = v;
	this.setSize(600, 500);
	this.setLayout(null);
	setBackground(Color.yellow);
	setLocation(700, 300);
	
	p1=new Panel();
	//p1.setBackground(Color.BLACK);
	//p1.setBounds(5, 5, 40, 400);
	

	title=new Label("Payslip");
	Font f=new Font("Serif",Font.BOLD,30);
	title.setFont(f);
	title.setForeground(Color.BLACK);
	

	lout=new Button("logout");
	exit=new Button("Exit");
	history=new Button("History");
	
	//setBounds
	title.setBounds(260,50,500,30);
	lout.setBounds(230,400,80,30);
	exit.setBounds(330, 400, 80, 30);
	history.setBounds(430, 400, 80, 30);
	lout.setBackground(Color.RED);
    exit.setBackground(Color.RED);
	
	 this.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent windowEvent){
	     dispose();}
	    });
	 
	 history.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	
		    	 h1=new History(r);
		    	 //JFrame jf=new JFrame();
		         //History h1= new History(v);
	    		 h1.setVisible(true);
	    		 h1.setSize(500,500);
	    		 h1.setBackground(Color.YELLOW);
		    	//jf.add(tab);

		    }
		});

	 

		try {
			
			
			JLabel r1=new JLabel();
			JLabel r2=new JLabel();
			JLabel r3=new JLabel();
			JLabel r4=new JLabel();
			JLabel r5=new JLabel();
			JLabel r6=new JLabel();
			JLabel r7=new JLabel();
			JLabel r8=new JLabel();
			JLabel l1=new JLabel("User_id:");
			JLabel l2=new JLabel("NAME:");
			JLabel l3=new JLabel("J_DT:");
			JLabel l4=new JLabel("DESIGNATION:");
			JLabel l5=new JLabel("Mgr:");
			JLabel l6=new JLabel("Deprt:");
			JLabel l7=new JLabel("L:");
			JLabel l8=new JLabel("SALARY:");
			
			
			
			
			
			int j=0;
		
			
	    	String database="jdbc:ucanaccess://F://Data2.mdb;";
	    	 Connection conn=DriverManager.getConnection(database,"","");
	    	 Statement s1=conn.createStatement();
	    	 String selTable1 = "SELECT User_id,Ename,Format([J_dt],\"short date\"),Designation,Mgr,Deprt,L,SALARY FROM EMPLOYEE WHERE User_id=\""+ v +"\"";
	           System.out.println(selTable1);
	           s1.execute(selTable1);
	           ResultSet rs1 = s1.getResultSet();
	           rs1.next();
        	       r1=new JLabel(rs1.getString(1));
	         	   r2=new JLabel(rs1.getString(2));
	        	   r3=new JLabel(rs1.getString(3));
	        	   r4=new JLabel(rs1.getString(4));
	        	   r5=new JLabel(rs1.getString(5));
	        	   r6=new JLabel(rs1.getString(6));
	        	   r7=new JLabel(rs1.getString(7));
	        	   r8=new JLabel(rs1.getString(8));
	        	   
	        	   
	        	  r1.setBounds(150,50+(j*100),100,100);
	        	  r2.setBounds(150,50+(j*140),100,140);
	        	  r3.setBounds(150,50+(j*180),80,180);
	        	  r4.setBounds(150,50+(j*220),100,220);
	        	  r5.setBounds(150,50+(j*260),100,260);
	        	  r6.setBounds(150,50+(j*300),100,300);
	        	  r7.setBounds(150,50+(j*340),100,340);
	        	  r8.setBounds(150,50+(j*380),100,380);
	        	  
	        	  l1.setBounds(50,50+(j*100),50,100);
	        	  l2.setBounds(50,50+(j*140),50,140);
	        	  l3.setBounds(50,50+(j*180),50,180);
	        	  l4.setBounds(50,50+(j*220),80,220);
	        	  l5.setBounds(50,50+(j*260),50,260);
	        	  l6.setBounds(50,50+(j*300),50,300);
	        	  l7.setBounds(50,50+(j*340),50,340);
	        	  l8.setBounds(50,50+(j*380),50,380);
	        	   add(r1);
	        	   add(r2);
	        	   add(r3);
	        	   add(r4);
	        	   add(r5);
	        	   add(r6);
	        	   add(r7);
	        	   add(r8);
	        	   add(l1);
	        	   add(l2);
	        	   add(l3);
	        	   add(l4);
	        	   add(l5);
	        	   add(l6);
	        	   add(l7);
	        	   add(l8);
	        	  // j++;
	           //}
	        	   s1.close();
	        	   conn.close();
	         
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addComponents(){
	
	add(title);	
	add(lout);
	add(exit);
	add(history);
	this.setVisible(true);
	p1.setVisible(true);
	}
	
	
	
	
	public void addEvents(){
		
		
		/*String r = v;
		 history.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e){
			    	
			    	 h1=new History(r);
			    	 //JFrame jf=new JFrame();
			         //History h1= new History(v);
		    		 h1.setVisible(true);
		    		 h1.setSize(500,500);
		    		 h1.setBackground(Color.YELLOW);
			    	//jf.add(tab);

			    }
			});*/			 
		
		exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	  JFrame f=new JFrame();
		    	  int a;
		          a = JOptionPane.showConfirmDialog(f,"Do You Want To Exit The System?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		      
		          if(a==JOptionPane.YES_OPTION)
		        	  {
		        	 System.exit(0);
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
		
		
		
	}//add events
	
	
	
	
}// class

