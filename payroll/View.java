package delemp;

import java.awt.Frame;
import java.awt.Color;
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

public class View extends Frame{
	//public View(
	//{
		
	//}
	public View(String s)
	
	{
		
		
		super(s);
		setLayout(null);
		
	    this.addWindowListener(new WindowAdapter()
	       {
	         public void windowClosing(WindowEvent e)
	         {
	          dispose();
	         }
	        });
	        
		
		try{   
			JLabel[] r=new JLabel[150];
			int j=0;
		
			
	    	String database="jdbc:ucanaccess://F://Data2.mdb;";
	    	 Connection conn=DriverManager.getConnection(database,"","");
	    	 Statement s1=conn.createStatement();
	    	 String selTable1 = "SELECT ID,Ename FROM EMPLOYEE";
	           System.out.println(selTable1);
	           s1.execute(selTable1);
	           ResultSet rs1 = s1.getResultSet();
	           //rs1.next();
	           while((rs1!=null) && (rs1.next())){
	        	   r[j]=new JLabel(rs1.getString(1)+"    "+rs1.getString(2));
	        	  r[j].setBounds(80,50+(j*30),100,20);
	        	   add(r[j]);
	        	   j++;
	           }
	        	   s1.close();
	        	   conn.close();
		}
		catch(Exception e)
		{
			System.out.println("error"+e);
		}
	}
		/*public static void main(String[] st)
		{
			View n1=new View("view");
			//n1.addEvents();
			n1.setVisible(true);
			n1.setSize(600,700);
			n1.setBackground(Color.YELLOW);
			n1.setLocation(0,0);
		}*/
		
}
	