package app;

import java.io.Serializable;

public abstract class Pocket implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String device;
	protected String Description;
	protected long date ;

	public String toStrings()
	{

		return("Device: " + device
				+"\nDescription: "+ Description
				+"\nDate: " + Long.toString(date)+"\n");
		   
	}
	public Pocket(String device,
				String description,
				long date) 
	{
		this.device = device;
		this.Description = description;
		this.date = date;
		
		// TODO Auto-generated constructor stub
	}

}
