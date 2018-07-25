package tidbit.instruction.store;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class FStore extends StoreInstruction
{

	public FStore(String variableName)
	{
		super(0x38, variableName, Type.ofFloat());
	}
	
}
