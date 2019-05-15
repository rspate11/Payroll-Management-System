package addemp;
import java.awt.Color;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import delemp.View;

import javax.swing.*;
public class Newadd<JChoice> extends Frame{
	
	    
String  dialogmessage;
	 View v1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	public JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton a,b,c;
	Panel p1;
	
	//JTabbedPane j;
	String User_id = "";
	String Emp_no = "";
	String Ename = "";
	//String J_dt = "";
	String Designation  = "";
	String Mgr   = ""; 
	String Deprt  = ""; 
	String Pass  = ""; 
	JLabel J_dt;
                  Choice r=new Choice();
	Choice dd=new Choice();
	Choice m=new Choice();
	Choice y=new Choice();
	
	
	//String Contact_no = ""; 
	
	//public Newadd()
	
		
	
	public Newadd(String s)
	{
		super(s);
		setLayout(null);
		
		
	    l1=new JLabel("User_id");
	    l2=new JLabel("Emp_no");
	    l3=new JLabel("Ename");
	    J_dt=new JLabel("J_dt");
	    l5=new JLabel("Deprt");
	    l6=new JLabel("Designation");
	    l7=new JLabel("Mgr");
	    l8=new JLabel("Pass");

	    
	    p1=new Panel();
	    a=new JButton("Add");
	    c=new JButton("View");

	    b=new JButton("Exit");
	
	    r.add("Marketing");
 	    r.add("Designing");
	    
	    a.setBounds(50,550,80,30);
	    c.setBounds(150,550,80,30);
	    b.setBounds(250, 550, 80, 30);
	    b.setBackground(Color.RED);
	    
	    
	    l1.setBounds(50,50,80,30);
	    l2.setBounds(50,150,80,30);
	    l3.setBounds(50,200,80,30);
	    l5.setBounds(50,300,80,30);
	    l6.setBounds(50,350,80,30);
	    l7.setBounds(50,400,80,30);
	    l8.setBounds(50,100,80,30);
	    

	   // p1.setBounds(400,50 ,200 , 550);
	   // p1.setBackground(Color.CYAN);
	    t1=new JTextField();
	    t2=new JTextField();
	    t3=new JTextField();
	   // t4=new JTextField();
	   // t5=new JTextField();
	    t6=new JTextField();
	    t7=new JTextField();
	    t8=new JTextField();
	    
	    t1.setBounds(150, 50, 200, 30);
	    t2.setBounds(150, 150, 200, 30);
	    t3.setBounds(150, 200, 200, 30);
	   // t4.setBounds(150, 250, 200, 30);
	   // t5.setBounds(150, 300, 200, 30);
	    t6.setBounds(150, 350, 200, 30);
	    t7.setBounds(150, 400, 200, 30);
	    r.setBounds(150, 300, 200, 30);	
	    t8.setBounds(150, 100, 200, 30);
	    
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
			
			for(int i=1999;i<=2017;i++){
				String z=Integer.toString(i);
				y.add(z);
				}
			  J_dt.setBounds(50,250,80,30);

		    dd.setBounds(150,250,70,30);
		    m.setBounds(220,250, 90, 30);
		    y.setBounds(310,250, 70, 30);
		    
		   
	    
	    
	   add(l1);
	    add(l2);
	    add(l3);
	    add(J_dt);
	    add(dd);
	    add(m);
	    add(y);
	    add(l5);
	    add(l6);
	    add(l7);
	    add(l8);
	   add(t1);
	    add(t2);
	    add(t3);
	  //  add(t4);
	    add(t5);
	    add(t6);
	    add(t7);
	    add(t8);
	    add(r);
	    add(a);
	    add(b);
	    add(c);
	   // add(p1);
//p1.setVisible(false);
		this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent windowEvent){
		      dispose();}
		    });
	   //   a.addActionListener(this);
	  // b.addActionListener(this);
	    //setOpaque(true);
	}
	    public void addEvents()
		{
	    	
	    	c.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e){
    		    
    		   
    		 
    		    	 v1=new View("Details");
    	    		   
    	    		    v1.setVisible(true);
    	    		    v1.setSize(500,500);
    	    		    v1.setBackground(Color.YELLOW);
    		  
    		    }
	    	});
			
	    	a.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e){
    		    
    		    String User_id=t1.getText();
    		    	String Emp_no=t2.getText();
    		    	String Ename=t3.getText();
    		    	//String J_dt=t4.getText();
    		    	String Deprt=r.getSelectedText();
    		    	String Designation =t6.getText();
    		    	String Mgr =t7.getText();
    		    	String Pass =t8.getText();
    		    	
    		    	if ((User_id.startsWith("E") && Deprt.equalsIgnoreCase("Marketing") && Mgr.equalsIgnoreCase("Ramesh Solanki") )|| 
    		    			User_id.startsWith("E") && Deprt.equalsIgnoreCase("Designing") && Mgr.equalsIgnoreCase("Shyam Malath"))
    		    	{
    		    	 try{   
    				    	String database="jdbc:ucanaccess://F://Data2.mdb;";
    				    	 Connection conn=DriverManager.getConnection(database,"","");
    				    	 Statement stmt=conn.createStatement();
    				    
    				    String temp = "INSERT INTO EMPLOYEE(User_id,Emp_no,Ename,J_dt,Designation,Mgr,Deprt) VALUES (\""+User_id+"\", "+Emp_no+",\""+Ename+"\",#"+m.getSelectedItem()+"/"+dd.getSelectedItem()+"/"+y.getSelectedItem()+"#,\""+Designation+"\",\""+Mgr+"\",\""+Deprt+"\")"; 
    				    System.out.println(temp);							
    	stmt.execute(temp);			
    	
    	



    	
    		    	 String database1="jdbc:ucanaccess://F://Data2.mdb;";
			    	 Connection conn1=DriverManager.getConnection(database,"","");
			    	 Statement stmt1=conn1.createStatement();	    
			    	 String temp1 = "INSERT INTO PASS(User_id,Pass) VALUES (\""+User_id+"\",\""+Pass+"\")"; 
 				    System.out.println(temp1);							
 	stmt.execute(temp1);
 	t1.setText("");
	t2.setText("");
	t3.setText("");
	dd.removeAll();
	m.removeAll();
	y.removeAll();
	
                  t5.setText("");
	t6.setText("");
	t7.setText("");
	t8.setText("");
	

	stmt.close();
	conn.close();
 	stmt1.close();
	conn1.close();
    		    	 }
    		    	 
    		    	 
    	catch(Exception ex)
    	{
    		JFrame f=new JFrame();
        	JOptionPane.showMessageDialog(f, "Invalid.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    		    	}
    		    	 else{
    		    		 JOptionPane.showMessageDialog(null, "User_id should be start with E for employee",
    		    		    	 "WARNING!!",JOptionPane.WARNING_MESSAGE);

    	    		    }
    	    		    }

    	});
	    		
    		    



                b.addActionListener(new ActionListener() {
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
			    
	    	
	 
	    //addWindowListener(new WindowAdapter()
       // {
       //  public void windowClosing(WindowEvent e)
      //   {
        //  System.exit(0);
        // }
       // });
                
	    
			     
			    
	    	}
	    	


	/*public static void main(String[] st)
	{
		Newadd n1=new Newadd("Fill Details");
		n1.addEvents();
		n1.setVisible(true);
		n1.setSize(650,650);
		n1.setBackground(Color.YELLOW);
		n1.setLocation(0,0);
	}*/
	
}
 


