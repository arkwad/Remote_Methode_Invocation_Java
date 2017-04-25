/**
 * 
 */
package app;

import java.util.Random;

/**
 * @author Arek
 *
 */
public final class Spectrum extends Sequence<Object> 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int num_of_samples = 1024;
	Random rand = new Random();
	
	public Spectrum(int channelNr,
					String unit,
					double resolution,
					String device,
					String description,
					long date,
					int number_of_samples) 
	{
		super(channelNr, unit, resolution, device, description, date);
	
	}
	public Spectrum()
	{
		super(2,"UNIT_1",1.2,"DEVICE_1","This is dummy Spectrum class's instance",123456);
		Integer  n = rand.nextInt(50) + 1;
		Integer  n1 = rand.nextInt(50) + 1;
		this.device = "DEVICE_"+n.toString();
		this.channelNr = n1;
	}
	public String get_name()
	{
		return this.device;
	}

}
