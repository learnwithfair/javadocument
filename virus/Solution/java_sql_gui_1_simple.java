import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class java_sql_gui_1_simple extends JFrame implements ActionListener
{
	JTextField tf1,tf2,tf3;
	JLabel l1,l2,l3;
	JButton b1,b2,b3,b4;
Connection con;
ResultSet rs;
Statement st;
public java_sql_gui_1_simple() 
{
	super("persionDetails");
	setLayout(null);
	Label d=new Label("Person Details");
	d.setBounds(200,10,150,50);
	d.setBackground(Color.RED);
	add(d);
	l1=new JLabel("Name");
	l1.setBounds(100,100,100,50);
	add(l1);
	tf1=new JTextField(" ");

	tf1.setBounds(200,100,250,40);
	add(tf1);
	l2=new JLabel("Email");
	l2.setBounds(100,150,100,50);
	add(l2);
	tf2=new JTextField();
	tf2.setBounds(200,150,250,40);
	add(tf2);
	l3=new JLabel("Phone");
	l3.setBounds(100,200,100,50);
	
	//l3.setFont(new Font("",Font.BOLD));
	add(l3);
	tf3=new JTextField();
	tf3.setBounds(200,200,250,40);
	add(tf3);
	b1=new JButton("Show");
	b1.setBounds(100,250,90,50);
	add(b1);
	b2=new JButton("Insert");
	b2.setBounds(200,250,90,50);
	add(b2);
	b3=new JButton("Update");
	b3.setBounds(300,250,90,50);
	add(b3);
	b4=new JButton("Delete");
	b4.setBounds(400,250,90,50);
	add(b4);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	setSize(600,600);
	setVisible(true);
 connection();
}

public void connection()
{
	try
	{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
        con= DriverManager.getConnection("jdbc:ucanaccess://D:\\Database\\Lab_18.accdb");//Establishing Connection
       System.out.println("Connected Successfully");
	st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 rs=st.executeQuery("SELECT * FROM Practice");
	System.out.println("connect");
	
	//JOptionPane.showMessageDialog(null, "please click next Button");
	}catch(Exception e)
	{
		System.out.println(e);
	}
}

	public void actionPerformed(ActionEvent e)
	{
		
	if(e.getSource()==b1) {
		System.out.println("I am show");
		try
		{
			if(rs.next()){
				tf1.setText(rs.getString("Name"));
				tf2.setText(rs.getString("Email"));
				tf3.setText(rs.getString("Phone"));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No data");
			}	
			
		}catch(Exception ex)
		{
			
		}}
	if(e.getSource()==b2)
	{
		System.out.println("I am Insert");
		String up1=tf1.getText();
		String up2=tf2.getText();
		String up3=tf3.getText();
		try
		{
			rs.updateString("Name",up1);
			rs.updateString("Email",up2);
			rs.updateString("Phone",up3);
			rs.insertRow();
			System.out.println("one row is inserted");
			
		}
		catch(Exception er)
		{
		}
		}
	if(e.getSource()==b3)
	{
		System.out.println("I am Update");
		String up1=tf1.getText();
		String up2=tf2.getText();
		String up3=tf3.getText();
		try
		{
			rs.updateString("Name",up1);
			rs.updateString("Email",up2);
			rs.updateString("Phone",up3);
			rs.updateRow();
			System.out.println("one row is updated");
			
		}
		catch(Exception er)
		{
		}
		}
	
	if(e.getSource()==b4)
	{
		System.out.println("I am Delete");
		try
		{
			rs.deleteRow();
			System.out.println("one row is deleted");
		}catch(Exception er)
		{
			
		}
	}
	}
	

public static void main(String a[])
{
	new java_sql_gui_1_simple();
}
}

