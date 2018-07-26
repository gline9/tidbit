package tidbit.attributes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import tidbit.ast.CodeGeneratingNode;
import tidbit.ast.Scope;
import tidbit.constants.ConstantTable;
import tidbit.constants.UTF8Constant;
import tidbit.instruction.Instruction;
import tidbit.instruction.VoidReturn;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class CodeAttribute extends Attribute
{
	private int codeIndex;
	private final List<Instruction> instructions;
	private final int stackSize;
	private final VariableTable variables;

	public CodeAttribute(List<CodeGeneratingNode> nodes, int inputArguments)
	{
		this.variables = new VariableTable(inputArguments);

		Scope scope = new Scope(nodes);
		this.instructions = scope.getInstructions(variables);
		this.instructions.add(new VoidReturn());
		this.stackSize = scope.getMaxStackDepth();
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		codeIndex = table.registerConstant(new UTF8Constant("Code"));

		this.instructions.forEach(i -> i.registerConstants(table));
	}


	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(codeIndex);
		int codeLength = this.instructions.stream()
				.map(Instruction::size)
				.collect(Collectors.summingInt(i -> i));

		out.writeInt(12 + codeLength);
		out.writeShort(stackSize); // stack size
		out.writeShort(variables.size()); // local variable array size
		out.writeInt(codeLength);
		for (Instruction instruction : instructions)
		{
			instruction.write(out);
		}
		out.writeShort(0); // exception handler count
		out.writeShort(0); // attribute count
	}
	
}
