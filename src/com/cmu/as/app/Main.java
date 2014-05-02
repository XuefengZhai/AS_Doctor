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
        

		System.out.println("Welcome to the Appointment Scheduler Sysmte.");
		
		
		while(true){
			System.out.println("Please choose an option you want to do: 1.Log In 2.Exit");
			String beforeLogInChoice = reader.nextLine();
			System.out.println("Please Log in.");

			if(beforeLogInChoice.equals("1"))
			{
			//login, 
			
				String logIn = "0";
				
				System.out.println("Enter your Doc ID:");
				docID = reader.nextLine();
				System.out.println("Enter your password:");
				String userPsw = reader.nextLine();
				
		        Map<Integer,ArrayList<String>> m = new HashMap<Integer,ArrayList<String>>();
				ArrayList<String> value = new ArrayList<String>();
		        value.add(docID);
		        value.add(userPsw);

		        m.put(10, value);
		        
		       // System.out.println("Send id and psw:"+docID+userPsw);
		        
		        out.writeObject(m);
		        logIn = (String) in.readObject();
		       // System.out.println("logIn value :"+logIn);
		
				if(logIn.equals("0")){
					
					System.out.println("Wrong password or ID.");
				}
				else{
					System.out.println("------------------------------");
				System.out.println("Youre are Loged In!!");
				//add app, delete app, check all booked app, check patient, update info
				//注意登陆出去以后改login value！！！
								
				int option = 0; 
				
				while(option != 6){
					
					System.out.println("Please Choose your option:");
					System.out.println("1. Add an apointment.");
					System.out.println("2. Delete an appointment.");
					System.out.println("3. Check all appointment");
					System.out.println("4. Check infor of an patient:");
					System.out.println("5. Update my info");
					System.out.println("6. Log out");
					option = Integer.parseInt(reader.nextLine());

					switch(option){
						
					case 1:
				        Map<Integer,ArrayList<String>> m2 = new HashMap<Integer,ArrayList<String>>();
						ArrayList<String> value2 = new ArrayList<String>();
						
						value2.add(docID);
						System.out.println("Please enter the appointment date:");
						String time = reader.nextLine();
						value2.add(time);
						System.out.println("Please enter the appointment time:");
						String date = reader.nextLine();
						value2.add(date);
						
						m2.put(11, value2);
						
						out.writeObject(m2);
					    String feedback = (String) in.readObject();
						
					    if(feedback.equals("1")){
					    	System.out.println("Appointment successfully added!");
					    }
					    else
					    	System.out.println("Appointment already exist");
						
						break;

					
					
					case 2:
						
						
						break;
						
						
						
					case 3:
						
						
						break;
						
						
						
					case 4:
						
						
						
						break;
						
						
						
					case 5:
						
						
						
						break;
						
						
						
						
					}
						
					
				}
					
				
				}
				
				System.out.println("You are logged out!");
				
			
			}
			
			else{
				System.out.println("Thanks for using the system! Bye");
				break;
			}
			
		}
		
        out.close();
        in.close();
        socket.close();
        reader.close();

	}

}
