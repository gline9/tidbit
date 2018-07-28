package tidbit.attributes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import tidbit.ast.CodeGeneratingNode;
import tidbit.ast.Scope;
import tidbit.constants.ConstantTable;
import tidbit.constants.UTF8Constant;
import tidbit.frames.StackFrame;
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
	private final StackFrameAttribute frameAttribute;
	private final int stackSize;
	private final VariableTable variables;
	private final int codeSize;

	public CodeAttribute(List<CodeGeneratingNode> nodes, int inputArguments)
	{
		this.variables = new VariableTable(inputArguments);

		Scope scope = new Scope(nodes);
		this.instructions = scope.getInstructions(variables);
		this.instructions.add(new VoidReturn());
		this.stackSize = scope.getMaxStackDepth();
		codeSize = this.instructions.stream()
				.map(Instruction::size)
				.collect(Collectors.summingInt(i -> i));

		List<StackFrame> frames = new ArrayList<>();

		int codeIndex = 0;
		int currentFrameDelta = 0;
		for (Instruction instruction : instructions)
		{
			Optional<StackFrame> frame = instruction.getStackFrame(codeIndex, currentFrameDelta);
			codeIndex += instruction.size();

			if (!frame.isPresent())
			{
				continue;
			}

			StackFrame stackFrame = frame.get();

			currentFrameDelta += stackFrame.getDelta() + 1;

			frames.add(stackFrame);
		}

		frameAttribute = new StackFrameAttribute(frames);
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		codeIndex = table.registerConstant(new UTF8Constant("Code"));

		frameAttribute.registerConstants(table);

		this.instructions.forEach(i -> i.registerConstants(table));
	}


	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(codeIndex);

		out.writeInt(12 + codeSize + frameAttribute.size());
		out.writeShort(stackSize); // stack size
		out.writeShort(variables.size()); // local variable array size
		out.writeInt(codeSize);
		for (Instruction instruction : instructions)
		{
			instruction.write(out);
		}
		out.writeShort(0); // exception handler count
		out.writeShort(1); // attribute count
		frameAttribute.write(out);
	}

	@Override
	public int size()
	{
		return codeSize + 18 + frameAttribute.size();
	}
	
}
