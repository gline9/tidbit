package tidbit.ast;

import java.util.ArrayList;
import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;

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
		this.left = assertInteger(left);
		this.right = assertInteger(right);
		this.combineInstruction = combineInstruction;
	}

	protected Value assertInteger(Value value)
	{
		if (!value.getType().equals(Type.ofInt()))
		{
			throw new RuntimeException(String.format("Invalid type expecting I got '%s'", value.getType().getName()));
		}

		return value;
	}

	@Override
	public List<Instruction> addToTopOfStack()
	{
		List<Instruction> instructions = new ArrayList<>();

		instructions.addAll(left.addToTopOfStack());
		instructions.addAll(right.addToTopOfStack());
		instructions.add(combineInstruction);

		return instructions;
	}

	@Override
	public int stackDepth()
	{
		return Math.max(left.stackDepth(), right.stackDepth() + 1);
	}

	@Override
	public Type getType()
	{
		return Type.ofInt();
	}
	
}
