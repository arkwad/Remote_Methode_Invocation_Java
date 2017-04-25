/**
 * 
 */
package app;

/**
 * @author Arek
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


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
	
	Map<Integer, String> temp_spectrum_map = new HashMap<Integer, String>();
	Map<Integer, String> temp_time_history_map = new HashMap<Integer, String>();

	public RMI_Server() throws RemoteException 
	{
		super();
		this.registry = LocateRegistry.createRegistry(1099);
		this.registry.rebind("Server", this);
        System.out.println("Server is ready!");
	};

	
	private  Map<Integer, String> filter_spec_list_by_dev_name(String dev_name)
	{
		//clear buffer 
		this.temp_spectrum_map.clear();
		if (dev_name.equalsIgnoreCase("all"))
		{
			Integer i = 1;
			for (Entry<String, Spectrum> entry : this.spectrum_map.entrySet())
			{   
				this.temp_spectrum_map.put(i,entry.getKey().toString()); 
				i++;
			}
		}
		else
		{
			Integer i = 1;
			for (Entry<String, Spectrum> entry : this.spectrum_map.entrySet())
			{
			    if (entry.getKey().toString().equals(dev_name) )
			    {
			    	this.temp_spectrum_map.put(i,entry.getKey().toString());
			    	i++;
			    }
			}
		}
		return this.temp_spectrum_map;	
	}
	
	private  Map<Integer, String> filter_timhis_list_by_dev_name(String dev_name)
	{
		//clear buffer 
		this.temp_time_history_map.clear();
		
		if (dev_name.equalsIgnoreCase("all"))
		{
			Integer i = 1;
			for (Entry<String, TimeHistory> entry : this.time_history_map.entrySet())
			{   
				this.temp_time_history_map.put(i,entry.getKey().toString());  
				i++;
			}
		}
		else
		{
			Integer i = 1;
			for (Entry<String, TimeHistory> entry : this.time_history_map.entrySet())
			{
			    if (entry.getKey().toString().equals(dev_name) )
			    {
			    	this.temp_time_history_map.put(i,entry.getKey().toString());
			    	i++;
			    }
			}
		}
		return this.temp_time_history_map;	
	}
	
	@Override
	public Boolean register_object(Object object) throws RemoteException 
	{
		if ( TimeHistory.class == object.getClass())
		{
			TimeHistory tmh = (TimeHistory)object;
			System.out.println("Server received TimeHistory object!");
			time_history_map.put(tmh.get_name(), tmh);
			return true;
		}
		else if ( Spectrum.class == object.getClass())
		{
			Spectrum spctr = (Spectrum)object;
			System.out.println("Server received Spectrum object!");
			spectrum_map.put(spctr.get_name(), spctr);
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public Map<Integer, String>  return_time_history_list(String dev_name) throws RemoteException
	{
		return this.filter_timhis_list_by_dev_name(dev_name);
	}
	
	@Override
	public Map<Integer, String>  return_spectrum_list(String dev_name) throws RemoteException
	{
		return this.filter_spec_list_by_dev_name(dev_name);
	}


	@Override
	public void save_data_to_file(String data_type,
								  String number_in_list)
								  throws RemoteException, IOException 
	{
		
		if (data_type.equalsIgnoreCase("Spectrum"))
		{
			Spectrum object = find_spectrum_object(number_in_list);
			@SuppressWarnings("resource")
			PrintWriter out = new PrintWriter("Spectrum_" + object.get_name() +"_"+ object.Description+".spc");
			out.println(object.Description);
		}
		else if (data_type.equalsIgnoreCase("TimeHistory"))
		{
			TimeHistory object = find_time_history_object(number_in_list);
			
			@SuppressWarnings("resource")
			PrintWriter out = new PrintWriter("TimeHistory_" + object.get_name()+"_" + object.Description+".thi");
			out.println(object.date);
		}
		else
		{
			System.out.println("File writing failed: wrong data type!!!");
		}
		
		
	}
	private TimeHistory find_time_history_object(String number_in_list)
	{
		String name = this.temp_time_history_map.get(Integer.parseInt(number_in_list));
		return this.time_history_map.get(name);
	}
	
	private Spectrum find_spectrum_object(String number_in_list)
	{
		String name = this.temp_spectrum_map.get(Integer.parseInt(number_in_list));
		return this.spectrum_map.get(name);
	}
}