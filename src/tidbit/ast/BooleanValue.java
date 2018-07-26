package tidbit.ast;

import java.util.Arrays;
import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.IConst0;
import tidbit.instruction.IConst1;
import tidbit.instruction.Instruction;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class BooleanValue extends Value
{
	private final boolean value;

	public BooleanValue(boolean value)
	{
		this.value = value;
	}

	@Override
	public List<Instruction> addToTopOfStack(VariableTable table)
	{
		return Arrays.asList(getBooleanLoadInstruction());
	}

	private Instruction getBooleanLoadInstruction()
	{
		return value ? new IConst1() : new IConst0();
	}

	@Override
	public int stackDepth()
	{
		return 1;
	}

	@Override
	public Type getType(VariableTable table)
	{
		return Type.ofBoolean();
	}
	
}
