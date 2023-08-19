import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
public class client1 {
	public static void main(String args[]) throws IOException {
		//Open your connection to a server, at port 2992
		Socket s1 = new Socket("localhost",2992);
		//Get an input file handle from the socket and read the input
		OutputStream s1out = s1.getOutputStream();
		DataOutputStream dos = new DataOutputStream (s1out);			
		String msg=JOptionPane.showInputDialog("Write Something : ");;
		dos.writeUTF(msg); //transfer to server and turn into upper case		
		InputStream s1In = s1.getInputStream();
		DataInputStream dis = new DataInputStream(s1In);
		String st = new String (dis.readUTF());
		System.out.print("Output From The Server : "+st);
		s1.close();
	}
}

