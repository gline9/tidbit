package tidbit.instruction.store;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class IStore extends StoreInstruction
{

	public IStore(String variableName, VariableTable table)
	{
		super(0x36, table.getVariable(variableName, Type.ofInt()));
	}

}
