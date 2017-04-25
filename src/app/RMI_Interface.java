/**
 * 
 */
package app;

/**
 * @author Arek
 *
 */

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;


public interface RMI_Interface extends Remote
{
	Boolean register_object(Object object) throws RemoteException;
	Map<Integer, String>  return_time_history_list(String dev_name) throws RemoteException;
	Map<Integer, String>  return_spectrum_list(String dev_name) throws RemoteException;
	void save_data_to_file(String data_type, String number_in_list) throws RemoteException, IOException;
}
