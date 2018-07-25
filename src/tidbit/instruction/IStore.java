package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;
import tidbit.constants.Type;
import tidbit.variables.Variable;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class IStore extends Instruction
{
	private final String variableName;
	private Variable variable;

	public IStore(String variableName)
	{
		super(0x36);

		this.variableName = variableName;
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
	public void registerVariables(VariableTable table)
	{
		variable = table.getVariable(variableName, Type.ofInt());
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeByte(variable.getIndex());
	}
	
}
