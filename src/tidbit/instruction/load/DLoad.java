package tidbit.instruction.load;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class DLoad extends LoadInstruction
{
	
	public DLoad(String variableName, VariableTable table)
	{
		super(0x18, table.getVariable(variableName, Type.ofDouble()));
	}
	
}
