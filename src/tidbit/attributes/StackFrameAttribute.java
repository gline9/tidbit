package tidbit.attributes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import tidbit.constants.ConstantTable;
import tidbit.constants.UTF8Constant;
import tidbit.frames.StackFrame;

/**
 *
 * @author Gavin
 */
public class StackFrameAttribute extends Attribute
{
	private int stackFrameIndex;
	private final List<StackFrame> stackFrames;
	private final int frameSize;

	public StackFrameAttribute(List<StackFrame> stackFrames)
	{
		this.stackFrames = stackFrames;
		this.frameSize = this.stackFrames.stream().map(StackFrame::size).collect(Collectors.summingInt(Integer::new));
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		stackFrameIndex = table.registerConstant(new UTF8Constant("StackMapTable"));
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(stackFrameIndex);

		out.writeInt(2 + frameSize);
		out.writeShort(stackFrames.size());

		for (StackFrame frame : stackFrames)
		{
			frame.write(out);
		}
	}

	@Override
	public int size()
	{
		return frameSize + 8;
	}
	
}
