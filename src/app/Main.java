/**
 * 
 */
package app;

import java.rmi.registry.Registry;
 
public class Main 
{
    // class's atributes
	static Registry register;
	RMI_Client client;
	RMI_Server server;
	
	protected Main() throws Exception
	{
		this.server = new RMI_Server();
		this.client = new RMI_Client();
		
	}
	
    public static void main(String[] args) throws Exception
    {
    	Main app = new Main();
        try 
        {

        } 
        catch (Exception e) 
        {
             e.printStackTrace();
        }
        try 
        {
              System.out.println("Response of server: " + app.get_client().comm("127.0.0.1"));
        } 
         catch (Exception e) 
         {
              e.printStackTrace();
         }
    }
    
    public RMI_Client get_client()
    {
    	return this.client;
    }
    public RMI_Server get_server()
    {
    	return this.server;
    }
}
