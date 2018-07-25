package tidbit.instruction.store;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class LStore extends StoreInstruction
{

	public LStore(String variableName)
	{
		super(0x37, variableName, Type.ofLong());
	}
	
}
