package tidbit.instruction.load;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class DLoad extends LoadInstruction
{
	
	public DLoad(String variableName)
	{
		super(0x18, variableName, Type.ofDouble());
	}
	
}
