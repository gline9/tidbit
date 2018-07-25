package tidbit.instruction.load;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;
import tidbit.variables.Variable;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class LoadInstruction extends Instruction
{
	private final String variableName;
	private final Type type;
	private Variable variable;

	public LoadInstruction(int instructionCode, String variableName, Type type)
	{
		super(instructionCode);

		this.variableName = variableName;
		this.type = type;
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
		this.variable = table.getVariable(variableName, type);
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeByte(variable.getIndex());
	}

}
