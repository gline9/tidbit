package tidbit.ast;

import java.util.ArrayList;
import java.util.List;
import tidbit.instruction.IStore;
import tidbit.instruction.Instruction;

/**
 *
 * @author Gavin
 */
public class AssignmentStatement extends CodeGeneratingNode
{
	private final String variableName;
	private final Value value;

	public AssignmentStatement(String variableName, Value value)
	{
		this.variableName = variableName;
		this.value = value;
	}

	@Override
	public List<Instruction> getInstructions()
	{
		List<Instruction> instructions = new ArrayList<>();

		instructions.addAll(value.addToTopOfStack());
		instructions.add(new IStore(variableName));

		return instructions;
	}

	@Override
	public int getMaxStackDepth()
	{
		return value.stackDepth();
	}
	
}
