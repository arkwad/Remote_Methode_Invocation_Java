/**
 * 
 */
package app;

/**
 * @author Arek
 *
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMI_Interface extends Remote
{
	String sayHello() throws RemoteException;
}
