package com.cmu.as.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Scanner reader = new Scanner(System.in);
		String docID; //Doctor ID

		
		Socket socket = new Socket("localhost", 8888);
		ObjectOutputStream out;
		ObjectInputStream in;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        
        Map<Integer,ArrayList<String>> m = new HashMap<Integer,ArrayList<String>>();
        ArrayList<String> value = new ArrayList<String>();


        
        
		System.out.println("Welcome to the Appointment Scheduler Sysmte.");
		
		String logIn = "0";
		
		System.out.println("Please Log in.");
		System.out.println("Enter your Doc ID:");
		docID = reader.nextLine();
		System.out.println("Enter your password:");
		String userPsw = reader.nextLine();

        value.add(docID);
        value.add(userPsw);
        m.put(10, value);
        out.writeObject(m);
        logIn = (String) in.readObject();

		while(logIn.equals("0")){
			
		System.out.println("Wrong password or ID.");
		System.out.println("Enter your Doc ID:");
		docID = reader.nextLine();
		System.out.println("Enter your password:");
		userPsw = reader.nextLine();

        value.add(docID);
        value.add(userPsw);
        m.put(10, value);
        out.writeObject(m);
        logIn = (String) in.readObject();
		}
		
		System.out.println("Loged In:");
		

		
		
		
        out.close();
        in.close();
        socket.close();

	}

}
