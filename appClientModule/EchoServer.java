// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import ocsf.server.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  String pass,username;
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
	  	ArrayList<String> msgToClient = new ArrayList<String>();
	  	String[] op = ((String)msg).split(":");
	  	
	  	
	    System.out.println("task to do: " + op[0] );
	    if (op[0].equals("get"))
	    {
	    	msgToClient = jdbc.mysqlConnection.getTable(op[1],username,pass);
	    	for (String item : msgToClient)
	    	{
	    		try{
	    			client.sendToClient(item);
	    			}
	    		catch (Exception exc) { }
	    	}
	    		
	    }
	    else if(op[0].equals("set"))
	    {
	    	 System.out.println("setting to "+op[1]+" DB");
	    	 msgToClient = jdbc.mysqlConnection.setTable( op[1], op[2],username,pass);
		    	for (String item : msgToClient)
		    	{
		    		try{
		    			client.sendToClient(item);
		    			}
		    		catch (Exception exc) { }
		    	}
	    }
	    System.out.println("Message received: " + msg + " from " + client);
	  }

    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
	Scanner fromConsole =  new Scanner(System.in);
	System.out.println("Enter Server User name:");
	username = fromConsole.nextLine();
	System.out.println("Enter Server Password:");
	pass = fromConsole.nextLine();
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class
