package tidbit.instruction.load;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class ALoad extends LoadInstruction
{
	
	public ALoad(String variableName, Type type)
	{
		super(0x19, variableName, type);
	}
	
}
