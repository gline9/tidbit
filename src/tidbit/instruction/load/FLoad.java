package tidbit.instruction.load;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class FLoad extends LoadInstruction
{

	public FLoad(String variableName, VariableTable table)
	{
		super(0x17, table.getVariable(variableName, Type.ofFloat()));
	}

	
}
