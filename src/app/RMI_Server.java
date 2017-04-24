/**
 * 
 */
package app;

/**
 * @author Arek
 *
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RMI_Server extends UnicastRemoteObject implements RMI_Interface 
{
        
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

		public RMI_Server() throws RemoteException 
		{
			//super();
		};

	    public String sayHello() throws RemoteException 
	    {
	        return "Hello, world!";
	    }
	        
	    
	    
	    
	    
	    /*public static void main(String args[])
	    {
	        
	        try 
	        {
	            RMI_Server obj = new RMI_Server();
	            RMI_Interface stub = (RMI_Interface)UnicastRemoteObject.exportObject(obj, 0);

	            // Bind the remote object's stub in the registry
	            Registry registry = LocateRegistry.getRegistry();
	            registry.bind("Server", stub);

	            System.err.println("Server is ready now!!!");
	            
	        } 
	        catch (Exception e)
	        {
	            System.err.println("Server exception: " + e.toString());
	            e.printStackTrace();
	        }
	    }	*/
}