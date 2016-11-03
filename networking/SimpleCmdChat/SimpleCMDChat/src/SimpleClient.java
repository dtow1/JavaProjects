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
		int portNumber;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the IP address (IPV4) that you want to connect to.");
		ipAddress=scan.next();
		if(!validAddress(ipAddress)){
			System.out.println("DANGER WILL ROBINSON");
			System.exit(1);
		}else{
			System.out.println("IPv4 Address validated");
			System.exit(0);
		}
		
		portNumber=5555;
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
		            String inputLine;
		            while ((inputLine = in.readLine()) != null) {
		                out.println(inputLine);
		            }
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

}
