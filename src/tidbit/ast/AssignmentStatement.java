package tidbit.ast;

import java.util.ArrayList;
import java.util.List;
import tidbit.instruction.Instruction;
import tidbit.variables.VariableTable;

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
	public List<Instruction> getInstructions(VariableTable table)
	{
		List<Instruction> instructions = new ArrayList<>();

		instructions.addAll(value.addToTopOfStack(table));
		instructions.add(table.getVariable(variableName, value.getType(table)).getType().getStoreInstruction(variableName));

		return instructions;
	}

	@Override
	public int getMaxStackDepth()
	{
		return value.stackDepth();
	}
	
}
