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
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


public class RMI_Server extends UnicastRemoteObject implements RMI_Interface 
{
        
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// declaration of data containers
	Registry registry;
	Map<String, Spectrum> spectrum_map = new HashMap<String, Spectrum>();
	Map<String, TimeHistory> time_history_map = new HashMap<String, TimeHistory>();

	public RMI_Server() throws RemoteException 
	{
		super();
		this.registry = LocateRegistry.createRegistry(1099);
		this.registry.rebind("Server", this);
        System.out.println("Server is ready!");
	};

	@Override
	public Boolean register_object(Object object) throws RemoteException 
	{
		if ( TimeHistory.class == object.getClass())
		{
			TimeHistory tmh = (TimeHistory)object;
			time_history_map.put(tmh.get_name(), tmh);
			return true;
		}
		else if ( Spectrum.class == object.getClass())
		{
			Spectrum spctr = (Spectrum)object;
			spectrum_map.put(spctr.get_name(), spctr);
			return true;
		}
		else
		{
			return false;
		}
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