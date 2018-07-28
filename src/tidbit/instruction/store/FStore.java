package tidbit.instruction.store;

import tidbit.constants.Type;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class FStore extends StoreInstruction
{

	public FStore(String variableName, VariableTable table)
	{
		super(0x38, table.getVariable(variableName, Type.ofFloat()));
	}
	
}
