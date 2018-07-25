package tidbit.instruction.load;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class ILoad extends LoadInstruction
{
	public ILoad(String variableName)
	{
		super(0x15, variableName, Type.ofInt());
	}
}
