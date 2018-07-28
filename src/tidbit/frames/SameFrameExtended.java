package tidbit.frames;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Gavin
 */
public class SameFrameExtended extends StackFrame
{
	private final int deltaOffset;

	public SameFrameExtended(int deltaOffset)
	{
		super(251);

		this.deltaOffset = deltaOffset;
	}

	@Override
	protected int additionalSize()
	{
		return 2;
	}

	@Override
	protected void writeFrameData(DataOutputStream out) throws IOException
	{
		out.writeShort(deltaOffset);
	}

	@Override
	public int getDelta()
	{
		return deltaOffset;
	}
	
}
