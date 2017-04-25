package app;

import java.util.Random;

@SuppressWarnings("rawtypes")
public final class TimeHistory extends Sequence 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double sensitivity;
	Random rand = new Random();
	
	
	public String toStrings()
	{
		return(super.toStrings()
				+"\nSensitivity: " + Double.toString(sensitivity) + "\n" );
	}
	public String get_name()
	{
		return this.device;
	}
	public TimeHistory(double sensitivity,
						int	channelNr,
						String unit,
						double resolution,
						String  device,
						String  description,
						long 	date)
	{
		super(channelNr,
				unit,
				resolution,
				device,
				description,
				date);
		this.sensitivity = sensitivity;
	}
	public TimeHistory()
	{	
		super(4,"UNIT_2",1.2,"DEVICE_2","This is dummy TimeHistory class's instance",123456);
		Integer  n = rand.nextInt(50) + 1;
		Integer  n1 = rand.nextInt(50) + 1;
		this.device = "DEVICE_"+n.toString();
		this.channelNr = n1;
	}

	public static void main(String Args[])
	{
		TimeHistory th = new TimeHistory(1.2,
										2,
										"cos",
										1.2,
										"device",
										"description",
										1234);
		
		System.out.println(th.toStrings());	
	}
}
