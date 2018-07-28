package tidbit.ast;

import java.util.ArrayList;
import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.IfEq;
import tidbit.instruction.Instruction;
import tidbit.instruction.JumpPointInstruction;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class IfStatement extends CodeGeneratingNode
{
	private final Value condition;
	private final Scope scope;

	public IfStatement(Value condition, Scope scope)
	{
		this.condition = condition;
		this.scope = scope;
	}

	protected void assertBoolean(Value value, VariableTable table)
	{
		if (value.getType(table).equals(Type.ofBoolean()))
		{
			return;
		}

		throw new RuntimeException(String.format("Invalid type expecting Z got '%s'", value.getType(table).getName()));
	}

	@Override
	public List<Instruction> getInstructions(VariableTable table)
	{
		List<Instruction> instructions = new ArrayList<>();

		assertBoolean(condition, table);
		instructions.addAll(condition.addToTopOfStack(table));

		List<Instruction> ifInstructions = scope.getInstructions(table);

		JumpPointInstruction jumpPoint = new JumpPointInstruction();
		instructions.add(new IfEq(jumpPoint));

		instructions.addAll(ifInstructions);

		instructions.add(jumpPoint);

		return instructions;
	}

	@Override
	public int getMaxStackDepth()
	{
		return Math.max(condition.stackDepth(), scope.getMaxStackDepth());
	}
	
}
