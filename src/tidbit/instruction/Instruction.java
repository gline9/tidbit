package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Optional;
import tidbit.constants.ConstantTable;
import tidbit.frames.StackFrame;

/**
 *
 * @author Gavin
 */
public abstract class Instruction
{
	private final int instructionCode;
	private int location;

	public Instruction(int instructionCode)
	{
		this.instructionCode = instructionCode;
	}
	
	public int size()
	{
		return additionalSize() + 1;
	}

	protected abstract int additionalSize();
	public abstract void registerConstants(ConstantTable table);

	public Optional<StackFrame> getStackFrame(int index, int frameOffset)
	{
		location = index;
		return Optional.empty();
	}

	public void write(DataOutputStream out) throws IOException
	{
		out.writeByte(instructionCode);

		writeInstruction(out);
	}

	protected abstract void writeInstruction(DataOutputStream out) throws IOException;

	public int getLocation()
	{
		return location;
	}

}
