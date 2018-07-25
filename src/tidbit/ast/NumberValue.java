package tidbit.ast;

import java.util.Arrays;
import java.util.List;
import tidbit.constants.Constant;
import tidbit.constants.IntegerConstant;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;
import tidbit.instruction.LoadConstant;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class NumberValue extends Value
{
	private int value;

	public NumberValue(String image)
	{
		value = Integer.parseInt(image);
	}

	private Constant getConstant()
	{
		return new IntegerConstant(value);
	}

	@Override
	public List<Instruction> addToTopOfStack(VariableTable table)
	{
		return Arrays.asList(
			new LoadConstant(getConstant()));
	}

	@Override
	public int stackDepth()
	{
		return 1;
	}

	@Override
	public Type getType(VariableTable table)
	{
		return Type.ofInt();
	}
	
}
