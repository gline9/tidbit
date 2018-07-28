package tidbit.instruction.load;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class ZLoad extends LoadInstruction
{
	public ZLoad(String variableName, VariableTable table)
	{
		super(0x15, table.getVariable(variableName, Type.ofBoolean()));
	}
}
