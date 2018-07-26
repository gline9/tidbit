package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;

/**
 *
 * @author Gavin
 */
public abstract class Instruction
{
	private final int instructionCode;

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

	public void write(DataOutputStream out) throws IOException
	{
		out.writeByte(instructionCode);

		writeInstruction(out);
	}

	protected abstract void writeInstruction(DataOutputStream out) throws IOException;

}
