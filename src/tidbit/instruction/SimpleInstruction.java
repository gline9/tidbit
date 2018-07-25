package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public abstract class SimpleInstruction extends Instruction
{

	public SimpleInstruction(int instructionCode)
	{
		super(instructionCode);
	}

	@Override
	protected int additionalSize()
	{
		return 0;
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		// do nothing
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		// do nothing
	}

	public void registerVariables(VariableTable table)
	{
		// do nothing
	}
	
}
