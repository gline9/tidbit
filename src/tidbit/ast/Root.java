package tidbit.ast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import tidbit.Program;
import tidbit.attributes.CodeAttribute;
import tidbit.instruction.Instruction;
import tidbit.instruction.VoidReturn;
import tidbit.methods.MethodAccessor;
import tidbit.methods.MethodBuilder;

/**
 *
 * @author Gavin
 */
public class Root
{
	private final List<CodeGeneratingNode> nodes;

	public Root(List<CodeGeneratingNode> nodes)
	{
		this.nodes = nodes;
	}

	public byte[] getClassBytes(String className)
	{
		List<Instruction> instructions = nodes.stream().map(CodeGeneratingNode::getInstructions).flatMap(List::stream).collect(Collectors.toList());
		instructions.add(new VoidReturn());
		int maxStackDepth = nodes.stream().map(CodeGeneratingNode::getMaxStackDepth).max(Integer::compare).orElse(0);
		try
		{
			return new Program(className, "java/lang/Object",
				Arrays.asList(
					new MethodBuilder().withName("main")
							.withAccess(MethodAccessor.PUBLIC).withAccess(MethodAccessor.STATIC).withAccess(MethodAccessor.SYNTHETIC)
							.withInputArguments("[Ljava/lang/String;")
							.withOutputArgument("V")
							.withAttribute(new CodeAttribute(instructions, maxStackDepth, 1))
							.build()
				)
			).getBytes();
		}
		catch (IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
}
