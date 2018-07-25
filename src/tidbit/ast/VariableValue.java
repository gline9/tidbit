package tidbit.ast;

import java.util.Arrays;
import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.ILoad;
import tidbit.instruction.Instruction;

/**
 *
 * @author Gavin
 */
public class VariableValue extends Value
{
	private final String variableName;

	public VariableValue(String variableName)
	{
		this.variableName = variableName;
	}

	@Override
	public List<Instruction> addToTopOfStack()
	{
		return Arrays.asList(new ILoad(variableName));
	}

	@Override
	public int stackDepth()
	{
		return 1;
	}

	@Override
	public Type getType()
	{
		return Type.ofInt();
	}
	
}
