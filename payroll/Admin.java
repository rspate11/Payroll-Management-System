package admin;



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
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import addemp.Newadd;
import delemp.DelEmp;






public class Admin extends Frame{

	public static void main(String args[]) {
		Admin u=new Admin();
	    u.addComponents();
	    u.addEvents();
	}
Label title;
Button lout,exit,a,b;
Panel p1;
Newadd newframe;
DelEmp newframe1;


	public Admin(){
	this.setSize(500, 400);
	setLayout(null);
	setBackground(Color.yellow);
	setLocation(700, 300);
	
	p1=new Panel();
	//p1.setBackground(Color.BLACK);
	//p1.setBounds(5, 5, 40, 400);
	

	title=new Label("PAYROLL SYSTEM");
	Font f=new Font("Serif",Font.BOLD,30);
	title.setFont(f);
	title.setForeground(Color.BLACK);
	

	a=new Button("Add employee");
	b=new Button("Delete employee");
	lout=new Button("logout");
	exit=new Button("Exit");
	
	//setBounds
	title.setBounds(110,90,500,30);
	a.setBounds(180, 170, 150, 30);
	b.setBounds(180, 220, 150, 30);
	lout.setBounds(220, 270, 70, 30);
	exit.setBounds(220, 310, 70, 30);
	a.setBackground(Color.cyan);
    b.setBackground(Color.cyan);
	lout.setBackground(Color.RED);
    exit.setBackground(Color.RED);
	
	 this.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent windowEvent){
	      dispose();}
	    });
	}
	
	public void addComponents(){
	
	add(title);	
	add(a);
	add(b);
	add(lout);
	add(exit);
	
	this.setVisible(true);
	p1.setVisible(true);
	}
	
	public void addEvents(){

		a.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	newframe= new Newadd("Fill Details");	
		    	newframe.setVisible(true);
		    	newframe.addEvents();
		    	newframe.setBackground(Color.YELLOW);
		    	newframe.setSize(650,700);
		    	
		    	
		          }
		    });
		
		b.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	newframe1= new DelEmp("delete");	
		    	newframe1.setVisible(true);
		    	newframe1.addEvents();
		    	newframe1.addComp();
		    	newframe1.setBackground(Color.YELLOW);
		    	newframe1.setSize(500,300);
		    	
		    	
		          }
		    });
		
	
		
			exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	  Frame f=new Frame();
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
		    	  Frame f=new Frame();
		    	  int a;
		          a = JOptionPane.showConfirmDialog(f,"Do You Want To Logout?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		      
		          if(a==JOptionPane.YES_OPTION)
		        	  {
		        	  dispose();
		        	  }
		          }
		    });	
		
		
		
	}
	
}

