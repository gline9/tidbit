package tidbit.instruction.store;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class AStore extends StoreInstruction
{

	public AStore(String variableName, Type type)
	{
		super(0x3a, variableName, type);
	}
	
}
