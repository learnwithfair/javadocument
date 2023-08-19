import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Image extends JFrame  {
private JLabel label1;
private JLabel label2;
Image() throws IOException{
   setLayout(new FlowLayout());
  //image1 = new ImageIcon(getClass().getResource("ICE_logo.jpg")); for jdk old version(8,6 etc)
  File file = new
  File("D:\\Java program\\Pust_Session_2018_19\\src\\ICE_logo.jpg");
  BufferedImage image1 = ImageIO.read(file); 
  ImageIcon imageIcon = new ImageIcon(image1); 
  label1 = new JLabel(imageIcon); 
  add(label1);
 
  //image2 = new ImageIcon(getClass().getResource("Pust_logo.png")); for jdk old version 
  File file2 = new File("D:\\Java program\\Pust_Session_2018_19\\src\\Pust_logo.png");
  BufferedImage image2 = ImageIO.read(file2);
  ImageIcon imageIcon2 = new ImageIcon(image2);

  label2 = new JLabel(imageIcon2);
   add(label2);
  }
public static void main(String args[]) throws IOException {
  Image gui = new Image();
  gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  gui.setVisible(true);
  gui.setSize(500,500);
  // gui.pack(); Fit image to the prescribe size of container
  gui.setTitle("Image Program");
}
}