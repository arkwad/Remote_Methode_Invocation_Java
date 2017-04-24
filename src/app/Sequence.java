package app;

public abstract class Sequence<T> extends Pocket
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9138533925223943773L;
	protected int channelNr;
	protected String unit;
	protected double resolution;
	protected  T[] buffer;

	public String toStrings()
	{
		return (super.toStrings()
				+"\nChannel Nr: "+ Integer.toString(channelNr)
				+"\nunit: "+ unit
				+"\nResolution: " + Double.toString(resolution));
	};
	public Sequence(int channelNr,
					String unit,
					double resolution,
					String device,
					String description,
					long date) 
	{
		super(device, description, date );
		  
		this.channelNr = channelNr;
		this.resolution =  resolution;
		this.unit = unit;
		
		
		// TODO Auto-generated constructor stub
	}

}
