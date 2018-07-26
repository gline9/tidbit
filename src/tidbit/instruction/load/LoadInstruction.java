package tidbit.instruction.load;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;
import tidbit.instruction.Instruction;
import tidbit.variables.Variable;

/**
 *
 * @author Gavin
 */
public class LoadInstruction extends Instruction
{
	private final Variable variable;

	public LoadInstruction(int instructionCode, Variable variable)
	{
		super(instructionCode);

		this.variable = variable;
	}

	@Override
	protected int additionalSize()
	{
		return 1;
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		// do nothing
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeByte(variable.getIndex());
	}

}
