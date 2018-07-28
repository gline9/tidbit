package tidbit.instruction.store;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class AStore extends StoreInstruction
{

	public AStore(String variableName, Type type, VariableTable table)
	{
		super(0x3a, table.getVariable(variableName, type));
	}
	
}
