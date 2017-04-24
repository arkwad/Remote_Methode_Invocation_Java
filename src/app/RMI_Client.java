/**
 * 
 */
package app;

/**
 * @author Arek
 *
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Client 
{


	RMI_Client() throws RemoteException
	{
		//dummy
	}

	public String comm(String arg) 
	{

		String host = (arg.length() < 1) ? null : arg;
	    try 
	    {
	    	Registry registry = LocateRegistry.getRegistry(host);
	    	RMI_Interface stub = (RMI_Interface) registry.lookup("Server");
	    	String response = stub.sayHello();
	    	return response;
	    }
	    catch (Exception e) 
	    {
	    	//System.err.println("Client exception: " + e.toString());
	    	return ("Client exception: " + e.toString());
	    }
	}
}
