package tidbit.instruction.store;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class DStore extends StoreInstruction
{

	public DStore(String variableName, VariableTable table)
	{
		super(0x39, table.getVariable(variableName, Type.ofDouble()));
	}
	
}
