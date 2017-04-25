/**
 * 
 */
package app;

/**
 * @author Arek
 *
 */

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;

public class RMI_Client 
{
	Registry registry;
	RMI_Interface stub;
	
	Scanner scan = new Scanner(System.in);

	RMI_Client() throws RemoteException, Exception, IOException
	{
		this.registry = LocateRegistry.getRegistry("127.0.0.1");
		this.stub = (RMI_Interface) this.registry.lookup("Server");
        System.out.println("Client succefully found server!");
	}

	
	
	public String send_data_to_server(String data_type) 
	{
		Object data;
		
		if (data_type.equalsIgnoreCase("Spectrum"))
		{
			Spectrum spectrum = new Spectrum();
			data = (Object)spectrum;
		}
		else if (data_type.equalsIgnoreCase("TimeHistory"))
		{
			TimeHistory timehistory = new TimeHistory();
			data = (Object)timehistory;
		}
		else
		{
			return "Data sending failed: wrong data type!!!";
		}
	    try 
	    {
	    	String response = stub.register_object( data ).toString();
	    	return response;
	    }
	    catch (Exception e) 
	    {
	    	return ("Client exception: " + e.toString());
	    }
	}
	
	
	
	
	public Map<Integer, String> request_list(String list_type,String dev_name) throws RemoteException
	{
		if (list_type.equalsIgnoreCase("Spectrum"))
		{
			return request_spectrum_list(dev_name);
		}
		else if (list_type.equalsIgnoreCase("TimeHistory"))
		{
			return request_time_history_list(dev_name);
		}
		else
		{
			System.out.println("List request failed: wrong data type!!!");
			return null;
		}
	}
	public void save_to_file(String data_type,
			  String number_in_list)
			  throws IOException 
	{
		
		stub.save_data_to_file(data_type, number_in_list);
		
	}
	
	private Map<Integer, String> request_spectrum_list(String dev_name) throws RemoteException
	{
		return stub.return_spectrum_list(dev_name);
	}
	private Map<Integer, String> request_time_history_list(String dev_name) throws RemoteException
	{
		return stub.return_time_history_list(dev_name);
	}
}
