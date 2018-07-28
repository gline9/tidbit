package tidbit.ast;

import java.util.Arrays;
import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class VariableValue extends Value
{
	private final String variableName;

	public VariableValue(String variableName)
	{
		this.variableName = variableName;
	}

	@Override
	public List<Instruction> addToTopOfStack(VariableTable table)
	{
		return Arrays.asList(table.getVariablesType(variableName).getLoadInstruction(variableName, table));
	}

	@Override
	public int stackDepth()
	{
		return 1;
	}

	@Override
	public Type getType(VariableTable table)
	{
		return table.getVariablesType(variableName);
	}
	
}
