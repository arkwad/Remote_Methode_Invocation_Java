/**
 * 
 */
package app;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
 
public class Main 
{
    // class's atributes
	static Registry register;
	RMI_Client client;
	RMI_Server server;
	
	protected Main() throws RemoteException
	{
		this.client = new RMI_Client();
		this.server = new RMI_Server();
	}
	
     public static void main(String[] args) throws RemoteException
     {
    	 Main app = new Main();
         try 
         {
              register = LocateRegistry.createRegistry(1099);
              register.rebind("Server", app.get_server());
              System.out.println("Server is ready!");
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
