package tidbit.instruction.load;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class ALoad extends LoadInstruction
{
	
	public ALoad(String variableName, Type type, VariableTable table)
	{
		super(0x19, table.getVariable(variableName, type));
	}
	
}
