package tidbit.instruction.store;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class IStore extends StoreInstruction
{

	public IStore(String variableName)
	{
		super(0x36, variableName, Type.ofInt());
	}

}
