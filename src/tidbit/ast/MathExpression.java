package tidbit.ast;

import java.util.ArrayList;
import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public abstract class MathExpression extends Value
{
	private final Value left;
	private final Value right;
	private final Instruction combineInstruction;

	public MathExpression(Value left, Value right, Instruction combineInstruction)
	{
		this.left = left;
		this.right = right;
		this.combineInstruction = combineInstruction;
	}

	protected Value assertInteger(Value value, VariableTable table)
	{
		if (!value.getType(table).equals(Type.ofInt()))
		{
			throw new RuntimeException(String.format("Invalid type expecting I got '%s'", value.getType(table).getName()));
		}

		return value;
	}

	@Override
	public List<Instruction> addToTopOfStack(VariableTable table)
	{
		assertInteger(left, table);
		assertInteger(right, table);

		List<Instruction> instructions = new ArrayList<>();

		instructions.addAll(left.addToTopOfStack(table));
		instructions.addAll(right.addToTopOfStack(table));
		instructions.add(combineInstruction);

		return instructions;
	}

	@Override
	public int stackDepth()
	{
		return Math.max(left.stackDepth(), right.stackDepth() + 1);
	}

	@Override
	public Type getType(VariableTable table)
	{
		return Type.ofInt();
	}
	
}
