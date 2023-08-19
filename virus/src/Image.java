import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Image extends JFrame { 
  Image() throws IOException{	   
	   // For First Image	  
	   ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("Image\\ICE_logo.jpg"));
	   this.add(new JLabel(imageIcon1));
	   	 
	   //  For second Image
	   File file2 = new File("D:\\Java program\\JavaTest\\src\\Image\\Pust_logo.png");
	   //BufferedImage class => ImageIO 
	   ImageIcon imageIcon2 = new ImageIcon(ImageIO.read(file2)); 
	   this.add(new JLabel(imageIcon2));
  }
	//  Main Class
	public static void main(String args[]) throws IOException {
	  Image image = new Image();
	  image.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  image.setLayout(new FlowLayout());  
	  image.setSize(500,500); 
	  image.setLocationRelativeTo(null); // To set Center Position 
	  //image.pack(); //To Fit image to the prescribe size of container
	  image.setTitle("Display Multiple Image");
	  image.setVisible(true);
	}
}