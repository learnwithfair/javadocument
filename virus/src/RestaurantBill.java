import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
public class RestaurantBill extends JFrame implements ActionListener{
	JLabel l;
	JCheckBox cb1,cb2,cb3;
	JButton b1,b2;
	RestaurantBill(){
		l=new JLabel("\"Food Ordering System\"");		
		l.setFont(new Font("Times new Roman",Font.BOLD,22));
		l.setBounds(80,50,300,20);		
		cb1=new JCheckBox("Pizza $100");
		cb1.setBounds(150,100,150,20);
		cb2=new JCheckBox("Burger $30");
		cb2.setBounds(150,150,150,20);
		cb3=new JCheckBox("Tea $10");
		cb3.setBounds(150,200,150,20);		
		b1=new JButton("Order");
		b1.setBounds(100,250,80,30);
		b1.addActionListener(this);
		
		b2=new JButton("Cancel");
		b2.setBounds(200,250,80,30);
		b2.addActionListener(this);
		
		add(l);add(cb1);add(cb2);add(cb3);add(b1);add(b2);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1) {
			if(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()) {
				float amount=0;
				String msg="";
				if(cb1.isSelected()){
				amount+=100;
				msg="Pizza: 100\n";
				}
				if(cb2.isSelected()){
				amount+=30;
				msg+="Burger: 30\n";
				}
				if(cb3.isSelected()){
				amount+=10;
				msg+="Tea: 10\n";
				}
				msg+="-----------------\n";
				JOptionPane.showMessageDialog(this,msg+"Total: "+amount,"Total Bill",JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this,"You have not selected any Item!!","Warning Message",JOptionPane.ERROR_MESSAGE);
			}
		}else {
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new RestaurantBill();
	}
}

