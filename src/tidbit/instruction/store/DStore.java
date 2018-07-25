package tidbit.instruction.store;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class DStore extends StoreInstruction
{

	public DStore(String variableName)
	{
		super(0x39, variableName, Type.ofDouble());
	}
	
}
