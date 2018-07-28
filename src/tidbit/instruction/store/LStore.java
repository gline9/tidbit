package tidbit.instruction.store;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class LStore extends StoreInstruction
{

	public LStore(String variableName, VariableTable table)
	{
		super(0x37, table.getVariable(variableName, Type.ofLong()));
	}
	
}
