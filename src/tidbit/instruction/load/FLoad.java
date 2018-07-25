package tidbit.instruction.load;

import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class FLoad extends LoadInstruction
{

	public FLoad(String variableName)
	{
		super(0x17, variableName, Type.ofFloat());
	}

	
}
