import java.io.BufferedReader;
import java.io.File;
import java.text.ParseException;
import java.io.IOException;
import java.io.Serializable;
import java.io.Reader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CallCharge {
	
	  public static void main(String[] args) throws IOException, ParseException {
		  
			  Scanner inFile = new Scanner(new File("C:\\Project_Callcost\\promotion1.log"));  
		
			    while (inFile.hasNext()) {
		
			      String take = inFile.next();
                  String[] parts = take.split("\\|");	 
	              String array = parts[3];
		          System.out.println(parts[3] + ": " + parts[1] + " - " + parts[2]);

		          java.util.Date date = new java.util.Date();
		          java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			            
			      String[] startTime = parts[1].split("\n");
				  String[] endTime = parts[2].split("\n");
				  SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				  Date date1 = (Date)format.parse(startTime[0]);
				  Date date2 = (Date)format.parse(endTime[1]);
				 
			    	 long difference = date2.getTime()-date1.getTime();
				     long callTiming1 = ((difference/1000)/60);
				     long callTiming2 = (long)(((difference/1000)%60)*0.6);
				 
				 if(callTiming1 <= 1)
				  {
				     System.out.println("Call cost = 3 Bath");
				  }
				 else
				  {
				     long callTime = callTiming1 - 1;
				     long callCost = callTime * 1 + 3;
				     System.out.println("Call cost =" + callCost +"."+callTiming2+" Bath");
		          }   		   
	    }
	}
}


