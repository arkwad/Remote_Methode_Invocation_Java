/**
 * 
 */
package app;

import java.rmi.NotBoundException;

/**
 * @author Arek
 *
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Client 
{
	Registry registry;
	RMI_Interface stub;

	RMI_Client() throws RemoteException, Exception
	{
		this.registry = LocateRegistry.getRegistry("127.0.0.1");
		this.stub = (RMI_Interface) this.registry.lookup("Server");
        System.out.println("Client succefully found server!");
	}

	public String comm(String arg) 
	{
		String host = (arg.length() < 1) ? null : arg;
	    try 
	    {
	    	TimeHistory tmh = new TimeHistory();
	    	String response = stub.register_object( (Object)tmh ).toString();
	    	return response;
	    }
	    catch (Exception e) 
	    {
	    	//System.err.println("Client exception: " + e.toString());
	    	return ("Client exception: " + e.toString());
	    }
	}
}
