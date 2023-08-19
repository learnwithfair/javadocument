
import javax.swing.JOptionPane;
import java.net.*;
public class UDPclient
{
   public static void main(String args[]) throws Exception{
	  String sentence = JOptionPane.showInputDialog("Write Something : ");	 
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      
      byte[] sendData 	 = new byte[1024];
      byte[] receiveData = new byte[1024];
      
      sendData = sentence.getBytes();

      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9872);
      clientSocket.send(sendPacket);
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      System.out.println("Waiting...... " );
      clientSocket.receive(receivePacket);
      System.out.println("Data Received...... " );
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("TEXT FROM SERVER:" + modifiedSentence);
      clientSocket.close();
   }
}
