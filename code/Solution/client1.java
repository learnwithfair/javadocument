
// SimpleClient.java: A simple client 	//program
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class client1 {
public static void main(String args[]) throws IOException {
//Open your connection to a server, at 	//port 2992
Socket s1 = new Socket("localhost",2992);
//Get an input file handle from the 	//socket and read the input
OutputStream s1out = s1.getOutputStream();
DataOutputStream dos = new DataOutputStream (s1out);
System.out.println("Write Your Message...");// take message from console
Scanner sc=new Scanner(System.in);
String msg=sc.nextLine();
dos.writeUTF(msg); //transfer to server and turn into upper case
//dos.writeUTF("hello world");
InputStream s1In = s1.getInputStream();
DataInputStream dis = new DataInputStream(s1In);
String st = new String (dis.readUTF());
System.out.println("Output:");
System.out.println(st);
//When done, just close the connection 	//and exitdis.close();
//s1In.close();
//s1.close();
//Send a string!
//dos.writeUTF("sent from client ");
//Close the connection, but not the
	//server socket
//dos.close();
//s1out.close();
s1.close();
}
}

