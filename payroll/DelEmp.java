package delemp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import view.View;


public class DelEmp extends Frame{
	
	    
String  dialogmessage;
	View v2; 
	JLabel l1,l2,l3,l4,l5,l6;
	public JTextField t1,t2,t3,t4,t5,t6;
	JButton a,b,c;
	JPanel p1;
	JScrollPane sp; 
	//JTabbedPane j;
	String User_id = "";
	
	
	
	

	
		
	
	public DelEmp(String s)
	
	{
		super(s);
		setLayout(null);
		
		
	    	 
		
		l1=new JLabel("User_id");
	   
	    a=new JButton("Delete");
	    b=new JButton("Exit");
	    c=new JButton("View");
	   // p1=new Panel();
	    
	    c.setBounds(50,250,80,30);
	    a.setBounds(150,250,80,30);
	    b.setBounds(250, 250, 80, 30);
	    b.setBackground(Color.RED);
	     p1=new JPanel();
	    l1.setBounds(50,50,80,30);
	    p1.setBounds(50, 100,400 , 120);
	    p1.setBackground(Color.CYAN);
	   t1=new JTextField();
	    
	    
	    t1.setBounds(150, 50, 100, 30);
		this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent windowEvent){
		      dispose();}
		    });
	}
	public void addComp() {   
	   add(l1);
	  
	   add(t1);
	  
	    add(a);
	    add(b);
	    add(c);
	   // add(p1);
}
	
	    public void addEvents()
		{
	    	
	    	 c.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e){
    		    
    		   
    		 
    		    	 v2=new View("Details");
    	    		   
    	    		    v2.setVisible(true);
    	    		    v2.setSize(500,500);
    	    		    v2.setBackground(Color.YELLOW);
    		  
    		    }
	    	});
		
			
	    	
	  
			
			
	    	a.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e){
    		    	p1.setVisible(false);
    		    	String User_id=t1.getText();
    		    	if(( User_id.startsWith("E")))
    		    	{
    		    	
    		    	 try{   
    				    	String database="jdbc:ucanaccess://F://Data2.mdb;";
    				    	 Connection conn=DriverManager.getConnection(database,"","");
    				    	 Statement stmt=conn.createStatement();
    				    
    				    String temp = "DELETE FROM EMPLOYEE WHERE User_id=\""+User_id+"\""; 
    				    
    				    
    				    
    				    	
    				   
    	stmt.execute(temp);	
    	String database1="jdbc:ucanaccess://F://Data2.mdb;";
   	 Connection conn1=DriverManager.getConnection(database,"","");
   	 Statement stmt1=conn1.createStatement();
   	 
   	 String temp1 = "DELETE FROM PASS WHERE User_id=\""+User_id+"\"";
   	stmt.execute(temp1);	
    	t1.setText("");
    	
    				   
    		    	 

    	stmt.close();
    	conn.close();
    	stmt1.close();
    	conn1.close();}
    		    	 
    		    	
    		    		    	 
    		    	 
    	catch(Exception ex)
    	{
    	String s1="error";
    	}
    	    		    }
    		    	 else{
    		    		 JOptionPane.showMessageDialog(null, "Invalid Entry",
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
			    
	    	
	 
	    addWindowListener(new WindowAdapter()
       {
         public void windowClosing(WindowEvent e)
         {
         dispose();
         }
        });
                
	    
			     
			    
	    	}
	    	
		
	    	
		
		
	    

	



	/*public static void main(String[] st)
	{
		DelEmp n1=new DelEmp("Fill Details");
		n1.addEvents();
		n1.addComp();
		//n1.setLayout(null);
		n1.setVisible(true);
		n1.setSize(500,300);
		n1.setBackground(Color.YELLOW);
		n1.setLocation(0,0);
	}*/
	
}
 


