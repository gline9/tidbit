package tidbit.instruction.load;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class LLoad extends LoadInstruction
{
	
	public LLoad(String variableName)
	{
		super(0x16, variableName, Type.ofLong());
	}
	
}
