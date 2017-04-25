/**
 * 
 */
package app;

import java.io.IOException;
import java.rmi.registry.Registry;
import java.util.Scanner;
 
public class Main 
{
    // class's atributes
	static Registry register;
	static RMI_Client client;
	static RMI_Server server;
	
	protected Main() throws Exception
	{
		Main.server = new RMI_Server();
		Main.client = new RMI_Client();
	}
	
    public static void main(String[] args) throws Exception, IOException
    {
    	System.out.println("Application started...");
    	
    	// create application instance
    	Main app = new Main();
    	infinite_loop(app);
    }
    
    @SuppressWarnings("resource")
	private static void infinite_loop(Main app) throws IOException
    {
		System.out.println("Type help to get list of available commands...");
		
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			String s = scan.next();
		
			switch (s.toLowerCase())
			{
				case "help":
				{
					print_commands();
					break;
				}
				case "send":
				{
					s = scan.next();
					app.get_client().send_data_to_server(s);
					break;
				}
				case "list":
				{
					s = scan.next();
					String action = scan.next();
					System.out.println(app.get_client().request_list(s,action));
					break;
				}
				case "save":
				{
					s = scan.next();
					String action = scan.next();
					app.get_client().save_to_file(s, action);
					break;
				}
				default:
				{
					System.out.println("Wrong syntax...");
					break;
				}	
			}
		}	
	}
  
    private static void print_commands()
    {
    	System.out.println("send - command that sends data to server\n"
    			+ "\tArguments: Spectrum or TimeHistory\n"
    			+ "\tExample: send Spectrum\n"
    			+ "\tValues of classes attributes will be generate.");
    	System.out.println("list - command that returns list of data for specified Device Name\n"
    			+ "\tArguments: first : Spectrum or TimeHistory, second: device name or all\n"
    			+ "\tExample1: list Spectrum Device2\n"
    			+ "\tExample2: list Spectrum all");
    	System.out.println("save - commands that saves data to file based on number of record from last printed list\n"
    			+ "\tArguments: first : Spectrum or TimeHistory, second: number of record in list\n"
    			+ "\tExample: save Spectrum 2\n");
    	
    }

	public RMI_Client get_client()
    {
    	return Main.client;
    }
    public RMI_Server get_server()
    {
    	return Main.server;
    }
}
