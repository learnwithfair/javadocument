import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class java_sql_gui_1_simple extends JFrame implements ActionListener{
Connection con;
ResultSet rs,ts;
Statement st;

protected Container c;
protected JLabel title,name, email, phone;    
protected JTable tbl;
protected JTextField nametf, emailtf, phonetf;
protected JButton addbtn, updbtn, dltbtn,showbtn;
protected DefaultTableModel model;
protected String[] cols = {"Name", "Email", "Phone"};
protected String[] row = new String[10];

	java_sql_gui_1_simple() {
	    this.setBounds(20, 29, 590, 550);
	    this.setLocationRelativeTo(null);
	    this.setTitle("Teachers Registration Form");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    c = this.getContentPane();
	    c.setLayout(null);       
	    
	    title = new JLabel("*Teachers Registration Form*");        
	    title.setBounds(170, 10, 340, 70);
	    title.setForeground(Color.RED);    
	    title.setFont(new Font("Times new Roman",Font.BOLD,22));
	    c.add(title);
	    
	    name = new JLabel("Full Name :");        
	    name.setBounds(20, 80, 130, 60);           
	    c.add(name);
	    
	    nametf = new JTextField();
	    nametf.setBounds(170, 87, 240, 50);       
	    nametf.setToolTipText("Enter Your Name");          
	    c.add(nametf);
	    
	    addbtn = new JButton("Submit");
	    addbtn.setBounds(420, 87, 140, 50);       
	    c.add(addbtn);
	    
	    email = new JLabel();
	    email.setText("Email :");
	    email.setBounds(20, 140, 130, 60);
	    c.add(email);
	    
	    emailtf = new JTextField();
	    emailtf.setBounds(170, 147, 240, 50);
	    emailtf.setToolTipText("Enter Your Email");               
	    c.add(emailtf);
	    
	    updbtn = new JButton("Update");
	    updbtn.setBounds(420, 147, 140, 50);      
	    c.add(updbtn);
	    
	    phone = new JLabel();
	    phone.setText("Phone No :");
	    phone.setBounds(20, 200, 130, 60);
	    c.add(phone);
	    
	    phonetf = new JTextField();
	    phonetf.setBounds(170, 207, 240, 50);
	    phonetf.setToolTipText("Enter Your Phone No");
	    c.add(phonetf);
	    
	    dltbtn = new JButton("Delete");
	    dltbtn.setBounds(420, 207, 140, 50);        
	    c.add(dltbtn);
	    
	    showbtn = new JButton("Show");
	    showbtn.setBounds(420, 267, 140, 50);        
	    c.add(showbtn);
	    
	    model = new DefaultTableModel();
	    model.setColumnIdentifiers(cols);
	    tbl = new JTable(model);
	    //tbl.setModel(model);
	    tbl.setBackground(Color.WHITE);
	    tbl.setSelectionBackground(Color.GREEN);      
	    tbl.setRowHeight(40);
	    JScrollPane scroll = new JScrollPane(tbl);
	    scroll.setBounds(20, 335, 540, 150);
	    c.add(scroll);
	    
	    addbtn.addActionListener(this);
	    dltbtn.addActionListener(this);        
	    updbtn.addActionListener(this);
	    showbtn.addActionListener(this);
		connection();
		
		tbl.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                int numOfRow = tbl.getSelectedRow();
                //tbl.addRowSelectionInterval(1, 3);
                String t_name = model.getValueAt(numOfRow, 0).toString();
                String t_email = model.getValueAt(numOfRow, 1).toString();
                String t_phone = model.getValueAt(numOfRow, 2).toString();
                
                nametf.setText(t_name);
                emailtf.setText(t_email);
                phonetf.setText(t_phone);               
            }
        });
}

public void connection(){
	  
	  
	try{	
		
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
        con= DriverManager.getConnection("jdbc:ucanaccess://D:\\Java program\\JavaTest\\src\\database\\Lab_18.accdb");//Establishing Connection
        System.out.println("Connected Successfully");
        st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=st.executeQuery("SELECT * FROM Teacher");       
	}catch(Exception e){
		System.out.println(e);
	}
}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==showbtn) {
			System.out.println("I am show");
			try
			{
				if(rs.next()){
					nametf.setText(rs.getString("Name"));
					emailtf.setText(rs.getString("Email"));
					phonetf.setText(rs.getString("Phone"));					
					row[0] = rs.getString("Name");
			        row[1] = rs.getString("Email");
			        row[2] = rs.getString("Phone");
			        model.addRow(row);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No data");
				}	
				
			}catch(Exception ex)
			{
				
			}}
		if(e.getSource()==addbtn){
			removeAll();
			System.out.println("I am Insert");
			String up1=nametf.getText();
			String up2=emailtf.getText();
			String up3=phonetf.getText();
			try{
				rs.updateString("Name",up1);
				rs.updateString("Email",up2);
				rs.updateString("Phone",up3);
				rs.insertRow();
				System.out.println("one row is inserted");
			}
			catch(Exception er){}		
		}
		if(e.getSource()==updbtn){
			removeAll();
			for(int rows=0; rows<=tbl.getRowCount();rows++) {
				model.removeRow(rows);
			}
			System.out.println("I am Update");
			String u_name=nametf.getText();
			String u_email=emailtf.getText();
			String u_phone=phonetf.getText();
			try{
				rs.updateString("Name",u_name);
				rs.updateString("Email",u_email);
				rs.updateString("Phone",u_phone);
				rs.updateRow();
				System.out.println("one row is updated");			
			}
			catch(Exception er){
				System.out.println(er);
			}
		}
		
		if(e.getSource()==dltbtn){
			removeAll();
			System.out.println("I am Delete");
			try{
				rs.deleteRow();
				System.out.println("one row is deleted");				
			}catch(Exception er){
				System.out.println(er);
			}
			
		}
	}	
	public void removeAll() {	
		if(tbl.getRowCount()>0) {
			for(int rows=0; rows<=tbl.getRowCount();rows++) {
				model.removeRow(rows);
			}
		}
		
	}
	public static void main(String a[]){	
		java_sql_gui_1_simple f = new java_sql_gui_1_simple(); 
        f.setVisible(true);
	}
}

