/**
 * 
 */
package app;

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
	
	public Spectrum(int channelNr,
					String unit,
					double resolution,
					String device,
					String description,
					long date,
					int number_of_samples) 
	{
		super(channelNr, unit, resolution, device, description, date);
		// TODO Auto-generated constructor stub
	}
	public Spectrum()
	{
		super(2,"UNIT_1",1.2,"DEVICE_1","This is dummy Spectrum class's instance!!!",123456);
	}
	public String get_name()
	{
		return this.device + "_"+this.channelNr;
	}

}
