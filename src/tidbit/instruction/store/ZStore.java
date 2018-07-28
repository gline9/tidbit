package tidbit.instruction.store;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class ZStore extends StoreInstruction
{
	
	public ZStore(String variableName, VariableTable table)
	{
		super(0x36, table.getVariable(variableName, Type.ofBoolean()));
	}
	
}
