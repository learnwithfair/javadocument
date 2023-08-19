
import java.io.*;
import java.net.*;

public class UDPserver{
   public static void main(String args[]) throws Exception{
         DatagramSocket serverSocket = new DatagramSocket(9872);
         byte[] receiveData = new byte[1024];
         byte[] sendData 	= new byte[1024];
         while(true){
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			  System.out.println("Waiting...... " );                 
			  serverSocket.receive(receivePacket);      
			  System.out.println("Data Received...... " );
	          String sentence = new String( receivePacket.getData());
	          System.out.println("RECEIVED: " + sentence);
	          Thread.sleep(600);                  
	          InetAddress IPAddress = receivePacket.getAddress();
	          int port = receivePacket.getPort();
	          // int fa=receivePacket.getLength();
	          String  capitalizedSentence = sentence.toUpperCase();
	          //  int  Sentencesize = sentence.length();
	          sendData = capitalizedSentence.getBytes();
	          
	          DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length ,IPAddress, port);
	          serverSocket.send(sendPacket);
       }
   }
}
