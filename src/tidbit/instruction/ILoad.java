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
public class ILoad extends Instruction
{
	private final String variableName;
	private Variable variable;

	public ILoad(String variableName)
	{
		super(0x15);

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
		this.variable = table.getVariable(variableName, Type.ofInt());
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeByte(variable.getIndex());
	}
	
}
