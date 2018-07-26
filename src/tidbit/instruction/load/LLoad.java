package tidbit.instruction.load;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class LLoad extends LoadInstruction
{
	
	public LLoad(String variableName, VariableTable table)
	{
		super(0x16, table.getVariable(variableName, Type.ofLong()));
	}
	
}
