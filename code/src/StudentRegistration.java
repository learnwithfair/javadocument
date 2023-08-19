
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentRegistration extends JFrame implements ActionListener {
    protected Container c;
    protected JLabel title,name, roll, dept;    
    protected JTable tbl;
    protected JTextField nametf, rolltf, depttf;
    protected JButton addbtn, updbtn, clbtn;
    protected DefaultTableModel model;
    protected String[] cols = {"Name", "Roll", "Dept"};
    protected String[] row = new String[5];

    StudentRegistration() {
        this.setBounds(20, 29, 590, 550);
        this.setLocationRelativeTo(null);
        this.setTitle("Student Registration Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        c = this.getContentPane();
        c.setLayout(null);       
        
        title = new JLabel("*Student Registration Form*");        
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
        
        roll = new JLabel();
        roll.setText("Roll No :");
        roll.setBounds(20, 140, 130, 60);
        c.add(roll);
        
        rolltf = new JTextField();
        rolltf.setBounds(170, 147, 240, 50);
        rolltf.setToolTipText("Enter Your Roll");               
        c.add(rolltf);
        
        updbtn = new JButton("Update");
        updbtn.setBounds(420, 147, 140, 50);      
        c.add(updbtn);
        
        dept = new JLabel();
        dept.setText("Dept Name :");
        dept.setBounds(20, 200, 130, 60);
        c.add(dept);
        
        depttf = new JTextField();
        depttf.setBounds(170, 207, 240, 50);
        depttf.setToolTipText("Enter Your Dept. Name");
        c.add(depttf);
        
        clbtn = new JButton("Reset");
        clbtn.setBounds(420, 207, 140, 50);        
        c.add(clbtn);
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cols);
        tbl = new JTable(model);
        //tbl.setModel(model);
        tbl.setBackground(Color.WHITE);
        tbl.setSelectionBackground(Color.GREEN);      
        tbl.setRowHeight(40);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(20, 285, 540, 200);
        c.add(scroll);
        
        addbtn.addActionListener(this);
        clbtn.addActionListener(this);        
        updbtn.addActionListener(this);
       
        tbl.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                int numOfRow = tbl.getSelectedRow();
                //tbl.addRowSelectionInterval(1, 3);
                String sName = model.getValueAt(numOfRow, 0).toString();
                String sRoll = model.getValueAt(numOfRow, 1).toString();
                String sDept = model.getValueAt(numOfRow, 2).toString();
                
                nametf.setText(sName);
                rolltf.setText(sRoll);
                depttf.setText(sDept);               
            }
        });
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn) {
            row[0] = nametf.getText();
            row[1] = rolltf.getText();
            row[2] = depttf.getText();           
            model.addRow(row);
            
        } else if (e.getSource() == clbtn) {
        	  this.clear();
        } else if (e.getSource() == updbtn) {
            int numOfRow = tbl.getSelectedRow();
            if (numOfRow >= 0) {
                String u_name = nametf.getText();
                String u_roll = rolltf.getText();
                String u_dept = depttf.getText();                
                model.setValueAt(u_name, numOfRow, 0);
                model.setValueAt(u_roll, numOfRow, 1);
                model.setValueAt(u_dept, numOfRow, 2);
            
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Row than try again!");
            }
        } 
        
    }
    
    public void clear() {
    	nametf.setText("");
    	rolltf.setText("");
    	depttf.setText(""); 
    }

    public static void main(String[] args) {
    	StudentRegistration f = new StudentRegistration(); 
        f.setVisible(true);
    }
}
