package tidbit.ast;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import tidbit.constants.Descriptor;
import tidbit.constants.FieldReferenceConstant;
import tidbit.constants.MethodReferenceConstant;
import tidbit.constants.Type;
import tidbit.instruction.GetStatic;
import tidbit.instruction.Instruction;
import tidbit.instruction.InvokeVirtual;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class PrintStatement extends CodeGeneratingNode
{
	private final Value value;

	public PrintStatement(Value value)
	{
		this.value = value;
	}

	@Override
	public List<Instruction> getInstructions(VariableTable table)
	{
		List<Instruction> instructions = new ArrayList<>();
		instructions.add(new GetStatic(new FieldReferenceConstant("java/lang/System", "out", Type.ofClass(PrintStream.class))));
		instructions.addAll(value.addToTopOfStack(table));
		instructions.add(new InvokeVirtual(new MethodReferenceConstant("java/io/PrintStream", "println", new Descriptor.Builder().addArg(value.getType(table)).withReturnType(Type.ofVoid()).build())));

		return instructions;
	}

	@Override
	public int getMaxStackDepth()
	{
		return value.stackDepth() + 1;
	}
	
}
