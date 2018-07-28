package tidbit.frames;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Gavin
 */
public abstract class StackFrame
{
	private final int frameCode;

	public StackFrame(int frameCode)
	{
		this.frameCode = frameCode;
	}

	public int size()
	{
		return additionalSize() + 1;
	}

	protected abstract int additionalSize();

	public void write(DataOutputStream out) throws IOException
	{
		out.writeByte(frameCode);

		writeFrameData(out);
	}

	protected abstract void writeFrameData(DataOutputStream out) throws IOException;

	public abstract int getDelta();
	
}
