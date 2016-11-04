import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleClient {

	public static void main(String[] args) {
		String ipAddress;
		int portNumber=0;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the IP address (IPV4) that you want to connect to.");
		ipAddress=scan.next();
		if(!validAddress(ipAddress)){
			System.out.println("DANGER WILL ROBINSON");
			System.exit(1);
		}else{
			System.out.println("IPv4 Address validated!");

		}
		System.out.println("Please enter the port for communication");
		try{
			portNumber = Integer.parseInt(scan.next());
		}catch(NumberFormatException n){
			System.err.println("That, my friend, was not a valid number.");
			System.exit(1);
		}
		if(!validPortNumber(portNumber)){
			System.out.println("Wrong port of call");
			System.exit(2);
		}else{
			System.out.println("TCP port validated!");
			
		}
		try (
	            Socket echoSocket = new Socket(ipAddress, portNumber);
	            PrintWriter out =
	                new PrintWriter(echoSocket.getOutputStream(), true);
	            BufferedReader in =
	                new BufferedReader(
	                    new InputStreamReader(echoSocket.getInputStream()));
	            BufferedReader stdIn =
	                new BufferedReader(
	                    new InputStreamReader(System.in))
	        ) {
		            //String inputLine,response;
		            
		            ReadThread read = new ReadThread(in);
		            SendThread send = new SendThread(out,stdIn);
		            
		            Thread readThread = new Thread(read);
		            readThread.start();
		            Thread sendThread = new Thread(send);
		            sendThread.start();
		            
		            while(!read.getExit()){
		            	//Do nothing, just keep the try block from exiting and closing the streams until the
		            	//communication threads have ended.
		            }
		            
		        /*    System.out.println("Please enter some text: ");
		            while ((inputLine = in.readLine()) != null) {
		                out.println("Inputline: " + inputLine);
		            }*/
		            
		       /*     while(!exit){
		            	inputLine = stdIn.readLine();
		            	System.out.println("Message> " + inputLine);
		            	out.println(inputLine);
		            	response = in.readLine();
		            	System.out.println("Response> " + response);
		            	if(response.equals("exit"));
		            }*/
/*        	System.out.println("Enter Text: ");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }*/
		        } catch (IOException e) {
		            System.out.println("Exception caught when trying to listen on port "
		                + portNumber + " or listening for a connection");
		            System.out.println(e.getMessage());
		        }

	}
	
	public static boolean validAddress(String ipAddress){
		boolean result = false;
		String pattern = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
		
		Pattern regex = Pattern.compile(pattern);
		Matcher match = regex.matcher(ipAddress);
		
		if(match.find()){
			result=true;
		}
		
		return result;
	}
	
	public static boolean validPortNumber(int port){
		return port<=65535 && port>=0;
	}
	

}

class SendThread implements Runnable {
	
	PrintWriter out;
	BufferedReader stdIn;
	
    public void run() {
        String inputLine="";
        while(!inputLine.equals("exit")){
        	try {
				inputLine = stdIn.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("Message> " + inputLine);
        	out.println(inputLine);
        }
    }

    SendThread(PrintWriter out, BufferedReader stdIn){
    	this.out = out;
    	this.stdIn = stdIn;
    }

}

class ReadThread implements Runnable {
	
	BufferedReader in;
	boolean exit=false;
	
    public void run() {
        String response="";
        
        while(!response.equals("exit")){
        	try {
				response = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("Response> " + response);
        	if(response.equals("exit")){
        		exit=true;
        	};
        }
    }

    ReadThread(BufferedReader in){
    	this.in = in;
    }
    
    public boolean getExit(){
    	return exit;
    }

}
