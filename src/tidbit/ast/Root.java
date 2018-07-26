package tidbit.ast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import tidbit.Program;
import tidbit.attributes.CodeAttribute;
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
		try
		{
			return new Program(className, "java/lang/Object",
				Arrays.asList(
					new MethodBuilder().withName("main")
							.withAccess(MethodAccessor.PUBLIC).withAccess(MethodAccessor.STATIC).withAccess(MethodAccessor.SYNTHETIC)
							.withInputArguments("[Ljava/lang/String;")
							.withOutputArgument("V")
							.withAttribute(new CodeAttribute(nodes, 1))
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
