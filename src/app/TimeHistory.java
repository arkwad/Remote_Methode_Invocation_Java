package app;

@SuppressWarnings("rawtypes")
public final class TimeHistory extends Sequence 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double sensitivity;

	public String toStrings()
	{
		return(super.toStrings()
				+"\nSensitivity: " + Double.toString(sensitivity) + "\n" );
	}
	
	public String get_name()
	{
		return this.device + "_"+this.channelNr;
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
		// TODO Auto-generated constructor stub
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
