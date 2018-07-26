package tidbit.instruction.store;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;
import tidbit.instruction.Instruction;
import tidbit.variables.Variable;

/**
 *
 * @author Gavin
 */
public class StoreInstruction extends Instruction
{
	private final Variable variable;

	public StoreInstruction(int instructionCode, Variable variable)
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
