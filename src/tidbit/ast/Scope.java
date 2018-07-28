package tidbit.ast;

import java.util.List;
import java.util.stream.Collectors;
import tidbit.instruction.Instruction;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class Scope extends CodeGeneratingNode
{
	private final List<CodeGeneratingNode> nodes;

	public Scope(List<CodeGeneratingNode> nodes)
	{
		this.nodes = nodes;
	}

	@Override
	public List<Instruction> getInstructions(VariableTable table)
	{
		VariableTable scopedTable = table.scope();
		return nodes.stream()
				.map(node -> node.getInstructions(scopedTable))
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}

	@Override
	public int getMaxStackDepth()
	{
		return nodes.stream()
				.map(CodeGeneratingNode::getMaxStackDepth)
				.max(Integer::compare)
				.orElse(0);
	}
	
}
