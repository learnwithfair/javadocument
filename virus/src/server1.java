import java.net.*;
import java.io.*;
public class server1 {
	public static void main(String args[]) throws IOException {
		// Register service on port 2992
		ServerSocket s = new ServerSocket(2992);
		while(true) {
			System.out.println("waiting ......");
			Socket s1=s.accept(); 
			// Wait and accept a connection
			// Get a communication stream associated with the socket
			InputStream s1In = s1.getInputStream();
			DataInputStream dis = new DataInputStream(s1In);
			String st = new String (dis.readUTF());
			System.out.println(st);
			OutputStream s1out = s1.getOutputStream();
			DataOutputStream dos = new DataOutputStream (s1out);
			
			// Send a string!
			dos.writeUTF(st.toUpperCase());		
			// Close the connection, but not the server socket
			dos.close();
			s1out.close();
			s1.close();
		}
	}
}
